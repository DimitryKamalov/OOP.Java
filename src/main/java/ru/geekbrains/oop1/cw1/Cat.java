/*
package ru.geekbrains.oop1.cw1;

import org.jetbrains.annotations.Contract;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cat extends Animal {
    private String name;
     private String color;
     private Integer age;
     public Cat (String name, String color, Integer age) {
         this.name = name;
          this.color = color;
          this.age = age;
     }

    public Cat() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        this.color = color;
        return null;
    }

    public Integer getAge() {
        return age;
    }

   */
/*//*
/ @Contract(pure = true)
    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    // Работа с полями напрямую (direct field access)
    public void setName(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {

        return color;
    }

    public void setAge(int age) {
        if (age < 0 || age > 20) {
            throw new InputMismatchException("Invalid age");
        } else {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }

    *//*
*/
/*public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter name, color and age of the cat, separated by space:");
                String input = scanner.nextLine();
                String[] tokens = input.split(" ");
                if (tokens.length == 3) {
                    String name = tokens[0];
                    String color = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    Cat cat = new Cat(name, color, age);
                    System.out.println(cat);
                } else {
                    System.out.println("Invalid input, try again.");
                }
            }
        *//*
*/
/*   *//*
*/
/* try {
        catch(Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }*//*
*/
/*
*//*
        }



*/
