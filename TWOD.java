//Create a class 2D figure that contain data members to represent dimension & a method cal_area to calculate the corresponding area. Derive 2 classes rectangular & traingle from 2D figure & calculate the corresponding areas.// 


// Interface Figure2D
interface Figure2D {
    double calcArea();
}
// Class Rectangle
class Rectangle implements Figure2D {
    private double width;
    private double height;
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    //@Override
    public double calcArea() {
        return width * height;
    }
}
// Class Triangle
class Triangle implements Figure2D {
    private double base;
    private double height;
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    //@Override
    public double calcArea() {
        return 0.5 * base * height;
    }
}
// Main class
public class TWOD {
    public static void main(String[] args) {
        Figure2D rectangle = new Rectangle(5, 10);
        Figure2D triangle = new Triangle(3, 4);
        System.out.println("Rectangle area: " + rectangle.calcArea());
        System.out.println("Triangle area: " + triangle.calcArea());
    }
}