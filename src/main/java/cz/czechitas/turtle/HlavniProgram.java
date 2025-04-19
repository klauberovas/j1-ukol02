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
//        drawIceCream(70.0);
        drawSnowman();
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

    public void drawSnowman() {
        int headSteps = 36;
        int middleSteps = 60;
        int bottomSteps = 90;
        int handSteps = 16;

        double stepLength = 6;

        // Head
        double headRadius = (headSteps * stepLength) / (2 * Math.PI);
        zofka.setLocation(400, 150);
        drawPolygon(headSteps, stepLength, 360.0 / headSteps);

        // Middle circle
        double middleRadius = (middleSteps * stepLength) / (2 * Math.PI);
        zofka.setLocation(zofka.getX() + middleRadius / 3, zofka.getY() + headRadius + middleRadius);
        drawPolygon(middleSteps, stepLength, 360.0 / middleSteps);

        // Lower circle
        double bottomRadius = (bottomSteps * stepLength) / (2 * Math.PI);
        zofka.setLocation(zofka.getX() + bottomRadius / 3, zofka.getY() + middleRadius + bottomRadius);
        drawPolygon(bottomSteps, stepLength, 360.0 / bottomSteps);

        // Right hand
        double handDiameter = (handSteps * stepLength) / Math.PI;
        zofka.setLocation(zofka.getX(), zofka.getY() - middleRadius - bottomRadius);
        drawPolygon(handSteps, stepLength, 360.0 / handSteps); // right hand

        // Left hand
        zofka.setLocation(zofka.getX() - handDiameter - (middleRadius * 2), zofka.getY());
        drawPolygon(handSteps, stepLength, 360.0 / handSteps); // left hand
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
