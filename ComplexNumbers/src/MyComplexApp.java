import java.util.Scanner;

public class MyComplexApp {

    public static void main(String[] args) {

        final Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter complex number 1 (real and imaginary part): " );
        MyComplex complex1 = new MyComplex(inputScanner.nextDouble(), inputScanner.nextDouble());

        System.out.print("Enter complex number 2 (real and imaginary part): " );
        MyComplex complex2 = new MyComplex(inputScanner.nextDouble(), inputScanner.nextDouble());

        System.out.println("Number 1 is: " + complex1);
        if(complex1.isReal()) {
            System.out.println(complex1 + "IS a pure real number");
        } else {
            System.out.println(complex1 + "is NOT a pure real number");
        }

        if ((complex1.isImaginary())) {
            System.out.println(complex1 + "IS a pure imaginary number");
        } else {
            System.out.println(complex1 + "is NOT a pure imaginary number");
        }

        System.out.println("Number 2 is: " + complex2);
        if(complex2.isReal()) {
            System.out.println(complex2 + "IS a pure real number");
        } else {
            System.out.println(complex2 + "is NOT a pure real number");
        }

        if ((complex2.isImaginary())) {
            System.out.println(complex2 + "IS a pure imaginary number");
        } else {
            System.out.println(complex2 + "is NOT a pure imaginary number");
        }

        if (complex1.equals(complex2)) {
            System.out.println(complex1 + "IS equal to " + complex2);
        } else {
            System.out.println(complex1 + "is NOT equal to " + complex2);
        }

        System.out.println(complex1 + "" + complex2 + " = " + complex1.addNew(complex2));
    }
}
