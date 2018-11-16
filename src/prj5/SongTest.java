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
        song.setHobbyData(new int[][] {{1}, {2}, {3}});
        assertTrue(Arrays.deepEquals(new int[][] {{1}, {2}, {3}}, 
            song.getHobbyData()));
    }
    
    /**
     * Test majorData
     */
    public void testGetMajorData() {
        song.setMajorData(new int[][] {{1}, {2}, {3}});
        assertTrue(Arrays.deepEquals(new int[][] {{1}, {2}, {3}}, 
            song.getMajorData()));
    }
    
    /**
     * Test regionData
     */
    public void testGetRegionData() {
        song.setRegionData(new int[][] {{1}, {2}, {3}});
        assertTrue(Arrays.deepEquals(new int[][] {{1}, {2}, {3}}, 
            song.getRegionData()));
    }
    
    /**
     * Test toString
     */
    public void testToString() {
        song.setHobbyData(new int[][] {{0,1,2},{3,4,5},{6,7,8},{9,10,11}});
        
        assertEquals("Song Title: Hello\nSong Artist: Khang\nSong Genre: Sad\n" 
        + "Song Year: 1980\nHeard\nreading:6 art:0 sports:9 music:3\n" +
          "Likes\nreading:7 art:1 sports:10 music:4\n", song.toString("hobby"));
    }
}
