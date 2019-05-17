package factoreum;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable {

    public static final int WI = 960, HE = 720;
    public static final int[] x = {20,125, 230, 335, 440, 545}, y = {60, 165, 270, 375, 480, 585};

    public Color c1 = new Color(0, 14, 33);
    public Color c2 = new Color(255, 172, 23);
    public Color c3 = new Color(255, 188, 91);

    private Thread action;
    private boolean r = false;

    private Handler handler =  Handler.getInstance();
    private GUI gui = GUI.getInstance();
    public static Menu menu = new Menu();
    public static Store store = new Store();
    public static Build build = new Build();
    public static Upgrade upgrade = new Upgrade();


    public Main(){

        this.addMouseListener(gui);
        this.addMouseListener(store);
        this.addMouseListener(menu);
        this.addMouseListener(build);
        this.addMouseListener(upgrade);

        new Window(WI, HE, "Factoreum", this);


//        handler.addMachine(new Solar(x[0], y[0], 20, 1, ID.Solar));
//        handler.addMachine(new CoolingSystem(x[1], y[1], 20, 3, ID.Cooler));
//        handler.addMachine(new Solar(x[2], y[2], 20, 3, ID.Solar));
//        handler.addMachine(new Solar(x[3], y[3], 20, 4, ID.Solar));
//        handler.addMachine(new Solar(x[4], y[4], 20, 5, ID.Solar));
//        handler.addMachine(new Solar(x[5], y[5], 20, 6, ID.Solar));
//        handler.addMachine(new FuelGen(x[4], y[3], 20, 2, ID.Fuel));
//        handler.addMachine(new NuclearGen(x[1], y[3], 20, 3, ID.Nuclear));
//        handler.addMachine(new Miner(x[0], y[5], 20, 2, ID.Miner));
//        handler.addMachine(new Miner(x[1], y[5], 20, 3, ID.Miner));
//        handler.addMachine(new Miner(x[0], y[4], 20, 4, ID.Miner));
//        handler.addMachine(new Miner(x[1], y[4], 20, 5, ID.Miner));
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
        menu.tick();
        store.tick();
        build.tick();
        upgrade.tick();

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
