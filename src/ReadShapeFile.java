
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

	private static void getData(String input){
		Scanner in = new Scanner(input);
		String shape = in.next();
		String insertionTime = in.next();
		String x = in.next();
		String y = in.next();
		String vx = in.next();
		String vy = in.next();
		String isFilled = in.next();
		String diameter = in.next();
		String colour = in.next();
		in.close();
		switch(shape) {
			case "circle":
				makeCircle(Integer.parseInt(insertionTime), Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(vx), Integer.parseInt(vy), Integer.parseInt(diameter), Boolean.parseBoolean(isFilled));
		}
	}


	private static void makeCircle(int intim, int x, int y, int vx, int vy, int diameter, boolean isFilled){
		Circle circle = new Circle(intim, x, y, vx, vy, diameter, null, isFilled);
		System.out.println(circle);
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
			while(in.hasNextLine()){
				ReadShapeFile.getData(in.nextLine());
			}
			in.close();
		}catch (FileNotFoundException e){
			System.out.println("Could not find " + filename);
			System.exit(0);
		}

		return ReadShapeFile.readLineByLine(in);

	}
}
