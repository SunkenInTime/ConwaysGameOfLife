import java.util.Random;

public class Grid {
    
    Cell[][] grid;

    Grid(){
       grid = new Cell[50][50];
       fillGrid();
    }
    Grid(int size){
      grid  = new Cell[size][size] ;
      fillGrid();
    }

    public void fillGrid(){
        for(int row = 0; row < grid.length; row++){
            
            for(int col = 0; col < grid[row].length; col ++){
                grid[row][col] = new Cell(row, col, false);
            }
        }
    }

    void randomPattern(){
        for(int row = 0; row < grid.length; row++){
            
            for(int col = 0; col < grid[row].length; col ++){
                Random random = new Random();
                grid[row][col].setState(random.nextBoolean());
            }
        }
        
    }

    void presetPattern(){
        grid = new Cell[50][50];
        fillGrid();
        //starts at 80 25
        int row = 25;
        int col = 25;


        grid[row][col].setState(true);
        grid[row-1][col].setState(true);
        grid[row-2][col-1].setState(true);
        grid[row-3][col-2].setState(true);
        grid[row-2][col-3].setState(true);
        grid[row-1][col-3].setState(true);
    }
   
    int getLiveNeighbors(int row, int col) {
        int liveNeighbors = 0;
        int[][] directions = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}
        };
    
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
    
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid.length) {
                if (grid[newRow][newCol].getIsAlive()) {
                    liveNeighbors++;
                }
            }
        }
        return liveNeighbors;
    }
    
    boolean getNextState(Cell cell){
        int row = cell.getRow();
        int col = cell.getCol();
        int liveNeighbors = getLiveNeighbors(row, col);

        if(grid[row][col].getIsAlive()){
        if(liveNeighbors >= 2 && liveNeighbors < 4) return true;
           
        
    }else{
        
        if(liveNeighbors == 3) return true;
    }
        
        
        return false;
    }

    void getNextGeneration(){
        Cell[][] newGrid = grid;
        
        for(int row = 0; row < grid.length; row++){

            for(int col = 0; col < grid[row].length; col++){
                boolean state = getNextState(grid[row][col]);
                newGrid[row][col].setState(state);
            }
        }
    }

    boolean hasLivingCell(){
        for(Cell[] row : grid){
            for (Cell cell : row){
                if(cell.getIsAlive() == true ) return true;
            }
        }
        return false;
    }

   
    @Override
    public String toString() {
        String output = "";
        for(Cell[] row : grid){
            for(Cell cell : row){
                output += cell;
            }
            
            output += "\u001B[0m";
            output += "\n";

        }

        return output;

    }


}
