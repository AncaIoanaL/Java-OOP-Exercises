public class MyComplexMain {

    public static void main(String[] args) {

        MyComplex C1 = new MyComplex(2, 4);
        MyComplex C2 = new MyComplex(3, 7);

        System.out.println(C1.getReal());
        System.out.println(C1.getImag() + "i");

        C1.setReal(1);
        C1.setImag(3);
        System.out.println(C1.getReal());
        System.out.println(C1.getImag() + "i");

        C1.setValue(6, 8);
        System.out.println(C1.getReal());
        System.out.println(C1.getImag() + "i");

        System.out.println(C1);

        System.out.println(C1.isReal());

        System.out.println(C1.isImaginary());

        System.out.println("is equals?: " + C1.equals(6, 8));

        System.out.println("is equals?: " + C1.equals(C2));

        System.out.println("magnitude: " + C1.magnitude());

        System.out.println("argument: " + C1.argument());

        C1.setValue(2, 5);
        C2.setValue(3, 7);

        System.out.println("add: " + C1.add(C2));
        System.out.println("subtract: " + C1.subtract(C2));
        System.out.println("multiply: " + C1.multiply(C2));
        System.out.println("divide: " + C1.divide(C2));
    }
}
