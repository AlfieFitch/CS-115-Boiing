
/**
 * This class reads a shape file, and creates objects for each shape read. It also adds them to the shape queue to be displayed.
 *
 * @author you
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

	/**
	 * The code block below takes the variables required to make each shape and returns the newly
	 * created object for each possible shape.
	 * @param intime - The insertion time for the shape.
	 * @param x - The starting X co-ordinate for the shape.
	 * @param y - The starting Y co-ordinate for the shape.
	 * @param vx - The X velocity of the shape.
	 * @param vy - The Y velocity of the shape.
	 * @param diameter - The diameter of the shape (used only for the circle and oval methods).
	 * @param width - The width of the shape (used only for the triangle and rectangle methods)
	 * @param height - The height of the shape (used only for the triangle and rectangle methods).
	 * @param side - The side length of the shape (used only for the square method).
	 * @param isFilled - Boolean that represents if the shape is filled with colour or not,
	 * @param color - The line colour and/or the fill colour of the shape.
	 * @return - The created shape object.
	 */

	private static Circle makeCircle(int intime, int x, int y, int vx, int vy, int diameter, boolean isFilled, Color color){
		Circle circle = new Circle(intime, x, y, vx, vy, diameter, color, isFilled);
		return circle;
	}

	private static Oval makeOval(int intime, int x, int y, int vx, int vy, int width, int height, boolean isFilled, Color color){
		Oval oval = new Oval(intime, x, y, vx, vy, width, height, color, isFilled);
		return oval;
	}

	private static Rect makeRect(int intime, int x, int y, int vx, int vy, int width, int height, boolean isFilled, Color color){
		Rect rect = new Rect(intime, x, y, vx, vy, width, height, color, isFilled);
		return rect;
	}

	private static Square makeSquare(int intime, int x, int y, int vx, int vy, int side, boolean isFilled, Color color){
		Square square = new Square(intime, x, y, vx, vy, side, color, isFilled);
		return square;
	}

	private static Triangle makeTriangle(int intime, int x, int y, int vx, int vy, int width, int height,  boolean isFilled, Color color){
		Triangle triangle = new Triangle(intime, x, y, vx, vy, width, height, color, isFilled);
		return triangle;
	}


	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readLineByLine(Scanner in) {

		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

		do{

			String[] split = in.nextLine().split("\\s+");

			String shape = split[0];
			int insertionTime = Integer.parseInt(split[1]);
			int x = Integer.parseInt(split[2]);
			int y = Integer.parseInt(split[3]);
			int vx = Integer.parseInt(split[4]);
			int vy = Integer.parseInt(split[5]);
			boolean isFilled = Boolean.parseBoolean(split[6]);
			int r, g, b;

			switch(shape) {

				/** The block of code below uses the array to apply the correct data to each variable as it differs 
				 *  depening on which shape is being created. It then calls the relevant shape class and adds the result to 
				 *  the shape queue ready to be displayed.
				 */

				case "circle":		
					int diameter = Integer.parseInt(split[7]);
					r = Integer.parseInt(split[8]);
					g = Integer.parseInt(split[9]);
					b = Integer.parseInt(split[10]);
					Color circleColor = Color.rgb(r, g, b);
					shapeQueue.enqueue(makeCircle(insertionTime, x, y, vx, vy, diameter, isFilled, circleColor));
					break;
					
				case "oval":
					int ovalWidth = Integer.parseInt(split[7]);
					int ovalHeight = Integer.parseInt(split[8]);
					r = Integer.parseInt(split[9]);
					g = Integer.parseInt(split[10]);
					b = Integer.parseInt(split[11]);
					Color ovalColor = Color.rgb(r, g, b);
					shapeQueue.enqueue(makeOval(insertionTime, x, y, vx, vy, ovalWidth, ovalHeight, isFilled, ovalColor));
					break;

				case "rect":
					int rectWidth = Integer.parseInt(split[7]);
					int rectHeight = Integer.parseInt(split[8]);
					r = Integer.parseInt(split[9]);
					g = Integer.parseInt(split[10]);
					b = Integer.parseInt(split[11]);
					Color rectColor = Color.rgb(r, g, b);
					shapeQueue.enqueue(makeRect(insertionTime, x, y, vx, vy, rectWidth, rectHeight, isFilled, rectColor));
					break;

				case "square":
					int side = Integer.parseInt(split[7]);
					r = Integer.parseInt(split[8]);
					g = Integer.parseInt(split[9]);
					b = Integer.parseInt(split[10]);
					Color squareColor = Color.rgb(r, g, b);
					shapeQueue.enqueue(makeSquare(insertionTime, x, y, vx, vy, side, isFilled, squareColor));
					break;

				case "triangle":
				int triWidth = Integer.parseInt(split[7]);
				int triHeight = Integer.parseInt(split[8]);
				r = Integer.parseInt(split[9]);
				g = Integer.parseInt(split[10]);
				b = Integer.parseInt(split[11]);
				Color triColor = Color.rgb(r, g, b);
				shapeQueue.enqueue(makeTriangle(insertionTime, x, y, vx, vy, triWidth, triHeight, isFilled, triColor));
				break;
						
				default:
					System.out.println("Shape not found");
			}


		}while(in.hasNextLine());

		// this returns the full shape queue ready to be displayed to the user.

		return shapeQueue;
	}





	/**
	 * Method to read the file and return a queue of shapes from this file. 
	 * @param filename the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {

		// The code below reads the data from the filename that is given by the user. 
		// It uses a try catch method in order to throw exception if the user enters a file that is invalid.  

		Scanner in = null;

		try{
			File shapeFile = new File(filename);
			in = new Scanner(shapeFile);
		}catch (FileNotFoundException e){
			System.out.println("Could not find " + filename);
			System.exit(0);
		}

		return ReadShapeFile.readLineByLine(in);

	}
}
