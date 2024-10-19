/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import modelos.Persona;
import repositorios.Repositorio;
import repositorios.conexionDB;

/**
 *
 * @author cdavi
 */
public class PersonaDataDB implements Repositorio{
    private final conexionDB conexion;
    public PersonaDataDB(conexionDB conexion)
    {
        this.conexion = conexion;
    }
    
    @Override
    public ArrayList<Persona> obtenerTodos() {
        ArrayList<Persona> personas = new ArrayList<>();
        String query = "SELECT * FROM Personas";
        try(PreparedStatement pstmt = conexion.conectar().prepareStatement(query))
        {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                int codigo = rs.getInt("id");
                String nombres = rs.getString("nombre");
                String apellidos = rs.getString("apellido");
                int edad = rs.getInt("edad");
                
                Persona persona = new Persona(codigo,nombres,apellidos,edad);
                personas.add(persona);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return personas;
    }

    @Override
    public Persona obtener(int codigo) {
        //Persona persona = null;
        String query = "SELECT * FROM Personas where id = ?";
        try(PreparedStatement pstmt = conexion.conectar().prepareStatement(query)){
            pstmt.setInt(1, codigo);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                int cod = rs.getInt("id");
                String nombres = rs.getString("nombre");
                String apellidos = rs.getString("apellido");
                int edad = rs.getInt("edad");
                
                Persona persona = new Persona(cod,nombres,apellidos,edad);
                return persona;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public void agregar(Persona persona) {
        String query = "INSERT INTO Personas (nombre,apellido,edad) values (?,?,?)";
        try(PreparedStatement pstmt = conexion.conectar().prepareStatement(query)){
            pstmt.setString(1, persona.getNombres());
            pstmt.setString(2, persona.getApellidos());
            pstmt.setInt(3, persona.getEdad());
            pstmt.executeUpdate();
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Persona persona) {
        String query = "UPDATE Personas set nombre = ?, apellido = ?, edad = ? where id = ?";
        try(PreparedStatement pstmt = conexion.conectar().prepareStatement(query)){
            pstmt.setString(1, persona.getNombres());
            pstmt.setString(2, persona.getApellidos());
            pstmt.setInt(3, persona.getEdad());
            pstmt.setInt(4, persona.getCodigo());
            pstmt.executeUpdate();
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public boolean eliminar(int codigo) {
        String query = "DELETE FROM Personas where id = ?";
        try(PreparedStatement pstmt = conexion.conectar().prepareStatement(query))
        {
            pstmt.setInt(1, codigo);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    
}
