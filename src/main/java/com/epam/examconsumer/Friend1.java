package com.epam.examconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
public class Friend1 {

    @Autowired
    private ConsumerFlowManager consumerFlowManager;

    public Friend1() {
        System.out.println("friend 1 is with us");
    }
}
