// THE EXPO CLASS FOR PRE-AP COMPUTER SCIENCE

// NOTE: HTML <br> (breaks) are used in the documentation so it will look better in Javadoc.


import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.applet.Applet;

/**
 *
 * EXPO CLASS UPDATE: 11/14/2016 <BR><BR>
 *
 * The concept and implementation of the original set of Expo class methods was created by John L. M. Schram
 * (the Son), who is called John Schram.  The Expo class was created to teach programming skills to students
 * in introductory computer science courses. Use of the Expo class eliminates many program steps that are
 * tedious and frustrating for beginning students.  Program input and random number generation are simplified.
 * Graphics commands are more intuitive.  Many additional graphics commands are added to allow for interesting
 * displays with minimal effort. <BR><BR>
 *
 * The Expo class is a work in progress and you can expect the Schrams to add/remove methods from time to time.
 * The version date will indicate if you have the latest update.
 *
 * This version of the Expo class is meant for Pre-AP Computer Science.
 * Unlike the Expo class used for "Intro" or "CP" Computer Science, this version does NOT include methods
 * drawString, setFont, drawPolygon and fillPolygon.  The reason they are excluded is Mr. John Schram wants
 * Pre-APCS students to have more practice creating objects (like Font objects and Polygon objects).
 *
 * Since the creation of the initial bulk of the Expo class, John L. A. Schram (the father),
 * who is called Leon Schram, has added some additional methods.
 * Both John Schram and Leon Schram are computer science teachers at John Paul II High School in Plano, Texas. <BR><BR>
 *
 * This code is free software; you can redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software Foundation. This code is distributed in the
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * 36 constant colors are built into the Expo class
 * The 7 primary colors are red, green, blue, orange, yellow, tan and gray.
 * Each of these colors also has a "dark" shade and a "light" shade.
 * For example, the 3 shades of red are: red, lightRed and darkRed.
 * The following colors are also included without multiple shades:
 * black, white, brown, violet, purple, turquoise, pink, cyan, magenta, indigo, teal, gold, silver, bronze, and lime.
 *
 * The following real numbers constants are also built in:
 * twoPI, which equals 2 * Math.PI
 * halfPI, which equals Math.PI / 2;
 * quarterPI, which equals Math.PI / 4;
 *
 **/

public class Expo
{
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Color constants
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 7 primary colors
	static final Color red            = Color.red;
	static final Color green          = Color.green;
	static final Color blue           = Color.blue;
	static final Color orange         = Color.orange;
	static final Color yellow         = Color.yellow;
	static final Color gray           = Color.gray;
	static final Color tan            = new Color(210,180,140);


	//dark and light shades of all of the above primary colors
	static final Color lightRed       = new Color(255,128,128);
	static final Color darkRed        = new Color(192,0,0);

	static final Color lightOrange    = new Color(255,224,0);
	static final Color darkOrange     = new Color(255,128,0);

	static final Color lightYellow    = new Color(255,255,128);
	static final Color darkYellow     = new Color(192,192,0);

	static final Color lightGreen     = new Color(128,255,128);
	static final Color darkGreen      = new Color(0,128,0);

	static final Color lightBlue      = new Color(128,128,255);
	static final Color darkBlue       = new Color(0,0,128);

	static final Color lightTan       = new Color(231,198,154);
	static final Color darkTan        = new Color(189,145,87);

	static final Color lightGray      =	Color.lightGray;
	static final Color darkGray       = Color.darkGray;

	// 15 special colors (which do not have multiple shades provided)
	static final Color pink           = Color.pink;
	static final Color black          = Color.black;
	static final Color white          = Color.white;
	static final Color cyan           = Color.cyan;
	static final Color magenta        = Color.magenta;
	static final Color brown          = new Color(150,100,15);
	static final Color violet         = new Color(240,128,240);
	static final Color purple         = new Color(128,0,128);
	static final Color turquoise      = new Color(64,224,208);
	static final Color indigo         = new Color(75,0,130);
	static final Color gold           = new Color(255,215,0);
	static final Color silver         = new Color(192,192,192);
	static final Color bronze         = new Color(164,102,40);
	static final Color teal           = new Color(0,128,128);
	static final Color lime           = new Color(50,205,50);


	// allows for alternative spelling of "grey"
	static final Color grey           = gray;
	static final Color lightGrey      =	lightGray;
	static final Color darkGrey       = darkGray;

	static Color currentColor 		  = black;   // The current drawing color being used at any particular time.


	//////////////////////////////////////////////////////////////////////////////////////////////////////////////



	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Math Constants and Random Number Generating Methods
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	static final double twoPI     = 2 * Math.PI;
	static final double halfPI    = Math.PI / 2;
	static final double quarterPI = Math.PI / 4;


	/**
     * Returns a "true" random integer in the [min..max] range, inclusive. <BR>
     * Precondition: max > min <br>
     * Example:<br>
     * System.out.println(Expo.random(100,200)); <br>
     * This will display a random integer between 100 and 200.
     **/
	public static int random(int min, int max)
	{
		int range = max - min + 1;
		int number = (int) (range * Math.random() + min);
		return number;
	}



	//////////////////////////////////////////////////////////////////////////////////////////////////////////////



	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Waiting Utility Methods
	// These next couple methods will stop the output temporarily.
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////


	/**
	 * Pauses the output and waits for the user to press the [enter] key. <br>
     * Example: <br>
     * Expo.pause();
	 **/
	public static void pause()
	{
		System.out.println("\n");
		System.out.print("Press the <enter> key to continue...");
		String dummy = enterString();
		System.out.println("\n\n");
	}


	/**
	 * Delays the output for a specified number of milliseconds (1/1000ths of a second). <br>
	 * Examples:<br>
	 * Expo.delay(1000); // pause for 1 second <br>
	 * Expo.delay(2000); // pause for 2 seconds <br>
	 * Expo.delay(500);  // pause for 1/2 of a second <br>
	 * Expo.delay(100);  // pause for 1/10 of a second <br>
	 * Expo.delay(10);   // pause for 1/100 of a second <br>
	 * Expo.delay(1);    // pause for 1/1000 of a second <br>
	 **/
	public static void delay(int n)
	{
		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while (endDelay - startDelay < n)
			endDelay = System.currentTimeMillis();
	}


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////



	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Methods for keyboard text input during program execution.
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
     * Allows input of an int (integer) from the keyboard in a text window. <br>
     * Example: <br>
     * System.out.print("How old are you?  -->  "); <br>
     * int age = Expo.enterInt();
     **/
	public static int enterInt()
	{
		Scanner input = new Scanner(System.in);
		int temp = input.nextInt();
		return temp;
	}


	/**
     * Allows input of a double (real number) from the keyboard in a text window. <br>
     * Example: <br>
     * System.out.print("What is your current GPA?  {0.00 - 4.00}  -->  "); <br>
     * double gpa = Expo.enterDouble();
     **/
	public static double enterDouble()
	{
		Scanner input = new Scanner(System.in);
		double temp = input.nextDouble();
		return temp;
	}


	/**
     * Allows input of a String from the keyboard in a text window. <br>
     * Example: <br>
     * System.out.print("What is your name?  --->  "); <br>
     * String name = Expo.enterString();
     **/
	public static String enterString()
	{
		Scanner input = new Scanner(System.in);
		String temp = input.nextLine();
		return temp;
	}


	/**
     * Allows input of a char from the keyboard in a text window. <br>
     * Example: <br>
     * System.out.print("What is your middle initial?  -->  "); <br>
     * char middleInitial = Expo.enterChar();
     **/
	public static char enterChar()
	{
		Scanner input = new Scanner(System.in);
		String temp = input.nextLine();
		return temp.charAt(0);
	}



	/////////////////////////////////////////////////////////////////////////////////////////////////////////////



	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Graphics methods to manipulate color.
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Allows the user to change the color, using a Color object parameter. <BR>
     * Example:
     * Expo.setColor(g,Expo.red);
     * Changes the current drawing  color to red.
     * 36 colors constants are built into the Expo class.  These colors are listed near the top of this file.
     **/
	public static void setColor(Graphics g, Color newColor)
	{
		g.setColor(newColor);
		currentColor = newColor;
	}


	/**
	 * Allows the user to change to one of 10 predefined primary colors using a single int parameter.<br>
	 * This is especially useful in programs where you want to change from one color to a contrasting color quickly. <br>
	 * 0 = black <br>
	 * 1 = red <br>
	 * 2 = green <br>
	 * 3 = blue <br>
	 * 4 = orange <br>
	 * 5 = cyan <br>
	 * 6 = magenta <br>
	 * 7 = yellow <br>
	 * 8 = gray <br>
	 * 9 = pink <br>
	 * Any negative number will give you white. <br><br>
	 * Example: <br>
	 * Expo.setColor(g,1); <br>
     * Changes the current drawing color to red.
	 **/
	public static void setColor(Graphics g, int colorNum)
	{
		colorNum %= 10;
		switch(colorNum)
		{
			case  0 : g.setColor(black); 	currentColor = black; 	 break;
			case  1 : g.setColor(red); 		currentColor = red;		 break;
			case  2 : g.setColor(green); 	currentColor = green;	 break;
			case  3 : g.setColor(blue); 	currentColor = blue;	 break;
			case  4 : g.setColor(orange); 	currentColor = orange;	 break;
			case  5 : g.setColor(cyan); 	currentColor = cyan;	 break;
			case  6 : g.setColor(magenta); 	currentColor = magenta;	 break;
			case  7 : g.setColor(yellow); 	currentColor = yellow;	 break;
			case  8 : g.setColor(gray); 	currentColor = gray;	 break;
			case  9 : g.setColor(pink); 	currentColor = pink;	 break;
			default : g.setColor(white);
		};
	}


	/**
	 * Allows the user to change the color using 3 int parameters representing the amount of red, green and blue.<br>
	 * This allows for more than 16 million different color combinations. <br>
	 * Precondition: All 3 color values need to be between 0 and 255 inclusive. <br>
	 * Example: <br>
	 * Expo.setColor(g,190,10,47); <br>
     * Changes the current drawing color to the shade of red used in the official Texas Flag
	 **/
	public static void setColor(Graphics g, int red, int green, int blue)
	{
		Color newColor = new Color(red, green, blue);
		g.setColor(newColor);
		currentColor = newColor;
	}


	/**
	 * Allows the user to change the color and transparency using 4 int parameters. <BR>
	 * The first 3 represent the amount of red, green and blue.<br>
	 * This allows for more than 16 million different color combinations. <br>
	 * The fourth int value is the "alpha" value which determines transparency.
	 * Small alpha values are more transparent.  Large alpha values are more opaque. <BR>
	 * Precondition: All 4 int values need to be between 0 and 255 inclusive. <br>
	 * Example: <br>
	 * Expo.setColor(g,190,10,47,128); <br>
     * Changes the current drawing color to the shade of red used in the official Texas Flag
     * and makes it semi-transparent
	 **/
	public static void setColor(Graphics g, int red, int green, int blue, int alpha)
	{
		Color newColor = new Color(red, green, blue, alpha);
		g.setColor(newColor);
		currentColor = newColor;
	}


	/**
	 * Sets the current color to a random color value which can be any of the 16,000,000+ possible colors. <br>
	 * Example: <br>
	 * Expo.setRandomColor(g);
	 **/
	public static void setRandomColor(Graphics g)
	{
	    int red   = random(0,255);
	    int green = random(0,255);
	    int blue  = random(0,255);
	    Color newColor = new Color(red, green, blue);
		g.setColor(newColor);
		currentColor = newColor;
	}


	/**
	 * Sets the entire background to a single color using a Color object parameter. <br>
	 * Precondition: The graphics screen cannot be greater than 4800 X 3600 in size. <br>
	 * Postcondition: The current drawing color will not be affected by the background color. <br>
	 * Example: <br>
	 * Expo.setBackground(g,Expo.red);
	 * This will make the entire background red.
	 * 36 colors constants are built into the Expo class.  These colors are listed near the top of this file.
	 **/
	public static void setBackground(Graphics g, Color bgColor)
	{
	    g.setColor(bgColor);
	    fillRectangle(g,0,0,4800,3600);
	    setColor(g,currentColor);
	}


	/**
	 * Sets the entire background to one of 10 predefined primary colors using a single int parameter. <br>
	 * 0 = black <br>
	 * 1 = red <br>
	 * 2 = green <br>
	 * 3 = blue <br>
	 * 4 = orange <br>
	 * 5 = cyan <br>
	 * 6 = magenta <br>
	 * 7 = yellow <br>
	 * 8 = gray <br>
	 * 9 = pink <br>
	 * Any negative number will give you white. <br><br>
	 * Example: <br>
	 * Expo.setBackground(g,1); <br>
     * Changes the background color to red.
	 **/
	public static void setBackground(Graphics g, int colorNum)
	{
		colorNum %= 10;
		switch(colorNum)
		{
			case  0 : setBackground(g,black);    break;
			case  1 : setBackground(g,red);      break;
			case  2 : setBackground(g,green);    break;
			case  3 : setBackground(g,blue);     break;
			case  4 : setBackground(g,orange);   break;
			case  5 : setBackground(g,cyan);     break;
			case  6 : setBackground(g,magenta);  break;
			case  7 : setBackground(g,yellow);   break;
			case  8 : setBackground(g,gray);     break;
			case  9 : setBackground(g,pink);     break;
			default : setBackground(g,white);
		}
	}

	/**
	 * Sets the entire background to a single color using 3 int parameters representing the amount of red, green and blue.<br>
	 * This allows for more than 16 million different color combinations. <br>
	 * Preconditions: All 3 color values need to be between 0 and 255 inclusive. <br>
	 *                The graphics screen cannot be greater than 4800 X 3600 in size. <br>
	 * Postcondition: The current drawing color will not be affected by the background color. <br>
	 * Example: <br>
	 * Expo.setBackground(g,190,10,47); <br>
     * Changes the background color to the shade of red used in the official Texas Flag
	 **/

	public static void setBackground(Graphics g, int red, int green, int blue)
	{
		Color newColor = new Color(red, green, blue);
		setBackground(g,newColor);
	}


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////




	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Graphics methods which draw a large variety of "open" figures.
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Draws a single pixel at the specified x,y location. <BR>
	 * Example: <BR>
	 * Expo.drawPixel(g,100,200); <BR>
	 * Draws a very small single dot (pixel) on the graphics screen 100 pixels over and 200 pixels down
	 **/
	public static void drawPixel(Graphics g, int x, int y)
	{
		g.drawLine(x,y,x,y);
	}


	/**
	 * Draws a 3 pixel X 3 pixel "point" whose center is at the specified x,y location. <BR>
	 * Example: <BR>
	 * Expo.drawPoint(g,100,200);
	 * Draws a larger, more visible (than drawPixel) dot on the graphics screen 100 pixels over and 200 pixels down.
	 **/
	public static void drawPoint(Graphics g, int x, int y)
	{
		g.fillRect(x-1,y-1,3,3);
	}


	/**
	 * Draws the line segment connecting coordinates x1,y1 and x2,y2. <BR>
	 * Example: <BR>
	 * Expo.drawLine(g,100,200,300,400); <BR>
	 * Draws a line segment connecting the starting coordinate point (100,200) with the ending point (300,400).
	 **/
	public static void drawLine(Graphics g, int x1, int y1, int x2, int y2)
	{
		g.drawLine(x1,y1,x2,y2);
	}


	/**
	 * Draws an open circle.<br>
	 * The user specifies the x,y coordinate of the center of the circle as well as the radius value. <br>
	 * Example: <br>
	 * Expo.drawCircle(g,300,200,100); <br>
	 * Draws an open circle with a radius of 100 pixels whose center is located at the coordinate (300,200).
	 **/
	public static void drawCircle(Graphics g, int centerX, int centerY, int radius)
	{
		int diameter = 2 * radius;
		g.drawOval(centerX-radius, centerY-radius, diameter, diameter);
	}


	/**
	 * Draws an open oval.<br>
	 * The user specifies the x,y coordinate of the center of the oval as well as the horizontal and vertical radii values. <br>
	 * Example: <br>
	 * Expo.drawOval(g,300,200,100,50); <br>
	 * Draws an open oval with a horizontal radius of 100 pixels and a vertical radius of 50 pixels. <br>
	 * The center of this oval is located at the coordinate (300,200).
	 **/
	public static void drawOval(Graphics g, int centerX, int centerY, int hRadius, int vRadius)
	{
		int hDiameter = 2 * hRadius;
		int vDiameter = 2 * vRadius;
		g.drawOval(centerX-hRadius, centerY-vRadius, hDiameter, vDiameter);
	}


	/**
	 * Draws and arc which looks like a curve.<br>
	 * An ARC is a "piece" of an OVAL.<br>
	 * The first 5 parameters (g and 4 ints) are the same as drawOval.<br>
	 * There are 2 additional parameters for the starting degree value and finishing degree of the arc. <br>
	 * 0 degrees is at the 12:00 position and the degrees progress in a CLOCKWISE fashion. <br>
	 * (90 degrees is at 3:00, 180 degrees is at 6:00, 270 degrees is at 9:00, 360 degrees is back at 12:00).
	 **/
	public static void drawArc(Graphics g, int centerX, int centerY, int hRadius, int vRadius, int start, int finish)
	{
		int hDiameter = 2 * hRadius;
		int vDiameter = 2 * vRadius;

		if (finish < start)
			finish += 360;
		int newStart  = 90 - start;   // shifts starting position from 3:00 to 12:00
		int newFinish = start-finish; // as opposed to finish-start.  Subtracting backwards changes from counter-clockwise to clockwise.

		g.drawArc(centerX-hRadius, centerY-vRadius, hDiameter, vDiameter, newStart, newFinish);
	}


	/**
	 * Draws an open rectangle.<br>
	 * The upper-left-hand corner is specified by x1,y1 and the lower-right-hand corner is specified by x2, y2. <br>
	 * Example: <br>
	 * Expo.drawRectangle(g,100,200,300,400); <br>
	 * Draws an open rectangle whose upper-left-hand coordinate is (100,200) and whose lower-right-hand coordinate is (300,400).
	 **/
	public static void drawRectangle(Graphics g, int x1, int y1, int x2, int y2)
	{
		int temp;
		if (x1 > x2)
			{ temp = x1; x1 = x2; x2 = temp; }
		if (y1 > y2)
			{ temp = y1; y1 = y2; y2 = temp; }
		int width  = x2 - x1;
		int height = y2 - y1;
		g.drawRect(x1,y1,width,height);
	}


	/**
	 * Draws an open rectangle with rounded corners.<br>
	 * The first 5 parameters (g and 4 ints) are the same as drawRect.<br>
	 * The final parameter "pixels" specifies the number of pixels used in the rounded corner. <br>
	 * Example: <br>
	 * Expo.drawRoundedRectangle(g,100,200,300,400,25);
	 **/
	public static void drawRoundedRectangle(Graphics g, int x1, int y1, int x2, int y2, int pixels)
	{
		int temp;
		if (x1 > x2) { temp = x1; x1 = x2; x2 = temp; }
		if (y1 > y2) { temp = y1; y1 = y2; y2 = temp; }
		int width  = x2 - x1;
		int height = y2 - y1;
		int diameter = pixels * 2;
		g.drawRoundRect(x1,y1,width,height,diameter,diameter);
	}


	/**
	 * Draws a spiral.
	 * The center of the spiral is specified with the centerX,centerY parameters. <BR>
	 * The maxRadius parameter determines the size of the spiral. <BR>
	 * (It is actually the radius of the circle that the spiral would fit inside.) <BR>
	 * The spacing is controlled by the "spacing" parameter.  <BR>
	 * Example: <BR>
	 * Expo.drawSpiral(g,300,200,100,25); <BR>
	 * Draws a spiral with a maxRadius of 100 pixels whose center is located at the coordinate (300,200). <BR>
	 * There are precisely 25 pixels separating each "loop" of the spiral. <BR>
	 **/
	public static void drawSpiral(Graphics g, int centerX, int centerY, int maxRadius, double spacing)
	{
		double spiralInc = spacing / (twoPI * 1000);

		double spiralRadius = 0;
		double radian = 0;
		while (spiralRadius <= maxRadius)
		{
			int x = (int) Math.round(Math.cos(radian - halfPI) * spiralRadius) + centerX;
			int y = (int) Math.round(Math.sin(radian - halfPI) * spiralRadius) + centerY;
			drawPixel(g,x,y);
			radian += 0.001;
			spiralRadius += spiralInc;
		}
	}


	/**
	 * Draws a certain number of lines (numLines) in a burst like pattern.<br>
	 * The lines are evenly spaced and drawn from the center of a circle to its edge.<br>
	 * The size of the circle is specified by the radius parameter. <br>
	 * Example: <br>
	 * Expo.drawBurst(g,300,200,100,50); <br>
	 * Draws a "burst" with a radius of 100 pixels whose center is located at the coordinate (300,200). <br>
	 * The "burst" will be comprised of 50 evenly spaced lines.
	 **/
	public static void drawBurst(Graphics g, int centerX, int centerY, int radius, int numLines)
	{
		double offSet;
		if (numLines % 2 == 1)
			offSet = halfPI;
		else
			offSet = halfPI + Math.PI/numLines;

		for (double radian = 0; radian < twoPI; radian += twoPI/numLines)
		{
			int x = (int) Math.round(Math.cos(radian - offSet) * radius) + centerX;
			int y = (int) Math.round(Math.sin(radian - offSet) * radius) + centerY;
			g.drawLine(centerX, centerY, x, y);
		}
	}


	/**
	 * Draws an open regular polygon with a specified number of sides.<br>
	 * The center of this polygon is specified by centerX,centerY and its size is specified by radius <br>
	 * (As in the radius of the circle the regular polygon would fit inside). <br>
	 * Precondition: sides >= 3 <br>
	 * Example: <br>
	 * Expo.drawRegularPolygon(g,300,200,100,8); <br>
	 * Draws an open regular polygon with 8 sides and a radius of 100 pixels whose center is located at the coordinate (300,200).
	 **/
	public static void drawRegularPolygon(Graphics g, int centerX, int centerY, int radius, int sides)
	{
		int xCoord[] = new int[sides];
		int yCoord[] = new int[sides];

	 	double rotate;
	    if (sides % 2 == 1)
	    	rotate = halfPI;
	    else
	    	rotate = halfPI + Math.PI/sides;

		for (int k = 0; k < sides; k++)
		{
			xCoord[k] = (int) Math.round(Math.cos(twoPI * k/sides - rotate) * radius) + centerX;
			yCoord[k] = (int) Math.round(Math.sin(twoPI * k/sides - rotate) * radius) + centerY;
		}
		if (sides == 3)
			yCoord[1] = yCoord[2];
		g.drawPolygon(xCoord,yCoord,sides);
	}


	/**
	 * Draws an open star with a specified number of points.<br>
	 * The center of this star is specified by centerX,centerY and its size is specified by radius <br>
	 * (As in the radius of the circle the star would fit inside). <br>
	 * Precondition: points >= 2 <br>
	 * Example: <br>
	 * Expo.drawStar(g,300,200,100,8); <br>
	 * Draws an open star with 8 points and a radius of 100 pixels whose center is located at the coordinate (300,200).
	 **/
	public static void drawStar(Graphics g, int centerX, int centerY, int radius, int points)
	{
		int halfRadius = getHalfRadius(radius, points);
		int p = points;
		points *= 2;

		int xCoord[] = new int[points];
		int yCoord[] = new int[points];

		int currentRadius;

		for (int k = 0; k < points; k++)
		{
			if (k % 2 == 0)
				currentRadius = radius;
			else
				currentRadius = halfRadius;

			xCoord[k] = (int) Math.round(Math.cos(twoPI * k/points - halfPI) * currentRadius) + centerX;
			yCoord[k] = (int) Math.round(Math.sin(twoPI * k/points - halfPI) * currentRadius) + centerY;
		}

		int x = (p-5)/2+1;
		if (p >= 5 && p <= 51)
			switch(p % 4)
			{
				case  1 : yCoord[x] = yCoord[x+1] = yCoord[points-x-1] = yCoord[points-x]; break;
				case  2 : yCoord[x] = yCoord[x+1] = yCoord[points-x-1] = yCoord[points-x];
					      yCoord[x+3] = yCoord[x+4] = yCoord[points-x-4] = yCoord[points-x-3]; break;
				case  3 : yCoord[x+2] = yCoord[x+3] = yCoord[points-x-3] = yCoord[points-x-2];
			}
		g.drawPolygon(xCoord,yCoord,points);
	}


 	/**
	 * Displays a heading at the top of the graphics screen. <br>
	 * The user provides his/her name and the number of the lab assignment. <br>
	 * Example: <br>
	 * Expo.drawHeading(g,"John Smith","6B"); <br>
	 * Displays "Lab 6B  By: John Smith" centered at the top of the graphics screen in big bold letters. <br>
	 * A separating line will also be drawn across the graphics screen 50 pixels below the top.
	 **/
	public static void drawHeading(Graphics g, String name, String labNum)
	{
	   String title = "Lab " + labNum + "   By: " + name;
  	   Font heading = new Font("Arial",Font.BOLD,36);
       FontMetrics metrics = g.getFontMetrics(heading);
	   int nameWidth = metrics.stringWidth(title);
       int x = (1000 - nameWidth) / 2;
       g.setFont(heading);
       g.drawString(title,x,38);
       g.drawLine(0,50,1000,50);
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////



	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Graphics methods which draws a large variety of "filled-in" figures.
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////


	/**
	 * Draws a solid "filled in" circle.<br>
	 * The user specifies the x,y coordinate of the center of the circle as well as the radius value. <br>
	 * Example: <br>
	 * Expo.fillCircle(g,300,200,100); <br>
	 * Draws a solid circle with a radius of 100 pixels whose center is located at the coordinate (300,200).
	 **/
	public static void fillCircle(Graphics g, int centerX, int centerY, int radius)
	{
		int diameter = 2 * radius;
		g.fillOval(centerX-radius, centerY-radius, diameter, diameter);
	}


	/**
	 * Draws a solid "filled in" oval.<br>
	 * The user specifies the x,y coordinate of the center of the oval as well as the horizontal and vertical radii values.  <br>
	 * Example: <br>
	 * Expo.fillOval(g,300,200,100,50); <br>
	 * Draws a solid oval with a horizontal radius of 100 pixels and a vertical radius of 50 pixels. <br>
	 * The center of this oval is located at the coordinate (300,200).
	 **/
	public static void fillOval(Graphics g, int centerX, int centerY, int hRadius, int vRadius)
	{
		int hDiameter = 2 * hRadius;
		int vDiameter = 2 * vRadius;
		g.fillOval(centerX-hRadius, centerY-vRadius, hDiameter, vDiameter);
	}


	/**
	 * Draws a "solid" arc which will look either like a pie wedge or Pac-man.<br>
	 * A FILLED ARC is a "piece" of a SOLID OVAL.<br>
	 * The first 5 parameters (g and 4 ints) are the same as drawOval.<br>
	 * There are 2 additional parameters for the starting degree value and finishing degree of the arc. <br>
	 * 0 degrees is at the 12:00 position and the degrees progress in a CLOCKWISE fashion. <br>
	 * (90 degrees is at 3:00, 180 degrees is at 6:00, 270 degrees is at 9:00, 360 degrees is back at 12:00).
	 **/
	public static void fillArc(Graphics g, int centerX, int centerY, int hRadius, int vRadius, int start, int finish)
	{
		int hDiameter = 2 * hRadius;
		int vDiameter = 2 * vRadius;

		if (finish < start)
			finish += 360;
		int newStart  = 90 - start;   // shifts starting position from 3:00 to 12:00
		int newFinish = start-finish; // as oppose to finish-start.  Subtracting backwards changes from counter-clockwise to clockwise.

		g.fillArc(centerX-hRadius, centerY-vRadius, hDiameter, vDiameter, newStart, newFinish);
	}


	/**
	 * Draws a solid "filled in" rectangle.<br>
	 * The upper-left-hand corner is specified by x1,y1 and the lower-right-hand corner is specified by x2, y2. <br>
	 * Example: <br>
	 * Expo.fillRectangle(g,100,200,300,400); <br>
	 * Draws an open rectangle whose upper-left-hand coordinate is (100,200) and whose lower-right-hand coordinate is (300,400).
	 **/
	public static void fillRectangle(Graphics g, int x1, int y1, int x2, int y2)
	{
		int temp;
		if (x1 > x2)
			{ temp = x1; x1 = x2; x2 = temp; }
		if (y1 > y2)
			{ temp = y1; y1 = y2; y2 = temp; }
		int width  = x2 - x1 + 1;
		int height = y2 - y1 + 1;
		g.fillRect(x1,y1,width,height);
	}


	/**
	 * Draws a solid "filled in" rectangle with rounded corners. <br>
	 * The parameters are the same as drawRoundedRectangle.
	 **/
	public static void fillRoundedRectangle(Graphics g, int x1, int y1, int x2, int y2, int pixels)
	{
		int temp;
		if (x1 > x2) { temp = x1; x1 = x2; x2 = temp; }
		if (y1 > y2) { temp = y1; y1 = y2; y2 = temp; }
		int width  = x2 - x1 + 1;
		int height = y2 - y1 + 1;
		int diameter = pixels * 2;
		g.fillRoundRect(x1,y1,width,height,diameter,diameter);
	}


	/**
	 * Draws a solid "filled in" regular polygon with a specified number of sides.<br>
	 * The center of this polygon is specified by centerX,centerY and its size is specified by radius <br>
	 * (As in the radius of the circle the regular polygon would fit inside). <br>
	 * Precondition: sides >= 3 <br>
	 * Example: <br>
	 * Expo.fillRegularPolygon(g,300,200,100,8); <br>
	 * Draws a solid regular polygon with 8 sides and a radius of 100 pixels whose center is located at the coordinate (300,200).
	 **/
	public static void fillRegularPolygon(Graphics g, int centerX, int centerY, int radius, int sides)
	{
		int xCoord[] = new int[sides];
		int yCoord[] = new int[sides];

	 	double rotate;
	    if (sides % 2 == 1)
	    	rotate = halfPI;
	    else
	    	rotate = halfPI + Math.PI/sides;

		for (int k = 0; k < sides; k++)
		{
			xCoord[k] = (int) Math.round(Math.cos(twoPI * k/sides - rotate) * radius) + centerX;
			yCoord[k] = (int) Math.round(Math.sin(twoPI * k/sides - rotate) * radius) + centerY;
		}
		if (sides == 3)
			yCoord[1] = yCoord[2];
		g.fillPolygon(xCoord,yCoord,sides);
	}


	private static int getHalfRadius(int radius, int points)
	{
		int halfRadius;

		switch(points)
		{
			case  3 : halfRadius = 140 * radius / 500; break;
			case  4 : halfRadius = 170 * radius / 400; break;
			case  5 : halfRadius = 192 * radius / 500; break;
			case  6 : halfRadius = 233 * radius / 400; break;
			case  7 : halfRadius = 179 * radius / 500; break;
			case  8 : halfRadius = 215 * radius / 400; break;
			case  9 : halfRadius = 173 * radius / 500; break;
			case 10 : halfRadius = 212 * radius / 400; break;
			default : if (points < 52)
				  	  {
				     	  if (points % 2 == 1)
					      	  halfRadius = (180-points) * radius / 500;
				     	  else
		                	  halfRadius = (222-points) * radius / 400;
				  	  }
				  	  else
				 	 	  halfRadius = radius / 2;
		}
		return halfRadius;
	}


	/**
	 * Draws a solid "filled in" star with a specified number of points.<br>
	 * The center of this star is specified by centerX,centerY and its size is specified by radius <br>
	 * (As in the radius of the circle the star would fit inside). <br>
	 * Precondition: points >= 2 <br>
	 * Example: <br>
	 * Expo.fillStar(g,300,200,100,8); <br>
	 * Draws a solid star with 8 points and a radius of 100 pixels whose center is located at the coordinate (300,200).
	 **/
	public static void fillStar(Graphics g, int centerX, int centerY, int radius, int points)
	{
		int halfRadius = getHalfRadius(radius, points);
		int p = points;
		points *= 2;

		int xCoord[] = new int[points];
		int yCoord[] = new int[points];

		int currentRadius;

		for (int k = 0; k < points; k++)
		{
			if (k % 2 == 0)
				currentRadius = radius;
			else
				currentRadius = halfRadius;

			xCoord[k] = (int) Math.round(Math.cos(twoPI * k/points - halfPI) * currentRadius) + centerX;
			yCoord[k] = (int) Math.round(Math.sin(twoPI * k/points - halfPI) * currentRadius) + centerY;
		}

		int x = (p-5)/2+1;
		if (p >= 5 && p <= 51)
			switch(p % 4)
			{
				case  1 : yCoord[x] = yCoord[x+1] = yCoord[points-x-1] = yCoord[points-x]; break;
				case  2 : yCoord[x] = yCoord[x+1] = yCoord[points-x-1] = yCoord[points-x];
					      yCoord[x+3] = yCoord[x+4] = yCoord[points-x-4] = yCoord[points-x-3]; break;
				case  3 : yCoord[x+2] = yCoord[x+3] = yCoord[points-x-3] = yCoord[points-x-2];
			}
		g.fillPolygon(xCoord,yCoord,points);
	}
}