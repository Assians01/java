//Rewrite the same program using the concept of abstract classes & abstract methods.//

// Abstract class Figure2D
abstract class Figure2D {
    protected double width;
    protected double height;
    public abstract double calcArea();
}
// Class Rectangle
class Rectangle extends Figure2D {
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
class Triangle extends Figure2D {
    public Triangle(double base, double height) {
        this.width = base;
        this.height = height;
    }
    //@Override
    public double calcArea() {
        return 0.5 * width * height;
    }
}
// Main class
public class TWOD1 {
    public static void main(String[] args) {
        Figure2D rectangle = new Rectangle(5, 10);
        Figure2D triangle = new Triangle(3, 4);
        System.out.println("Rectangle area: " + rectangle.calcArea());
        System.out.println("Triangle area: " + triangle.calcArea());
    }
}