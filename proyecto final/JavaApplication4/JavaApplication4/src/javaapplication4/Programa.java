package javaapplication4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Programa {

    public static ArrayList<Inquilino > inquilinos  = new ArrayList<Inquilino >();
    
    public static Inquilino  inquilino ;
    
    public static String fichero = "archivos.dat";

    
    public static void main(String[] args) {
        inquilinos =cargarInquilinos();
        int opcion = 0;

        do {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Propietario \nIngrese la opcion que desea realizar: \n 1. Agregar Propietario \n 2. Eliminar Propietario  \n 3. Modificar Propietario \n 4. Listar Popietarios \n 5. Guardar y Salir"));
            switch (opcion) {
            // Nuevo
            case 1:
                //TODO Crear metodo que le permita crear un producto y agregarlo al listado de productos
                crearInquilino ();
                break;

            // Eliminar
            case 2:
                //TODO Crear metodo que le permita eliminar un producto.
                eliminarInquilinos ();
                break;
                
            // Modificar
            case 3:
                //TODO Crear metodo que le permita modificar un producto ya existente en el listado
                modificarInquilinos ();
                break;

            // Listar
            case 4:
                //TODO crear metodo que le permita imprimir la informacion de los productos contenidos en el arreglo
                JOptionPane.showMessageDialog(
                        null,listarInquilinos());
                break;

            // Salir
            case 5:
                guardaInquilinos();
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opcion no valida!\n");
                break;
            }
        } while (opcion != 5);
        JOptionPane.showMessageDialog(null, "Adios!");
        

    }
    
    public static void crearInquilino (){
        String nombre;
        String Direccion;
        Integer cedula;
        Float telefono;
        nombre = JOptionPane.showInputDialog(
                "Nombre del propietario");
        Direccion = JOptionPane.showInputDialog(
                "direccion de la propiedada");       
        cedula = Integer.parseInt(JOptionPane.showInputDialog(
                "numero de cedula"));
        telefono = Float.parseFloat(JOptionPane.showInputDialog(
                "telefono"));
        inquilino  = new Inquilino (nombre,Direccion,cedula,telefono);
        inquilinos.add(inquilino );
    }
    
    public static String listarInquilinos (){
        String texto = "";
        for (Inquilino inquilino : inquilinos){
            texto += "\n"+" [ "+(inquilinos .indexOf(inquilino )+1) +" ] "+inquilino ;
        }
        return texto;
    }
    
    public static void eliminarInquilinos(){
        int indice = Integer.parseInt( 
                JOptionPane.showInputDialog(
                    listarInquilinos ()+
                            "\nIngrese el propiatario a eliminar \n"));
        inquilinos .remove(indice);
        JOptionPane.showMessageDialog(null,
                "Propietario fue eliminado");
        
    }
    
    /**
     * Carga la lista de productos desde un archivo .dat
     * 
     * @return
     */
    public static ArrayList<Inquilino > cargarInquilinos () {
        ArrayList<Inquilino > inquilinos = new ArrayList<Inquilino >();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            Object aux = ois.readObject();
            while (aux != null) {
                if (aux instanceof Inquilino )
                    inquilinos.add((Inquilino ) aux);
                aux = ois.readObject();

            }
            ois.close();
        } catch (FileNotFoundException e) {
            try {
                File archivo = new File(fichero);
                archivo.createNewFile();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } catch (Exception e) {

        }
        return inquilinos ;
    }

    /**
     * Recibe un listado de productos y guarda en un archivo .dat
     * 
     * @param inquilino
     */
    public static void guardaInquilinos () {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
            for (Inquilino  inquilino  : inquilinos ) {
                oos.writeObject(inquilino );
            }
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void modificarInquilinos (){
        int indice = Integer.parseInt(
                JOptionPane.showInputDialog(
                    "Ingrese el propietario a modificar.\n"+
                            listarInquilinos ()));
        inquilino  = inquilinos .get(indice-1);
        inquilino.setNombre(JOptionPane.showInputDialog(
            "Nombre del propietario"));
        inquilino .setDireccion(
                JOptionPane.showInputDialog(
                    "Direccion de la residencia"));
        inquilino .setcedula(Integer.parseInt(
            JOptionPane.showInputDialog("numero de cedula")));
        inquilino .settelefono(Float.parseFloat(
            JOptionPane.showInputDialog("telefono")));
        JOptionPane.showMessageDialog(null,
                "prietario modificado \n" + inquilino );
    }    
           
   
}
