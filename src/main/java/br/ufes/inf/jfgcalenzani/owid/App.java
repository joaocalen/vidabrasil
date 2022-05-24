package br.ufes.inf.jfgcalenzani.owid;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import br.ufes.inf.jfgcalenzani.owid.BirthRecord;

public class App 
{
    public enum Headers {
        ENTITY, CODE, YEAR, LIFEFEMALE, LIFEMALE
    }
    public static void main( String[] args )
    {
        Reader in = null;
        try {
            in = new FileReader(args[0]);
        } catch (FileNotFoundException e) {            
            e.printStackTrace();
        }
        Iterable<CSVRecord> records = null;
        List<BirthRecord> birthRecords = new ArrayList<>();
        try {
            records = CSVFormat.RFC4180.withHeader(Headers.class).parse(in);
        } catch (IOException e) {            
            e.printStackTrace();
        }
        for (CSVRecord record : records) {
            String entity = record.get(Headers.ENTITY);
            String code = record.get(Headers.CODE);
            Integer year;
            try {
                year = Integer.parseInt(record.get(Headers.YEAR));    
            } catch (NumberFormatException nfe) {
                continue;
            }            
            Float lifeExpectMale = Float.parseFloat(record.get(Headers.LIFEMALE));
            Float lifeExpectFemale = Float.parseFloat(record.get(Headers.LIFEFEMALE));
            BirthRecord br = new BirthRecord(entity, code, year, lifeExpectMale, lifeExpectFemale);
            if(year == 2020)
                birthRecords.add(br);
        }
        Collections.sort(birthRecords);       
        for(BirthRecord br : birthRecords)
        {
            System.out.println(br);
        }
    }
}
