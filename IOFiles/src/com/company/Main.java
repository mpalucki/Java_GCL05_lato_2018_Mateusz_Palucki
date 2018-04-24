package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String path = "data_serialize.csv";
	    ScatterSystem system = new ScatterSystem();
        ExtendedSystemCache cache = new ExtendedSystemCache();


        double[] input = {1,2,3,4,5};
        Double output = cache.get(input);

        if(output == null)
        {
            output = system.getGreatestNumber(input);
            cache.put(input,output);
        }
        try {
            File file = new File("data1.csv");
            cache.ExportCSV(file);
            cache.ImportCSV(file);

            cache.serialize(path);
            cache.deserialize(path);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
