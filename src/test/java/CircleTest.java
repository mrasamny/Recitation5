import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

class CircleTest {
    private static Random rand = new Random();

    @Test
    void constructor() {
        double x = rand.nextInt(100);
        double y = rand.nextInt(100);
        double radius = rand.nextInt(100);
        Point p = new Point(x,y);
        Circle c = new Circle(p,radius);
        String expected = "Circle/loc=("+x+","+y+"),radius="+radius;
        String actual = c.toString();
        assertEquals(expected,actual,"Expected:\n"+expected+"\nActual:\n"+actual);
    }

    @Test
    void getRadius() {
        double x = rand.nextInt(100);
        double y = rand.nextInt(100);
        double radius = rand.nextInt(100);
        Point p = new Point(x,y);
        Circle c = new Circle(p,radius);
        double expected = radius;
        double actual = c.getRadius();
        assertEquals(expected, actual,"Expected:\n"+expected+"\nActual:\n"+actual);
    }

    @Test
    void getLocation() {
        double x = rand.nextInt(100);
        double y = rand.nextInt(100);
        Point p = new Point(x,y);
        Circle c = new Circle(p,20);
        Point expected = p;
        Point actual = c.getLocation();
        assertEquals(expected,actual,"Expected:\n"+expected+"\nActual:\n"+actual);
    }

    @Test
    void setRadius() {
    }

    @Test
    void setLocation() {
        double x = rand.nextInt(100);
        double y = rand.nextInt(100);
        Point p = new Point(x,y);
        Circle c = new Circle(13);
        c.setLocation(p);
        Point expected = p;
        Point actual = c.getLocation();
        assertEquals(expected,actual,"Expected:\n"+expected+"\nActual:\n"+actual);
    }

    @Test
    void contains() {

        Point center = new Point(9,21);
        double x = rand.nextInt(50);
        double y = rand.nextInt(50);
        Point p_in = new Point(x,y);
        x += rand.nextInt(50)+55;
        y += rand.nextInt(50)+55;
        Point p_out = new Point(x,y);
        Circle c = new Circle(center,p_in.distanceTo(center)+1);
        boolean expected = true;
        boolean actual = c.contains(p_in);
        assertTrue(actual,"Expected:\n"+expected+"\nActual:\n"+actual);
        expected = false;
        actual = c.contains(p_out);
        assertFalse(actual,"Expected:\n"+expected+"\nActual:\n"+actual);
    }

    @Test
    void intersects() {
        double x = rand.nextInt(50);
        double y = rand.nextInt(50);
        double radius = rand.nextInt(50);
        Point center = new Point(x,y);
        Circle c = new Circle(center,radius);
        Point p_in = new Point(x+5,y+5);
        Circle c_in = new Circle(p_in,center.distanceTo(p_in));
        x = center.distanceTo()+radius+rand.nextInt(100)+20;
        y = center.distanceTo()+radius+rand.nextInt(100)+20;
        Point p_out = new Point(x,y);
        Circle c_out = new Circle(p_out, (p_out.distanceTo(center)-c.getRadius())/2);
        boolean expected = true;
        boolean actual = c.intersects(c_in);
        assertTrue(actual,"Expected:\n"+expected+"\nActual:\n"+actual);
        expected = false;
        actual = c.intersects(c_out);
        assertFalse(actual,"Expected:\n"+expected+"\nActual:\n"+actual);
    }
}