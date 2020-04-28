import java.awt.*;

// Тест для выпуклой оболочки.
class ConvexTest {
    public static void main(String[] args) throws Exception {
        Convex convex = new Convex();
        Frame frame = new Frame(convex);
        while (true) {
            convex.add(new R2Point());
            System.out.println("S = " + convex.area() + " , P = "  + convex.perimeter()); //
            frame.repaint();  //  обновление экрана после ввода точки

        }

    }
}