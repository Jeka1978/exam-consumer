package com.epam.examconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class Friend2 {
    public Friend2() {
        System.out.println("friend 2 is with us");
    }


    @Autowired
    private ConsumerFlowManager consumerFlowManager;
}
