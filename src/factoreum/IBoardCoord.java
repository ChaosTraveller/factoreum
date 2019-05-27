package factoreum;

public interface IBoardCoord {

    public int[][] getBoardField();
    public void setBoardField(int[][] boardField);
    public int[][] getBoardFieldOre();
    public void setBoardFieldOre(int[][] boardFieldOre);
    public int getFx();
    public void setFx(int fx);
    public int getFy();
    public void setFy(int fy);
    public int[] getMinX();
    public void setMinX(int[] minX);
    public int[] getMinY();
    public void setMinY(int[] minY);

    public OVERLAP getOverlap();
    public void setOverlap(OVERLAP overlap);
}
