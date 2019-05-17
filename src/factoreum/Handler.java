package factoreum;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    private static Handler ourInstance = new Handler();

    private static Handler single_instance = null;

    public static Handler getInstance()
    {
        if (single_instance == null)
            single_instance = new Handler();

        return single_instance;
    }

    LinkedList<Machine> machine = new LinkedList<Machine>();

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

    public void addMachine(Machine machine) {
        this.machine.add(machine);
    }

    public void deleteMachine(Machine machine) {
        this.machine.remove(machine);
    }

}
