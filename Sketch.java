import processing.core.PApplet;

public class Sketch extends PApplet {

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
  int countCells = 0;
  boolean boolGreen = false;

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
          //cell_pointX = cell_pointX * row + margin;

     }
    }
    //intGrid[9][9] = 1; 

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

  public void mousePressed(){
    //if(mousePressed){
      for(int row = 0; row < 10; row++){
        for(int column = 0; column < 10; column++){
 
         
            if(column != 0 && mouseX < (cell_pointX + margin) * row + 20 && mouseX > (cell_pointX + margin) * row && mouseY < (cell_pointY + margin) * column + 20 && mouseY > (cell_pointY + margin) * column){
                intGrid[column][row] = 1;
                //System.out.println(row);
                //System.out.println(column);

              /*
                intGrid[column - 1][row] = 1;
                intGrid[column + 1][row] = 1;
                intGrid[column][row - 1] = 1;
                intGrid[column][row + 1] = 1; 
                boolGreen = true;
              */
            }
            /*
            if(column != 0 && mouseX < (cell_pointX + margin) * row + 20 && mouseX > (cell_pointX + margin) * row && mouseY < (cell_pointY + margin) * column + 20 && mouseY > (cell_pointY + margin) * column && intGrid[column][row] == 1 && boolGreen == true){            
              intGrid[column][row] = 0;
              intGrid[column - 1][row] = 0;
              intGrid[column + 1][row] = 0;
              intGrid[column][row - 1] = 0;
              intGrid[column][row + 1] = 0;
              System.out.println("yyyyyyyyyyyyyyyyyyyy");
            }
            */

            //if(intGrid[column][row] == 1){
             // intGrid[column][row] = 0;
            //}

            else if(column == 0 && mouseX < (cell_pointX + margin) * row + 20 && mouseX > (cell_pointX + margin) * row && mouseY < (cell_pointY + margin) * column + 20 && mouseY > (cell_pointY + margin) * column){
              intGrid[column][row] = 1;
              intGrid[column][row + 1] = 1;
              intGrid[column][row - 1] = 1;
              intGrid[column + 1][row] = 1;
            }

          }
          
        }
      }
    }
    
//}