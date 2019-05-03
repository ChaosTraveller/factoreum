package com.main;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

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
