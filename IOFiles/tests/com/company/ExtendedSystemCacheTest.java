package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.*;

public class ExtendedSystemCacheTest {


    private ExtendedSystemCache Cache;
    private ExtendedSystemCache testCache;
    private ScatterSystem system;

    @Before
    public void setUp() throws Exception {
        testCache = new ExtendedSystemCache();
        Cache = new ExtendedSystemCache();
        system = new ScatterSystem();
    }

    @After
    public void tearDown() throws Exception {
        testCache = null;
        system = null;
    }

    @Test
    public void FileTest() throws IOException{
        int i=0;
        String path = "data.csv";
        double[] input = {10,12,3,100,40,11};
        Double output = testCache.get(input);
        try{
        if(output == null)
        {
            output = system.getGreatestNumber(input);

            testCache.put(input,output);
            Cache.put(input,output);

        }

            testCache.ExportCSV(path);
            testCache.ImportCSV(path);
            if(testCache.getCache().equals(Cache.getCache()))
            {
                i=1;
            }
            assertEquals(1,i);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }


    public void serializeTest(){


    }

}