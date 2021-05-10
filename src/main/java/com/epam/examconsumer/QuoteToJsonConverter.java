package com.epam.examconsumer;

/**
 * @author Evgeny Borisov
 */
public interface QuoteToJsonConverter {
    String read(Quote quote);
}
