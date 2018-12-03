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
        song.setHobbyData(new int[][] { { 1 }, { 2 }, { 3 } });
        assertTrue(Arrays.deepEquals(new int[][] { { 1 }, { 2 }, { 3 } }, song
            .getHobbyData()));
    }


    /**
     * Test majorData
     */
    public void testGetMajorData() {
        song.setMajorData(new int[][] { { 1 }, { 2 }, { 3 } });
        assertTrue(Arrays.deepEquals(new int[][] { { 1 }, { 2 }, { 3 } }, song
            .getMajorData()));
    }


    /**
     * Test regionData
     */
    public void testGetRegionData() {
        song.setRegionData(new int[][] { { 1 }, { 2 }, { 3 } });
        assertTrue(Arrays.deepEquals(new int[][] { { 1 }, { 2 }, { 3 } }, song
            .getRegionData()));
    }


    /**
     * Test toString
     */
    public void testToString() {
        assertEquals("", song.toString(""));
        
        song.setHobbyData(new int[][] { { 0, 1, 2 }, { 3, 4, 5 }, 
            { 6, 7, 8 }, {9, 10, 11 } });

        assertEquals("Song Title: Hello\nSong Artist: Khang\nSong Genre: Sad\n"
            + "Song Year: 1980\nHeard\nreading:6 art:0 sports:9 music:3\n"
            + "Likes\nreading:7 art:1 sports:10 music:4\n", song.toString(
                "hobby"));
        
        song.setMajorData(new int[][] { { 0, 1, 2 }, { 3, 4, 5 }, 
            { 6, 7, 8 }, {9, 10, 11 } });
        
        assertEquals("Song Title: Hello\nSong Artist: Khang\nSong Genre: Sad\n"
            + "Song Year: 1980\nHeard\nreading:6 art:0 sports:9 music:3\n"
            + "Likes\nreading:7 art:1 sports:10 music:4\n", song.toString(
                "major"));
        
        song.setRegionData(new int[][] { { 0, 1, 2 }, { 3, 4, 5 }, 
            { 6, 7, 8 }, {9, 10, 11 } });
        
        assertEquals("Song Title: Hello\nSong Artist: Khang\nSong Genre: Sad\n"
            + "Song Year: 1980\nHeard\nreading:6 art:0 sports:9 music:3\n"
            + "Likes\nreading:7 art:1 sports:10 music:4\n", song.toString(
                "region"));
        
        assertEquals("Song Title: Hello\nSong Artist: Khang\nSong Genre: Sad\n"
            + "Song Year: 1980\n", song.toString("a"));
    }
    
    /**
     * Test compare title
     */
    public void testCompare() {
        Song a = new Song("A", "A", "A", 2000);
        Song b = new Song("B", "C", "D", 2004);
        
        assertEquals(-1, song.BY_TITLE.compare(a, b));
        assertEquals(-2, song.BY_ARTIST.compare(a, b));
        assertEquals(-3, song.BY_GENRE.compare(a, b));
        assertEquals(-4, song.BY_YEAR.compare(a, b));
    }
}
