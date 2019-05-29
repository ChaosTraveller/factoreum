package factoreum;

import java.awt.*;

public interface IHandler {

    public void addMachine(Machine m);

    public void deleteMachine(int j);
    public void tick();
    public void render(Graphics gr);

}
