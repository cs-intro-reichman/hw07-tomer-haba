/** Draws the Koch curve and the Koch snowflake fractal. */
public class Koch {

    public static void main(String[] args) {

        //// Uncomment the first code block to test the curve function.
        //// Uncomment the second code block to test the snowflake function.
        //// Uncomment only one block in each test, and remember to compile
        //// the class whenever you change the test.

        /* // Tests the curve function:
        // Gets n, x1, y1, x2, y2,
        // and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
        if (args.length >= 5) {
            curve(Integer.parseInt(args[0]),
                Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
                Double.parseDouble(args[3]), Double.parseDouble(args[4]));
        }
        */
        
        // Tests the snowflake function:
        // Gets n, and draws a Koch snowflake of n edges in the standard canvas.
        if (args.length >= 1) {
             snowFlake(Integer.parseInt(args[0]));
        }
    }

    /** Gets n, x1, y1, x2, y2,
     * and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
    public static void curve(int n, double x1, double y1, double x2, double y2) {
        // Base case: if depth is 0, just draw the line
        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }

        // Calculate the division points for depth n > 0
        
        // Point at 1/3 of the segment
        double x_p2 = x1 + (x2 - x1) / 3;
        double y_p2 = y1 + (y2 - y1) / 3;

        // Point at 2/3 of the segment
        double x_p4 = x1 + 2 * (x2 - x1) / 3;
        double y_p4 = y1 + 2 * (y2 - y1) / 3;

        // The peak of the equilateral triangle (p3)
        // Using the formula from the homework PDF
        double x_p3 = (x1 + x2) / 2 + (Math.sqrt(3) / 6) * (y1 - y2);
        double y_p3 = (y1 + y2) / 2 + (Math.sqrt(3) / 6) * (x2 - x1);

        // Recursive calls for the 4 segments
        curve(n - 1, x1, y1, x_p2, y_p2);       // Segment 1
        curve(n - 1, x_p2, y_p2, x_p3, y_p3);   // Segment 2 (up to peak)
        curve(n - 1, x_p3, y_p3, x_p4, y_p4);   // Segment 3 (down from peak)
        curve(n - 1, x_p4, y_p4, x2, y2);       // Segment 4
    }

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvas. */
    public static void snowFlake(int n) {
        // A little tweak that makes the drawing look better
        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);
        
        // Draws a Koch snowflake of depth n
        // We define the vertices of a large equilateral triangle
        // to serve as the base for the snowflake.
        
        double x1 = 0.200, y1 = 0.750;
        double x2 = 0.800, y2 = 0.750;
        double x3 = 0.500, y3 = 0.230; // Approx height for equilateral

        // Draw the 3 curves connecting the vertices
        // Note: The order matters to ensure the "bumps" point outwards
        curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
    }
}