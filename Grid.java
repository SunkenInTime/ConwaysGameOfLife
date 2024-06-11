
public class Grid {
    Cell[][] grid = new Cell[50][50];

    
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
                if (grid[newRow][newCol].getState()) {
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

        if(grid[row][col].getState){
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
                newGrid[row][col] = newGrid[row][col].setState(getNextState(row, col));
            }
        }
    }


}
