package com.main;

import java.awt.*;

public class Main extends Canvas implements Runnable {

    public static final int Wi = 960, He = 720;

    public Main(){
        new Window(Wi, He, "Factoreum", this);

    }

    public synchronized void start() {

    }

    public void run(){

    }

    public static void main(String[] args) {

        new Main();

    }
}
