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
//        drawEquilateralTriangle(100.0);
//        drawSquare(100.0);
//        drawRectangle(50.0, 100.0);
        drawPolygon(23, 12, 16);
    }

    public void drawEquilateralTriangle(double size) {
        for (int i = 0; i < 3; i++) {
            zofka.move(size);
            zofka.turnLeft(120.0);
        }
    }

    public void drawSquare(double a) {
        for (int i = 0; i < 3; i++) {
            zofka.move(a);
            zofka.turnLeft(90.0);
        }
        zofka.move(a);
    }

    public void drawRectangle(double a, double b) {
        zofka.move(a);
        zofka.turnLeft(90.0);
        zofka.move(b);
        zofka.turnLeft(90.0);
        zofka.move(a);
        zofka.turnLeft(90.0);
        zofka.move(b);
    }

    public void drawPolygon(int steps, double stepLength, double circleAngle) {
        for (int i = 0; i < steps; i++) {
            zofka.turnLeft(circleAngle);
            zofka.move(stepLength);
        }
    }
}
