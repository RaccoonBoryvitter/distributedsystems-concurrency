/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.redscarf.distributedsystems.concurrency.threads;

import com.github.redscarf.distributedsystems.concurrency.models.Counter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Pavlo
 */
public class CounterProcessorThread implements Runnable {

    private final Counter counter;
    private static final Logger logger = LogManager.getLogger(CounterProcessorThread.class);

    public CounterProcessorThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        logger.info("Incrementing the counter...");
        counter.increment();
        logger.info("The value of counter is {}", counter.value());
    }

}
