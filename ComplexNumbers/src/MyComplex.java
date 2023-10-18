public class MyComplex {

    private double real;
    private double imag;

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public String toString() {
        return String.format("(%s + %si)", real, imag);
    }

    public boolean isReal() {
        return imag == 0;
    }

    public boolean isImaginary() {
        return (real == 0);
    }

    public boolean equals(double real, double imag) {
        return (this.real == real && this.imag == imag);
    }

    public boolean equals(MyComplex another) {
        return (this.real == another.real && this.imag == another.imag);
    }

    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    public double argument() {
        return Math.atan2(imag, real);
    }

    public MyComplex add(MyComplex right) {
        this.real = real + right.real;
        this.imag = imag + right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex((real + right.real), (imag + right.imag));
    }

    public MyComplex subtract(MyComplex right) {
        this.real = real - right.real;
        this.imag = imag - right.imag;
        return this;
    }

    public MyComplex multiply(MyComplex right) {
        double a = real;
        double b = imag;
        double c = right.real;
        double d = right.imag;

        this.real = a * c - b * d;
        this.imag = a * d + b * c;
        return this;
    }

    public MyComplex divide(MyComplex right) {
        double a = real;
        double b = imag;
        double c = right.real;
        double d = right.imag;

        this.real = (a * c + b * d) / (c * c + d * d);
        this.imag = (b * c - a * d) / (c * c + d * d);

        return this;
    }
}
