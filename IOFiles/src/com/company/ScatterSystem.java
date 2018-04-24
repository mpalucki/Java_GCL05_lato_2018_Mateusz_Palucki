package com.company;

public class ScatterSystem {
    public double getGreatestNumber(double[] input)
    {
        double tmp = 0;
        for(int i=0;i<input.length;i++)
        {
            if(input[i] > tmp)
                tmp = input[i];
        }
        return tmp;
    }
}
