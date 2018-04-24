package com.company;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.supercsv.io.CsvListWriter;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
import java.util.*;
import java.lang.Object;

public class ExtendedSystemCache extends SystemCache implements Serializable {

    //ArrayList<HashMap<Parameter,Double>> myArrList = new ArrayList<HashMap<Parameter,Double>>();

    public void Export(FileWriter write)
    {
        try (ICsvListWriter listWriter = new CsvListWriter(write,
                CsvPreference.STANDARD_PREFERENCE)){
            for (Map.Entry<Parameter, Double> entry : cache.entrySet()){
                listWriter.write(entry.getKey().changeToString(), entry.getValue());
                cache.remove(entry.getKey());
            }
            listWriter.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void Export(OutputStreamWriter write)
    {
        try (ICsvListWriter listWriter = new CsvListWriter(write,
                CsvPreference.STANDARD_PREFERENCE)){
            for (Map.Entry<Parameter, Double> entry : cache.entrySet()){
                listWriter.write(entry.getKey().changeToString(), entry.getValue());
            }
            listWriter.close();
        }
        catch (IOException ex){
            ex.printStackTrace();

        }
    }
    public void Import(FileReader read) throws IOException {
        String cvsSplitBy = ",";
        BufferedReader reader = new BufferedReader(read);
        String line;
        while((line = reader.readLine())!=null){
            String[] splited = line.split(cvsSplitBy);
            String key = splited[0];
            String value = splited[1];
            String[] split_numbers = key.split(" ");
            double[] numbers = new double[split_numbers.length];
            for(int i=0;i<split_numbers.length;i++) {
                System.out.println(split_numbers[i]);
                numbers[i] = Double.parseDouble(split_numbers[i]);
                //System.out.println(numbers[i]);
            }
            Parameter tmp = new Parameter(numbers);
            cache.put(tmp,Double.parseDouble(value));


        }
        reader.close();
    }
    public void Import(InputStreamReader read) throws IOException {

        BufferedReader reader = new BufferedReader(read);
        String tmp;
        while((tmp = reader.readLine())!=null){
            String[] splited = tmp.split(",");
            String key = splited[0];
            String value = splited[1];
            String[] split_numbers = key.split(" ");
            double[] numbers = new double[split_numbers.length];
            for(int i=0;i<split_numbers.length;i++) {
                //System.out.println(split_numbers[i]);
                numbers[i] = Double.parseDouble(split_numbers[i]);
                //System.out.println(numbers[i]);
            }
            Parameter one = new Parameter(numbers);
            cache.put(one,Double.parseDouble(value));

        }
        reader.close();
    }

    public void serialize_main(FileOutputStream stream) throws IOException {

        ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(stream);
            oos.writeObject(cache);
            oos.close();
            //stream.close();
            System.out.println("Serialized completed!");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally {
            try {
                if (oos != null)
                    oos.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }

        }


    }

    public void serialize_main(ObjectOutputStream oos) throws IOException {

        try{
            oos.writeObject(cache);
            System.out.println("Serialized completed!");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally {
            try {
                if (oos != null)
                    oos.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

    }

    public void deserialize_main(FileInputStream stream) throws IOException {
        HashMap<Parameter, Double> tmp = null;
        ObjectInputStream ois = null;
        try
        {
            ois = new ObjectInputStream(stream);
            tmp = (HashMap) ois.readObject();
            cache = tmp;
            ois.close();
            stream.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }

        catch (ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        finally {
            try {
                if (ois != null)
                    ois.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }


    public void deserialize_main(ObjectInputStream stream){
        HashMap<Parameter, Double> tmp = null;
        ObjectInputStream ois = null;
        try
        {
            ois = new ObjectInputStream(stream);
            tmp = (HashMap) ois.readObject();
            //tmp.keySet().removeAll(tmp.keySet());
            cache.putAll(tmp);

            ois.close();
            stream.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }

        catch (ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        finally {
            try{
                if(ois != null)
                    ois.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }



    public void ExportCSV(String path) throws IOException
    {
        FileWriter write = new FileWriter(path);
        Export(write);

    }

    public void ExportCSV(File file) throws IOException{

        FileWriter write = new FileWriter(file);
        Export(write);

    }

    public void ExportCSV(OutputStream stream) throws IOException{

        OutputStreamWriter write = new OutputStreamWriter(stream);
        Export(write);
    }


    public void ImportCSV(String path) throws IOException{

        String cvsSplitBy = ",";
        FileReader read = new FileReader(path);
        Import(read);
    }

    public void ImportCSV(File file) throws IOException{

        String cvsSplitBy = ",";
        FileReader read = new FileReader(file);
        Import(read);
    }

    public void ImportCSV(InputStream stream) throws IOException {

        InputStreamReader read = new InputStreamReader(stream);
        Import(read);
    }


    public void serialize(String path) throws IOException{

        FileOutputStream stream = new FileOutputStream(path);
        serialize_main(stream);

    }


    public void serialize(File file) throws IOException{
        FileOutputStream stream = new FileOutputStream(file);
        serialize_main(stream);
    }



    public void serialize(OutputStream stream) throws IOException{

        ObjectOutputStream oos = new ObjectOutputStream(stream);
        serialize_main(oos);

    }

    public void deserialize(String path) throws IOException{

        FileInputStream fis = new FileInputStream(path);
        deserialize_main(fis);
    }


    public void deserialize(File file) throws IOException{

        FileInputStream fis = new FileInputStream(file);
        deserialize_main(fis);
    }

    public void deserialize(InputStream stream) throws IOException{

        ObjectInputStream oos = new ObjectInputStream(stream);
        deserialize_main(oos);
    }
}
