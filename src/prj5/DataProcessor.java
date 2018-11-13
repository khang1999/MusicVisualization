// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- Khang Nguyen (khang) Nathan Kim (nathank) Jason Hassold (jasonh44)
package prj5;

import CS2114.Window;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * DataProcessor class loads in the data 
 * 
 * @author khang, nathank, jasonh44
 * @version 12.11.2018 
 *
 */
public class DataProcessor {
    // Fields
    private Window window;
    private LinkedList<Person> people;
    private LinkedList<Song> songs;
    private LinkedList<Glyph> glyphs;
    
    /**
     * Constructor
     * Loads in data from SongList2018S.csv and MusicSurveyData2018S.csv
     * 
     * @param w  the window
     */
    public DataProcessor(Window w) {
        // Initialize fields
        window = w;
        people = new LinkedList<Person>();
        songs = new LinkedList<Song>();
        glyphs = new LinkedList<Glyph>();
       
        
        // LOAD SONGS
       
        // Load file into scanner
        Scanner songFile = null;
        try {
            songFile = new Scanner(new File(
                "C:\\Users\\Jason\\Documents\\GitHub\\MusicVisualization\\"
                + "SongList2018S.csv"));
            
            // Loop through by line
            songFile.nextLine(); // Skips information line
            while (songFile.hasNextLine()) {
                Scanner line = new Scanner(songFile.nextLine());
                line.useDelimiter(",");
                
                String title = line.next();
                String artist = line.next();
                int year = line.nextInt();
                String genre = line.next();
                
                songs.add(new Song(title, artist, genre, year));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        // LOAD POEPLE
        
        // Load file into scanner
        Scanner surveyFile = null;
        try {
            surveyFile = new Scanner(new File(
                "C:\\Users\\Jason\\Documents\\GitHub\\MusicVisualization\\"
                + "MusicSurveyData2018S.csv"));
            
            // Loop through by line
            surveyFile.nextLine(); // Skips information line
            while (surveyFile.hasNextLine()) {
                Scanner line = new Scanner(surveyFile.nextLine());
                line.useDelimiter(",");
                
                int id = line.nextInt();
                String date = line.next();
                String major = line.next();
                String region = line.next();
                String hobby = line.next();
                int[] votes = new int[songs.size() * 2];
                
                int index = 0;
                while (line.hasNext()) {
                    switch (line.next()) {
                        case "Yes":
                            votes[index] = 1;
                            break;
                        case "No":
                            votes[index] = 0;
                            break;
                        default:
                            votes[index] = -1;
                    }
                    index++;
                }
                
                people.add(new Person(id, date, major, region, hobby, votes));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
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
        return null;
        //run through each people at a specific vote
    }
    
    /**
     * Get songs linkedlist to test
     */
    public LinkedList<Song> getSongs() {
        return songs;
    }
    
    /**
     * Get people linkedlist to test
     */
    public LinkedList<Person> getPeople() {
        return people;
    }
}
