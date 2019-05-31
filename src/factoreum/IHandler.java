package factoreum;

import java.awt.*;
import java.util.ArrayList;

public interface IHandler {

    public void addMachine(Machine m);
    public void deleteMachine(int j);
    public void tick();
    public void render(Graphics gr);
    public ArrayList<Machine> getMachine();
    public void setMachine(ArrayList<Machine> machine);

}
