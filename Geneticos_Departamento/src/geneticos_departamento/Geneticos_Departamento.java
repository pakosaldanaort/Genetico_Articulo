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
        ArrayList <ArrayList> lista = new ArrayList <ArrayList>();
        for (int i = 0; i < 100; i++) {
            lista.add(a.generateIndividuos(13, 10));
        }
        
        
        solucionMejorada(lista);
        solucionNormal(lista);
      
        
        
        
        
    }
    
    public static void solucionMejorada(ArrayList <ArrayList> poblacion){
        Geneticos_Tools a = new Geneticos_Tools();
        ArrayList  <Double> mejoresFitness =  new ArrayList<Double>() ;
        ArrayList  <ArrayList> historialFitness =  new ArrayList<ArrayList>() ;
        ArrayList  <Double> historialTime =  new ArrayList<Double>() ;
        ArrayList  <Cromosoma> fitnessXGenracion;
        int topeMax = 40000, indexMax=0;
        long endTime,startTime;
        double maxFit=0;
        
        for (int b = 0; b < 100; b++) {
            
            startTime = System.nanoTime();

            ArrayList <Cromosoma> c = (ArrayList <Cromosoma>) poblacion.get(b);
            ArrayList <Cromosoma> ch ;
            fitnessXGenracion =  new ArrayList<Cromosoma>() ;
            for (Cromosoma cr : c) {

                  double j = a.fitness(cr);
                  cr.setFitness(j);
                  cr.setGeneracion(1);

                }
                a.Bubblesort(c);
                fitnessXGenracion.add(c.get(c.size()-1));
                

                int i = 0,cont =0,numMax;
                double maxFitness = c.get(c.size()-1).getFitness();
                numMax = 70;

                do{
 


                    c = a.selection(c, 2);
                    ch = a.crossoverMejorado(c);
                    a.mutationMejorada(ch);

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
                    fitnessXGenracion.add(c.get(c.size()-1));
                    
                    
                    i++;

                }while(i!=topeMax);
                
               
               
               
               // System.out.println("-------------------------------------------------------------------");
                
               /* System.out.println("best Solution: "+c.get(c.size()-1));
                System.out.println("Decodificado= Barrio: "+a.toBarrio(c.get(c.size()-1).getBarrio()) 
                        + ", Distancia a la estación de subte mas cercana: " +a.toCls(c.get(c.size()-1).getCls())
                        + ", Antiguedad: " +a.toAntiguedad(c.get(c.size()-1).getAntiguedad())
                        + ", Precio Alquiler: " +a.toPrecio(c.get(c.size()-1).getPrecioAlquiler()) 
                        + ", Ambientes: " +a.toAmbiente(c.get(c.size()-1).getAmbientes()));*/
                if(b==0){
                    maxFit = c.get(c.size()-1).getFitness();
                    indexMax = b;
                }
                else{
                    if(maxFit < c.get(c.size()-1).getFitness()){
                        maxFit = c.get(c.size()-1).getFitness();
                        indexMax = b;
                    }
                }
                endTime = System.nanoTime();
 
               double tiempo = (double) (endTime - startTime)/1000000000;
                
                historialFitness.add(fitnessXGenracion);
                mejoresFitness.add(c.get(c.size()-1).fitness);
                historialTime.add(tiempo);
                
                
            
        }
        
        System.out.println("-----------------------Fitness----------------------------");
        for (int i = 0; i < 100; i++) {

            
            System.out.println(mejoresFitness.get(i));
        }
        System.out.println("-----------------------Tiempos ----------------------------");
        for (int i = 0; i < 100; i++) {

            
            System.out.println(historialTime.get(i));
        }
        System.out.println("-----------------------Evolucion del Mejor Fitness por Generacion de la Mejor Corrida ----------------------------");
            

            for (int j = 0; j <historialFitness.get(indexMax).size() ; j++) {
                Cromosoma aux = (Cromosoma) historialFitness.get(indexMax).get(j);
                System.out.println(aux.getFitness());
            }
            
            
        
        
        //System.out.println(maxFit+" "+indexMax);
    }
    
    public static void solucionNormal(ArrayList <ArrayList> poblacion){
        System.out.println("**********************Solucion Normal**********************************");
        Geneticos_Tools a = new Geneticos_Tools();
        ArrayList  <Double> mejoresFitness =  new ArrayList<Double>() ;
        ArrayList  <ArrayList> historialFitness =  new ArrayList<ArrayList>() ;
        ArrayList  <Double> historialTime =  new ArrayList<Double>() ;
        ArrayList  <Cromosoma> fitnessXGenracion;
        int topeMax = 40000, indexMax=0;
        long endTime,startTime;
        double maxFit=0;
        
        for (int b = 0; b < 100; b++) {
            
            startTime = System.nanoTime();

            ArrayList <Cromosoma> c = (ArrayList <Cromosoma>) poblacion.get(b);
            ArrayList <Cromosoma> ch ;
            fitnessXGenracion =  new ArrayList<Cromosoma>() ;
            for (Cromosoma cr : c) {

                  double j = a.fitness(cr);
                  cr.setFitness(j);
                  cr.setGeneracion(1);

                }
                a.Bubblesort(c);
                fitnessXGenracion.add(c.get(c.size()-1));
                

                int i = 0,cont =0,numMax;
                double maxFitness = c.get(c.size()-1).getFitness();
                numMax = 70;

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
                    fitnessXGenracion.add(c.get(c.size()-1));
                    
                    
                    i++;

                }while(i!=topeMax);
                
               
               
               
               //System.out.println("-------------------------------------------------------------------");
                
                /*System.out.println("best Solution: "+c.get(c.size()-1));
                System.out.println("Decodificado= Barrio: "+a.toBarrio(c.get(c.size()-1).getBarrio()) 
                        + ", Distancia a la estación de subte mas cercana: " +a.toCls(c.get(c.size()-1).getCls())
                        + ", Antiguedad: " +a.toAntiguedad(c.get(c.size()-1).getAntiguedad())
                        + ", Precio Alquiler: " +a.toPrecio(c.get(c.size()-1).getPrecioAlquiler()) 
                        + ", Ambientes: " +a.toAmbiente(c.get(c.size()-1).getAmbientes()));*/
                if(b==0){
                    maxFit = c.get(c.size()-1).getFitness();
                    indexMax = b;
                }
                else{
                    if(maxFit < c.get(c.size()-1).getFitness()){
                        maxFit = c.get(c.size()-1).getFitness();
                        indexMax = b;
                    }
                }
                endTime = System.nanoTime();
 
               double tiempo = (double) (endTime - startTime)/1000000000;
                
                historialFitness.add(fitnessXGenracion);
                mejoresFitness.add(c.get(c.size()-1).fitness);
                historialTime.add(tiempo);
                
                
            
        }
        
        
         System.out.println("-----------------------Fitness----------------------------");
        for (int i = 0; i < 100; i++) {

            
            System.out.println(mejoresFitness.get(i));
        }
        System.out.println("-----------------------Tiempos ----------------------------");
        for (int i = 0; i < 100; i++) {

            
            System.out.println(historialTime.get(i));
        }
        System.out.println("-----------------------Evolucion del Mejor Fitness por Generacion de la Mejor Corrida ----------------------------");
            

            for (int j = 0; j <historialFitness.get(indexMax).size() ; j++) {
                Cromosoma aux = (Cromosoma) historialFitness.get(indexMax).get(j);
                System.out.println(aux.getFitness());
            }
       
        //System.out.println(maxFit+" "+indexMax);
    }
    
    
    
    
    
}
