// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Khang Nguyen (khang) Nathan Kim (nathank) Jason Hassold (jasonh44)

package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Creates window that displays legend and glyphs
 * 
 * @author Nathan Kim, Khang Nguyen, Jason Hassold
 * @version 11.12.2018
 * 
 */
public class DisplayWindow {
    // Fields
    private DataProcessor dp;
    private Song[] songs;
    private Glyph[] glyphs;
    
    private String represent; // What data is currently being represented
    
    private Window window;
    private Button sortArtist;
    private Button sortSong;
    private Button sortYear;
    private Button sortGenre;
    private Button prevButton;
    private Button nextButton;
    private Button hobbyButton;
    private Button majorButton;
    private Button regionButton;
    private Button quitButton;
    
    private TextShape key1;
    private TextShape key2;
    private TextShape key3;
    private TextShape key4;
    
    private final int[][] coordinates = new int[][] {{}, {}, {},
                                                     {}, {}, {},
                                                     {}, {}, {}};
    
    /**
     * Constructor 
     * 
     * @param surveyDataFile  the file path of the survey data
     * @param musicFile       the file path of the music file
     */
    public DisplayWindow(String surveyDataFile, String musicFile) {
        dp = new DataProcessor(surveyDataFile, musicFile);
        glyphs = new Glyph[9];
        
        represent = "";
        
        // Set up window
        window = new Window();
        window.setSize(1200, 600);
        window.setTitle("Project 5");
        
        // Set up buttons
        prevButton = new Button("<-- Prev");
        prevButton.onClick(this, "clickedPrevButton");
        window.addButton(prevButton, WindowSide.NORTH);
        
        sortArtist = new Button("Sort by Artist Name");
        sortArtist.onClick(this, "clickedSortArtist");
        window.addButton(sortArtist, WindowSide.NORTH);
        
        sortSong = new Button("Sort by Song Title");
        sortSong.onClick(this, "clickedSortTitle");
        window.addButton(sortSong, WindowSide.NORTH);
        
        sortYear = new Button("Sort by Release Year");
        sortYear.onClick(this, "clickedSortYear");
        window.addButton(sortYear, WindowSide.NORTH);
        
        sortGenre = new Button("Sort by Genre");
        sortGenre.onClick(this, "clickedSortGenre");
        window.addButton(sortGenre, WindowSide.NORTH);
        
        nextButton = new Button("Next -->");
        nextButton.onClick(this, "clickedNextButton");
        window.addButton(nextButton, WindowSide.NORTH);
        
        hobbyButton = new Button("Represent Hobby");
        hobbyButton.onClick(this, "clickedHobbyButton");
        window.addButton(hobbyButton, WindowSide.SOUTH);
        
        majorButton = new Button("Represent Major");
        majorButton.onClick(this, "clickedMajorButton");
        window.addButton(majorButton, WindowSide.SOUTH);
        
        regionButton = new Button("Represent Region");
        regionButton.onClick(this, "clickedRegionButton");
        window.addButton(regionButton, WindowSide.SOUTH);
        
        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuitButton");
        window.addButton(quitButton, WindowSide.SOUTH);
        
        // Set up the legend
        TextShape hobby = new TextShape((window.getWidth() - 175), 
            (window.getHeight() / 2 - 80), "Hobby Legend", Color.BLACK);
        hobby.setBackgroundColor(Color.WHITE);
        window.addShape(hobby);
        
        TextShape songTitle = new TextShape((window.getWidth() - 160), 
            (window.getHeight() / 2 + 20), "Song Title", Color.BLACK);
        songTitle.setBackgroundColor(Color.WHITE);
        songTitle.setForegroundColor(Color.BLACK);
        window.addShape(songTitle);
        
        TextShape heard = new TextShape((window.getWidth() - 175), 
            (window.getHeight() / 2 + 60), "Heard", Color.BLACK);
        heard.setBackgroundColor(Color.WHITE);
        heard.setForegroundColor(Color.BLACK);
        window.addShape(heard);
        
        TextShape likes = new TextShape((window.getWidth() - 110), 
            (window.getHeight() / 2 + 60), "Likes", Color.BLACK);
        likes.setBackgroundColor(Color.WHITE);
        likes.setForegroundColor(Color.BLACK);
        window.addShape(likes);
        
        Shape line = new Shape((window.getWidth() - 125), 
            (window.getHeight() / 2 + 50), 10, 40, Color.BLACK);
        window.addShape(line);
        
        Shape inside = new Shape((window.getWidth() - 180), 
            (window.getHeight() / 2 - 85), 120, 200, Color.WHITE);
        window.addShape(inside);
        
        Shape outline = new Shape((window.getWidth() - 185), 
            (window.getHeight() / 2 - 90), 130, 210, Color.BLACK);
        window.addShape(outline);
    }
    
    
    /**
     * Updates display
     */
    public void update() {
        
    }
    
    /**
     * Clears the whole window
     */
    public
    
    
    /**
     * Handler method for previous button
     * 
     * @param button  the button 
     */
    public void clickedPrevButton(Button button) {
        
    }
    
    /**
     * Handler method for sort artist button
     * 
     * @param button  the button 
     */
    public void clickedSortArtist(Button button) {
        songs = dp.sort(Song.BY_ARTIST);
        update();
    }
    
    /**
     * Handler method for sort title button
     * 
     * @param button  the button 
     */
    public void clickedSortTitle(Button button) {
        songs = dp.sort(Song.BY_TITLE);
        update();
    }
    
    /**
     * Handler method for sort year button
     * 
     * @param button  the button 
     */
    public void clickedSortYear(Button button) {
        songs = dp.sort(Song.BY_GENRE);
        update();
    }
    
    /**
     * Handler method for sort genre button
     * 
     * @param button  the button 
     */
    public void clickedSortGenre(Button button) {
        songs = dp.sort(Song.BY_YEAR);
        update();
    }    
    
    /**
     * Handler method for next button
     * 
     * @param button  the button 
     */
    public void clickedNextButton(Button button) {
        
    }
    
    /**
     * Handler method for represent hobby button
     * 
     * @param button  the button 
     */
    public void clickedHobbyButton(Button button) {
        represent = "hobby";
        update();
    }
    
    /**
     * Handler method for represent major button
     * 
     * @param button  the button 
     */
    public void clickedMajorButton(Button button) {
        represent = "major";
        update();
    }
    
    /**
     * Handler method for represent region button
     * 
     * @param button  the button 
     */
    public void clickedRegionButton(Button button) {
        represent = "region";
        update();
    }
    
    /**
     * Handler method for quit button
     * 
     * @param button  the button 
     */
    public void clickedQuitButton(Button button) {
        System.exit(0);
    }
}
