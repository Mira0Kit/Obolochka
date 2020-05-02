import java.awt.*;
import javax.swing.*;

//Тест для выпуклой оболочки.
class ConvexTest {
    public static void main(String[] args) throws Exception {
        Convex convex = new Convex();
        Frame frame = new Frame(convex);
        while (true) {
            convex.add(new R2Point());
            System.out.println("S МВО= " + convex.area() + " , P МВО= "  + convex.perimeter());
            System.out.println("S Rect = " + convex.areaRect() + " , P Rect = "  + convex.perimeterRect());
             //  обновление экрана после ввода точки
            frame.repaint();
        }
    }
}