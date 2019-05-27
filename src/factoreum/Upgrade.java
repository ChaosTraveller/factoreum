package factoreum;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Upgrade extends MouseAdapter{

    private static Upgrade ourInstance = new Upgrade();

    private static Upgrade single_instance = null;

    public static Upgrade getInstance()
    {
        if (single_instance == null)
            single_instance = new Upgrade();

        return single_instance;
    }

        private GUI gui = GUI.getInstance();
        private Handler handler = Handler.getInstance();
    public static final int[] x = {20,125, 230, 335, 440, 545}, y = {60, 165, 270, 375, 480, 585};

        public void mouseClicked(MouseEvent e) {
            int mx = e.getX();
            int my = e.getY();

            if (mousePos(mx, my, 665, 130, 265, 35) && gui.overlap == GUI.OVERLAP.Field) {
                handler.deleteMachine(gui.getBoardField()[gui.getFx()][gui.getFy()]);
                gui.getBoardField()[gui.getFx()][gui.getFy()] = -1;
            }
        }

        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
        }

    private boolean mousePos(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }


        public void tick() {

        }

        public void render(Graphics gr) {

            gr.setFont(new Font("arial", Font.PLAIN, 20));
            gr.setColor(Color.white);
            gr.drawString("Destroy",                                   670, 155);
            gr.drawRect(                                                    665, 130, 265, 35);

        }

}

