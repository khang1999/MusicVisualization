// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Khang Nguyen (khang) Nathan Kim (nathank) Jason Hassold (jasonh44)
package prj5;

import CS2114.Button;

/**
 * DisplayWindow Tester Class
 * 
 * @author khang
 * @version 2.12.2018
 */
public class DisplayWindowTest extends student.TestCase {
    private DisplayWindow window;
    
    /**
     * Sets up constructor
     */
    public void setUp() {
        window = new DisplayWindow("MusicSurveyData.csv", 
                                   "SongList.csv");
    }
    
    /**
     * Test update
     */
    public void testUpdate() {
        window.clickedHobbyButton(new Button());
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
    
    /**
     * Test set
     */
    public void testGetSet() {
        assertEquals(0, window.getSet());
    }
    
    /**
     * Test Previous
     */
    public void testClickedPrevButton() {
        window.clickedPrevButton(new Button());
        assertEquals(0, window.getSet());
    }
    
    /**
     * test clickedSortArtist
     */
    public void testClickedSortArtist() {
        window.clickedSortArtist(new Button());
        assertEquals(0, window.getSet());
    }
    
    /**
     * test clickedSortTitle
     */
    public void testSortTitle() {
        window.clickedSortTitle(new Button());
        assertEquals(0, window.getSet());
    }
    
    /**
     * test clickedSortTitle
     */
    public void testSortYear() {
        window.clickedSortYear(new Button());
        assertEquals(0, window.getSet());
    }
    
    /**
     * test clickedSortTitle
     */
    public void testSortGenre() {
        window.clickedSortGenre(new Button());
        assertEquals(0, window.getSet());
    }
    
    /**
     * test next
     */
    public void testNext() {
        window.clickedNextButton(new Button());
        assertEquals(9, window.getSet());
    }
    
    /**
     * test getRepresent
     */
    public void testGetRepresent() {
        assertEquals("", window.getRepresent());
    }
    
    /**
     * test major
     */
    public void testMajorButton() {
        window.clickedMajorButton(new Button());
        assertEquals("major", window.getRepresent());
    }
    
    /**
     * Test Region
     */
    public void testRegionButton() {
        window.clickedRegionButton(new Button());
        assertEquals("region", window.getRepresent());
    }
    
    /**
     * Test hobby
     */
    public void testHobbyButton() {
        window.clickedHobbyButton(new Button());
        assertEquals("hobby", window.getRepresent());
    }
    
}
