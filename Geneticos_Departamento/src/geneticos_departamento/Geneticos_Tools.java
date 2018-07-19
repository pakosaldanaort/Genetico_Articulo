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
public class Geneticos_Tools {
    
    
    public ArrayList<Cromosoma> generateIndividuos(int size, int poblacionSize){
        
        Cromosoma individuo ;
        ArrayList<Cromosoma> individuos = new ArrayList<Cromosoma>();
        byte aux[];
        for (int i = 0; i < poblacionSize; i++) {
           aux  = new byte [size];
           individuo = new Cromosoma(size);
            for (int j = 0; j < size; j++) {
                if(Math.random()<0.5){
                    aux[j]= 0;
                    
                    
                }
                else{
                    
                    aux[j]= 1;
                }
            }
            
            individuo.setCromosoma(aux);
            individuos.add(individuo);
            
            
        }
       
        return individuos;
                
        
    }
    
    
    public int puntosBarrio(String barrio){
        int puntos;
        switch (barrio){
            case "010":
                puntos = 7;
                break;
            
            case "011":
                puntos = 5;
                break;
                
            case "100":
                puntos = 8;
                break;
                
            case "101":
                puntos = 10;
                break;
                
            case "110":
                puntos = 1;
                break;
                
            default:
                puntos = -50;
                break;
                
        }
        
        return puntos;
        
    }
    
    public int puntosCls(String cls){
        int puntos;
        switch (cls){
            case "010":
                puntos = 10;
                break;
            
            case "011":
                puntos = 8;
                break;
                
            case "100":
                puntos = 5;
                break;
                
            case "101":
                puntos = 3;
                break;
                
            case "110":
                puntos = 1;
                break;
                
            default:
                puntos = -50;
                break;
                
        }
        
        return puntos;
        
    }
    
    public int puntosAntiguedad(String antiguedad){
        int puntos;
        switch (antiguedad){
            case "00":
                puntos = 10;
                break;
            
            case "01":
                puntos = 7;
                break;
                
            case "11":
                puntos = 4;
                break;
                
            case "10":
                puntos = 1;
                break;
                
                
            default:
                puntos = -50;
                break;
                
        }
        
        return puntos;
        
    }
    
    public int puntosPrecio(String precio){
        int puntos;
        switch (precio){
            case "001":
                puntos = 10;
                break;
            
            case "010":
                puntos = 8;
                break;
                
            case "011":
                puntos = 6;
                break;
                
            case "100":
                puntos = 4;
                break;
                
            case "101":
                puntos = 1;
                break;
                
            default:
                puntos = -50;
                break;
                
        }
        
        return puntos;
        
    }
    
    public int puntosAmbiente(String ambiente){
        int puntos;
        switch (ambiente){
            case "00":
                puntos = 0;
                break;
            
            case "01":
                puntos = 5;
                break;
                
            case "10":
                puntos = 8;
                break;
                
            case "11":
                puntos = 10;
                break;
                
                
            default:
                puntos = -50;
                break;
                
        }
        
        return puntos;
        
    }
    
    public void fitness(Cromosoma crom){
        int barrio,cls,antiguedad,precio,ambientes,puntajeCaracteristicas,puntajeRestricciones,costoPorAmbiente,probabilidadExistencia;
        barrio = this.puntosBarrio(crom.getBarrio());
        cls = this.puntosCls(crom.getCls());
        antiguedad = this.puntosAntiguedad(crom.getAntiguedad());
        precio = this.puntosAmbiente(crom.getPrecioAlquiler());
        ambientes = this.puntosAmbiente(crom.getAmbientes());
        
        puntajeCaracteristicas = barrio + cls + antiguedad + precio + ambientes;
        costoPorAmbiente = (int) (10*(ambientes/precio));
        probabilidadExistencia = (int) (10*(precio/barrio));
        puntajeRestricciones = costoPorAmbiente + probabilidadExistencia;
        crom.setFitness(puntajeCaracteristicas + puntajeRestricciones);
        
        
    }
    
    public int selection(ArrayList<Cromosoma> croms){
        int index =0;
        double maxFitness= croms.get(0).getFitness();
        double currentFitness=0;
        for(int i=0; i < croms.size(); i++){
            currentFitness =  croms.get(i).getFitness();
            if(currentFitness > maxFitness){
                maxFitness = currentFitness;
                index = i;
            }
        }
        return index;
    }
    
    public ArrayList<Cromosoma> crossover(int index,ArrayList<Cromosoma> croms){
         byte[] mparent1 = croms.get(index).getCromosoma();
         ArrayList<Cromosoma> children = new ArrayList<Cromosoma>();
         for(int i=0; i < croms.size();i++){
             if(i!= index){

                 byte[] mparent2 = croms.get(i).getCromosoma();
                 Cromosoma child = new Cromosoma( 13);        
                 Cromosoma child2 = new Cromosoma( 13 );
                 child.setCromosoma(newChild(mparent1,mparent2));
                 child2.setCromosoma(newChild(mparent2,mparent1));
                 children.add(child);
                 children.add(child2);
                 fitness(child);
                 fitness(child2);

             }
         }
         return children;

     }
    
    public byte[] newChild(byte[] parent1, byte[] parent2){
        byte[] child = new byte[13];
        
        child[0]=parent1[0];
        child[1]=parent1[1];
        child[2]=parent2[2];
        child[3]=parent2[3];
        child[4]=parent2[4];
        child[5]=parent1[5];
        child[6]=parent1[6];
        child[7]=parent1[7];
        
        child[8]=parent1[8];
        child[9]=parent1[9];
        child[10]=parent2[10];
        child[11]=parent2[11];
        child[12]=parent2[12];
        
        
        return child;
    } 
    
    public void mutation(ArrayList<Cromosoma> children) {
        byte [] m  = new byte[13];
        int random;
        for(int i=0; i< children.size();i++){
            m = children.get(i).getCromosoma();
            random =  (int)(Math.random() * (100+1)); 
            if(random<= 50){
               
                for(int j=0;j< m.length; j++){
                     random =  (int)(Math.random() * (100+1)); 
                     if(random<= 50){
                         if(m[j]==0)
                             m[j]=1;
                         else
                             m[j]=0;
                     }
                }
             
            }
        }
        
    }
    
    public void limpiar(ArrayList<Cromosoma> crom){
        int size = crom.size();
        if(size>10){
            int index =0;
            double minFitness=  crom.get(0).getFitness() ;
            double currentFitness=0;
            
            for(int i=0; i < crom.size(); i++){
                currentFitness =  crom.get(i).getFitness() ;
                
                if(currentFitness <  minFitness){
                    minFitness = currentFitness;
                    index = i;
                }
            }
          
            crom.remove(index);
            limpiar(crom);
        }
    
    
    }
    
    
    public void Bubblesort(ArrayList<Cromosoma> crom){
        Cromosoma buffer;
        int i,j;
        for(i = 0; i < crom.size(); i++)
            {
            for(j = 0; j < i; j++)
            {
                if(crom.get(i).getFitness() < crom.get(j).getFitness())
                {
                    buffer = crom.get(j);
                    crom.set(j, crom.get(i));
                    crom.set(i, buffer) ;
                }
            }
        }
    }
    
    public String byteToString(Cromosoma crom){
        String bytes = "";
        byte arr[] = crom.getCromosoma();
        for (byte b : arr) {
            bytes += b;
        }
        
        return bytes;
    }
    
    
    
    
}