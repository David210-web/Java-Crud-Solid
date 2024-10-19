package modelos;


public class Persona {
    private int codigo;
    private String nombres;
    private String apellidos;
    private int edad;

    public Persona(int codigo, String nombres, String apellidos, int edad) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
    }
    
    public Persona()
    {
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
