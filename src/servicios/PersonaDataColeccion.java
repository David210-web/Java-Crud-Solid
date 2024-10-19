package servicios;
import java.util.ArrayList;
import modelos.Persona;
import repositorios.Repositorio;



public class PersonaDataColeccion implements Repositorio{
    private ArrayList<Persona> personas = new ArrayList<>();

    
    public ArrayList<Persona> obtenerTodos() {
        return personas;
    }

    @Override
    public Persona obtener(int codigo) {
        for(Persona persona : personas)
        {
            if(persona.getCodigo() == codigo){
                return persona;
            }
        }
        return null;
    }

    @Override
    public void agregar(Persona persona) {
        personas.add(persona);
    }

    @Override
    public void modificar(Persona persona) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getCodigo() == persona.getCodigo()) {
                personas.set(i,persona);
            }
        }
    }

    @Override
    public boolean eliminar(int codigo) {
        Persona personaEliminar = obtener(codigo);
        
        if(personas.remove(personaEliminar))
        {
            return true;
        }else
        {
            return false;
        }
    }
}
