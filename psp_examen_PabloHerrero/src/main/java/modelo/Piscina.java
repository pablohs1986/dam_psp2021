/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static java.lang.Thread.yield;

/**
 *
 * @author Pablo Herrero
 * Clase que simula el comportamiento de una piscina con N calles
 */
public class Piscina {

    private int totalCalles;
    private int callesOcupadas;
    private boolean calleDisponible;
    private int totalHombres;
    private int totalMujeres;
    private int totalNiños;

    public Piscina(int totalCalles) {
        this.totalCalles = totalCalles;
        this.calleDisponible = true;
        this.callesOcupadas = 0;
    }

    /**
     * Comprueba si hay calles disponibles
     *
     */
    public boolean isCalleDisponible() {
        return callesOcupadas == totalCalles ? calleDisponible : !calleDisponible;
    }

    /**
     * Contabiliza los tipos de nadadores en la entrada
     * @param Nadador
     */
    public void contarTipoNadadorAlEntrar(Nadador nadador) {
        TipoNadador tipoNadador = nadador.getTipo();
        if (tipoNadador == TipoNadador.hombre) {
            totalHombres++;
        } else if (tipoNadador == TipoNadador.mujer) {
            totalMujeres++;
        } else if (tipoNadador == TipoNadador.niño) {
            totalNiños++;
        }
    }

    /**
     * Contabiliza los tipos de nadadores en la salida
     *
     * @param Nadador
     */
    public void contarTipoNadadorAlSalir(Nadador nadador) {
        TipoNadador tipoNadador = nadador.getTipo();
        if (tipoNadador == TipoNadador.hombre) {
            totalHombres--;
        } else if (tipoNadador == TipoNadador.mujer) {
            totalMujeres--;
        } else if (tipoNadador == TipoNadador.niño) {
            totalNiños--;
        }
    }

     /**
     * Gestiona la entrada del nadador. Si no hay calles disponibles, pone el hilo
     * nadador en espera. Si hay calles disponibles, el hilo sigue su curso.
     * @param Nadador
     */
    public void entraNadador(Nadador nadador) {
        while (isCalleDisponible()) {
            System.out.println(">>> Calles ocupadas, nadador " + nadador.getName() + ", está ESPERANDO...");
            yield();
        }
        contarTipoNadadorAlEntrar(nadador);
        int calleAOcupar = callesOcupadas;
        System.out.println(">>> Calle libre, nadador " + nadador.getName()
                + " ENTRA y comienza su largo || DESGLOSE TIPOS: Hombres: " + totalHombres + " Mujeres: " + totalMujeres
                + " Niños: " + totalNiños);
        callesOcupadas++;
//        System.out.println("--- Nadadores en piscina " + callesOcupadas);
    }

    /**
     * Gestiona la salida del nadador. 
     *
     * @param Nadador
     */
    public void saleNadador(Nadador nadador) {
        callesOcupadas--;
        calleDisponible = true;
        contarTipoNadadorAlSalir(nadador);
        System.out.println(">>> " + nadador.getName() + " SALE de la calle y se va al vestuario"
                + " || DESGLOSE TIPOS: Hombres: " + totalHombres + " Mujeres: " + totalMujeres
                + " Niños: " + totalNiños);
    }

}
