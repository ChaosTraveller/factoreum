package factoreum;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable {

    private static final int WI = 960, HE = 720; // Window width and height


    private Thread action;
    private boolean r = false; // Is game running?

    private GUI gui = GUI.getInstance();
    private Handler handler =  Handler.getInstance();
    private  Menu menu = Menu.getInstance();
    private  Store store = Store.getInstance();
    private  Build build = Build.getInstance();
    private MachineManager upgrade = MachineManager.getInstance();


    public Main(){

        this.addMouseListener(gui);
        this.addMouseListener(store);
        this.addMouseListener(menu);
        this.addMouseListener(build);
        this.addMouseListener(upgrade);
        this.addMouseMotionListener(store);

        new Window(WI, HE, "Factoreum", this);

    }

    public synchronized void start() {      // Game starts

        action = new Thread(this);
        action.start();
        r = true;

    }

    public synchronized void stop() {       // Game stops

        try {
            action.join();
            r = false;
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void run(){                          //main game loop

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
