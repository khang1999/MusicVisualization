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

/**
 * @author khang, jasonh44
 * @version 2018.11.12
 */
public class SongTest extends student.TestCase {
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
}
