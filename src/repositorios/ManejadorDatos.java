
package repositorios;

import java.util.List;
import modelos.Persona;


public interface ManejadorDatos {
    public List<Persona> leerPersonas();
    public void guardarPersonas(List<Persona> personas);
}
