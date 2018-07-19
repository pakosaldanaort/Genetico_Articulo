/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos_departamento;

import java.util.ArrayList;



/**
 *
 * @author francisco_saldana
 */
public class Geneticos_Departamento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        
        Geneticos_Tools a = new Geneticos_Tools();
        
        ArrayList <Cromosoma> c = a.generateIndividuos(13, 10);
        ArrayList <Cromosoma> ch = a.generateIndividuos(13, 10);
        
        for (Cromosoma cr : c) {
            
            
            
           a.fitness(cr);
            
            
            
            
        }
        int i = 0;
        System.out.println(c.toString());
        do{
            int index = a.selection(c);
            ch = a.crossover(index, c);
            a.mutation(ch);
            c = ch;
            System.out.println(c.toString());
            i++;
            
        }while(i==50);
        
        
        //System.out.println(a.puntosBarrio(c.get(0).getBarrio()));
        System.out.println(c.toString());
        
        
        System.out.println(c.get(a.selection(c)));
        
        
        
        
        
        
        
    }
    
    
    
    
    
}
