package com.epam.examconsumer;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.file.Paths;

/**
 * @author Evgeny Borisov
 */
@Component
public class FileQuoteWriter implements QuoteWriter {

    @Value("${output_dir}")
    private String dirTo;

    @SneakyThrows
    @Override
    @Async
    public void write(String json,long id) {
        FileWriter fileWriter = new FileWriter(dirTo+"/");
        fileWriter.write(json);
        fileWriter.flush();
        fileWriter.close();
    }
}





