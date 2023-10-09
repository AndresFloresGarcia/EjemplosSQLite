public class empleado {
    private int emp_mo;
    private String apellido;
    private String oficio;
    private int dir;
    private String fecha_alt;
    private double salario;
    private Double Comision;
    private Departamento dept_no;

    public empleado(int emp_mo, String apellido, String oficio, int dir, String fecha_alt, double salario, Double comision, Departamento dept_no) {
        this.emp_mo = emp_mo;
        this.apellido = apellido;
        this.oficio = oficio;
        this.dir = dir;
        this.fecha_alt = fecha_alt;
        this.salario = salario;
        Comision = comision;
        this.dept_no = dept_no;
    }

    public int getEmp_mo() {
        return emp_mo;
    }

    public void setEmp_mo(int emp_mo) {
        this.emp_mo = emp_mo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public String getFecha_alt() {
        return fecha_alt;
    }

    public void setFecha_alt(String fecha_alt) {
        this.fecha_alt = fecha_alt;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Double getComision() {
        return Comision;
    }

    public void setComision(Double comision) {
        Comision = comision;
    }

    public Departamento getDept_no() {
        return dept_no;
    }

    public void setDept_no(Departamento dept_no) {
        this.dept_no = dept_no;
    }

    @Override
    public String toString() {
        return "emp_mo=" + emp_mo +
                ", apellido='" + apellido + '\'' +
                ", oficio='" + oficio + '\'' +
                ", dir=" + dir +
                ", fecha_alt=" + fecha_alt +
                ", salario=" + salario +
                ", Comision=" + Comision +
                ", dept_no=" + dept_no;
    }
}
