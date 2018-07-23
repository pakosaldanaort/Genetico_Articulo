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
        ArrayList  <Double> mejorXGeneracion =  new ArrayList<Double>() ;
        int topeMax = 40000;
        
        for (int b = 0; b < 100; b++) {
            
            
            ArrayList <Cromosoma> c = a.generateIndividuos(13, 10);
            ArrayList <Cromosoma> ch ;

            for (Cromosoma cr : c) {

                  double j = a.fitness(cr);
                  cr.setFitness(j);
                  cr.setGeneracion(1);

                }
                a.Bubblesort(c);
                mejorXGeneracion.add(c.get(c.size()-1).getFitness());


                int i = 0,cont =0,numMax;
                double maxFitness = c.get(c.size()-1).getFitness();
                numMax = 3000;

                do{
 


                    c = a.selection(c, 2);
                    ch = a.crossover(c);
                    a.mutation(ch);

                    for (Cromosoma aux : ch) {
                        double d = a.fitness(aux);

                        aux.setFitness(d);
                        aux.setGeneracion(i+2);

                        c.add(aux);

                    }

                    a.Bubblesort(c);
                    

                    
                    if(maxFitness < c.get(c.size()-1).getFitness()  ){

                        maxFitness = c.get(c.size()-1).getFitness();
                        cont =0;

                    }
                    if(maxFitness == c.get(c.size()-1).getFitness()){

                        cont++;
                        if(cont>numMax){

                            break;
                        }

                    }
                    
                
                    i++;

                }while(i!=topeMax);
                
               
                System.out.println("-------------------------------------------------------------------");
                
                System.out.println("best Solution: "+c.get(c.size()-1));
                System.out.println("Decodificado= Barrio: "+a.toBarrio(c.get(c.size()-1).getBarrio()) 
                        + ", Distancia a la estación de subte mas cercana: " +a.toCls(c.get(c.size()-1).getCls())
                        + ", Antiguedad: " +a.toAntiguedad(c.get(c.size()-1).getAntiguedad())
                        + ", Precio Alquiler: " +a.toPrecio(c.get(c.size()-1).getPrecioAlquiler()) 
                        + ", Ambientes: " +a.toAmbiente(c.get(c.size()-1).getAmbientes()));
            
        }
        
    
      
        
        
        
        
    }
    
    
    
    
    
}
