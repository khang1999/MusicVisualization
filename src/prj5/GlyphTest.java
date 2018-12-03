/**
 * 
 */
package prj5;

import java.util.Arrays;

/**
 * Test class for Glyph
 * 
 * @author Khang Nguyen, Nathan Kim, Jason Hassold
 * @version 11.12.2018
 *
 */
public class GlyphTest extends student.TestCase {
    private Glyph glyph;
    private Song song;


    /**
     * Sets up tester
     */
    public void setUp() {
        song = new Song("Love Story", "Taylor Swift", "love", 2002);
        int[][] hobbyData = new int[][] { { 2, 2, 2 }, { 2, 2, 2 }, { 2, 2, 2 },
            { 2, 2, 2 } };
        int[][] majorData = new int[][] { { 2, 2, 2 }, { 2, 2, 2 }, { 2, 2, 2 },
            { 2, 2, 2 } };
        int[][] regionData = new int[][] {{ 2, 2, 2 }, { 2, 2, 2 }, { 2, 2, 2 },
            { 2, 2, 2 } };
        song.setHobbyData(hobbyData);
        song.setMajorData(majorData);
        song.setRegionData(regionData);
        glyph = new Glyph(song);
    }


    /**
     * Test getAuthor()
     */
    public void testGetTitle() {
        song.getGenre();
        assertEquals(glyph.getTitle(), "Love Story");
    }


    /**
     * Test getAuthor()
     */
    public void testGetAuthor() {
        assertEquals(glyph.getAuthor(), "by Taylor Swift");
    }


    /**
     * Test getHobby()
     */
    public void testGetHobby() {
        double[] hobby = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
            1.0 };

        assertTrue(Arrays.equals(hobby, glyph.getHobby()));
    }


    /**
     * Test getMajor()
     */
    public void testGetMajor() {
        double[] major = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
            1.0 };

        assertTrue(Arrays.equals(major, glyph.getMajor()));
    }


    /**
     * Test getRegion()
     */
    public void testGetRegion() {
        double[] region = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
            1.0 };

        assertTrue(Arrays.equals(region, glyph.getRegion()));
    }
}
