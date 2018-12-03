/**
 * 
 */
package prj5;



/**
 * @author khang
 *
 */
public class DisplayWindowTest extends student.TestCase {
    DisplayWindow window;
    
    /**
     * Sets up constructor
     */
    public void setUp() {
        window = new DisplayWindow("MusicSurveyData", "SongList");
        
        
    }
    
    /**
     * Test update
     */
    public void testUpdate() {
        window.update();
        assertNotNull(window.getGlyph());
    }
    
    /**
     * Test legend
     */
    public void testLegend() {
        window.legend();
        assertNotNull(window.getGlyph());
    }
    
    /**
     * Test populate Glyph
     */
    public void testPopulateGlyph() {
        window.populateGlyphs();
        assertNotNull(window.getGlyph());
    }
    
    /**
     * Test displayGlyph
     */
    public void testDisplayGlyphs() {
        window.displayGlyphs();
        assertNotNull(window.getGlyph());
    }
    
    /**
     * Test getGlyph
     */
    public void testGetGlyph() {
        assertNotNull(window.getGlyph());
        
    }
}
