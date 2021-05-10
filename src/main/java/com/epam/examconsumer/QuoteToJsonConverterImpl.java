package com.epam.examconsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class QuoteToJsonConverterImpl implements QuoteToJsonConverter {
    @Autowired
    private ObjectMapper mapper;

    @Override
    @SneakyThrows
    public String read(Quote quote) {
        return mapper.writeValueAsString(quote);
    }

}
