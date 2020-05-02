import java.awt.*;

public class Polygon extends Deq implements Figure {
    private double s, p;
    private double sRect, pRect;
    public int minX=10000, minY=10000, maxX=-10000, maxY=-10000;
    public double minXR=10000, minYR=10000, maxXR=-10000, maxYR=-10000;
    public R2Point cord1 = new R2Point(minXR, minYR);
    public R2Point cord2 = new R2Point(maxXR, maxYR);;

    private void grow(R2Point a, R2Point b, R2Point t) {
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
    }

    public Polygon(R2Point a, R2Point b, R2Point c) {

        pushFront(b);
        if (b.light(a, c)) {
            pushFront(a); pushBack(c);
        } else {
            pushFront(c); pushBack(a);
        }

        p = R2Point.dist(a, b) + R2Point.dist(b, c) + R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));

        cord1.x = Math.min(a.x, Math.min(b.x, c.x));
        cord1.y = Math.min(a.y, Math.min(b.y, c.y));
        cord2.x = Math.max(a.x, Math.max(b.x, c.x));
        cord2.y = Math.max(a.y, Math.max(b.y, c.y));

        pRect = R2Point.perimeterRect(cord1, cord2);
        sRect = R2Point.areaRect(cord1, cord2);
    }
    public double perimeter() {
        return p;
    }
    public double area() {
        return s;
    }

    public double perimeterRect() {
        return pRect;
    }

    public double areaRect() {
        return sRect;
    }


    public Figure add(R2Point t) {
        int i;
    // Ищем освещенные ребра, просматривая их одно за другим.
        for (i=length(); i>0 && !t.light(back(),front()); i--) //если ребра не освещены, просто просматриваем
            pushBack(popFront());
    // УТВЕРЖДЕНИЕ: либо ребро [back(),front()] освещено из t,
    // либо освещенных ребер нет совсем.
        if (i>0)
        {
            R2Point x;
            grow(back(), front(), t); //если есть освещенное, уменьшаем периметр, увеличиваем площадь
    // Удаляем все освещенные ребра из начала дека.
            for (x = popFront(); t.light(x, front()); x = popFront())
                grow(x, front(), t );
            pushFront(x);
    // Удаляем все освещенные ребра из конца дека.
            for (x = popBack(); t.light(back(), x); x = popBack())
                grow(back(), x, t);
            pushBack(x);
    // Завершаем обработку добавляемой точки.
            p += R2Point.dist(back(), t) + R2Point.dist(t, front()); //добавляем к оболочке сумму длин ребер
            pushFront(t);
        }

        cord1.x = Math.min(cord1.x, t.x);
        cord1.y = Math.min(cord1.y, t.y);
        cord2.x = Math.max(cord2.x, t.x);
        cord2.y = Math.max(cord2.y, t.y);

        pRect = R2Point.perimeterRect(cord1, cord2);
        sRect = R2Point.areaRect(cord1, cord2);

        return this;
    }

    @Override
    public void draw(Graphics g) {
        for (int i=length(); i>0; i--) // прорисовывает все точки
        {

            g.fillOval((int)(front().x - 3), ((int)(front().y - 3)),6,6);
            g.drawLine((int)front().x, ((int)front().y), (int)back().x, ((int)back().y));
            pushFront(popBack());

            if (front().x < minX) {
                minX = (int)front().x - 4 ;
            }
            if (front().y < minY) {
                minY = (int)front().y - 4;
            }
            if (front().x > maxX) {
                maxX = (int)front().x + 4;
            }
            if (front().y > maxY) {
                maxY = (int)front().y + 4;
            }
        }

        g.setColor(Color.red);
        g.drawRect(minX , minY , maxX-minX, maxY-minY);


    }
}
