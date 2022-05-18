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
  int countCells = 0;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(250, 250);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
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
    intGrid[0][0] = 1; 

    for(int row = 0; row < intGrid.length; row++){
      for(int column = 0; column < intGrid.length; column++){
        if(intGrid[column][row] == 1){
          rect((cell_pointX + margin) * row, ((cell_pointY + margin) * column), cell_width, cell_height);
          fill(18, 252, 80);
        }
        else{
          rect((cell_pointX + margin) * row, ((cell_pointY + margin) * column), cell_width, cell_height);
          fill(255, 255, 255);
        }
      }
    }
	  
  }

  public void mousePressed(){
    
  }
}
