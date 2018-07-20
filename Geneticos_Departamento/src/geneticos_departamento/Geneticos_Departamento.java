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
            
            
            
          double j = a.fitness(cr);
          cr.setFitness(j);
            
            
            
            
        }
        a.Bubblesort(c);
        
        int i = 0;

        do{
            
            
            c = a.selection(c, 2);
           
            
           
            
            ch = a.crossover(c);

            a.mutation(ch);

            for (Cromosoma aux : ch) {
                double d = a.fitness(aux);
                
                aux.setFitness(d);
                
                c.add(aux);
                
            }
            
            a.Bubblesort(c);
            System.out.println(c);
            
            
            //a.crossover(i, ch)
            //a.mutation(ch);
            //c = ch;
            
           
            i++;
            
        }while(i!=100);
        
        
        //System.out.println(a.puntosBarrio(c.get(0).getBarrio()));
       
        
        
        //System.out.println(c.get(a.selection(c)));
        
        
        
        
        
        
        
    }
    
    
    
    
    
}
