package com.main;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable {

    public static final int wi = 960, he = 720;

    private Thread action;
    private boolean r = false;

    private Handler handler;

    public Main(){
        new Window(wi, he, "Factoreum", this);

        handler = new Handler();

        handler.addMachine(new Solar(50, 50, 20, 1, ID.Solar));
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
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics gr = bs.getDrawGraphics();
        gr.setColor(Color.black);
        gr.fillRect(0,0, wi, he);

        handler.render(gr);

        gr.dispose();
        bs.show();

    }

    public static void main(String[] args) {

        new Main();

    }
}
