
public class Grid {
    
    Cell[][] grid;

    Grid(){
       grid   = new Cell[50][50];
    }
    Grid(int size){
      grid  = new Cell[size][size] ;
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
    
            if (newRow >= 0 && newRow < 50 && newCol >= 0 && newCol < 50) {
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
        Cell[][] newGrid = new Cell[50][50];

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


}
