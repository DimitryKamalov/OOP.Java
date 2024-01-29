package com.complex.calculator;
import java.util.logging.Logger;


    // ���������, �������������� ����������� �����
    interface ComplexNumber {
        double getRealPart();
        double getImaginaryPart();
        ComplexNumber add(ComplexNumber number);
        ComplexNumber multiply(ComplexNumber number);
        ComplexNumber divide(ComplexNumber number);
    }

    // ���������� ���������� ������������ �����
    class ConcreteComplexNumber implements ComplexNumber {
        private final double realPart;
        private final double imaginaryPart;

        public ConcreteComplexNumber(double realPart, double imaginaryPart) {
            this.realPart = realPart;
            this.imaginaryPart = imaginaryPart;
        }

        public double getRealPart() {
            return realPart;
        }

        public double getImaginaryPart() {
            return imaginaryPart;
        }

        public ComplexNumber add(ComplexNumber number) {
            double real = this.realPart + number.getRealPart();
            double imaginary = this.imaginaryPart + number.getImaginaryPart();
            return new ConcreteComplexNumber(real, imaginary);
        }

        public ComplexNumber multiply(ComplexNumber number) {
            double real = this.realPart * number.getRealPart() - this.imaginaryPart * number.getImaginaryPart();
            double imaginary = this.realPart * number.getImaginaryPart() + this.imaginaryPart * number.getRealPart();
            return new ConcreteComplexNumber(real, imaginary);
        }

        public ComplexNumber divide(ComplexNumber number) {
            double denominator = number.getRealPart() * number.getRealPart() + number.getImaginaryPart() * number.getImaginaryPart();
            double real = (this.realPart * number.getRealPart() + this.imaginaryPart * number.getImaginaryPart()) / denominator;
            double imaginary = (this.imaginaryPart * number.getRealPart() - this.realPart * number.getImaginaryPart()) / denominator;
            return new ConcreteComplexNumber(real, imaginary);
        }
    }

    // ��������� �������
    interface LoggerInterface {
        void log(String message);
    }

    // ���������� ������� � �������������� java.util.logging
    class JavaUtilLoggingLogger implements LoggerInterface {
        private final Logger logger;

        public JavaUtilLoggingLogger(String className) {
            logger = Logger.getLogger(className);
        }

        public void log(String message) {
            logger.info(message);
        }
    }

    // ����� ������������ ����������� �����
    class ComplexNumberCalculator {
        private final LoggerInterface logger;

        public ComplexNumberCalculator(LoggerInterface logger) {
            this.logger = logger;
        }

        public ComplexNumber add(ComplexNumber a, ComplexNumber b) {
            ComplexNumber result = a.add(b);
            String logMessage = String.format("Addition: %f + %fi + %f + %fi = %f + %fi", a.getRealPart(), a.getImaginaryPart(), b.getRealPart(), b.getImaginaryPart(), result.getRealPart(), result.getImaginaryPart());
            logger.log(logMessage);
            return result;
        }

        public ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
            ComplexNumber result = a.multiply(b);
            String logMessage = String.format("Multiplication: %f + %fi * %f + %fi = %f + %fi", a.getRealPart(), a.getImaginaryPart(), b.getRealPart(), b.getImaginaryPart(), result.getRealPart(), result.getImaginaryPart());
            logger.log(logMessage);
            return result;
        }

        public ComplexNumber divide(ComplexNumber a, ComplexNumber b) {
            ComplexNumber result = a.divide(b);
            String logMessage = String.format("Division: %f + %fi / %f + %fi = %f + %fi", a.getRealPart(), a.getImaginaryPart(), b.getRealPart(), b.getImaginaryPart(), result.getRealPart(), result.getImaginaryPart());
            logger.log(logMessage);
            return result;
        }
    }
    // ����� ��� ������������ ������ ������������ ����������� �����
    public class Main {
        public static void main(String[] args) {
            // ������� ������ �������
            LoggerInterface logger = new JavaUtilLoggingLogger(Main.class.getName());

            // ������� ������ ������������ ����������� �����
            ComplexNumberCalculator calculator = new ComplexNumberCalculator(logger);

            // ������� ����������� �����
            ComplexNumber a = new ConcreteComplexNumber(2.0, 3.0);
            ComplexNumber b = new ConcreteComplexNumber(1.0, 2.0);

            // ��������� �������� � ������������ �������
            ComplexNumber additionResult = calculator.add(a, b);
            ComplexNumber multiplicationResult = calculator.multiply(a, b);
            ComplexNumber divisionResult = calculator.divide(a, b);

            // ������� ����������
            System.out.println("Addition: " + additionResult.getRealPart() + " + " + additionResult.getImaginaryPart() + "i");
            System.out.println("Multiplication: " + multiplicationResult.getRealPart() + " + " + multiplicationResult.getImaginaryPart() + "i");
            System.out.println("Division: " + divisionResult.getRealPart() + " + " + divisionResult.getImaginaryPart() + "i");
        }
    }

/*
* � ������ ������� ��� ������ ����� ComplexNumber, �������������� ����������� �����, � ��� ���������� ���������� ConcreteComplexNumber.
* ����� ComplexNumberCalculator ��������� �������� ��������, ��������� � ������� ����������� �����.
* �������� ����� ��������� LoggerInterface � ��� ���������� ���������� JavaUtilLoggingLogger ��� ����������� �������� ������������.
* ����� Main �������� ������ ������������� ������������ ����������� ����� � ������������.
* ��������� ������ �������, ��������� �����������, ����������� �������� ��������, ��������� � �������, � ���������� ��������� �� �����.
* ��� ������ ���������� ��������� SOLID (��������, �������� ������������ ��������������� � �������� ����������/����������),
* � ��� �� ������������� ��������� ��������������, ������� �������� Factory Method � Dependency Injection.
*/