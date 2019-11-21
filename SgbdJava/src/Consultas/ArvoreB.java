/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import bTree.BTree;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Calendar;

/**
 *
 * @author Windows
 */
public class ArvoreB {
    BTree b = new BTree(2);

    public static BTree Arvore() {
        Calendar calndr1 = Calendar.getInstance();
        BTree b = new BTree(2);
        String row;
        try{
            BufferedReader reader = new BufferedReader(new FileReader("src//consulta_cand_2016_RS.csv"));
            reader.readLine();
            while((row = reader.readLine())!=null){
                String[] data = row.split(";");
                b.insert(new bTree.Candidato(Long.valueOf(data[20].replace("\"", "")),data[17].replace("\"", "")));
                //System.out.println(new Candidato(Long.valueOf(data[20].replace("\"", "")),data[17].replace("\"", "")));
                    
            }
                
        }catch(Exception ex){
            System.out.println(ex); 
        }
        Calendar calndr2 = Calendar.getInstance();
        long time;
        time = (calndr2.getTimeInMillis()-calndr1.getTimeInMillis());
        System.out.println(time);
        
        return b;
    }
    
}
