// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Khang Nguyen (khang) Nathan Kim (nathank) Jason Hassold (jasonh44)
package prj5;

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
        dp = new DataProcessor(
            "C:\\Users\\Jason\\Documents\\GitHub\\MusicVisualization\\"
                + "MusicSurveyData2018S.csv",
            "C:\\Users\\Jason\\Documents\\GitHub\\MusicVisualization\\"
                + "SongList2018S.csv");
    }


    /**
     * Test for the two data loading methods
     */
    public void testLoadData() {
        LinkedList<Song> songs = dp.getSongs();
        LinkedList<Person> people = dp.getPeople();

        assertEquals("Hotline Bling", songs.get(0).getTitle());
        assertEquals("Michael Jackson", songs.get(42).getArtist());
        assertEquals(2017, songs.get(54).getYear());

        assertEquals(1, people.get(9).getVote(7));
        assertEquals(0, people.get(9).getVote(8));
        assertEquals(-1, people.get(7).getVote(50));
    }


    /**
     * Test calculate votes
     */
    public void testCalculateVotes() {
        dp.calculateVotes();

        assertTrue(dp.getSongs().get(54).getMajorData()[2][2] != 0);
    }
}
