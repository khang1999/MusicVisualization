// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- Khang Nguyen (khang) Nathan Kim (nathank) Jason Hassold (jasonh44)
package prj5;

import CS2114.Window;
import student.TestCase;

/**
 * Test Class for DataProcessor
 * 
 * @author khang, nathank, jasonh44
 * @version 12.11.2018
 */
public class DataProcessorTest extends TestCase {
    // Fields
    private DataProcessor dp;
    
    /**
     * Constructor
     */
    public DataProcessorTest() {
        // This was left blank intentionally
    }
    
    /**
     * Set up
     */
    public void setUp() {
        dp = new DataProcessor(new Window());
    }
    
    /**
     * Test
     */
    public void test() {
        LinkedList<Song> songs = dp.getSongs();
        
        assertEquals("Hotline Bling", songs.get(0).getTitle());
        assertEquals("Michael Jackson", songs.get(42).getArtist());
        assertEquals(2017, songs.get(54).getYear());
    }
}
