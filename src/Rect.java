/**
 * Rect.Java
 * A subClass of the ClosedShape class that creates and displays a rectangle.
 * @author AlfieFitchMay
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Rect extends ClosedShape {

    private int height;
    private int width;

    /**
     * Creates a rectangle.
     * @param x - The display component's x position.
     * @param y - The display component's y position.
     * @param vx - The display component's x velocity.
     * @param vy - The display component's y velocity.
     * @param height - The height of the rectangle.
     * @param width - The width of the rectangle.
     * @param color - The line or fill colour of the rectangle.
     * @param isFilled - boolean value that is true if the rectangle is filled with colour.
     */
    public Rect (int instertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled){
        super(instertionTime, x, y, vx, vy, colour, isFilled);
        this.height = height;
        this.width = width;
    }

    /** @return The width of the rectangle. */
    public int getWidth(){
        return width;
    }

    /** @return The height of the rectangle. */
    public int getHeight(){
        return height;
    }

    /** @param Resets the size. */
    public void setSize(int height, int width){
        this.height = height;
        this.width = width;
    }

        /**
     * Draws the rectangle.
     * @param g The graphics object of the drawable component.
     */
    public void draw(GraphicsContext g){
        g.setFill(colour);
        g.setStroke(colour);
        if (isFilled){
            g.fillRect(x, y, width, height);
        }else{
            g.strokeRect(x, y, width, height);
        }
    }

    /** Method to convert the rectangle to a string to be printed. */
    public String toString(){
        String result = "This is a rectangle\n";
        result += super.toString();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }
}
