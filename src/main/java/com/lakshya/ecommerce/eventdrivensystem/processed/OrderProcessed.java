package com.lakshya.ecommerce.eventdrivensystem.processed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;


public class OrderProcessed {

    private Random random = new Random();

    // define the methord
    public List<String> getCatagoryMap(){
        // define the properties
        List<String> lookUp = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(FileConfig.INVENTORY_FILE));
            String headerLine = br.readLine();
            // define the condition
            if(headerLine == null){
                return lookUp;
            }
            String[] headers = headerLine.split(",");
            int idIdx = findColumnIdx(headers, FileConfig.COL_PRODUCT_ID);
            String line;
            // define the while loop
            while((line = br.readLine())!=null){
                String[] cols = parseCSVLine(line);
                // define the condition
                if(idIdx != -1 && cols.length > idIdx){
                    lookUp.add(cols[idIdx].trim());
                }
            }
        }
        catch(IOException ex){
            ex.getMessage();
        }
        return lookUp;
    }

    public void processEcommerce(List<String> list) throws IOException{
        // define the base condition
        if(list.isEmpty()){
            throw new IOException("Product ID pool is empty! Check your inventory file.");
        }
        Files.createDirectories(Paths.get(FileConfig.OUTPUT_DIR));

        try{
            BufferedReader br = new BufferedReader(new FileReader(FileConfig.ORDERS_FILE));
            BufferedWriter bw = new BufferedWriter(new FileWriter(FileConfig.UPDATED_ORDERS));
            String headerLine = br.readLine();
            if(headerLine == null){
                return ;
            }
            String[] header = parseCSVLine(headerLine);
            int idIdx = findColumnIdx(header, FileConfig.COL_PRODUCT_ID);
            int catIdx = findColumnIdx(header, FileConfig.COL_CATAGORY);
            String line;
            bw.write(generateLine(header, catIdx));
            bw.newLine();

            // define the while loop
            while((line = br.readLine())!= null){
                String[] col = parseCSVLine(line);
                // define the condition
                if(idIdx != -1 && idIdx < col.length){
                    int randomIndex = random.nextInt(list.size());
                    String newId = list.get(randomIndex);
                    col[idIdx] = newId;
                }
                bw.write(generateLine(col, catIdx));
                bw.newLine();
            }
        }
        catch(IOException ex){
            ex.getMessage();
        }

    }

    // define the helper class
    private int findColumnIdx(String[] header ,String target){
        // define the for-each loop
        for(int i = 0;i<header.length;i++){
            // define the condition
            if(header[i].replace("\"", "").trim().equalsIgnoreCase(target)){
                return i;
            }
        }
        return -1;
    }
    private String[] parseCSVLine(String line) {
        return line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
    }

    private String generateLine(String[] header , int catIdx){
        StringJoiner join = new StringJoiner(",");
        // define the for-loop
        for(int i = 0;i< header.length;i++){
            // define the condition
            if(i != catIdx){
                join.add(header[i]);
            }
        }
        return join.toString();
    }
}
