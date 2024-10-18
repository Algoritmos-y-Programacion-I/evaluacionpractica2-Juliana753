package model;

public class Controller {
    //Atributos
    private int contadorProyectos = 0;

    //Relaciones
    private Proyecto[] proyectos;
    private EnumEstado enumEstado;
    private EnumPilares enumPilares;
    
    //Constantes
    public final static int MAXPROYECTOS = 50;

    //Metodos
    public Controller(){
        proyectos = new Proyecto[MAXPROYECTOS];
    }

    public int registrarProyecto(String nombre, String id, String estado, int numEstado) {
        if (contadorProyectos < MAXPROYECTOS) {
            proyectos[contadorProyectos] = new Proyecto(nombre, id, estado, numEstado);
            contadorProyectos++;
            return 0;
        } else {
            return 1;
        }
    }

    public void seleccionarPilar(int numPilar) {
        switch (numPilar) {
            case 1:
                enumPilares = EnumPilares.BIODIVERSIDAD;
                break;
            case 2: 
                enumPilares = EnumPilares.AGUA;
                break;
            case 3: 
                enumPilares = EnumPilares.TRATAMIENTODEBASURAS;
                break;
            case 4: 
                enumPilares = EnumPilares.ENERGIA;
                break;
            default:
                System.out.println("Número de pilar inválido.");
                break;
        }
    }
    

    public String consultarPilar(int numPilar) {
        String mensaje = "";
        int contador = 0;
    
        if (numPilar < 1 || numPilar > EnumPilares.values().length) {
            return "Número de pilar inválido. Por favor selecciona un número entre 1 y " + EnumPilares.values().length + ".";
        }
    
        EnumPilares pilarSeleccionado = EnumPilares.values()[numPilar - 1];  
    
        for (int i = 0; i < proyectos.length; i++) {
            if (proyectos[i] != null && proyectos[i].getEnumPilares() == pilarSeleccionado) {
                if (contador == 0) {
                    mensaje += "Nombre del pilar: " + pilarSeleccionado + "\nProyectos asociados:\n";
                }
                mensaje += "(Proyecto " + (contador + 1) + ")\n";
                mensaje += "Nombre del proyecto: " + proyectos[i].getNombre() + "\n";
                mensaje += "ID: " + proyectos[i].getId() + "\n";
                mensaje += "Estado: " + proyectos[i].getEstado() + "\n\n";
                contador++;
            }
        }
    
        if (contador == 0) {
            mensaje = "No existen proyectos registrados bajo el pilar de " + pilarSeleccionado + ". Por favor registra alguno desde el menú.";
        }
    
        return mensaje;
    }
    
   
}
