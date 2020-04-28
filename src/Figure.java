import java.awt.Graphics;

public interface Figure {
    public double perimeter();
    public double area();
    public Figure add(R2Point p);
    public void draw(Graphics g);  // методд draw
}
