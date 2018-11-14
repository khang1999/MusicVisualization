// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- Khang Nguyen (khang) Nathan Kim (nathank) Jason Hassold ()
/**
 * 
 */
package prj5;

import student.TestCase;
import java.util.Arrays;

/**
 * @author khang, jasonh44
 * @version 2018.11.12
 */
public class SongTest extends TestCase {
    private Song song;
    
    /**
     * Sets up
     */
    public void setUp() {
        song = new Song("Hello", "Khang", "Sad", 1980);
    }
    
    /**
     * Test title
     */
    public void testGetTitle() {
        assertEquals(song.getTitle(), "Hello");
    }
    
    /**
     * Test artist
     */
    public void testGetArtist() {
        assertEquals(song.getArtist(), "Khang");
    }
    
    /**
     * Test Genre
     */
    public void testGetGenre() {
        assertEquals(song.getGenre(), "Sad");
    }
    
    /**
     * Test Year
     */
    public void testGetYear() {
        assertEquals(song.getYear(), 1980);
    }
    
    /**
     * Test hobbyData
     */
    public void testGetHobbyData() {
        song.setHobbyData(new double[] {0.1, 0.2, 0.3});
        assertTrue(Arrays.equals(new double[] {0.1, 0.2, 0.3}, song.getHobbyData()));
    }
    
    /**
     * Test majorData
     */
    public void testGetMajorData() {
        song.setMajorData(new double[] {0.4, 0.5, 0.6});
        assertTrue(Arrays.equals(new double[] {0.4, 0.5, 0.6}, song.getMajorData()));
    }
    
    /**
     * Test regionData
     */
    public void testGetRegionData() {
        song.setRegionData(new double[] {0.7, 0.8, 0.9});
        assertTrue(Arrays.equals(new double[] {0.7, 0.8, 0.9}, song.getRegionData()));
    }
}
