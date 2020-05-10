package com.example.AeroParker.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.common.io.Files;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import net.bytebuddy.asm.Advice.Return;

@Component
public class CsvUtils {
    private Scanner scanner;


    private  final CsvMapper mapper = new CsvMapper();
    public  <T> List<T> read(Class<T> clazz, InputStream stream) throws IOException {
        CsvSchema schema = mapper.schemaFor(clazz).withHeader().withColumnSeparator('|');
        ObjectReader reader = mapper.readerFor(clazz).with(schema);
        return reader.<T>readValues(stream).readAll();
    }


    // Not reading items in csv
    public  <T> List<T> loadObjectList(Class<T> type, String fileName) {
        try {
            CsvSchema schema = CsvSchema.emptySchema().withHeader().withLineSeparator("\n");
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues = mapper.readerFor(type).with(schema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            // logger.error("Error occurred while loading object list from file " + fileName, e);
            return Collections.emptyList();
        }
    }




    public void openFile(File file) {
        
        try {
            scanner = new Scanner( file );
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Couldn't find the file");
        }
    }

    public List<String> readFileReturnList() {
        List<String> values = new ArrayList<String>();
        while( scanner.hasNext() ){
            String stringValue = scanner.nextLine();
            if ( !stringValue.matches("Name") ) { 
                values.add(stringValue);
            }
            // System.out.println(stringValue);
        }
        return values;
    }


    public void closeFile(){
        scanner.close();
    }
    
}