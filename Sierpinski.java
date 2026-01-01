/** Draws the Sierpinski Triangle fractal. */
public class Sierpinski {
    
    public static void main(String[] args) {
        sierpinski(Integer.parseInt(args[0]));
    }
    
    // Draws a Sierpinski triangle of depth n on the standard canvas.
    public static void sierpinski (int n) {
        // Calculate the height of the equilateral triangle with side length 1
        double height = Math.sqrt(3) / 2;
        
        // Define the vertices of the main outer triangle
        // Bottom-left (0,0), Bottom-right (1,0), Top (0.5, height)
        double[] x = {0, 1, 0.5};
        double[] y = {0, 0, height};

        // Draw the initial solid black triangle
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledPolygon(x, y);

        // Call the recursive function to "punch holes" in it
        sierpinski(n, x[0], x[1], x[2], y[0], y[1], y[2]);
    }
    
    // Does the actual drawing, recursively.
    private static void sierpinski(int n, double x1, double x2, double x3,
                                         double y1, double y2, double y3) {
        // Base case: if depth is 0, we stop the recursion
        if (n == 0) {
            return;
        }

        // Calculate midpoints of the edges
        double x12 = (x1 + x2) / 2;
        double y12 = (y1 + y2) / 2;
        double x23 = (x2 + x3) / 2;
        double y23 = (y2 + y3) / 2;
        double x31 = (x3 + x1) / 2;
        double y31 = (y3 + y1) / 2;

        // Draw the inverted white triangle in the middle (erasing the center)
        double[] xHole = {x12, x23, x31};
        double[] yHole = {y12, y23, y31};
        
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledPolygon(xHole, yHole);

        // Recursive calls for the three remaining smaller triangles (at the corners)
        // Note: The order of arguments maintains the orientation relative to the corner
        sierpinski(n - 1, x1, x12, x31, y1, y12, y31); // Bottom-left corner
        sierpinski(n - 1, x12, x2, x23, y12, y2, y23); // Bottom-right corner
        sierpinski(n - 1, x31, x23, x3, y31, y23, y3); // Top corner
    }
}