package com.company;

public class ThreadBro extends Thread {
    public ThreadBro(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(   ThreadBro.currentThread().getName());


    }




}
