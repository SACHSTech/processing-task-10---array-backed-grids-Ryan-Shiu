import processing.core.PApplet;

/**
 * Description A program that forms a grid in which the user can click on squares and change colours.
 */

public class Sketch extends PApplet {
// Declaring variables and arrays
  int[][] intGrid = new int[10][10];

  int cell_width = 20;
  int cell_height = 20;
  int margin = 15;
  int row_count = 10;
  int column_count = 10;
  int screen_row = 10;
  int screen_height = 10;
  int cell_pointX = 10;
  int cell_pointY = 10;
  int cellX;
  int cellY;
  int intCellsinRows = 0;
  int intcountCells = 0;
  int intRow0Count = 0; 
  int intRow1Count = 0;
  int intRow2Count = 0;
  int intRow3Count = 0;
  int intRow4Count = 0;
  int intRow5Count = 0;
  int intRow6Count = 0;
  int intRow7Count = 0;
  int intRow8Count = 0;
  int intRow9Count = 0;
  int intcellTotal = 0;






  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(500, 600);
    size(250, 250);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(255,255,255);
    background(0, 0, 0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    for(int row = 0; row < row_count; row++){
      for(int column = 0; column < column_count; column++){
          rect((cell_pointX + margin) * row, ((cell_pointY + margin) * column), cell_width, cell_height);

     }
    }
    
    // Loop that draws grid (Green Squares and white squares)
    for(int row = 0; row < 10; row++){
      for(int column = 0; column < 10; column++){
        if(intGrid[column][row] == 1){
          fill(18, 252, 80);
          rect((cell_pointX + margin) * row, ((cell_pointY + margin) * column), cell_width, cell_height);
        }
        else{
          fill(255, 255, 255);
          rect((cell_pointX + margin) * row, ((cell_pointY + margin) * column), cell_width, cell_height);
        }
      }
    }

  }
/**
 * This method takes the mouse's location on click and turns squares green according to the instructions. It also counts the amount of cells that are green.
 */
  public void mousePressed(){
      for(int row = 0; row < 10; row++){
        for(int column = 0; column < 10; column++){
 
         
            if(mouseX < (cell_pointX + margin) * row + 20 && mouseX > (cell_pointX + margin) * row && mouseY < (cell_pointY + margin) * column + 20 && mouseY > (cell_pointY + margin) * column){

                
              // Top left corner
                if(row == 0 && column == 0){
                  if(intGrid[column][row] == 1){
                    intGrid[column][row] = 0;
                    intGrid[column + 1][row] = 0;
                    intGrid[column][row + 1] = 0;
                    intcountCells = intcountCells - 3;
                    intRow0Count = intRow0Count - 2;
      
                  }
                  else if(intGrid[column][row] == 0){
                    intGrid[column][row] = 1;
                    intGrid[column + 1][row] = 1;
                    intGrid[column][row + 1] = 1;
                    intcountCells = intcountCells + 3;
                    intRow0Count = intRow0Count + 2;
                  }
                }
                
                // Top right corner
                else if(row == 9 && column == 0){

                  if(intGrid[column][row] == 0){
                    intGrid[column][row] = 1;
                    intGrid[column + 1][row] = 1;
                    intGrid[column][row - 1] = 1;
                    intcountCells = intcountCells + 3;
                    intRow0Count = intRow0Count + 2;
                  }
                  else if(intGrid[column][row] == 1){
                    intGrid[column][row] = 0;
                    intGrid[column + 1][row] = 0;
                    intGrid[column][row - 1] = 0;
                    intcountCells = intcountCells - 3;
                    intRow0Count = intRow0Count - 2;
                  }
                }
                // Bottom Right Corner
                else if(row == 9 && column == 9){
                  if(intGrid[column][row] == 0){
                    intGrid[column][row] = 1;
                    intGrid[column - 1][row] = 1;
                    intGrid[column][row - 1] = 1;
                    intcountCells = intcountCells + 3;
                    intRow9Count = intRow9Count + 2;
                  }
                  else if(intGrid[column][row] == 1){
                    intGrid[column][row] = 0;
                    intGrid[column - 1][row] = 0;
                    intGrid[column][row - 1] = 0;
                    intcountCells = intcountCells - 3;
                    intRow9Count = intRow9Count - 2;
                  }
                }
                // Bottom Left Corner
                else if(row == 0 && column == 9){
                  if(intGrid[column][row] == 0){
                    intGrid[column][row] = 1;
                    intGrid[column - 1][row] = 1;
                    intGrid[column][row + 1] = 1;
                    intcountCells = intcountCells + 3;
                  }
                  else if(intGrid[column][row] == 1){
                    intGrid[column][row] = 0;
                    intGrid[column - 1][row] = 0;
                    intGrid[column][row + 1] = 0;
                    intcountCells = intcountCells - 3;
                  }
                }

                // Left Edge detection and colour switch
                else if(row == 0 && column > 0){
                    if(intGrid[column][row + 1] == 0){
                      intGrid[column][row + 1] = 1;
                      intcountCells = intcountCells + 1;
                    }
                    else if(intGrid[column][row + 1] == 1){
                      intGrid[column][row + 1] = 0;
                      intcountCells = intcountCells - 1;
                    }
                    if(intGrid[column - 1][row] == 1){
                      intGrid[column - 1][row] = 0;
                      intcountCells = intcountCells - 1;
                      intRow0Count = intRow0Count - 1;
                    }
                    else if(intGrid[column - 1][row] == 0){
                      intGrid[column - 1][row] = 1;
                      intcountCells = intcountCells + 1;
                      intRow0Count = intRow0Count + 1;
                    }
                    if(intGrid[column + 1][row] == 1){
                      intGrid[column + 1][row] = 0;
                      intcountCells = intcountCells - 1;
                      intRow0Count = intRow0Count - 1;
                    }
                    else if(intGrid[column + 1][row] == 0){
                      intGrid[column + 1][row] = 1;
                      intcountCells = intcountCells + 1;
                      intRow0Count = intRow0Count + 1;
                    }
                    if(intGrid[column][row] == 0){
                      intGrid[column][row] = 1;
                      intcountCells = intcountCells + 1;
                      intRow0Count = intRow0Count + 1;
                    }
                    else if(intGrid[column][row] == 1){
                      intGrid[column][row] = 0;
                      intcountCells = intcountCells - 1;
                      intRow0Count = intRow0Count - 1;
                    }
            }
              
                // Right side edge detection and colour switch
                else if(row == 9 && column > 0){
                  if(intGrid[column][row] == 0){
                    intGrid[column][row] = 1;
                    intcountCells = intcountCells + 1;
                    intRow9Count = intRow9Count + 1;
                  }
                  else if(intGrid[column][row] == 1){
                    intGrid[column][row] = 0;
                    intcountCells = intcountCells - 1;
                    intRow9Count = intRow9Count - 1;
                  }
                  
                  if(intGrid[column][row - 1] == 1){
                    intGrid[column][row - 1] = 0;
                    intcountCells = intcountCells - 1;
                  }
                  else if(intGrid[column][row - 1] == 0){
                    intGrid[column][row - 1] = 1;
                    intcountCells = intcountCells + 1;
                  }
                  
                  if(intGrid[column -1][row] == 1){
                    intGrid[column - 1][row] = 0;
                    intcountCells = intcountCells - 1;
                    intRow9Count = intRow9Count - 1;
                  }
                  else if(intGrid[column -1][row] == 0){
                    intGrid[column - 1][row] = 1;
                    intcountCells = intcountCells + 1;
                    intRow9Count = intRow9Count + 1;
                  }

                  if(intGrid[column + 1][row] == 1){
                    intGrid[column + 1][row] = 0;
                    intcountCells = intcountCells - 1;
                    intRow9Count = intRow9Count - 1;
                  }
                  else if(intGrid[column + 1][row] == 0){
                    intGrid[column + 1][row] = 1;
                    intcountCells = intcountCells + 1;
                    intRow9Count = intRow9Count + 1;
                  }
                }
                // Top Row Edge detection and colour switch
                else if(row > 0 && column == 0){
                  if(intGrid[column][row] == 0){
                    intGrid[column][row] = 1;
                    intcountCells = intcountCells + 1;
                  }
                  else if(intGrid[column][row] == 1){
                    intGrid[column][row] = 0;
                    intcountCells = intcountCells - 1;
                  }

                  if(intGrid[column][row - 1] == 0){
                    intGrid[column][row - 1] = 1;
                    intcountCells = intcountCells + 1;
                  }
                  else if(intGrid[column][row - 1] == 1){
                    intGrid[column][row - 1] = 0;
                    intcountCells = intcountCells - 1;
                  }

                  if(intGrid[column][row + 1] == 0){
                    intGrid[column][row + 1] = 1;
                    intcountCells = intcountCells + 1;
                  }
                  else if(intGrid[column][row + 1] == 1){
                    intGrid[column][row + 1] = 0;
                    intcountCells = intcountCells - 1;
                  }

                  if(intGrid[column + 1][row] == 0){
                    intGrid[column + 1][row] = 1;
                    intcountCells = intcountCells + 1;
                  }
                  else if(intGrid[column + 1][row] == 1){
                    intGrid[column + 1][row] = 0;
                    intcountCells = intcountCells - 1;
                  }
                }
                // Bottom edge detection and colour switch
                else if(row > 0 && column == 9){
                  if(intGrid[column][row] == 0){
                    intGrid[column][row] = 1;
                    intcountCells = intcountCells + 1;
                  }
                  else if(intGrid[column][row] == 1){
                    intGrid[column][row] = 0;
                    intcountCells = intcountCells - 1;
                  }

                  if(intGrid[column - 1][row] == 0){
                    intGrid[column - 1][row] = 1;
                    intcountCells = intcountCells + 1;
                  }
                  else if(intGrid[column - 1][row] == 1){
                    intGrid[column - 1][row] = 0;
                    intcountCells = intcountCells - 1;
                  }

                  if(intGrid[column][row + 1] == 0){
                    intGrid[column][row + 1] = 1;
                    intcountCells = intcountCells + 1;
                  }
                  else if(intGrid[column][row + 1] == 1){
                    intGrid[column][row + 1] = 0;
                    intcountCells = intcountCells - 1;
                  }

                  if(intGrid[column][row - 1] == 0){
                    intGrid[column][row - 1] = 1;
                    intcountCells = intcountCells + 1;
                  }
                  else if(intGrid[column][row - 1] == 1){
                    intGrid[column][row - 1] = 0;
                    intcountCells = intcountCells - 1;
                  }
                }
                
                // All other squares that are not in corners or on edges.
                else{
                  if(intGrid[column][row] == 0){
                    intGrid[column][row] = 1;
                    intcountCells = intcountCells + 1;
                      if(row == 1){
                        intRow1Count = intRow1Count + 1;
                        intRow0Count = intRow0Count + 1;
                      }
                  }
                  else if(intGrid[column][row] == 1){
                    intGrid[column][row] = 0;
                    intcountCells = intcountCells - 1;
                      if(row == 1){
                        intRow1Count = intRow1Count - 1;
                      }
                  }

                  if(intGrid[column][row + 1] == 0){
                    intGrid[column][row + 1] = 1;
                    intcountCells = intcountCells + 1;
                  }
                  else if(intGrid[column][row + 1] == 1){
                    intGrid[column][row + 1] = 0;
                    intcountCells = intcountCells - 1;
                    if(row == 1){
                      intRow0Count = intRow0Count - 1;
                    }
                  }

                  if(intGrid[column][row - 1] == 0){
                    intGrid[column][row - 1] = 1;
                    intcountCells = intcountCells + 1;
                    if(row == 1){
                      intRow0Count = intRow0Count + 1;
                    }
                  }
                  else if(intGrid[column][row - 1] == 1){
                    intGrid[column][row - 1] = 0;
                    intcountCells = intcountCells - 1;
                    if(row == 1){
                      intRow0Count = intRow0Count - 1;
                    }
                  }

                  if(intGrid[column - 1][row] == 1){
                    intGrid[column - 1][row] = 0;
                    intcountCells = intcountCells - 1;
                    if(row == 1){
                      intRow1Count = intRow1Count - 1;
                    }
                  }
                  else if(intGrid[column - 1][row] == 0){
                    intGrid[column - 1][row] = 1;
                    intcountCells = intcountCells + 1;
                    if(row == 1){
                      intRow1Count = intRow1Count + 1;
                    }
                  }
                  if(intGrid[column + 1][row] == 1){
                    intGrid[column + 1][row] = 0;
                    intcountCells = intcountCells - 1;
                    if(row == 1){
                      intRow1Count = intRow1Count - 1;
                    }
                  }
                  else if(intGrid[column + 1][row] == 0){
                    intGrid[column + 1][row] = 1;
                    intcountCells = intcountCells + 1;
                    if(row == 1){
                      intRow1Count = intRow1Count + 1;
                    }
                  }
                  
                }
                
                // Outputting total cells
                System.out.println("Total of " + intcountCells + " are selected");
              
                // Outputting cells in each row (unsuccessful)
                System.out.println("In row 0 " + intRow0Count + " are selected");
                System.out.println("In row 1 " + intRow1Count + " are selected");
                System.out.println("In row 1 " + intRow9Count + " are selected");
                
                
                

        }
      }
   }
   // Outputting cells in each column (unsuccessful)
   for(int column = 0; column < 10; column++){
     int intcolumnCount = 0;
     for(int row = 0; row < 10; row++){
       if(intGrid[column][row] == 1){
         intcolumnCount += 1;
       }
      System.out.println("Column " + column + " has " + intcolumnCount);
      intcolumnCount = 0;
     }
   }

   //// Outputting cells in each row (unsuccessful)
   for(int row = 0; row < 10; row++){
    int intRowCount = 0;
    for(int column = 0; column < 10; column++){
      if(intGrid[row][column] == 1){
        intRowCount += 1;
      }
      System.out.println("Row " + column + " has " + intRowCount);
      intRowCount = 0;
    }
  }
}
}