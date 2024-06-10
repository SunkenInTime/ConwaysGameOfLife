public class Grid {
    boolean[][] grid = new boolean[50][50];


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
                if (grid[newRow][newCol]) {
                    liveNeighbors++;
                }
            }
        }
        return liveNeighbors;
    }
    
    boolean getNextState(int row, int col){
        int liveNeighbors = getLiveNeighbors(row, col);

        if(grid[row][col]){
        if(liveNeighbors >= 2 && liveNeighbors < 4) return true;
           
        
    }else{
        if(liveNeighbors == 3) return true;
    }
        
        
        return false;
    }

    void getNextGeneration(){
        boolean[][] newGrid = new boolean[50][50];

        for(int row = 0; row < grid.length; row++){

            for(int col = 0; col < grid[row].length; col++){
                newGrid[row][col] = getNextState(row, col);
            }
        }
    }


}
