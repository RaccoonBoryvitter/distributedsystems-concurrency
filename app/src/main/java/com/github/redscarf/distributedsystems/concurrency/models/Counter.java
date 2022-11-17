/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.redscarf.distributedsystems.concurrency.models;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
/**
 *
 * @author Pavlo
 */
public class Counter {
    private int counterValue = 0;
    private final Lock locker;

    public Counter(Lock locker) {
        this.locker = locker;
    }

    public void increment() {
        try {
            locker.tryLock(10, TimeUnit.SECONDS);
            
            int a;
            a = counterValue;
            Thread.sleep(100);
            a++;
            counterValue = a;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            locker.unlock();
        }
    }

    public void decrement() {
        try {
            locker.tryLock(10, TimeUnit.SECONDS);
            
            int a;
            a = counterValue;
            Thread.sleep(100);
            a--;
            counterValue = a;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            locker.unlock();
        }
    }

    public int value() {
        return this.counterValue;
    }
}
