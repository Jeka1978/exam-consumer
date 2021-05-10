package com.epam.examconsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.aspectj.apache.bcel.classfile.annotation.AnnotationGen;
import org.aspectj.util.TypeSafeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Evgeny Borisov
 */
@Component
public class ConsumerFlowManagerImpl implements ConsumerFlowManager {

    @Value("${input_dir}")
    private String dirFrom;

    @Value("${output_dir}")
    private String dirTo;

    private File rootDir;
    private File outputDir;

    private Queue<String> filesInProcess = new ArrayBlockingQueue<String>(10);

    @Autowired
    private QuoteToJsonConverter jsonConverter;
    private QuoterReader quoteReader;
    private QuoteWriter quoterWriter;

    @PostConstruct
    public void init(){
        rootDir = new File(dirFrom);
        outputDir = new File(dirTo);
    }

    @Override
    @SneakyThrows
    public void handle() {
        File rootDir = this.rootDir;
        String[] fileNames = rootDir.list();
        if (fileNames.length != 0) {
            for (String fileName : fileNames) {
                if (!filesInProcess.contains(fileName)) {
                    filesInProcess.add(fileName);
                    Quote quote =  quoteReader.read(fileName);
                    String json = jsonConverter.read(quote);
                    quoterWriter.write(json,quote.getId());
                }
            }
        }
    }



    @Scheduled(fixedDelay = 30000)
    public void cleanUp(){
        String[] list = outputDir.list();
        for (String fileName : list) {
            String id = fileName.split("\\.")[0];
            File file = new File(id + dirFrom+"\\.obj");
            file.delete();
          //  removeFromSet();
        }
    }

}


