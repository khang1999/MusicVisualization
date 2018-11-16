/**
 * 
 */
package prj5;

/**
 * @author khang
 *
 */
public class GlyphTest {
    private Glyph glyph;
    private Song song;
    
    public void setUp() {
        song = new Song("Love Story", "Taylor Swift", "love", 2002);
        
        glyph = new Glyph();
    }
}
