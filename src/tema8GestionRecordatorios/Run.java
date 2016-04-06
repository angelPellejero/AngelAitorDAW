/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema8GestionRecordatorios;

import menu.*;

/**
 *
 * @author PROF_VESPERTINO
 */
public class Run {

    public static final void main(String[] args) {
        // Inicializamos menu
        Menu menu = Menu.init();
        OpcionesMenu op = new OpcionesMenu();
        
        // Añadimos las opciones 
        menu.addOpcionMenu("Añadir Carpeta", () -> op.carpeta());
        menu.addOpcionMenu("Añadir Apunte", () -> op.añadir());
	menu.addOpcionMenu("Borrar Apunte", () -> op.borrarApunte());
        menu.addOpcionMenu("Ver Apunte", () -> op.ver());
        menu.addOpcionMenu("Modificar Apunte", () -> op.modificar());
        menu.addOpcionMenu("Listado natural", () -> op.natural());
        menu.addOpcionMenu("Listado por horas", () -> op.horas());
        menu.addOpcionMenu("salir del menu", () -> op.salir());
        // Mostrar menu
        menu.mostrarMenu();
        
    }
}
