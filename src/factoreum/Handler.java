package factoreum;

import com.sun.deploy.util.ArrayUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Handler {

    private static Handler ourInstance = new Handler();

    private static Handler single_instance = null;

    private GUI gui = GUI.getInstance();

    public static Handler getInstance()
    {
        if (single_instance == null)
            single_instance = new Handler();

        return single_instance;
    }


    public ArrayList<Machine> machine = new ArrayList<>();

    public void tick() {
        for (int i = 0; i < machine.size(); i++) {
            Machine tempM = machine.get(i);

            tempM.tick();
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

            if(tempM.getId() == j){
                if (tempM.getType() == TYPE.Solar) {
                    gui.setMaxPower(gui.getMaxPower() - Math.round((float)tempM.getLvl()*tempM.getLvl()/2));
                } else if (tempM.getType() == TYPE.Fuel) {
                    gui.setMaxPower(gui.getMaxPower() - Math.round((float)tempM.getLvl()*tempM.getLvl()));
                }else if (tempM.getType() == TYPE.Nuclear) {
                    gui.setMaxPower(gui.getMaxPower() - Math.round((float)tempM.getLvl()*tempM.getLvl()*tempM.getLvl()));
                }else if (tempM.getType() == TYPE.Miner) {
                    gui.setPowerUsage(gui.getPowerUsage() - Math.round((float)(2*tempM.getLvl())));
                }else if (tempM.getType() == TYPE.AdvancedMiner) {
                    gui.setMaxPower(gui.getMaxPower() - Math.round((float)tempM.getLvl()*tempM.getLvl()*tempM.getLvl()));
                }else if (tempM.getType() == TYPE.Cooler) {
                    gui.setMaxPower(gui.getMaxPower() - Math.round((float)tempM.getLvl()*tempM.getLvl()*tempM.getLvl()));
                }else if (tempM.getType() == TYPE.Crafter) {
                    gui.setMaxPower(gui.getMaxPower() - Math.round((float)tempM.getLvl()*tempM.getLvl()*tempM.getLvl()));
                }
                machine.remove(i);
                break;
            }
        }
    }

}
