//Create a class POINT for storing the co-ordinates of a geometrical point. Write static function to calculate the distance between two points.//


import java.util.Scanner;
public class Point {
    private double x;
    private double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public static double distance(Point p1, Point p2) {
        double dx = p2.x - p1.x;
        double dy = p2.y - p1.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the coordinates of the first point
        System.out.println("Enter the x-coordinate of the first point:");
        double x1 = scanner.nextDouble();
        System.out.println("Enter the y-coordinate of the first point:");
        double y1 = scanner.nextDouble();
        // Read the coordinates of the second point
        System.out.println("Enter the x-coordinate of the second point:");
        double x2 = scanner.nextDouble();
        System.out.println("Enter the y-coordinate of the second point:");
        double y2 = scanner.nextDouble();
        // Create the two points
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        // Calculate the distance between the two points
        double distance = distance(p1, p2);
        // Print the distance
        System.out.println("The distance between the two points is: " + distance);
    }
}