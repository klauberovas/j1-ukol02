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
//        drawSnowman();
        drawTrain();
    }

    // Part 2
    // Ice cream
    public void drawIceCream(double iceCreamDiameter) {
        moveToDefaultPosition();

        drawIsocelesTriangle(iceCreamDiameter);

        int steps = 36;
        double circleCircumference = Math.PI * iceCreamDiameter;
        double stepLength = circleCircumference / steps;
        double circleAngle = 360.0 / steps;

        drawPolygon(steps, stepLength, circleAngle);
    }

    // Snowman
    public void drawSnowman() {
        moveToDefaultPosition();

        int headSteps = 36;
        int middleSteps = 60;
        int bottomSteps = 90;
        int handSteps = 16;

        double stepLength = 6;

        // Head
        double headRadius = (headSteps * stepLength) / (2 * Math.PI);
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

    public void drawTrain() {
        int backWheelSteps = 60;
        double stepLength = 6;
        double backWheelDiameter = (backWheelSteps * stepLength) / Math.PI;
        double cabinHeight = backWheelDiameter * 1.3;
        double cabinWidth = backWheelDiameter;
        double engineHeight = cabinHeight / 2;
        double engineWidth = cabinHeight;
        int frontWheelSteps = backWheelSteps / 2;
        double frontWheelDiameter = backWheelDiameter / 2;
        double frontWheelOffset = engineWidth * 0.1;

        drawBackWheel(backWheelSteps, stepLength);
        drawCabine(cabinHeight, cabinWidth);

        zofka.setLocation(zofka.getX() - backWheelDiameter, zofka.getY());
        zofka.turnLeft(90);
        drawEngine(engineHeight, engineWidth);

        // X-axis for plow
        double frontTrainX = zofka.getX() - engineWidth;

        // Front wheels
        zofka.turnLeft(90);
        drawFrontWheels(frontWheelSteps, stepLength, frontWheelDiameter, frontWheelOffset);

        // Plow
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

    private void drawFrontWheels(int steps, double stepLength, double diameter, double offset) {
        zofka.setLocation(zofka.getX() - offset, zofka.getY() + diameter / 2);
        drawPolygon(steps, stepLength, 360.0 / steps);

        zofka.setLocation(zofka.getX() - diameter - 10, zofka.getY());
        drawPolygon(steps, stepLength, 360.0 / steps);
    }

    private void drawPlow(double size) {
        drawRightIsocelesTriangle(size);
    }

    public void moveToDefaultPosition() {
        zofka.setLocation(zofka.getX(), 150);
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
