import processing.core.PApplet;
import processing.event.MouseEvent;

public class Sketch extends PApplet {
	
	
  /**
   * A showcase of the many inputs one can use in coding
   * @author: T. Chhor
   */

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    // setting up the background
    background(20, 20, 20);
    fill(124, 252, 0);
    rect(0, 350, 400, 400);
    textSize(10);
  }

  // defining variables
  int intCircleX = 200;
  int intCircleY = 350;
  boolean aPressed = false;
  boolean wPressed = false;
  boolean sPressed = false;
  boolean dPressed = false;
  int rColour = 20;
  int bColour = 20;
  int gColour = 20;
  String specialMessage = "";
  boolean isTyping = false;
  

  public void draw() {
    text("Press 1 for type mode, 2 for move mode", 20, 20);

    // Drawing or typing?
    if (keyPressed) {
      if (key == '1') {
        isTyping = true;
      }
      else if (key == '2') {
        isTyping = false;
      }
    }

    // Draws an ellipse wherever the mouse is clicked
	  if (mousePressed && key != '1' && key != '2' && !isTyping) {
      clearScreen();
      ellipse(mouseX, mouseY, 50, 50);
    }
    
    // Control a ball with WASD
    if (aPressed && !isTyping) {
      intCircleX--;
    }
    if (dPressed && !isTyping) {
      intCircleX++;
    }
    if (sPressed && !isTyping) {
      intCircleY++;
    }
    if (wPressed && !isTyping) {
      intCircleY--;
    }
    if (keyPressed && key != '1' && key != '2' && !isTyping) {
      if (key == 'a' || key == 'A') {
        aPressed = true;
      }
      if (key == 'w' || key == 'W') {
        wPressed = true;
      }
      if (key == 'd' || key == 'D') {
        dPressed = true;
      }
      if (key == 's' || key == 'S') {
        sPressed = true;
      }
      clearScreen();
    }
    ellipse(intCircleX, intCircleY, 50, 50);
    text(specialMessage, 20, 40);
  }
  
  /**
   * Clears the screen
   */
  private void clearScreen() {
        background(rColour, gColour, bColour);
        fill(124, 252, 0);
        rect(0, 350, 400, 400);
  }
  
  /** 
   * Sets important values to false when keys are not pressed
  */
  public void keyReleased() {
      if (key != '1' && key != '2' && !isTyping){
        if (key == 'a' || key == 'A') {
          aPressed = false;
        }
        if (key == 'w' || key == 'W') {
          wPressed = false;
        }
        if (key == 'd' || key == 'D') {
          dPressed = false;
        }
        if (key == 's' || key == 'S') {
          sPressed = false;
        }
      }
    }

  /**
   * While holding r, g or b, you can change the rgb values by scrolling with the mouse wheel 
   */
  public void mouseWheel(MouseEvent event) {
    if (keyPressed && key != '1' && key != '2' && !isTyping) {
      keyPressed();
      if (key == 'r' || key == 'R') {
        rColour += 20 * event.getCount();
        if (rColour > 255 || rColour < 0) {
          rColour = 20;
        }
      }
      else if (key == 'g' || key == 'G') {
        gColour += 20 * event.getCount();
        if (gColour > 255 || gColour < 0) {
          gColour = 20;
      }
      }
      else if (key == 'b' || key == 'B') {
        bColour += 20 * event.getCount();
        if (bColour > 255 || bColour < 0) {
          bColour = 20;
        }
      }
    }
  }

  public void keyTyped() {
    if (keyPressed && isTyping && key != '1' && key != '2') {
      specialMessage += key; 
    }
  }
}