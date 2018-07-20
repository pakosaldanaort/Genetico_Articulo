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
        ArrayList <Cromosoma> ch = a.generateIndividuos(13, 20);
        
        for (Cromosoma cr : c) {
            
            
            
          double j = a.fitness(cr);
          cr.setFitness(j);
            
            
            
            
        }
        a.Bubblesort(c);
        
        int i = 0;

        do{
            
            
            c = a.selection(c, 2);

            
           //a.crossoverMejorado(c);
            
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
            
        }while(i!=200);
        
        
        
        System.out.println("best Solution: "+c.get(c.size()-1));
        System.out.println("Decodificado= Barrio: "+a.toBarrio(c.get(c.size()-1).getBarrio()) 
                + ", Distancia a la estación de subte mas cercana: " +a.toCls(c.get(c.size()-1).getCls())
                + ", Antiguedad: " +a.toAntiguedad(c.get(c.size()-1).getAntiguedad())
                + ", Precio Alquiler: " +a.toPrecio(c.get(c.size()-1).getPrecioAlquiler()) 
                + ", Ambientes: " +a.toAmbiente(c.get(c.size()-1).getAmbientes()));
        
        //System.out.println(a.puntosBarrio(c.get(0).getBarrio()));
       
        
        
        //System.out.println(c.get(a.selection(c)));
        
        
        
        
        
        
        
    }
    
    
    
    
    
}
