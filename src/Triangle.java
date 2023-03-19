/**
 * Triangle.Java
 * A subClass of the ClosedShape class that creates and displays a triangle.
 * @author AlfieFitchMay
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Triangle extends ClosedShape {

    private int base;
    private int height;

    /**
     * Creates a triangle.
     * @param x - The display component's x position.
     * @param y - The display component's y position.
     * @param vx - The display component's x velocity.
     * @param vy - The display component's y velocity.
     * @param height - The height of the triangle.
     * @param base - The base of the triangle.
     * @param color - The line or fill colour of the triangle.
     * @param isFilled - boolean value that is true if the triangle is filled with colour.
     */
    public Triangle(int insertionTime, int x, int y, int vx, int vy, int base, int height,  Color colour, boolean isFilled){
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        this.base = base;
        this.height = height;
    }

    /** @return The width of the triangle. */
    public int getWidth(){
        return base;
    }

    /** @return The height of the triangle. */
    public int getHeight(){
        return height;
    }

    /** @param resets the height and the base size of the triangle.*/
    public void setSize(int base, int height){
        this.base = base;
        this.height = height;
    }

    /** @return The X Coordinates of the triangle. */
    public double[] getXCoords(){
        double[] list = {getX(), getX() + base, getX() + height/2};
        return list;
    }

    /** @return the Y Coordinates of the triangle. */
    public double[] getYCoords(){
        double[] list = {getY(), getY() + base, getY() + height/2};
        return list;
    }

    /**
     * Draws the triangle
     * @param g The graphics object of the drawable component.
     */
    public void draw(GraphicsContext g){
        System.out.println(getXCoords());
        g.setFill(colour);
        g.setStroke(colour);
        if (isFilled){
            g.fillPolygon(new double[]{getX(), getX() + base / 2, getX() + base},
            new double[]{getY() + height, getY(), getY() + height},
            3);
        }  else{
            g.strokePolygon(new double[]{getX(), getX() + base / 2, getX() + base},
            new double[]{getY() + height, getY(), getY() + height},
            3);
        }
    }

    /** Method to convert the triangle to a string to be printed. */
    public String toString(){
        String result = "This is a triangle\n";
        result += super.toString();
        result += "Its width is " + this.base + " and its height is " + this.height + "\n";
        return result;
    }

}

