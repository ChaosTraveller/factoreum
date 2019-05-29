package factoreum;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GUI extends MouseAdapter {

    private static GUI ourInstance = new GUI();

    private static GUI single_instance = null;

    public static GUI getInstance()
    {
        if (single_instance == null)
            single_instance = new GUI();

        return single_instance;
    }



    public Color c1 = new Color(0, 14, 33);
    public Color c2 = new Color(255, 172, 23);
    public Color c3 = new Color(255, 188, 91);

    private int[] minX = {0, 0, 0, 0, 0, 0};
    private int[] minY = {0, 0, 0, 0, 0, 0};
//    private int[][] boardField = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1} };
//    private int[][] boardFieldOre = {{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, };
//    private int fx, fy;

    public enum OVERLAP {
        Menu,
        Items,
        Crafting,
        Store,
        Field,
        FieldEmpty;

    }
//    private Handler handler = Handler.getInstance();

//    public boolean menu, items, crafting, store, upgrade;



    private int ore = 0;
    Random r = new Random();
    private int n;

    private IBoardCoord board = Board.getInstance();
    private IStorageItems items = Storage.getInstance();
    private IStorageRaw raw = Storage.getInstance();
    private Build build = Build.getInstance();
    private Menu menu = Menu.getInstance();
    private MachineManager upgrade = MachineManager.getInstance();
    private Store store = Store.getInstance();

    public factoreum.OVERLAP overlap = board.getOverlap();

    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (mousePos(mx, my, 880, 0, 70, 35)) {
            board.setOverlap(factoreum.OVERLAP.Menu);

        } else if (mousePos(mx, my, 665, 65, 81, 35)) {
            board.setOverlap(factoreum.OVERLAP.Items);

        } else if (mousePos(mx, my, 756, 65, 81, 35)) {
            board.setOverlap(factoreum.OVERLAP.Crafting);

        } else if (mousePos(mx, my, 847, 65, 81, 35)) {
            board.setOverlap(factoreum.OVERLAP.Store);

        } else if (mousePos(mx, my, 10, 50, 630, 630)) {
            mouseBoardPos(mx, my);
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
    private void mouseBoardPos(int mx, int my) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (mx > board.getMinX()[j] && mx < board.getMinX()[j] + 100) {
                    if (my > board.getMinY()[i] && my < board.getMinY()[i] + 100) {
                        board.setFx(j);
                        board.setFy(i);
                        if (board.getBoardField()[j][i] == -1) {
                            board.setOverlap(factoreum.OVERLAP.FieldEmpty);
                        } else {
                            board.setOverlap(factoreum.OVERLAP.Field);
                        }
                    }
                }
            }
        }
    }


    public void tick(){
        if (board.getMinY()[5] == 0) {
            int spx = 0, spy = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    minX = board.getMinX();
                    minX[j] = 10 + (j * 100) + spx;
                    board.setMinX(minX);
                    minY = board.getMinY();
                    minY[i] = 50 + (i * 100) + spy;
                    board.setMinY(minY);
                    spx += 5;
                }
                spx = 0;
                spy += 5;
            }
        }

        if (board.getBoardFieldOre()[5][5] == 0) {
//            for (int i =0; i<36; i++) {
//                random[i] = r.nextInt(100) + 1;
//            }

            for (int k = 0; k < 6; k++) {
                //n = r.nextInt(100) + 1; //Coś tu jest nie tak z liczbami losowymi i błędy w energii przy usówaniu minerów
                for (int l = 0; l < 6; l++) {
                    int i = r.nextInt(100) + 1;
                    if (i <= 40) {
                        board.getBoardFieldOre()[k][l] = 1;
                    } else if (i > 40 && i <= 70) {
                        board.getBoardFieldOre()[k][l] = 2;
                    } else if (i > 70 && i <= 90) {
                        board.getBoardFieldOre()[k][l] = 3;
                    } else {
                        board.getBoardFieldOre()[k][l] = 4;
                    }
                    //i++;
                }
            }
//            for (int k = 0; k < 6; k++) {
////                //n = r.nextInt(100) + 1; //Coś tu jest nie tak z liczbami losowymi i błędy w energii przy usówaniu minerów
////                for (int l = 0; l < 6; l++) {
////                    System.out.println(boardFieldOre[k][l]);
////                    if (boardFieldOre[k][l] <= 50) {
////                        boardFieldOre[k][l] = 1;
////                    } else if (boardFieldOre[k][l] > 50 && boardFieldOre[k][l] <= 80) {
////                        boardFieldOre[k][l] = 2;
////                    } else if (boardFieldOre[k][l] > 80 && boardFieldOre[k][l] <= 95) {
////                        boardFieldOre[k][l] = 3;
////                    } else {
////                        boardFieldOre[k][l] = 4;
////                    }
////                }
////            }
        }
    }

    public void render(Graphics gr) {

        gr.setColor(c1);
        gr.fillRect(0, 0, 960, 40);
        gr.fillRect(10, 50, 630, 630);
        gr.fillRect(650, 50, 295, 630);
        gr.setColor(c3);
        int spx=0, spy=0;
        for (int i=0; i<6; i++) {
            for (int j=0; j<6; j++) {
                gr.drawRect(10 + (j * 100) + spx,50 + (i * 100) + spy,100,100);
                spx += 5;
            }
            spx = 0;
            spy += 5;
        }


        gr.setColor(c2);
        gr.drawString("Power: " + (raw.getMaxPower() - raw.getPowerUsage()), 5, 20);
        gr.drawString("Units: " + raw.getUnits(), 100, 20 );
        gr.drawString("Coal: " + raw.getCoal(), 200, 20);
        gr.drawString("Titanium: " + raw.getTitanium(), 300, 20);
        gr.drawString("Crystals: " + raw.getCrystals(), 400, 20);
        gr.drawString("Uranium: " + raw.getUranium(), 500, 20);
        gr.drawString("Heating: " + raw.getHeatingPower(), 600, 20);
        gr.drawString("Cooling: " + raw.getCoolingPower(), 700, 20);
        gr.setColor(Color.black);
        gr.fillRect(660, 60, 275, 610);
        gr.setColor(Color.white);
        gr.setFont(new Font("arial", Font.PLAIN, 20));
        gr. drawRect(880, 0, 70, 35);
        gr. drawString("Menu", 890, 25);
        gr.drawRect(665, 65, 81, 35);
        gr.drawString("Storage", 670, 90);
        gr.drawRect(756, 65, 81, 35);
        gr.drawString("Crafting", 761, 90);
        gr.drawRect(847, 65, 81, 35);
        gr.drawString("Store", 862, 90);

        if (board.getOverlap() == factoreum.OVERLAP.Items) {
            gr.setColor(c2);
            gr.setFont(new Font("arial", Font.PLAIN, 20));
            gr.drawString("Graphite: " + items.getGraphite(),                          665, 130);
            gr.drawString("Graphite rods: " + items.getGraphiteRod(),                  665, 155);
            gr.drawString("Controm Rods: " + items.getControlRod(),                    665, 180);
            gr.drawString("Titanium plates: " + items.getTitaniumPlate(),              665, 205);
            gr.drawString("Fuel rods: " + items.getFuelRod(),                          665, 230);
            gr.drawString("Advanced fuel rods: " + items.getAdvancedFuelRod(),         665, 255);
            gr.drawString("Electronic parts: " + items.getElectronicParts(),           665, 280);
            gr.drawString("Power transmiters: " + items.getPowerTransmiter(),          665, 305);
            gr.drawString("Pure crystals: " + items.getPureCrystal(),                  665, 330);
            gr.drawString("Reinforced ti. plates: " + items.getReinforcedTiPlate(),    665, 355);
            gr.drawString("Electronic circutes: " + items.getElectronicCircute(),      665, 380);
            gr.setColor(Color.red);
            gr.setFont(new Font("arial", Font.PLAIN, 20));
            gr.drawRect(665, 65, 81, 35);
            gr.drawString("Storage", 670, 90);
        } else if (board.getOverlap() == factoreum.OVERLAP.Crafting) {


            gr.setColor(Color.red);
            gr.setFont(new Font("arial", Font.PLAIN, 20));
            gr.drawRect(756, 65, 81, 35);
            gr.drawString("Crafting", 761, 90);
        } else if (board.getOverlap() == factoreum.OVERLAP.Store) {
            store.render(gr);
        } else if (board.getOverlap() == factoreum.OVERLAP.Menu) {
            menu.render(gr);
        } else if (board.getOverlap() == factoreum.OVERLAP.Field) {
            gr.setColor(Color.red);
            gr.drawRect(minX[board.getFx()], minY[board.getFy()], 100, 100);
            upgrade.render(gr);
        } else if (board.getOverlap() == factoreum.OVERLAP.FieldEmpty) {
            gr.setColor(Color.green);
            gr.drawRect(minX[board.getFx()], minY[board.getFy()], 100, 100);
            build.render(gr);
        }


    }



//    public int[][] getBoardField() {
//        return boardField;
//    }
//
//    public void setBoardField(int[][] boardField) {
//        this.boardField = boardField;
//    }
//
//    public int[][] getBoardFieldOre() {
//        return boardFieldOre;
//    }
//
//    public void setBoardFieldOre(int[][] boardFieldOre) {
//        this.boardFieldOre = boardFieldOre;
//    }
//
//    public int getFx() {
//        return fx;
//    }
//
//    public void setFx(int fx) {
//        this.fx = fx;
//    }
//
//    public int getFy() {
//        return fy;
//    }
//
//    public void setFy(int fy) {
//        this.fy = fy;
//    }
}
