public class GameOfLife {
    
   GameOfLife(){

   }
   void play(){

    Grid myGrid = new Grid(50);
   
   //  myGrid.randomPattern();
   myGrid.presetPattern();
    System.out.println( myGrid.toString());
    
    while(myGrid.hasLivingCell()){
        myGrid.getNextGeneration();
        
       System.out.println( myGrid.toString());
    }

    
   }
   void displayOptions(){

   }

}
