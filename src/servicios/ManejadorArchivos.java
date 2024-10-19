
package servicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelos.Persona;
import repositorios.ManejadorDatos;

public class ManejadorArchivos implements ManejadorDatos{
    private String rutaArchivo;
    
    public ManejadorArchivos(String rutaArchivo)
    {
        this.rutaArchivo = rutaArchivo;
    }
    
    /**
     *
     * @return
     * @throws IOException
     */
    @Override
    public List<Persona> leerPersonas()
    {
        List<Persona> personas = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo)))
        {
            String linea; //Almacena cada linea del archivo
            while((linea = br.readLine()) != null) 
            {
                //Divide la linea leida en un vector separando los elementos usando la coma como delimitador
                String[] datos = linea.split(",");
                //Asigna a unas variables los datos de la linea del archivo txt
                int codigo = Integer.parseInt(datos[0]);
                String nombres = datos[1];
                String apellidos = datos[2];
                int edad = Integer.parseInt(datos[3]);
                //creo un objeto el cual le paso por el constructor las variables
                Persona persona = new Persona(codigo,nombres,apellidos,edad);
                personas.add(persona);
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return personas;
    }
    
    @Override
    public void guardarPersonas(List<Persona> personas) 
    {
        //Abro el archivo especificado por rutaArchivo para la escritura
         try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo)))
        {
            for(Persona persona : personas)
            {
                //Escribo una nueva linea al archivo txt
                bw.write(persona.getCodigo() + ","+persona.getNombres()+","+persona.getApellidos()+","+persona.getEdad());
                //Cuando termino de escribir pongo una nueva linea para evitar que no me escriba todo en una linea
                bw.newLine();
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}