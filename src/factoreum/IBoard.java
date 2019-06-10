package factoreum;

import java.util.ArrayList;

public interface IBoard {

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

    public ITEM[] getItem();
    public void setItem(ITEM[] item);
    public int[] getOre();
    public void setOre(int[] ore);
    public Board.FIELDTYPE getFieldtype();
    public void setFieldtype(Board.FIELDTYPE fieldtype);
}
