package cz.czechitas.turtle;

import dev.czechitas.java1.turtle.engine.Turtle;

import java.awt.*;

public class HlavniProgram {
    private Turtle zofka = new Turtle();

    public static void main(String[] args) {
        new HlavniProgram().start();
    }

    public void start() {
        zofka.setPenColor(Color.black);
        zofka.setPenWidth(4);

        //TODO Tady bude kód pro kreslení želví grafiky.
        drawIceCream(70.0);
    }

    // Part 2
    // Ice cream
    public void drawIceCream(double iceCreamDiameter) {
        drawIsocelesTriangle(iceCreamDiameter);

        int steps = 36;
        double circleCircumference = Math.PI * iceCreamDiameter;
        double stepLength = circleCircumference / steps;
        double circleAngle = 360.0 / steps;

        drawPolygon(steps, stepLength, circleAngle);
    }

    // Part 1 - basic parametric shapes
    private void drawEquilateralTriangle(double size) {
        for (int i = 0; i < 3; i++) {
            zofka.turnLeft(120.0);
            zofka.move(size);
        }
    }

    private void drawIsocelesTriangle(double base) {
        zofka.turnLeft(90.0);
        zofka.move(base);

        zofka.turnLeft(105);
        zofka.move(base * 2);

        zofka.turnLeft(150);
        zofka.move(base * 2);
    }

    private void drawRightIsocelesTriangle(double size) {
        zofka.move(size);
        zofka.turnLeft(90.0);

        zofka.move(size);
        zofka.turnLeft(135.0);

        zofka.move(Math.sqrt(2 * Math.pow(size, 2)));
        zofka.turnLeft(135.0);
    }

    private void drawSquare(double a) {
        for (int i = 0; i < 3; i++) {
            zofka.move(a);
            zofka.turnLeft(90.0);
        }
        zofka.move(a);
    }

    private void drawRectangle(double a, double b) {
        zofka.move(a);
        zofka.turnLeft(90.0);
        zofka.move(b);
        zofka.turnLeft(90.0);
        zofka.move(a);
        zofka.turnLeft(90.0);
        zofka.move(b);
    }

    private void drawPolygon(int steps, double stepLength, double circleAngle) {
        for (int i = 0; i < steps; i++) {
            zofka.turnLeft(circleAngle);
            zofka.move(stepLength);
        }
    }
}
