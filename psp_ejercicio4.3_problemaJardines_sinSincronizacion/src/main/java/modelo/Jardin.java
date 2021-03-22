/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Pablo Herrero
 */
public class Jardin {
    private int personasEnJardin;

    public Jardin(int personasEnJardin) {
        this.personasEnJardin = personasEnJardin;
    }

    public int getPersonasEnJardin() {
        return personasEnJardin;
    }

    public void setPersonasEnJardin(int personasEnJardin) {
        this.personasEnJardin = personasEnJardin;
    }
    
    public void incrementarPersonas() {
        System.out.println(Thread.currentThread().getName());
        personasEnJardin++;
        System.out.println("Total personas en jardín: " + personasEnJardin);
    }
    
    public void decrementarPersonas() {
        System.out.println(Thread.currentThread().getName());
        personasEnJardin--;
        System.out.println("Total personas en jardín: " + personasEnJardin);
    }
}
