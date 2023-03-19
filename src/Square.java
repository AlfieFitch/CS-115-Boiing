/** 
 * Square.java
 * A subclass of the ClosedShape class that creates and displays a square.
 * @author AlfieFitchMay 
 */ 

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Square extends ClosedShape {
    private int side;

    /** Creates a square.
     * @param x - The display component's x position.
     * @param y - The display component's y position.
     * @param vx - The display component's x velocity.
     * @param vy - The display component's y velocity.
     * @param height - The height of the square.
     * @param width - The width of the the square.
     * @param color - The line or fill colour of the square.
     * @param isFilled - boolean value that is true if the square is filled with colour.
     */
    public Square (int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled){
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        this.side = side;
    }

    /** @return The width of the square. */
    public int getWidth(){
        return side;
    }

    /** @return the height of the square. */
    public int getHeight(){
        return side;
    }


    /** @param Resets the size. */
    public void setSide(int side){
        this.side = side;
    }

    /**
     * Draw the Square on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw(GraphicsContext g){
        g.setFill(colour);
        g.setStroke(colour);
        if(isFilled){
            g.fillRect(x, y, side, side);
        }else{
            g.strokeRect(x, y, side, side);
        }
    }

    /**
     * Method to convert a Square to a string.
     */
    public String toString(){
        String result = "This is a square\n";
        result += super.toString();
        result += "Its side is " + this.side;
        return result;
    }
}
