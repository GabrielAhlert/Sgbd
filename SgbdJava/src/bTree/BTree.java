/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bTree;

import models.Candidato;

/**
 *
 * @author Windows
 */
public class BTree {
    private class BTreeNode{
        public Candidato[] keys;
        int t;
        BTreeNode[] c;
        int n;
        Boolean leaf;

        public BTreeNode(int t, Boolean leaf) {
            this.t = t;
            this.leaf = leaf;
            keys = new Candidato[2*t-1];
            c = new BTreeNode[2*t];
        }
        
        void traverse(){
            int i;
            for(i=0; i<n; i++){
                if(leaf == false){
                    c[i].traverse();
                    System.out.println(" "+keys[i]);
                }
            }
            if(leaf == false){
                c[i].traverse();
            }
        }
        
        BTreeNode search(long k){
            int i=0;
            
            while(i<n && k> keys[i].getCpf())
                i++;
            
            if(keys[i].getCpf() == k)
                return this;
            
            if (leaf == true)
                return null;
            
            return c[i].search(k);
        }
        
        void insertNonFull(Candidato k){
            int i = n-1;
            if(leaf == true){
                while( i >= 0 && keys[i].getCpf()>k.getCpf()){
                    keys[i+1] = keys[i];
                    i--;
                }
                keys[i+1] = k;
                n = n+1;

            }else{
                while( i >= 0 && keys[i].getCpf()>k.getCpf())
                    i--;
                
                if( this.c[i+1].n == 2*t-1){
                    splitChild(i+1, this.c[i+1]);
                    
                    if(keys[i+1].getCpf()<k.getCpf())
                        i++;
                }
                
                this.c[i+1].insertNonFull(k);
            }
            
        }
        
        void splitChild(int i,BTreeNode y){
            BTreeNode z = new BTreeNode(y.t, y.leaf); 
            z.n = t - 1;
            
            for (int j = 0; j < t-1; j++) {
                z.keys[j] = y.keys[j+t];  
            }
            if (y.leaf == false) 
            { 
                for (int j = 0; j < t; j++) 
                z.c[j] = y.c[j+t]; 
            }
            y.n = t - 1; 
            
            for (int j = n; j >= i+1; j--) 
                c[j+1] = c[j]; 
            
            c[i+1] = z;
            
            for (int j = n-1; j >= i; j--) {
                keys[j+1] = keys[j];
                
            keys[i] = y.keys[t-1];
            }
            
            n = n + 1;
 
        }        
    }

    BTreeNode root;
    int t;
    public long time;

    public BTree(int t) {
        this.root = null;
        this.t = t;
    }
    

    
    public void traverse(){
        if(root == null) root.traverse();
    }
    
    public Candidato[] search(long k){
        if (root == null){
            return null;
        }else{
            return root.search(k).keys;
        }
    }
    public void insert (Candidato c){
        if (root == null){
            root = new BTreeNode(t,true);
            root.keys[0]=c;
            root.n = 1;
        }
        else{
            if(root.n == 2*t-1){
                BTreeNode s = new BTreeNode(t,false);
                s.c[0]=root;
                s.splitChild(0,root);
                
                int i = 0; 
                try{
                    if (s.keys[0].getCpf() < c.getCpf()) 
                        i++;
                }catch(Exception ex){
                    
                }
                s.c[i].insertNonFull(c);
                
                root = s;
            }else{
                root.insertNonFull(c);
            }
            
        }
        
    }
}
