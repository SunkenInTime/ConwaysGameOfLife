public class Cell {

    private boolean isAlive;
    private int row;
    private int col;
    
    Cell(int row, int col, boolean isAlive){
        this.isAlive = isAlive;
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public boolean getIsAlive(){
        return isAlive;
    }

    public void setState(boolean isAlive) {
        this.isAlive = isAlive;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {

        if (isAlive)
        return "\033[48;2;0;0;0m  ";

        return "\033[48;2;255;255;255m  ";


    }

}