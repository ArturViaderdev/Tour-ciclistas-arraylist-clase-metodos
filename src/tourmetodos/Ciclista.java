/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tourmetodos;

/**
 *
 * @author arturv
 */

//Clase ciclista que sirve para guardar un ciclista con sus datos
public class Ciclista {
    private int dorsal;
    private String nombre;
    private int edad;
    
    //Constructor
    public Ciclista(int dorsal, String nombre, int edad)
    {
        this.dorsal = dorsal;
        this.nombre = nombre;
        this.edad=edad;
    }
    
    public int getdorsal()
    {
        return dorsal;
    }
    
    public void setdorsal(int dorsal)
    {
        this.dorsal = dorsal;
    }
    
    public String getnombre()
    {
        return nombre;
    }
    
    public void setnombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public int getedad()
    {
        return edad;
    }
    
    public void setedad(int edad)
    {
        this.edad = edad;
    }
    
    
    
}
