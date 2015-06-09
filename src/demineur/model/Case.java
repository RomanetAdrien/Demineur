/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur.model;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Gaëtan
 */
public class Case extends Observable{
    private Case[] voisines;
    private int etat;
    private int contenu;
    private boolean drapeau;
    private Observer obs;

    
    
    public Case(int contenu) {
        this.contenu = contenu;
        etat = 0;
        this.drapeau = false;
    }


    public Case(int j, int k, int contenue){
        contenu=0;
        etat = 0;
        this.contenu=contenue;
    }
    
    public int reveleCase(){
        etat = 1;
        this.callUpdate();
        return contenu;
    }
    
    public void marqueCase(){
        etat = 2;
        this.callUpdate();
    }
    
    
    public boolean bombe(){
        if(contenu == 9){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        return "|"+this.contenu +"|";
    }

    public boolean setDrapeau() {
        this.drapeau = !this.drapeau;
        this.callUpdate();
        return this.drapeau;
    }
    
    public void callUpdate(){
        this.setChanged();
        this.notifyObservers();
    }

    void setBombe() {
        this.contenu = 9;
    }

    void incContenu() {
        if(this.contenu != 9){
            this.contenu ++;
        }
    }
    
}
