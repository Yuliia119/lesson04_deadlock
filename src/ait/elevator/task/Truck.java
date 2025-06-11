package ait.elevator.task;

import ait.elevator.model.Elevator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Truck implements Runnable {
    private static Lock mutex = new ReentrantLock();
    private int nRaces;
    private int capacity;
    private Elevator elevator;

    public Truck(int nRaces, int capacity, Elevator elevator) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevator = elevator;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {

                mutex.lock();
                try {
                    elevator.add(capacity);
                } finally {
                    mutex.unlock();
                }


        }
    }

}

