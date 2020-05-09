package com.example.AeroParker.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import org.springframework.core.io.ClassPathResource;

public class CsvUtils {
    private static final CsvMapper mapper = new CsvMapper();
    public static <T> List<T> read(Class<T> clazz, InputStream stream) throws IOException {
        CsvSchema schema = mapper.schemaFor(clazz).withHeader().withColumnSeparator('|');
        ObjectReader reader = mapper.readerFor(clazz).with(schema);
        return reader.<T>readValues(stream).readAll();
    }


    // Not reading items in csv
    public static <T> List<T> loadObjectList(Class<T> type, String fileName) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues = mapper.readerFor(type).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            // logger.error("Error occurred while loading object list from file " + fileName, e);
            return Collections.emptyList();
        }
    }
}