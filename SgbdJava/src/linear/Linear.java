/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linear;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Administrador
 */
public class Linear {
    ArrayList<Candidato> lista = null;
    public long  time;
    
    
    public Linear(){
        Calendar calndr1 = Calendar.getInstance();
        this.lista = new ArrayList<>();
        String row;
        try{
                BufferedReader reader = new BufferedReader(new FileReader("src//consulta_cand_2016_RS.csv"));
                reader.readLine();
                while((row = reader.readLine())!=null){
                    String[] data = row.split(";");
                    lista.add(new Candidato(Long.valueOf(data[20].replace("\"", "")),data[17].replace("\"", "")));
                    //System.out.println(new Candidato(Long.valueOf(data[20].replace("\"", "")),data[17].replace("\"", "")));
                    
                }
                
                }catch(Exception ex){
                   System.out.println(ex); 
                }
        Calendar calndr2 = Calendar.getInstance();
        time = (calndr2.getTimeInMillis()-calndr1.getTimeInMillis());
    }
    
    public String buscar(long cpf){
        Calendar calndr1 = Calendar.getInstance();
        int i = 0;
        try{
            while (lista.get(i).getCpf()!=cpf){
                i++;
            }
            if (lista.get(i).getCpf() == cpf){
                Calendar calndr2 = Calendar.getInstance();
                return "Nome: "+lista.get(i).getNome()+"  Pesquisas: "+(i+1)+"  Tempo de Carregamento: "+time+" ms  Tempo de Busca: "+(calndr2.getTimeInMillis()-calndr1.getTimeInMillis())+" ms";
            }
        }catch(IndexOutOfBoundsException ex){
            Calendar calndr2 = Calendar.getInstance();
            return "Não Encontrado!"+"  Pesquisas: "+(i+1)+"  Tempo de Carregamento: "+time+" ms  Tempo de Busca: "+(calndr2.getTimeInMillis()-calndr1.getTimeInMillis())+" ms";
        }
        return null;
    }
    
    
    
}
