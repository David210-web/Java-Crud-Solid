package repositorios;

import java.util.ArrayList;
import modelos.Persona;

public interface Repositorio {
    ArrayList<Persona> obtenerTodos();
    Persona obtener(int codigo);
    void agregar(Persona persona);
    void modificar(Persona persona);
    boolean eliminar(int codigo);
}
