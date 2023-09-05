//Create a class COMPLEX for storing the real and imaginary parts of a complex number. The class should have static members to store the number of complex numbers created and dispaly it. Write functions (static or non-static  as required) to calculate i) sum,difference and product of two complex numbers, ii) modulus  and complement of a complex number Define required constructors and destructors of the class. Implement the class by a main function.//

import java.util.Scanner;

public class Complex {
    private double real;
    private double imaginary;
    private static int numComplexNumbers = 0;
    private static int count = 0;

    public Complex() {
        this(0, 0);
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
        numComplexNumbers++;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public static int getNumComplexNumbers() {
        return numComplexNumbers;
    }

    public static Complex add(Complex c1, Complex c2) {
        return new Complex(c1.real + c2.real, c1.imaginary + c2.imaginary);
    }

    public static Complex subtract(Complex c1, Complex c2) {
        return new Complex(c1.real - c2.real, c1.imaginary - c2.imaginary);
    }

    public static Complex multiply(Complex c1, Complex c2) {
        return new Complex(c1.real * c2.real - c1.imaginary * c2.imaginary,
                c1.real * c2.imaginary + c1.imaginary * c2.real);
    }

    public double modulus() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public Complex complement() {
        return new Complex(real, -imaginary);
    }

    public String toString() {
        return real + " + " + imaginary + "i";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the real part of the first complex number:");
        double real1 = scanner.nextDouble();
        System.out.println("Enter the imaginary part of the first complex number:");
        double imaginary1 = scanner.nextDouble();
        System.out.println("Enter the real part of the second complex number:");
        double real2 = scanner.nextDouble();
        System.out.println("Enter the imaginary part of the second complex number:");
        double imaginary2 = scanner.nextDouble();
        Complex c1 = new Complex(real1, imaginary1);
        Complex c2 = new Complex(real2, imaginary2);

        System.out.println("Number of complex numbers created: " + Complex.getNumComplexNumbers());

        System.out.println("Complex number 1: " + c1);
        System.out.println("Complex number 2: " + c2);

        Complex sum = Complex.add(c1, c2);
        Complex difference = Complex.subtract(c1, c2);
        Complex product = Complex.multiply(c1, c2);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);

        System.out.println("Modulus of c1: " + c1.modulus());
        System.out.println("Complement of c2: " + c2.complement());
    }

    public String display() {
        return;
    }

    public static void totalCount() {
        System.out.println("Total active objects = " + count);
    }

    public void finalise() {
        System.out.println("Destroy: " + display());
        count -= 1;
    }

    public static void totalCount() {
        System.out.println("Total active objects = " + count);
    }

}