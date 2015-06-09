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
    private int x;
    private int y;
    private boolean drapeau;
    private Observer obs;

    public Case(Case[] voisines) {
        etat = 0;
        this.voisines = voisines;
        this.drapeau = false;
    }
    
    public Case(int contenu) {
        this.contenu = contenu;
        etat = 0;
        this.drapeau = false;
    }


    public Case(int j, int k, int contenue){
        contenu=0;
        etat = 0;
        this.contenu=contenue;
        x=j;
        y=k;
    }
    
    public int getEtat(){
        return this.etat;
    }
    
    public int reveleCase(){
        etat = 1;
       // this.callUpdate();
        return contenu;
    }
    
    public void marqueCase(){
        etat = 2;
      //  this.callUpdate();
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
    
}
