// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Khang Nguyen (khang) Nathan Kim (nathank) Jason Hassold (jasonh44)
package prj5;

import java.awt.Color;
import CS2114.Window;
import CS2114.Button;
import CS2114.WindowSide;
import CS2114.Shape;
import CS2114.TextShape;

/**
 * Creates window that displays legend and glyphs
 * 
 * @author Nathan Kim, Khang Nguyen, Jason Hassold
 * @version 11.12.2018
 * 
 */
public class LegendWindow {
    // fields
    private DataProcessor dp;
    private String represent;
    private Song[] songs;
    private Glyph[] glyphs;

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
    private Shape inside;
    private Shape outline;
    private TextShape hobby;
    private TextShape art;
    private TextShape music;
    private TextShape read;
    private TextShape sports;
    private TextShape songTitle;
    private TextShape heard;
    private TextShape likes;
    private Shape line;

    // manually inserting glpyh
    private TextShape cali;
    private Shape blue;
    private Shape green;
    private Shape red;
    private Shape yellow;
    private Shape black;


    // Constructor
    /**
     * Creates a new LegendWindow
     */
    public LegendWindow(String surveyDataFile, String musicFile) {
        dp = new DataProcessor(surveyDataFile, musicFile);
        represent = "";
        glyphs = new Glyph[9];
        
        window = new Window();
        window.setSize(1500, 1000);
        window.setTitle("Project 5");
        prevButton = new Button("<-- Prev");
        prevButton.onClick(this, "clickedPrevButton");
        window.addButton(prevButton, WindowSide.NORTH);
        sortArtist = new Button("Sort by Artist Name");
        sortArtist.onClick(this, "clickedSortArtist");
        window.addButton(sortArtist, WindowSide.NORTH);
        sortSong = new Button("Sort by Song Title");
        sortSong.onClick(this, "clickedSortSong");
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
        hobby = new TextShape(1275, 430, "Hobby Legend", Color.BLACK);
        hobby.setBackgroundColor(Color.WHITE);
        window.addShape(hobby);
        art = new TextShape(1275, 500, "Art", Color.BLACK);
        art.setBackgroundColor(Color.WHITE);
        art.setForegroundColor(Color.BLUE);
        window.addShape(art);
        music = new TextShape(1275, 520, "Music", Color.BLACK);
        music.setBackgroundColor(Color.WHITE);
        music.setForegroundColor(Color.GREEN);
        window.addShape(music);
        read = new TextShape(1275, 540, "Read", Color.BLACK);
        read.setBackgroundColor(Color.WHITE);
        read.setForegroundColor(Color.RED);
        window.addShape(read);
        sports = new TextShape(1275, 560, "Sports", Color.BLACK);
        sports.setBackgroundColor(Color.WHITE);
        sports.setForegroundColor(Color.YELLOW);
        window.addShape(sports);
        songTitle = new TextShape(1275, 600, "Song Title", Color.BLACK);
        songTitle.setBackgroundColor(Color.WHITE);
        songTitle.setForegroundColor(Color.BLACK);
        window.addShape(songTitle);
        heard = new TextShape(1225, 680, "Heard", Color.BLACK);
        heard.setBackgroundColor(Color.WHITE);
        heard.setForegroundColor(Color.BLACK);
        window.addShape(heard);
        likes = new TextShape(1350, 680, "Likes", Color.BLACK);
        likes.setBackgroundColor(Color.WHITE);
        likes.setForegroundColor(Color.BLACK);
        window.addShape(likes);
        line = new Shape(1300, 640, 10, 100, Color.BLACK);
        window.addShape(line);
        cali = new TextShape(30, 50, "Hotel California by The Eagles",
            Color.BLACK);
        cali.setBackgroundColor(Color.WHITE);
        window.addShape(cali);
        black = new Shape(125, 70, 7, 60, Color.BLACK);
        window.addShape(black);
        blue = new Shape(50, 70, 150, 15, Color.BLUE);
        window.addShape(blue);
        green = new Shape(50, 85, 150, 15, Color.GREEN);
        window.addShape(green);
        red = new Shape(50, 100, 150, 15, Color.RED);
        window.addShape(red);
        yellow = new Shape(50, 115, 150, 15, Color.YELLOW);
        window.addShape(yellow);

        inside = new Shape((window.getWidth() - 300), (window.getHeight() / 2
            - 85), 240, 390, Color.WHITE);
        window.addShape(inside);
        outline = new Shape((window.getWidth() - 305), (window.getHeight() / 2
            - 90), 250, 400, Color.BLACK);
        window.addShape(outline);
    }


    // Method
    /**
     * Updates the window
     */
    public void update() {
        StringBuilder out = new StringBuilder();
        for (Song song : dp.getSongs()) {
            out.append(song.toString(represent) + "\n");
        }

        System.out.print(out.toString());
    }
    
    /**
     * Display glyph
     */
    public void displayGlyph() {
        if (represent.equals("hobby")) {
            
        }
        if (represent.equals("major")) {
            
        }
        if (represent.equals("region")) {
            
        }
    }

    /**
     * Click button that sorts songs by Artist alphabetically
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedSortArtist(Button button) {
        songs = dp.sort(Song.BY_ARTIST);
        update();
    }


    /**
     * Click button that sorts songs by song title alphabetically
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedSortSong(Button button) {
        songs = dp.sort(Song.BY_TITLE);
        update();
    }


    /**
     * Click button that sorts songs by genre alphabetically
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedSortGenre(Button button) {
        songs = dp.sort(Song.BY_GENRE);
        update();
    }


    /**
     * Click button that sorts songs by release year from newest to oldest
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedSortYear(Button button) {
        songs = dp.sort(Song.BY_YEAR);
        update();
    }


    /**
     * Click button that goes to previous legend
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedPrevButton(Button button) {

    }


    /**
     * Click button that goes to next legend
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedNextButton(Button button) {
        
    }


    /**
     * Click button that represents legend by hobby
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedHobbyButton(Button button) {
        represent = "hobby";
        // update();
    }


    /**
     * Click button that represents legend by major
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedMajorButton(Button button) {
        represent = "major";
        // update();
    }


    /**
     * Click button that represents legend by region
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedRegionButton(Button button) {
        represent = "region";
        // update();
    }


    /**
     * Click button that exits window
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedQuitButton(Button button) {
        System.exit(0);
    }
    
    /**
     * Gittest
     */
    public int gitTest() {
        return 1;
    }
}
