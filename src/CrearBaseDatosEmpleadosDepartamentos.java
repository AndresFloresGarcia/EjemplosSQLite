import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class CrearBaseDatosEmpleadosDepartamentos {
    public static void main(String[] args) {
        // Abrir la base de datos
        ObjectContainer db = Db4o.openFile("EMPLEDEP.YAP");

        try {
            // Insertar objetos DEPARTAMENTOS
            Departamento departamento1 = new Departamento(10, "Ventas", "Madrid");
            Departamento departamento2 = new Departamento(20, "Marketing", "Barcelona");
            Departamento departamento3 = new Departamento(30, "Finanzas", "Valencia");

            db.store(departamento1);
            db.store(departamento2);
            db.store(departamento3);

            // Insertar objetos EMPLEADOS
            empleado empleado1 = new empleado(1, "González", "Vendedor", 101, "2023-01-15", 2500.00, 200.00, departamento1);
            empleado empleado2 = new empleado(2, "López", "Gerente", 102, "2022-03-20", 5000.00, null, departamento2);
            empleado empleado3 = new empleado(3, "Martínez", "Contador", 103, "2023-02-10", 3500.00, null, departamento3);
            empleado empleado4 = new empleado(4, "Rodríguez", "Vendedor", 101, "2022-12-05", 2700.00, 150.00, departamento1);

            db.store(empleado1);
            db.store(empleado2);
            db.store(empleado3);
            db.store(empleado4);

            //Leer empleados en departamentos
            getEmpleadosDepartamentos(departamento1, db);
            getEmpleadosDepartamentos(departamento2, db);
            getEmpleadosDepartamentos(departamento3, db);

        } finally {
            db.close();
        }
    }

    public static void getEmpleadosDepartamentos(Departamento dep , ObjectContainer db){
        ObjectSet<empleado> result = db.queryByExample(new empleado(0, null, null, 0, null, 0, null, dep));
        System.out.println("Empleados del departamento " + dep.getdNombre() + ":");
        while (result.hasNext()) {
            empleado empleado = result.next();
            System.out.println(empleado);
        }
    }
}
