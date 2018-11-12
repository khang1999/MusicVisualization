// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- Khang Nguyen (khang) Nathan Kim (nathank) Jason Hassold ()
package prj5;

public class DataProcessor {
    private Window window;
    private LinkedList<Person> people;
    private LinkedList<Song> songs;
    private LinkedList<Glyph> glyphs;
    
    public DataProcessor(Window w) {
        window = w;
    }
    
    /**
     * Generates the glyphs
     */
    public void generateGlyphs() {
        
    }
    
    /**
     * Calculates votes based on index of song
     * @param s song to check for
     * @return song index and votes
     */
    public double[][] calculateVotes(Song s){
        //run through each people at a specific vote
    }
}
