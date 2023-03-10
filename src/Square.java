/** 
 * Square.java
 * A subclass of the ClosedShape class that creates and displays a square.
 * @author AlfieFitchMay 
 */ 

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Square extends ClosedShape {
    private int height;
    private int width;

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
    public Square (int insertionTime, int x, int y, int vx, int vy, int height, int width, Color colour, boolean isFilled){
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        this.height = height;
        this.width = width;
    }

    /** @return The width of the square. */
    public int getWidth(){
        return width;
    }

    /** @return The height of the square */
    public int getHeight(){
        return height;
    }

    /** @param Resets the size. */
    public void setSize(int height, int width){
        this.height = height;
        this.width = width;
    }

    public void draw(GraphicsContext g){
        g.setFill(colour);
        g.setStroke(colour);
        if(isFilled){
            g.fillRect(x, y, width, height);
        }else{
            g.strokeRect(x, y, width, height);
        }
    }

    @Override
    public String toString(){
        String result = "This is a square\n";
        result += super.toString();
        result += "It's height is " + this.height + ", and it's width is " + this.width + "\n";
        return result;
    }
}
