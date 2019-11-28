/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvoreb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import models.Candidato;

/**
 *
 * @author Windows
 */
public class BTree {
    
  
    BTreeNode root; // Pointer to root node 
    int t;  // Minimum degree
    public long time;

    // Constructor (Initializes tree as empty) 
    public BTree(int _t) 
    {  root = null;  t = _t; } 
    
    public BTree(int _t, boolean mountTree){
        root = null;
        t = _t;
        
        Calendar calndr1 = Calendar.getInstance();
        String row;
        try{
            BufferedReader reader = new BufferedReader(new FileReader("src//consulta_cand_2016_RS.csv"));
            reader.readLine();
            while((row = reader.readLine())!=null){
                String[] data = row.split(";");
                this.insert(Long.valueOf(data[20].replace("\"", "")) , new Candidato(Long.valueOf(data[20].replace("\"", "")),data[17].replace("\"", "")));
               
                    
            }
                
        }catch(Exception ex){
            System.out.println(ex); 
        }
        Calendar calndr2 = Calendar.getInstance();
        time = (calndr2.getTimeInMillis()-calndr1.getTimeInMillis());
    }
  
    // function to traverse the tree 
    public void traverse() 
    {  if (root != null) root.traverse(); } 
  
    // function to search a key in this tree 
    public Candidato search(long k) 
    {  
        if (root == null){
            return null;
        }else{
            BTreeNode temp = root.search(k);
            try{
                return temp.find(k);
            }catch(NullPointerException ex){
                return null;
            }
        }
    }
    
    public String buscar(long k){
        long calndr1 = System.nanoTime();
        Candidato c = this.search(k);
        long calndr2 = System.nanoTime();
        if(c != null){
            return "Nome: "+c.getNome()+"  Pesquisas: "+(c.temp)+"  Tempo de Carregamento: "+time+" ms  Tempo de Busca: "+(calndr2-calndr1)+" ns";
        }else{
            return "Não Encontrado!"+"  Tempo de Carregamento: "+time+" ms  Tempo de Busca: "+(calndr2-calndr1)+" ns";
        }

    }
  

  
 
  
// The main function that inserts a new key in this B-Tree 
    public void insert(long k,Candidato _c) 
    { 
        // If tree is empty 
        if (root == null) 
        { 
            // Allocate memory for root 
            root = new BTreeNode(t, true); 
            root.keys[0] = k;  // Insert key 
            root.values[0] = _c;
            root.n = 1;  // Update number of keys in root 
        } 
        else // If tree is not empty 
        { 
            // If root is full, then tree grows in height 
            if (root.n == 2*t-1) 
            { 
                // Allocate memory for new root 
                BTreeNode s = new BTreeNode(t, false); 

                // Make old root as child of new root 
                s.C[0] = root; 

                // Split the old root and move 1 key to the new root 
                s.splitChild(0, root); 

                // New root has two children now.  Decide which of the 
                // two children is going to have new key 
                int i = 0; 
                if (s.keys[0] < k) 
                    i++; 
                s.C[i].insertNonFull(k,_c); 

                // Change root 
                root = s; 
            } 
            else  // If root is not full, call insertNonFull for root 
                root.insertNonFull(k,_c); 
        } 
    } 
}
 