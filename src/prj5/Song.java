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
 * Song class for Music Data Visualization
 * @author khang
 *
 */
public class Song {
    private String title;
    private String artist;
    private String genre;
    private int year;
    
    /**
     * Constructor
     */
    public Song(String t, String a, String g, int y) {
        title = t;
        artist = a;
        genre = g;
        year = y;
    }
    
    /**
     * returns title
     * @return title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * returns artist
     * @return artist of song
     */
    
    public String getArtist() {
        return artist;
    }
    
    /**
     * returns genre
     * @return genre of song
     */
    public String getGenre() {
        return genre;
    }
    
    /**
     * return year
     * @return year song was created
     */
    public int getYear() {
        return year;
    }

}
