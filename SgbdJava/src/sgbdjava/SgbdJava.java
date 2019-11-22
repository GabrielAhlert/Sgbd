/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbdjava;

import linear.Linear;
import arvoreb.BTree;

/**
 *
 * @author Administrador
 */
public class SgbdJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Linear l = new Linear();
        System.out.println(l.buscar(97844667087l));
        System.out.println(l.buscar(51543036015l));
        System.out.println("");
        
        BTree t = new BTree(3,true);   
        System.out.println(t.buscar(97844667087l));
        System.out.println(t.buscar(51543036015l));
        //Carol - 97844667087
        //Dionisio - 51543036015
        
    }
    
}
