package model;

public class Proyecto {
    
    //Atributos 
    private String nombre;
    private String id;
    private String estado;
    private int numEstado;

    //Relaciones
    private EnumEstado enumEstado;
    private EnumPilares enumPilar;

    public final static int MAXPROYECTOS = 50;
    
    public Proyecto(String nombre, String id, String estado, int numEstado) {
        this.nombre = nombre;
        this.id = id;
        this.estado = estado;

        switch(numEstado){
            case 1:
            enumEstado = EnumEstado.ACTIVO;
            break;

            case 2: 
            enumEstado = EnumEstado.INACTIVO;
            break;
        }
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EnumPilares getEnumPilares() {
        return enumPilar;
    }

    public EnumEstado getEnumEstado() {
        return enumEstado;
    }
    

}
