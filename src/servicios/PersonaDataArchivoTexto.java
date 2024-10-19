package servicios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelos.Persona;
import repositorios.Repositorio;

public class PersonaDataArchivoTexto implements Repositorio{
    List<Persona> personas = new ArrayList<>();
    public static final String rutaArchivo = "basedatos.txt";
    private ManejadorArchivos manejadorArchivos;
    
    public PersonaDataArchivoTexto()
    {
        this.manejadorArchivos = new ManejadorArchivos(rutaArchivo);
        this.personas = manejadorArchivos.leerPersonas();
    }
    
    @Override
    public ArrayList<Persona> obtenerTodos() {
        //Devuelvo una copia del arraylist que contiene los objetos personas leidos
        return new ArrayList<>(personas);
    }

    @Override
    public Persona obtener(int codigo) {
        return personas.stream().filter(persona -> persona.getCodigo() == codigo)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void agregar(Persona persona) {
        personas.add(persona);
        guardarCambios();
       
    }

    @Override
    public void modificar(Persona persona) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getCodigo() == persona.getCodigo()) {
                personas.set(i, persona);
                break;
            }
        }
        
        guardarCambios();
    }

    @Override
    public boolean eliminar(int codigo) {
         Persona personaEliminar = obtener(codigo);
        
        if(personas.remove(personaEliminar))
        {
            guardarCambios();
            return true;
        }else
        {
            return false;
        }
    }
    
    private void guardarCambios()
    {
        manejadorArchivos.guardarPersonas(personas);
    }
    
}
