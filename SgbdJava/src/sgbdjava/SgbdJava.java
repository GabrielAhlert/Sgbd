/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbdjava;

import linear.Linear;
import bTree.BTree;

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
        //System.out.println(linear.buscar(97844667088L));
        
      
        BTree b = new BTree(2);
        
        b.insert(l.lista.get(0));
        System.out.println(l.lista.get(0));
        System.out.println(b.search(78311454000l)[0]);
        
        b.insert(l.lista.get(1));
        b.insert(l.lista.get(2));
        b.insert(l.lista.get(3));
        b.insert(l.lista.get(4));
        
        
        
        
    }
    
}
