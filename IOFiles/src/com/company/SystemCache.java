package com.company;

import java.io.Serializable;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;

public class SystemCache {

    protected HashMap<Parameter, Double> cache;

    public SystemCache() {
        this.cache = new HashMap<>();
    }

    public HashMap<Parameter, Double> getCache() {
        return cache;
    }

    public void setCache(HashMap<Parameter, Double> cache) {
        this.cache = cache;
    }


    public void put(double[] input, double output){
        this.cache.put(new Parameter(input),output);
    }

    public Double get(double[] input){
        return this.cache.get(new Parameter(input));
    }

    protected class Parameter implements Serializable{

        private double[] values;

        public double[] getValues() {
            return values;
        }
        public String changeToString(){
            String tmp = "";
            for(int i =0;i<values.length;i++){
                if(i==values.length-1)
                    tmp+=values[i];
                else
                    tmp += values[i]+" ";
            }
            return tmp;
        }
        public Parameter(double[] values){
            this.values=values;
        }


        @Override
        public int hashCode(){
            return 31 + Arrays.hashCode(this.values);
        }
        @Override
        public boolean equals(Object obj){
            if(this == obj)
                return true;
            if(obj == null)
                return false;
            if(this.getClass() != obj.getClass())
                return false;
            Parameter other = (Parameter) obj;
            if(!Arrays.equals(this.values,other.values))
                return false;

            return true;
        }
    }
}
