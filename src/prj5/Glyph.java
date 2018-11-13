// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Khang Nguyen (khang) Nathan Kim (nathank) Jason Hassold (jasonh44)
package prj5;

/**
 * The visual representation of a piece of data where the attributes of a
 * graphical entity are dictated by one or more attributes of a data record
 * 
 * @author Khang Nguyen, Nathan Kim, Jason Hassold
 * @version 11.12.2018
 *
 */
public class Glyph {
    private Window window;
    private Song song;
    private double[] majors;
    private double[] regions;
    private double[] hobbies;


    public Glyph(Window w, Song s, double[] m, double[] r, double[] h) {
        window = w;
        song = s;
        majors = m;
        regions = r;
        hobbies = h;
    }


    /**
     * Adds a glyph to window
     * 
     * @param x
     *            x value of glyph
     * @param y
     *            y value of glyph
     */
    public void addToWindow(int x, int y) {

    }
}
