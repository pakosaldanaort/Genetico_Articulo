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
                
                if(Math.random()>0.5){
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
                puntos = 0;
                cont+=50;
                break;
                
        }
        
        return puntos;
        
    }
    
    public String toBarrio(String barrio){
        String nombre="";
        switch (barrio){
            case "010":
                nombre = "Almagro";
                break;
            
            case "011":
                nombre = "Balvanera";
                break;
                
            case "100":
                nombre = "Caballito";
                break;
                
            case "101":
                nombre = "Belgrano";
                break;
                
            case "110":
                nombre = "Parque Patricios";
                break;
                
            
                
        }
        
        return nombre;
        
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
                puntos = 0;
                cont+=50;
                break;
                
        }
        
        return puntos;
        
    }
    
    public String toCls(String cls){
        String distancia="";
        switch (cls){
            case "010":
                distancia = "Hasta 100 m";
                break;
            
            case "011":
                distancia = "Entre 100 y 200 metros";
                break;
                
            case "100":
                distancia = "Entre 200 y 300 metros";
                break;
                
            case "101":
                distancia = "Entre 300 y 400 metros";
                break;
                
            case "110":
                distancia = "Más de 400 metros";
                break;
                
            
                
        }
        
        return distancia;
        
    }
    
    public int puntosAntiguedad(String antiguedad){
        int puntos=0;
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
                
                
            
                
        }
        
        return puntos;
        
    }
    
    public String toAntiguedad(String antiguedad){
        String ant="";
        switch (antiguedad){
            case "00":
                ant = "A estrenar";
                break;
            
            case "01":
                ant = "hasta 10 años";
                break;
                
            case "11":
                ant = "hasta 20 años";
                break;
                
            case "10":
                ant = "30 años o más:";
                break;
                
                
            
                
        }
        
        return ant;
        
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
                puntos = 0;
                cont+=50;
                break;
                
        }
        
        return puntos;
        
    }
    
    public String toPrecio(String precio){
        String pre ="";
        switch (precio){
            case "001":
                pre = "Hasta $3000";
                break;
            
            case "010":
                pre = "De $3000 a $3500";
                break;
                
            case "011":
                pre = "De $3500 a $4000";
                break;
                
            case "100":
                pre = "De $4000 a $5500";
                break;
                
            case "101":
                pre = "Mayor a $5500";
                break;
                
            
                
        }
        
        return pre;
        
    }
    
    public int puntosAmbiente(String ambiente){
        int puntos=0;
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
                
                
            
        }
        
        return puntos;
        
    }
    
    public String toAmbiente(String ambiente){
        String amb="";
        switch (ambiente){
            case "00":
                amb = "1 ambiente";
                break;
            
            case "01":
                amb = "2 ambientes";
                break;
                
            case "10":
                amb = "3 ambientes";
                break;
                
            case "11":
                amb = "4 ambientes o más";
                break;
                
                
            
                
        }
        
        return amb;
        
    }
    
    public double fitness(Cromosoma crom){
        int barrio,cls,antiguedad,precio,ambientes,a=0,puntajeCaracteristicas,puntajeRestricciones,costoPorAmbiente =0,probabilidadExistencia =0;
        barrio = this.puntosBarrio(crom.getBarrio());
        cls = this.puntosCls(crom.getCls());
        antiguedad = this.puntosAntiguedad(crom.getAntiguedad());
        precio = this.puntosPrecio(crom.getPrecioAlquiler());
        ambientes = this.puntosAmbiente(crom.getAmbientes());
        puntajeCaracteristicas = barrio + cls + antiguedad + precio + ambientes;
        if(precio != 0 & barrio!=0 ){
            costoPorAmbiente = (int) (10*(ambientes/precio));
            probabilidadExistencia = (int) (10*(precio/barrio));
        }
        
        
        if(costoPorAmbiente<0){
            costoPorAmbiente *= -1;
        }
        if(probabilidadExistencia<0){
            probabilidadExistencia *= -1;
        }
        
        puntajeRestricciones = costoPorAmbiente + probabilidadExistencia-cont;
        cont = 0;
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

         double ram;
         byte[] padre = croms.get(0).getCromosoma();
         byte[] madre = croms.get(1).getCromosoma();
         byte[] hijo1 = new byte[padre.length];
         byte[] hijo2 = new byte[padre.length];
         Cromosoma aux1 = new Cromosoma(13);
         Cromosoma aux2 = new Cromosoma(13);
         ArrayList<Cromosoma> children = new ArrayList<Cromosoma>();
 
         for (int j = 0; j < padre.length; j++) {
             ram=Math.random();
             if(ram<0.5){
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
    
    public ArrayList<Cromosoma> crossoverMejorado(ArrayList<Cromosoma> croms){
  
         byte[] padre = croms.get(0).getCromosoma();
         
         
         byte[] madre = croms.get(1).getCromosoma();
 
         
         Cromosoma aux1 = new Cromosoma(13);
         Cromosoma aux2 = new Cromosoma(13);
         ArrayList<Cromosoma> children = new ArrayList<Cromosoma>();
 
         
         aux1.setCromosoma(child(padre,madre));
         aux2.setCromosoma(child(madre,padre));
         
         
         children.add(aux1);
         children.add(aux2);
 
         
         return children;

     }
    
    public byte[] child(byte [] padre,byte[]madre){
        
        byte hijo[] = new byte[13];

        for (int i = 0; i < 3; i++) {
            hijo[i] = madre[i];
        }
        for (int j = 3; j < 8; j++) {

         hijo[j] = padre[j];


        }
        for (int i = 8; i < 13; i++) {
            hijo[i] = madre[i];
        }
        return hijo;
            
    }

    public void mutation(ArrayList<Cromosoma> children) {
        byte [] m  = new byte[13];
        double random;
        for(int i=0; i< children.size();i++){
            m = children.get(i).getCromosoma();
            for(int j=0;j< m.length; j++){
                 random =  Math.random() ; 
                 if(random<0.5){
                     if(m[j]==0)
                         m[j]=1;
                     else
                         m[j]=0;
                 }
            }
            
            children.get(i).setCromosoma(m);
            
            
            
            
        }
        
    }
    
    public void mutationMejorada(ArrayList<Cromosoma> children) {
        byte [] m  = new byte[13];
        double random;
        for(int i=0; i< children.size();i++){
            m = children.get(i).getCromosoma();
            random =  Math.random() ; 
            if(random < 0.5){
                for(int j=0;j< m.length; j++){
                 random =  Math.random() ; 
                 if(random<0.5){
                     if(m[j]==0)
                         m[j]=1;
                     else
                         m[j]=0;
                 }
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
