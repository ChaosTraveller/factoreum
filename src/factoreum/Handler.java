package factoreum;

//import com.sun.deploy.util.ArrayUtil;

import java.awt.*;
import java.util.ArrayList;

public class Handler implements IHandler{

    private static Handler ourInstance = new Handler();

    private static Handler single_instance = null;

    public static Handler getInstance()
    {
        if (single_instance == null)
            single_instance = new Handler();

        return single_instance;
    }


    private IStorageRaw raw = Storage.getInstance();
    private IBoard board = Board.getInstance();

    private ArrayList<Machine> machine = new ArrayList<>();

    private boolean lose = false;


    public void tick() {
        for (int i = 0; i < machine.size(); i++) {
            Machine tempM = machine.get(i);
            tempM.tick();
            if(raw.getUnits() < 50 && raw.getMaxPower() < 2) {
                lose = true;
            }
        }
    }

    public void render(Graphics gr) {
        for (int i = 0; i < machine.size(); i++) {
            Machine tempM = machine.get(i);

            tempM.render(gr);
        }
    }

    public void addMachine(Machine m) {
        machine.add(m);
    }

    public void deleteMachine(int j) {
        for (int i = 0; i < machine.size(); i++) {
            Machine tempM = machine.get(i);

            if(tempM.getId() == j && board.getOverlap() == OVERLAP.Field){
                board.setOverlap(OVERLAP.FieldEmpty);

                if (tempM.getType() == TYPE.Solar) {
                    raw.setMaxPower(raw.getMaxPower() - Math.round((float)tempM.getLvl()*tempM.getLvl()/2));
                    raw.setUnits(raw.getUnits() + 25);
                } else if (tempM.getType() == TYPE.Fuel) {
                    raw.setMaxPower(raw.getMaxPower() - Math.round((float)tempM.getLvl()*tempM.getLvl()));
                    raw.setUnits(raw.getUnits() + 250);
                }else if (tempM.getType() == TYPE.Nuclear) {
                    raw.setMaxPower(raw.getMaxPower() - Math.round((float)tempM.getLvl()*tempM.getLvl()*tempM.getLvl()));
                    raw.setUnits(raw.getUnits() + 1000);
                }else if (tempM.getType() == TYPE.Miner) {
                    raw.setPowerUsage(raw.getPowerUsage() - Math.round((float)(2*tempM.getLvl())));
                    raw.setUnits(raw.getUnits() + 100);
                }else if (tempM.getType() == TYPE.AdvancedMiner) {
                    raw.setPowerUsage(raw.getPowerUsage() - Math.round((float)(tempM.getLvl()*tempM.getLvl()*tempM.getLvl())));
                    raw.setUnits(raw.getUnits() + 2500);
//                }else if (tempM.getType() == TYPE.Cooler) {
//                    raw.setPowerUsage(raw.getPowerUsage() - Math.round((float)(tempM.getLvl()*tempM.getLvl()*tempM.getLvl())));
//                    raw.setUnits(raw.getUnits() + 100);
                }else if (tempM.getType() == TYPE.Crafter) {
                    raw.setPowerUsage(raw.getPowerUsage() - (tempM.getLvl()*tempM.getLvl()*tempM.getLvl()));
                    raw.setUnits(raw.getUnits() + 100);
                }
                machine.remove(i);
                break;
            }
        }
    }

    public ArrayList<Machine> getMachine() {
        return machine;
    }

    public void setMachine(ArrayList<Machine> machine) {
        this.machine = machine;
    }

    public boolean isLose() { return lose; }
}
