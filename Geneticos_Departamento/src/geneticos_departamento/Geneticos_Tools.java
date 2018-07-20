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
    int cont=0;
    
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
                cont++;
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
                cont++;
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
                cont++;
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
                cont++;
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
                cont++;
                break;
                
        }
        
        return puntos;
        
    }
    
    public double fitness(Cromosoma crom){
        int barrio,cls,antiguedad,precio,ambientes,puntajeCaracteristicas,puntajeRestricciones,costoPorAmbiente,probabilidadExistencia;
        barrio = this.puntosBarrio(crom.getBarrio());
        cls = this.puntosCls(crom.getCls());
        antiguedad = this.puntosAntiguedad(crom.getAntiguedad());
        precio = this.puntosAmbiente(crom.getPrecioAlquiler());
        ambientes = this.puntosAmbiente(crom.getAmbientes());
        puntajeCaracteristicas = barrio + cls + antiguedad + precio + ambientes;
        costoPorAmbiente = (int) (10*(ambientes/precio));
        probabilidadExistencia = (int) (10*(precio/barrio));
        if(costoPorAmbiente<0){
            costoPorAmbiente *= -1;
        }
        if(probabilidadExistencia<0){
            probabilidadExistencia *= -1;
        }
        
        puntajeRestricciones = costoPorAmbiente + probabilidadExistencia;

        return puntajeCaracteristicas + puntajeRestricciones;
        
    }
    
    public ArrayList<Cromosoma> selection(ArrayList<Cromosoma> croms, int n){
        int index =0,cont=0;
        ArrayList<Cromosoma> aux =  new ArrayList<Cromosoma>();
        
        for (int i = 0; i < n; i++) {
            aux.add(croms.get(croms.size()-1));
            croms.remove(croms.size()-1);
            
        }
        
        
        /*double maxFitness= croms.get(0).getFitness();
        double currentFitness=0;
        for(int i=0; i < croms.size(); i++){
            currentFitness =  croms.get(i).getFitness();
            if(currentFitness > maxFitness){
                maxFitness = currentFitness;
                index = i;
            }
        }*/
        return aux;
    }
    
    public ArrayList<Cromosoma> crossover(ArrayList<Cromosoma> croms){
         byte[] padre = croms.get(0).getCromosoma();
         byte[] madre = croms.get(1).getCromosoma();
         byte[] hijo1 = new byte[padre.length];
         byte[] hijo2 = new byte[padre.length];
         Cromosoma aux1 = new Cromosoma(13);
         Cromosoma aux2 = new Cromosoma(13);
         ArrayList<Cromosoma> children = new ArrayList<Cromosoma>();
 
         for (int j = 0; j < padre.length; j++) {

             if(Math.random()<0.5){
                hijo1[j]= padre[j];
                hijo2[j] = madre[j];

            }
            else{

                hijo1[j]= madre[j];
                hijo2[j] = padre[j];
            }

         }
         aux1.setCromosoma(hijo1);
         aux2.setCromosoma(hijo2);
         
         children.add(aux1);
         children.add(aux2);
         
         return children;

     }
    
    
    
    public void mutation(ArrayList<Cromosoma> children) {
        byte [] m  = new byte[13];
        int random;
        for(int i=0; i< children.size();i++){
            m = children.get(i).getCromosoma();
            for(int j=0;j< m.length; j++){
                 random =  (int)(Math.random() * (100+1)); 
                 if(random<= 50){
                     if(m[j]==0)
                         m[j]=1;
                     else
                         m[j]=0;
                 }
            }
            
            children.get(i).setCromosoma(m);
            
            
            
            
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
