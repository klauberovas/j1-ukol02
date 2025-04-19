package cz.czechitas.turtle;

import dev.czechitas.java1.turtle.engine.Turtle;

import java.awt.*;

public class HlavniProgram {
    private Turtle zofka = new Turtle();

    public static void main(String[] args) {
        new HlavniProgram().start();
    }

    double STEP_LENGTH = 6;

    public void start() {
        zofka.setPenColor(Color.black);
        zofka.setPenWidth(4);


        //TODO Tady bude kód pro kreslení želví grafiky.
//        drawIceCream();
//        drawSnowman();
        drawTrain();
    }

    // Part 2
    // Ice cream
    public void drawIceCream() {
        moveToDefaultPosition();
        drawIsocelesTriangle(70.0);
        drawPolygon(36, STEP_LENGTH, 360.0 / 36);
    }

    // Snowman
    public void drawSnowman() {
        int headSteps = 36;
        int middleSteps = 60;
        int bottomSteps = 90;
        int handSteps = 16;

        // Calculation of radii and hand diameter
        double headRadius = calculateRadius(headSteps, STEP_LENGTH);
        double middleRadius = calculateRadius(middleSteps, STEP_LENGTH);
        double bottomRadius = calculateRadius(bottomSteps, STEP_LENGTH);
        double handDiameter = calculateDiameter(handSteps, STEP_LENGTH);

        // Head
        moveToDefaultPosition();
        drawSnowBall(headSteps, STEP_LENGTH);

        // Middle circle
        zofka.setLocation(zofka.getX() + middleRadius / 3, zofka.getY() + headRadius + middleRadius);
        drawSnowBall(middleSteps, STEP_LENGTH);

        // Lower circle
        zofka.setLocation(zofka.getX() + bottomRadius / 3, zofka.getY() + middleRadius + bottomRadius);
        drawSnowBall(bottomSteps, STEP_LENGTH);

        // Right hand
        zofka.setLocation(zofka.getX(), zofka.getY() - middleRadius - bottomRadius);
        drawSnowBall(handSteps, STEP_LENGTH);

        // Left hand
        zofka.setLocation(zofka.getX() - handDiameter - (middleRadius * 2), zofka.getY());
        drawSnowBall(handSteps, STEP_LENGTH);
    }

    private void drawSnowBall(int steps, double stepLength) {
        drawPolygon(steps, stepLength, 360.0 / steps);
    }

    public void drawTrain() {
        int backWheelSteps = 60;
        double backWheelDiameter = calculateDiameter(backWheelSteps, STEP_LENGTH);
        double cabinHeight = backWheelDiameter * 1.3;
        double cabinWidth = backWheelDiameter;
        double engineHeight = cabinHeight / 2;
        double engineWidth = cabinHeight;
        int frontWheelSteps = backWheelSteps / 2;
        double frontWheelDiameter = backWheelDiameter / 2;
        double frontWheelOffset = engineWidth * 0.1;

        drawBackWheel(backWheelSteps, STEP_LENGTH);
        drawCabine(cabinHeight, cabinWidth);

        zofka.setLocation(zofka.getX() - backWheelDiameter, zofka.getY());
        zofka.turnLeft(90);
        drawEngine(engineHeight, engineWidth);

        double frontTrainX = zofka.getX() - engineWidth;

        zofka.turnLeft(90);
        drawFrontWheels(frontWheelSteps, STEP_LENGTH, frontWheelDiameter, frontWheelOffset, 10);

        zofka.setLocation(frontTrainX, zofka.getY());
        drawPlow(engineHeight);
    }

    private void drawBackWheel(int segments, double segmentsLength) {
        drawPolygon(segments, segmentsLength, 360.0 / segments);
    }

    private void drawCabine(double height, double width) {
        drawRectangle(height, width);
    }

    private void drawEngine(double height, double width) {
        drawRectangle(height, width);
    }

    private void drawFrontWheels(int steps, double stepLength, double diameter, double offset, double spacing) {
        zofka.setLocation(zofka.getX() - offset, zofka.getY() + diameter / 2);
        drawPolygon(steps, stepLength, 360.0 / steps);

        zofka.setLocation(zofka.getX() - diameter - spacing, zofka.getY());
        drawPolygon(steps, stepLength, 360.0 / steps);
    }

    private void drawPlow(double size) {
        drawRightIsocelesTriangle(size);
    }

    public void moveToDefaultPosition() {
        zofka.setLocation(zofka.getX(), 150);
    }

    private double calculateDiameter(int steps, double stepLength) {
        return (steps * stepLength) / Math.PI;
    }

    private double calculateRadius(int steps, double stepLength) {
        return (steps * stepLength) / (2 * Math.PI);
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
        zofka.turnLeft(135.0);

        zofka.move(Math.sqrt(2 * Math.pow(size, 2)));
        zofka.turnLeft(135.0);

        zofka.move(size);
        zofka.turnLeft(90.0);
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
