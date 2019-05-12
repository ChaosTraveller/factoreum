package com.main;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable{

    public static final int WI = 960, HE = 720;
    public static final int[] x = {20,125, 230, 335, 440, 545}, y = {60, 165, 270, 375, 480, 585};

    private Thread action;
    private boolean r = false;

    private Handler handler;
    private GUI gui;

    public Main(){
        handler = new Handler();

        new Window(WI, HE, "Factoreum", this);

        gui = new GUI();

        handler.addMachine(new Solar(x[0], y[0], 20, 1, ID.Solar));
        handler.addMachine(new Solar(x[1], y[1], 20, 2, ID.Solar));
        handler.addMachine(new Solar(x[2], y[2], 20, 3, ID.Solar));
        handler.addMachine(new Solar(x[3], y[3], 20, 4, ID.Solar));
        handler.addMachine(new Solar(x[4], y[4], 20, 5, ID.Solar));
        handler.addMachine(new Solar(x[5], y[5], 20, 6, ID.Solar));
        handler.addMachine(new FuelGen(x[4], y[3], 20, 2, ID.Fuel));
        handler.addMachine(new NuclearGen(x[1], y[3], 20, 3, ID.Nuclear));
    }

    public synchronized void start() {

        action = new Thread(this);
        action.start();
        r = true;

    }

    public synchronized void stop() {

        try {
            action.join();
            r = false;
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void run(){

        long lastTime = System.nanoTime();
        double ticks = 30.0;
        double ns = 1000000000 / ticks;
        double d = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (r){
            long now = System.nanoTime();
            d += (now - lastTime) / ns;
            lastTime = now;
            while (d >= 1) {
                tick();
                d--;
            }
            if (r){
                render();
            }
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick(){
        handler.tick();
        gui.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics gr = bs.getDrawGraphics();
        gr.setColor(Color.black);
        gr.fillRect(0,0, WI, HE);
        gui.render(gr);
        handler.render(gr);

        gr.dispose();
        bs.show();

    }

    public static void main(String[] args) {

        new Main();

    }
}
