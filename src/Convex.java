import java.awt.*;

public class Convex {
    private Figure fig;

    public Convex() {
        fig = new Void();
    }

    public void add(R2Point p) {
        fig = fig.add(p);
    }

    public double area() {
        return fig.area();
    }

    public double perimeter() {
        return fig.perimeter();
    }

    public double areaRect() {
        return fig.areaRect();
    }

    public double perimeterRect() {
        return fig.perimeterRect();
    }

    public void draw(Graphics g) {
        fig.draw(g);
    }
}
