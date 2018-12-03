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

import java.util.Comparator;

/**
 * Song class for Music Data Visualization
 * 
 * @author khang, jasonh44, nathank
 * @version 2018.11.12
 */
public class Song {
    private final String title;
    private final String artist;
    private final String genre;
    private final int year;
    private int[][] hobbyData;
    private int[][] majorData;
    private int[][] regionData;
    /**
     * Song title
     */
    public static final Comparator<Song> BY_TITLE = new ByTitle();
    /**
     * Song artist
     */
    public static final Comparator<Song> BY_ARTIST = new ByArtist();
    /**
     * Song genre
     */
    public static final Comparator<Song> BY_GENRE = new ByGenre();
    /**
     * Song year
     */
    public static final Comparator<Song> BY_YEAR = new ByYear();


    /**
     * Constructor
     * 
     * @param t
     *            Title
     * @param a
     *            Artist
     * @param g
     *            Genre
     * @param y
     *            Year
     */
    public Song(String t, String a, String g, int y) {
        title = t;
        artist = a;
        genre = g;
        year = y;

        hobbyData = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0,
            0 } };
        majorData = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0,
            0 } };
        regionData = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0,
            0, 0 } };
    }


    /**
     * returns title
     * 
     * @return title
     */
    public String getTitle() {
        return title;
    }


    /**
     * returns artist
     * 
     * @return artist of song
     */

    public String getArtist() {
        return artist;
    }


    /**
     * returns genre
     * 
     * @return genre of song
     */
    public String getGenre() {
        return genre;
    }


    /**
     * return year
     * 
     * @return year song was created
     */
    public int getYear() {
        return year;
    }


    /**
     * Setter for hobby data
     * 
     * @param hData
     *            the hobby data
     */
    public void setHobbyData(int[][] hData) {
        hobbyData = hData;
    }


    /**
     * Getter for hobby data
     * 
     * @return the data for hobbies
     */
    public int[][] getHobbyData() {
        return hobbyData;
    }


    /**
     * Setter for major data
     * 
     * @param mData
     *            the major data
     */
    public void setMajorData(int[][] mData) {
        majorData = mData;
    }


    /**
     * Getter for major data
     * 
     * @return the data for major
     */
    public int[][] getMajorData() {
        return majorData;
    }


    /**
     * Setter for region data
     * 
     * @param rData
     *            the region data
     */
    public void setRegionData(int[][] rData) {
        regionData = rData;
    }


    /**
     * Getter for region data
     * 
     * @return the data for regions
     */
    public int[][] getRegionData() {
        return regionData;
    }


    /**
     * To string
     * 
     * @param represent
     *            data to represent
     * @return the string representation
     */
    public String toString(String represent) {
        if (!(represent.equals(""))) {
            StringBuilder out = new StringBuilder();
            out.append("Song Title: " + title + "\n");
            out.append("Song Artist: " + artist + "\n");
            out.append("Song Genre: " + genre + "\n");
            out.append("Song Year: " + year + "\n");
            switch (represent) {
                case "hobby":
                    out.append("Heard\n");
                    out.append("reading:" + hobbyData[2][0] + " " + "art:"
                        + hobbyData[0][0] + " " + "sports:" + hobbyData[3][0] + " "
                        + "music:" + hobbyData[1][0] + "\n");
                    out.append("Likes\n");
                    out.append("reading:" + hobbyData[2][1] + " " + "art:"
                        + hobbyData[0][1] + " " + "sports:" + hobbyData[3][1] + " "
                        + "music:" + hobbyData[1][1] + "\n");
                    break;
                case "major":
                    out.append("Heard\n");
                    out.append("reading:" + majorData[2][0] + " " + "art:"
                        + majorData[0][0] + " " + "sports:" + majorData[3][0] + " "
                        + "music:" + majorData[1][0] + "\n");
                    out.append("Likes\n");
                    out.append("reading:" + majorData[2][1] + " " + "art:"
                        + majorData[0][1] + " " + "sports:" + majorData[3][1] + " "
                        + "music:" + majorData[1][1] + "\n");
                    break;
                case "region":
                    out.append("Heard\n");
                    out.append("reading:" + regionData[2][0] + " " + "art:"
                        + regionData[0][0] + " " + "sports:" + regionData[3][0] + " "
                        + "music:" + regionData[1][0] + "\n");
                    out.append("Likes\n");
                    out.append("reading:" + regionData[2][1] + " " + "art:"
                        + regionData[0][1] + " " + "sports:" + regionData[3][1] + " "
                        + "music:" + regionData[1][1] + "\n");
                    break;
            }

            return out.toString();
        }
        
        return "";
    }


    private static class ByTitle implements Comparator<Song> {
        /**
         * Compare Song by title
         * 
         * @param v
         *            Song
         * @param w
         *            Song
         * @return Int of compare
         */
        public int compare(Song v, Song w) {
            return v.getTitle().compareTo(w.getTitle());
        }
    }


    private static class ByArtist implements Comparator<Song> {
        /**
         * Compare Song by artist
         * 
         * @param v
         *            Song
         * @param w
         *            Song
         * @return Int of compare
         */
        public int compare(Song v, Song w) {
            return v.getArtist().compareTo(w.getArtist());
        }
    }


    private static class ByGenre implements Comparator<Song> {
        /**
         * Compare Song by genre
         * 
         * @param v
         *            Song
         * @param w
         *            Song
         * @return Int of compare
         */
        public int compare(Song v, Song w) {
            return v.getGenre().compareTo(w.getGenre());
        }
    }


    private static class ByYear implements Comparator<Song> {
        /**
         * Compare Song by year
         * 
         * @param v
         *            Song
         * @param w
         *            Song
         * @return Int of compare
         */
        public int compare(Song v, Song w) {
            return v.getYear() - w.getYear();
        }
    }

}
