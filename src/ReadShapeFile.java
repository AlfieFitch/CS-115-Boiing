
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */

import javafx.css.SimpleStyleableDoubleProperty;
import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

	// TODO: You will likely need to write four methods here. One method to
	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.

	private static Circle makeCircle(int intim, int x, int y, int vx, int vy, int diameter, boolean isFilled, Color color){
		Circle circle = new Circle(intim, x, y, vx, vy, diameter, color, isFilled);
		System.out.println(circle);
		return circle;
	}

	private static void makeOval(){

	}

	private static void rect(){
	}
	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in
	 *            the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readLineByLine(Scanner in) {

		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

		do{

			String[] split = in.nextLine().split("\\s+");

			String shape = split[0];
			String insertionTime = split[1];
			String x = split[2];
			String y = split[3];
			String vx = split[4];
			String vy = split[5];
			String isFilled = split[6];
			int r, g, b;

			switch(shape) {

				case "circle":		
					System.out.println(shape);
					String diameter = split[7];
					r = Integer.parseInt(split[8]);
					g = Integer.parseInt(split[9]);
					b = Integer.parseInt(split[10]);
					Color color = Color.rgb(r, g, b);
					shapeQueue.enqueue(makeCircle(Integer.parseInt(insertionTime), Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(vx), Integer.parseInt(vy), Integer.parseInt(diameter), Boolean.parseBoolean(isFilled), color));

				case "oval":
					String width = split[7];
					String height = split[8];
					r = Integer.parseInt(split[9]);
					g = Integer.parseInt(split[10]);
					b = Integer.parseInt(split[11]);
					makeOval();
			}


		}while(in.hasNextLine());

		//Right now, returning an empty Queue.  You need to change this.
		return shapeQueue;
	}





	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename
	 *            the name of the file
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
