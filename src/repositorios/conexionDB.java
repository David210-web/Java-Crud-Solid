/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorios;
import java.sql.Connection;

/**
 *
 * @author cdavi
 */
public interface conexionDB {
    public Connection conectar();
    public void desconectar();
}
