/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tourmetodos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author arturv
 */
public class Tourmetodos {
    private static ArrayList<Ciclista> ciclistas;
    /**
     * @param args the command line arguments
     */
    
    //Inserta un nuevo ciclista en la Arraylist
    //Pide los datos del ciclista por teclado
    private static void insertarciclista()
    {
       int dorsal, edad;
       String nombre;
       Scanner entrada=new Scanner(System.in);
       BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Intruduce el nombre del nuevo ciclista.");
       Ciclista dato;
       try
       {
           nombre= lector.readLine();
           System.out.println("Introduce el dorsal del nuevo ciclista.");
           dorsal=entrada.nextInt();
           System.out.println("Introduce la edad del nuevo ciclista.");
           edad = entrada.nextInt();
           //hago que las array tengan una posición más copiándolas, simulo que son dinámicas
           dato = new Ciclista(dorsal,nombre,edad);
           ciclistas.add(dato);
           System.out.println("Ciclista añadido.");     
       }
       catch(Exception e){
            System.out.println("Error.");
        }  
    }
    
    //Informa de cuantos ciclistas tiene la arraylist.
    private static void cuantosciclistas()
    {
        System.out.println("El vector tiene " + ciclistas.size() + " ciclistas.");
    }
    
    //Muestra todos los ciclistas con un bucle for each.
    private static void mostrarciclistas()
    {
        int cont;
        cont=0;
        for(Ciclista uno:ciclistas)
        {
            System.out.println("Ciclista " + cont);
            System.out.println("Nombre - " + uno.getnombre());
            System.out.println("Dorsal - " + uno.getdorsal());
            System.out.println("Edad - " + uno.getedad());
            cont++;
        }
       
    }
    
    //Nos dice cual es el ciclista más grande y el más pequeño.
    private static void masgrandepequeno()
    {
        int masgrande =0, maspequeno=0;
        for(int cont=0;cont<ciclistas.size();cont++)
        {
            if(cont>0)
            {
                if(ciclistas.get(cont).getedad()>ciclistas.get(masgrande).getedad())
                {
                    masgrande = cont;
                }
                if(ciclistas.get(cont).getedad()<ciclistas.get(maspequeno).getedad())
                {
                    maspequeno = cont;
                }
            }   
        }
        if(ciclistas.size()>0)
        {
            System.out.println("El ciclista mas grande es " + ciclistas.get(masgrande).getnombre() + " y tiene " + ciclistas.get(masgrande).getedad() + " años.");
            System.out.println("El ciclista mas pequeño es " + ciclistas.get(maspequeno).getnombre() + " y tiene " + ciclistas.get(maspequeno).getedad() + " años.");
        }
    }

    //Busca un ciclista por nombre e informa de sus datos.
    private static void buscarpornombre()
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String nombre;
        boolean encontrado=false;
        System.out.println("Introduce el nombre del ciclista a buscar.");
        try
        {
            nombre = lector.readLine();
            for(int cont=0;cont<ciclistas.size();cont++)
            {
                if(ciclistas.get(cont).getnombre().equals(nombre))
                {
                    encontrado=true;
                    mostrarciclista(cont);
                }
            }
            if(!encontrado)
            {
                System.out.println("No existe un ciclista con este nombre.");
            }
            
        }
        catch(Exception e){
            System.out.println("Error.");
        }  
    }    
    
    //Muestra un ciclista concreto por número de posición
    private static void mostrarciclista(int cual)
    {
        System.out.println("Nombre - " + ciclistas.get(cual).getnombre());
        System.out.println("Dorsal - " + ciclistas.get(cual).getdorsal());
        System.out.println("Edad - " + ciclistas.get(cual).getedad());   
    }
    
    //Calcula la media de edad de todos los ciclistas.
     private static void calcularmedia()
    {
        double media=0;
    
        if(ciclistas.size()>0)
        {
            for(Ciclista uno:ciclistas)
            {
                media+=uno.getedad();
            }
            media/=ciclistas.size();
            System.out.println("La media de edad es de " + media + ".");
        }
        else
        {
            System.out.println("No hay ciclistas");
        }
    }
    
    //Borra un ciclista buscado por nombre.
    private static void borrarunciclista()
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String nombre;
        boolean encontrado=false, sal = false;
        int cont;
        System.out.println("Introduce el nombre del ciclista a borrar. Se borrará el primer ciclista que se encuentre con ese nombre.");
        try
        {
            nombre = lector.readLine();
            cont=0;
            while(!sal)
            {
               if(cont<ciclistas.size())
               {
                   if(ciclistas.get(cont).getnombre().equals(nombre))
                   {
                       encontrado=true;
                       sal=true;
                   }
                   else
                   {
                       cont++;
                   }
               }
               else
               {
                   sal=true;
               }
            }
            //Si se ha encontrado el ciclista se procede a eliminarlo desplazando los ciclistas posteriores
            
            if(encontrado)
            {
                ciclistas.remove(cont);
                System.out.println("Ciclista eliminado.");
            }
            else
            {
                System.out.println("No existe un ciclista con este nombre.");
            }
        }
        catch(Exception e){
            System.out.println("Error.");
        }  
    }  
    
    //Ordena ciclistas por edad con el algoritmo de la burbuja
    private static void ordenaredad()
    {
        int i, j;
        Ciclista aux;
        for(i=0;i<ciclistas.size()-1;i++)
              for(j=0;j<ciclistas.size()-i-1;j++)
                   if(ciclistas.get(j+1).getedad()<ciclistas.get(j).getedad()){
                      aux=ciclistas.get(j+1);
                      ciclistas.set(j+1, ciclistas.get(j));
                      ciclistas.set(j, aux);
                   }
        mostrarciclistas();
    }
    
    //Ordena ciclistas por nombre con el algoritmo de la burbuja
    private static void ordenarnombre()
    {
          int i, j;
        Ciclista aux;
        for(i=0;i<ciclistas.size()-1;i++)
              for(j=0;j<ciclistas.size()-i-1;j++)
                   if(ciclistas.get(j+1).getnombre().compareTo(ciclistas.get(j).getnombre())<0){
                      aux=ciclistas.get(j+1);
                      ciclistas.set(j+1, ciclistas.get(j));
                      ciclistas.set(j, aux);
                   }
        mostrarciclistas();
    }
 
    public static void main(String[] args) {
        
        Scanner entrada=new Scanner(System.in);
        int opcion;
        ciclistas = new ArrayList<>();
        
        //Se muestra el menú        
        boolean sal=false;
          do
          {
            System.out.println("1-Insertar nuevo ciclista.");
            System.out.println("2-Informar de cuantos ciclistas tiene el vector.");
            System.out.println("3-Mostrar todos los ciclistas del vector.");
            System.out.println("4-Mostrar el ciclista más grande y el más pequeño.");
            System.out.println("5-Buscar ciclista por nombre.");
            System.out.println("6-Caluclar la media de edad de todos los ciclistas.");
            System.out.println("7-Borrar un ciclista.");
            System.out.println("8-Ordenar por edad.");
            System.out.println("9-Ordenar por nombre.");
            System.out.println("0-Salir");
            System.out.println("Introduce una opción.");
            try
            {
                //Se pide la opción al usuario
                opcion=entrada.nextInt();
                switch(opcion)
                {
                    case 0:
                        //Si el usuario introduce 0 se sale del bucle del menú y del programa
                        sal=true;
                        break;
                     case 1:
                        insertarciclista();       
                        break;
                     case 2:
                        cuantosciclistas();
                        break;
                     case 3:
                         mostrarciclistas();
                         break;
                     case 4:
                         masgrandepequeno();
                         break;
                     case 5:
                         buscarpornombre();
                         break;
                     case 6:
                         calcularmedia();
                         break;
                     case 7:
                         borrarunciclista();
                         break;
                     case 8:
                         ordenaredad();
                         break;
                     case 9:
                        ordenarnombre();
                         break;
                    default:
                }
            }
            catch(Exception e){
                System.out.println("Error.");
            }  
        }
        while(!sal);
        
    }  
}
