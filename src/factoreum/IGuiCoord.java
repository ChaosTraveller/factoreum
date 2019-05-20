package factoreum;

public interface IGuiCoord {

    public int[][] getBoardField();
    public void setBoardField(int[][] boardField);
    public static int[][] getBoardFieldOre();
    public void setBoardFieldOre(int[][] boardFieldOre);
    public static int getFx();
    public void setFx(int fx);
    public static int getFy();
    public void setFy(int fy);
}
