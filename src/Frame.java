import javax.swing.JFrame;
import java.awt.*; //оператор import обеспечивает подключение необходимых классов библиотеки awt для компиляции

public class Frame extends JFrame {

    protected static int width = 1000; // параметры окна: высота, длина и цвет
    protected static int height = 800;
    protected static Color backgroundColor = Color.WHITE;
    private Convex convex;

    public Frame(Convex convex) // Отображение окна
    {
        super("CONVEX"); // название
        this.setSize(width, height); // размеры окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // операция закрытия программы вместе с окном
        this.setVisible(true); // задает видимость
        this.convex=convex; // инициализация конвекс
    }

    public void paint(Graphics g)
    {
        Rectangle s = this.getBounds(); // использование размеров окна динамически //getBounds возвращает ограничивающий сложную фигуру четырехугольник
        g.setColor(backgroundColor);
        g.translate(s.width/2, s.height/2); // Начало координат в центр
        g.fillRect(-s.width/2, -s.height/2, s.width, s.height);// фон
        g.setColor(Color.BLACK);
        g.drawLine(-s.width /2, 0, s.width/2, 0);// оси
        g.drawLine(0, -s.height/2, 0, s.height/2);
        g.setColor(Color.BLACK); // смена цвета

        convex.draw(g);// прорисовка точек всех (использование Дро)
    }
}
