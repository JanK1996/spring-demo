package com.example.demo.complex;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Complex {

    private final double real;
    private final double imaginary;

    @JsonCreator
    public Complex(@JsonProperty("real") double real,@JsonProperty("imaginary") double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public Complex add(Complex other) {
        return new Complex(real + other.real, imaginary + other.imaginary);


    }

    public Complex substract(Complex other) {
        return new Complex(real - other.real, imaginary - other.imaginary);
    }

    public Complex multiply(Complex other) {
        return new Complex(
                real * other.real - (imaginary * other.imaginary),
                (imaginary * other.real) + (real * other.imaginary));
    }

    public Complex divide(Complex other) {
        double x = other.real * other.real + other.imaginary * other.imaginary;
        return new Complex(
                ((real * other.real) + (imaginary * other.imaginary))/x,
                ((imaginary * other.real) - (real * other.imaginary))/x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Complex complex = (Complex) o;

        if (Double.compare(complex.real, real) != 0) return false;
        return Double.compare(complex.imaginary, imaginary) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(real);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(imaginary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "real=" + real +
                ", imaginary=" + imaginary +
                '}';
    }
}