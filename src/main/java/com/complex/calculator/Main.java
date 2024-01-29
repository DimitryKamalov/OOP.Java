package com.complex.calculator;
import java.util.logging.Logger;


    // Интерфейс, представляющий комплексное число
    interface ComplexNumber {
        double getRealPart();
        double getImaginaryPart();
        ComplexNumber add(ComplexNumber number);
        ComplexNumber multiply(ComplexNumber number);
        ComplexNumber divide(ComplexNumber number);
    }

    // Конкретная реализация комплексного числа
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

    // Интерфейс логгера
    interface LoggerInterface {
        void log(String message);
    }

    // Реализация логгера с использованием java.util.logging
    class JavaUtilLoggingLogger implements LoggerInterface {
        private final Logger logger;

        public JavaUtilLoggingLogger(String className) {
            logger = Logger.getLogger(className);
        }

        public void log(String message) {
            logger.info(message);
        }
    }

    // Класс калькулятора комплексных чисел
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
    // Класс для демонстрации работы калькулятора комплексных чисел
    public class Main {
        public static void main(String[] args) {
            // Создаем объект логгера
            LoggerInterface logger = new JavaUtilLoggingLogger(Main.class.getName());

            // Создаем объект калькулятора комплексных чисел
            ComplexNumberCalculator calculator = new ComplexNumberCalculator(logger);

            // Создаем комплексные числа
            ComplexNumber a = new ConcreteComplexNumber(2.0, 3.0);
            ComplexNumber b = new ConcreteComplexNumber(1.0, 2.0);

            // Выполняем операции с комплексными числами
            ComplexNumber additionResult = calculator.add(a, b);
            ComplexNumber multiplicationResult = calculator.multiply(a, b);
            ComplexNumber divisionResult = calculator.divide(a, b);

            // Выводим результаты
            System.out.println("Addition: " + additionResult.getRealPart() + " + " + additionResult.getImaginaryPart() + "i");
            System.out.println("Multiplication: " + multiplicationResult.getRealPart() + " + " + multiplicationResult.getImaginaryPart() + "i");
            System.out.println("Division: " + divisionResult.getRealPart() + " + " + divisionResult.getImaginaryPart() + "i");
        }
    }

/*
* В данном примере был создан класс ComplexNumber, представляющий комплексное число, и его конкретная реализация ConcreteComplexNumber.
* Класс ComplexNumberCalculator реализует операции сложения, умножения и деления комплексных чисел.
* Добавлен также интерфейс LoggerInterface и его конкретная реализация JavaUtilLoggingLogger для логирования действий калькулятора.
* Класс Main содержит пример использования калькулятора комплексных чисел с логированием.
* Создается объект логгера, создается калькулятор, выполняются операции сложения, умножения и деления, и результаты выводятся на экран.
* Это пример применения принципов SOLID (например, принципа единственной ответственности и принципа открытости/закрытости),
* а так же архитектурных паттернов проектирования, включая паттерны Factory Method и Dependency Injection.
*/