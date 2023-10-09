//Clase Libro
public class Libro {
    String Titulo;
    String Editorial;

    public Libro(String titulo, String editorial) {
        Titulo = titulo;
        Editorial = editorial;
    }

    public Libro() {
        this.Titulo = null;
        this.Editorial = null;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String editorial) {
        Editorial = editorial;
    }
}
