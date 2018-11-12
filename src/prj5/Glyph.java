/**
 * 
 */
package prj5;

/**
 * @author khang
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
     * @param x x value of glyph
     * @param y y value of glyph
     */
    public void addToWindow(int x, int y) {
        
    }
}
