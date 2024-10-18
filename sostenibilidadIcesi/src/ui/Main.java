package ui;

import java.util.Scanner;
import model.Controller;

public class Main {
    public static Scanner scanner; 
    public static Controller objController;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        Main mainInstance = new Main(); 
        mainInstance.crearController();
        mainInstance.mostrarMenu();     
    }

    public void crearController(){
        objController = new Controller();
    }
    
    public void mostrarMenu() {

        boolean terminar = true;
        while (terminar) {
            System.out.println("Lista de opciones:" + 
            "\n1. Para registrar un proyecto" +  
            "\n2. Para consultar un pilar con sus proyectos asociados" +
            "\n3. Salir del programa");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    registrarProyecto();
                    break;

                case 2:
                    consultarPilar();
                    break;

                case 4:
                    System.out.println("Gracias por usar la aplicación.");
                    terminar = false;
                break;

                default:
                    System.out.println("Ingresaste una opción inválida.");
                    break;
            }
        }      
    }

    public void registrarProyecto(){
        System.out.println("Ingresa nombre del proyecto");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el numero del estado del proyecto: "+
                            "\n1. Activo "+
                            "\n2. Inactivo");
        int numEstado = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingresa un id: ");
        String id = scanner.nextLine();
    }

    public String consultarPilar() {
            
            System.out.println("Escoge un pilar: " +
                             "\n1. Biodiversidad" +
                             "\n2. Agua" +
                             "\n3. Tratamiento de basuras" +
                             "\n4. Energia\n");
            int numPilar = scanner.nextInt();
            scanner.nextLine(); 
                    
            String resultado = objController.consultarPilar(numPilar);
        

            return resultado;
        }
}    

