import java.awt.*;

public class Void  implements Figure {
    public double perimeter() {
        return 0.0;
    }
    public double area() {
        return 0.0;
    }
    public Figure add(R2Point p) {
        return new Point(p);
    }
    public double perimeterRect() {
        return 0.0;
    }
    public double areaRect() {
        return 0.0;
    }

    @Override
    public void draw(Graphics g) {

    }
}
