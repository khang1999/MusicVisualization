// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Khang Nguyen (khang) Nathan Kim (nathank) Jason Hassold (jasonh44)
package prj5;

/**
 * The visual representation of a piece of data where the attributes of a
 * graphical entity are dictated by one or more attributes of a data record
 * 
 * @author Khang Nguyen, Nathan Kim, Jason Hassold
 * @version 11.12.2018
 *
 */
public class Glyph {
    private Song song;

    /**
     * Constructor
     * @param s Song
     */
    public Glyph(Song s) {
        song = s;
    }


    /**
     * Returns the title for the glyph
     * 
     * @return title of the song
     */
    public String getTitle() {
        return song.getTitle();
    }


    /**
     * Returns the author for the glyph
     * 
     * @return author of the song
     */
    public String getAuthor() {
        return "by " + song.getArtist();
    }


    /**
     * Returns the vote data for hobbies for the song
     * 
     * @return hobby data
     */
    public double[] getHobby() {
        double[] bars = new double[8];

        int[][] hobbyData = song.getHobbyData();
        // For loop that goes through each element of bar and fills it up
        for (int i = 0; i < 7; i += 2) {
            // Creates two elements at a time, for each subgroup
            bars[i] = (double)hobbyData[i / 2][0] / (double)hobbyData[i / 2][2];
            bars[i + 1] = (double)hobbyData[i / 2][1] / (double)hobbyData[i
                / 2][2];
        }

        return bars;
    }


    /**
     * Returns the vote data for majors for the song
     * 
     * @return major data
     */
    public double[] getMajor() {
        double[] bars = new double[8];

        int[][] majorData = song.getMajorData();
        // For loop that goes through each element of bar and fills it up
        for (int i = 0; i < 7; i += 2) {
            // Creates two elements at a time, for each subgroup
            bars[i] = (double)majorData[i / 2][0] / (double)majorData[i / 2][2];
            bars[i + 1] = (double)majorData[i / 2][1] / (double)majorData[i
                / 2][2];
        }

        return bars;
    }


    /**
     * Returns the vote data for region for the songs
     * 
     * @return region data
     */
    public double[] getRegion() {
        double[] bars = new double[8];

        int[][] regionData = song.getRegionData();
        // For loop that goes through each element of bar and fills it up
        for (int i = 0; i < 7; i += 2) {
            bars[i] = (double)regionData[i / 2][0] / (double)regionData[i
                / 2][2];
            bars[i + 1] = (double)regionData[i / 2][1] / (double)regionData[i
                / 2][2];
        }

        return bars;
    }
}
