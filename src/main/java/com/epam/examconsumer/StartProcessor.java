package com.epam.examconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class StartProcessor {
    @Autowired
    private ConsumerFlowManager flowManager;

    @Scheduled(fixedDelay = 10000)
    public void start() {
        flowManager.handle();
    }
}
