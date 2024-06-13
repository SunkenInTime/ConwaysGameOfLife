import java.util.Scanner;

public class GameOfLife {
   Grid myGrid = new Grid(50);
   Scanner scan = new Scanner(System.in);
   GameOfLife(){

   }
   void play(){

    
    String input = "";
    userChoice();
    do {
      System.out.println( myGrid.toString());
      myGrid.getNextGeneration();
      

System.out.println("\u001B[0mPress Space to start and show the next generation(Enter x to exit)\n");
input= scan.nextLine();
    } while(!input.equals("x"));
   //  myGrid.randomPattern();
   
    System.out.println( myGrid.toString());
    
    while(myGrid.hasLivingCell()){
        myGrid.getNextGeneration();
        
       System.out.println( myGrid.toString());
    }

    

}
public void userChoice() {
   int option;
   do {
       System.out.println(displayOptions());
       option = scan.nextInt();
       scan.nextLine();
       if(option ==1) {
         myGrid.randomPattern();
       } else if(option == 2) {
         myGrid.presetPattern();
       }else {
           System.out.println("Please enter a vaid option");
           }
       }while(option != 1 && option !=2);
   }

public String displayOptions() {
return "How would you like to initialize the grid? \n 1. Randomized \n 2. Angel\n:";
}
   
}