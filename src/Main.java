import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.time.Period;

public class Main{
    static String BDLib = "DBLibros.yap";

    public static void main(String[] args){
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDLib);

        //Creamos los objetos.
        Libro l1 = new Libro("Redes de Área Local", "Garceta");
        Libro l2 = new Libro("Acceso a Datos", "RAMA");
        Libro l3 = new Libro("Lenguaje de Marcas", "Sintesis");
        Libro l4 = new Libro("Bases de Datos", "Garceta");
        Libro l5 = new Libro("Sistemas Informáticos", "RAMA");

        //Almacenamos objetos en la base de datos
        db.store(l1);
        db.store(l2);
        db.store(l3);
        db.store(l4);
        db.store(l5);

        //Consulta de todos los libros de la editorial Garceta-----------------------------------
        Libro libro = new Libro(null,"Garceta");
        ObjectSet<Libro> result = db.queryByExample(libro);

        if (result.size() == 0)
            System.out.println("No existen registros (consulta)..");
        else {
            System.out.printf("Número de registros Editorial Garceta: %d %n", result.size());
            while (result.hasNext()){
                Libro l = result.next();
                System.out.printf("Título: %s, Editorial: %s %n", l.getTitulo(), l.getEditorial());
            }
        }

        //Modifico el libro Redes de Área Local-------------------------------------------------
        result = db.queryByExample(new Libro("Redes de Área Local",null));
        if (result.size() == 0)
            System.out.println("No existen registros (modificación)..");
        else {
            Libro existe = (Libro) result.next();
            existe.setTitulo("Redes");
            db.store(existe); //Título modificado
            //Consulto los datos
            result = db.queryByExample(new Libro("Redes",null));
            existe = (Libro) result.next();
            System.out.println("Libro Modificado: ");
            System.out.printf("Título: %s, Editorial: %s %n", existe.getTitulo(), existe.getEditorial());
        }

        //Borro los libros de la editorial RAMA-----------------------------------------------------------
        result = db.queryByExample(new Libro(null, "RAMA"));
        Libro l = new Libro();
        if (result.size() == 0)
            System.out.println("No existen registros (borrado)..");
        else {
            System.out.printf("Registro a borrar: %d %n", result.size());
            while (result.hasNext()){
                l = result.next();
                db.delete(l);
                System.out.println("Borrando.....");
            }
            //Muestro los restantes
            result = db.queryByExample(new Libro(null, null));
            System.out.println("Registros restantes");
            while (result.hasNext()){
                l = result.next();
                System.out.printf("Título: %s, Editorial: %s %n", l.getTitulo(), l.getEditorial());
            }
        }

        db.close();
    }
}