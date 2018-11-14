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
 * @author khang, jasonh44, nathank
 * @version 2018.11.12
 */
public class Song {
    private final String title;
    private final String artist;
    private final String genre;
    private final int year;
    private double[] hobbyData;
    private double[] majorData;
    private double[] regionData;
    
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

    /**
     * Setter for hobby data
     * @param hData  the hobby data
     */
    public void setHobbyData(double[] hData) {
        hobbyData = hData;
    }
    
    /**
     * Getter for hobby data
     * @return the data for hobbies
     */
    public double[] getHobbyData() {
        return hobbyData;
    }
    
    /**
     * Setter for major data
     * @param mData  the major data
     */
    public void setMajorData(double[] mData) {
        majorData = mData;
    }
    
    /**
     * Getter for major data
     * @return the data for major
     */
    public double[] getMajorData() {
        return majorData;
    }
    
    /**
     * Setter for region data
     * @param rData  the region data
     */
    public void setRegionData(double[] rData) {
        regionData = rData;
    }
    
    /**
     * Getter for region data
     * @return the data for regions
     */
    public double[] getRegionData() {
        return regionData;
    }
}
