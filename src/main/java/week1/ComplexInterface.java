package week1;

public interface ComplexInterface {
    // a static version of plus

    // return abs/modulus/magnitude
    double abs();

    // return angle/phase/argument, normalized to be between -pi and pi
    double phase();

    // return a new Complex object whose value is (this + b)
    Complex plus(ComplexInterface b);

    // return a new Complex object whose value is (this - b)
    Complex minus(ComplexInterface b);

    // return a new Complex object whose value is (this * b)
    Complex times(ComplexInterface b);

    // return a new object whose value is (this * alpha)
    Complex scale(double alpha);

    // return a new Complex object whose value is the conjugate of this
    Complex conjugate();

    // return a new Complex object whose value is the reciprocal of this
    Complex reciprocal();

    // return the real or imaginary part
    double re();

    double im();

    // return a / b
    Complex divides(ComplexInterface b);

    // return a new Complex object whose value is the complex exponential of this
    Complex exp();

    // return a new Complex object whose value is the complex sine of this
    Complex sin();

    // return a new Complex object whose value is the complex cosine of this
    Complex cos();

    // return a new Complex object whose value is the complex tangent of this
    Complex tan();
}
