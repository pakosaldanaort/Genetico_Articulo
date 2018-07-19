/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos_departamento;

/**
 *
 * @author francisco_saldana
 */
public class Cromosoma {
    
    public byte cromosoma[];
    public double fitness;
    public int size;
    public String barrio;
    public String cls;
    public String antiguedad;
    public String precioAlquiler;
    public String ambientes;
    public String cromoString;
    
    
    public Cromosoma(int size){
        cromosoma = new byte[size];
    }

    public String getBarrio() {
       
        barrio = this.cromoString.substring(0,3);
        
        
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCls() {
        cls =  this.cromoString.substring(3,6);
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getAntiguedad() {
        antiguedad = this.cromoString.substring(6,8);
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getPrecioAlquiler() {
        precioAlquiler = this.cromoString.substring(8,11);
        return precioAlquiler;
    }

    public void setPrecioAlquiler(String precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public String getAmbientes() {
        ambientes = this.cromoString.substring(11,13);
        return ambientes;
    }

    public void setAmbientes(String ambientes) {
        this.ambientes = ambientes;
    }
    

    public byte[] getCromosoma() {
        return cromosoma;
    }

    public void setCromosoma(byte[] cromosoma) {
        String stringCromosoma = "";
        this.cromosoma = cromosoma;
        
       
        for(byte bit : this.cromosoma){
            stringCromosoma+= bit;
        }
        
        this.cromoString = stringCromosoma;
        
        
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        
        String stringCromosoma = "";
        
       
        for(byte bit : this.cromosoma){
            stringCromosoma+= bit;
        }
        
        return "Cromosoma{" + "cromosoma=" + stringCromosoma + ", fitness=" + fitness + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
