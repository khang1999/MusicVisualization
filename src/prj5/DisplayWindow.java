// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Khang Nguyen (khang) Nathan Kim (nathank) Jason Hassold (jasonh44)

package prj5;

import java.awt.Color;
import java.util.Arrays;
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
    private int set;
    
    private Window window;
    
    private TextShape key1;
    private TextShape key2;
    private TextShape key3;
    private TextShape key4;
    
    private final int[][] coordinates = 
        new int[][] {{100, 25}, {433, 25}, {766, 25},
                     {100, 175}, {433, 175}, {766, 175},
                     {100, 325}, {433, 325}, {766, 325}};
    
    /**
     * Constructor 
     * 
     * @param surveyDataFile  the file path of the survey data
     * @param musicFile       the file path of the music file
     */
    public DisplayWindow(String surveyDataFile, String musicFile) {
        dp = new DataProcessor(surveyDataFile, musicFile);
        Object[] objArr = dp.getSongs().toArray();
        songs = Arrays.copyOf(objArr, objArr.length, Song[].class);
        glyphs = new Glyph[9];
        
        represent = "";
        set = 0;
        
        // Set up window
        window = new Window();
        window.setSize(1200, 600);
        window.setTitle("Project 5");
        
        // Set up buttons
        Button prevButton = new Button("<-- Prev");
        prevButton.onClick(this, "clickedPrevButton");
        window.addButton(prevButton, WindowSide.NORTH);
        
        Button sortArtist = new Button("Sort by Artist Name");
        sortArtist.onClick(this, "clickedSortArtist");
        window.addButton(sortArtist, WindowSide.NORTH);
        
        Button sortSong = new Button("Sort by Song Title");
        sortSong.onClick(this, "clickedSortTitle");
        window.addButton(sortSong, WindowSide.NORTH);
        
        Button sortYear = new Button("Sort by Release Year");
        sortYear.onClick(this, "clickedSortYear");
        window.addButton(sortYear, WindowSide.NORTH);
        
        Button sortGenre = new Button("Sort by Genre");
        sortGenre.onClick(this, "clickedSortGenre");
        window.addButton(sortGenre, WindowSide.NORTH);
        
        Button nextButton = new Button("Next -->");
        nextButton.onClick(this, "clickedNextButton");
        window.addButton(nextButton, WindowSide.NORTH);
        
        Button hobbyButton = new Button("Represent Hobby");
        hobbyButton.onClick(this, "clickedHobbyButton");
        window.addButton(hobbyButton, WindowSide.SOUTH);
        
        Button majorButton = new Button("Represent Major");
        majorButton.onClick(this, "clickedMajorButton");
        window.addButton(majorButton, WindowSide.SOUTH);
        
        Button regionButton = new Button("Represent Region");
        regionButton.onClick(this, "clickedRegionButton");
        window.addButton(regionButton, WindowSide.SOUTH);
        
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuitButton");
        window.addButton(quitButton, WindowSide.SOUTH);
        
        // Set up legend key
        key1 = new TextShape((window.getWidth() - 175), 
            (window.getHeight() / 2 - 60), "", Color.BLACK);
        key1.setBackgroundColor(Color.WHITE);
        key1.setForegroundColor(Color.BLUE);
        
        key2 = new TextShape((window.getWidth() - 175), 
            (window.getHeight() / 2 - 40), "", Color.BLACK);
        key2.setBackgroundColor(Color.WHITE);
        key2.setForegroundColor(Color.GREEN);
        
        key3 = new TextShape((window.getWidth() - 175), 
            (window.getHeight() / 2 - 20), "", Color.BLACK);
        key3.setBackgroundColor(Color.WHITE);
        key3.setForegroundColor(Color.RED);
        
        key4 = new TextShape((window.getWidth() - 175), 
            (window.getHeight() / 2 - 0), "", Color.BLACK);
        key4.setBackgroundColor(Color.WHITE);
        key4.setForegroundColor(Color.YELLOW);
    }
    
    
    /**
     * Updates display
     */
    public void update() {
        clear();
        legend();
        
        // Print out songs
        StringBuilder out = new StringBuilder();
        for (Song song : dp.getSongs()) {
            out.append(song.toString(represent) + "\n");
        }
        System.out.print(out.toString());
        
        populateGlyphs();
    }
    
    /**
     * Clears the whole window
     */
    public void clear() {
        window.removeAllShapes();
    }
    
    /**
     * Displays the legend
     */
    public void legend() {
        TextShape legendTitle = new TextShape((window.getWidth() - 175), 
            (window.getHeight() / 2 - 80), "", Color.BLACK);
        legendTitle.setBackgroundColor(Color.WHITE);
        window.addShape(legendTitle);
        
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
        
        switch (represent) {
            case "hobby":
                key1.setText("Art");
                key2.setText("Music");
                key3.setText("Read");
                key4.setText("Sports");
                legendTitle.setText("Hobby Legend");
                break;
            case "region":
                key1.setText("Northeast");
                key2.setText("Outside US");
                key3.setText("Southeast");
                key4.setText("US Other");
                legendTitle.setText("Region Legend");
                break;
            case "major":
                key1.setText("Comp Sci");
                key2.setText("Math/CMDA");
                key3.setText("Other Eng");
                key4.setText("Other");
                legendTitle.setText("Major Legend");
                break;
            default:
                break;
        }
        
        window.addShape(key1);
        window.moveToFront(key1);
        window.addShape(key2);
        window.moveToFront(key2);
        window.addShape(key3);
        window.moveToFront(key3);
        window.addShape(key4);
        window.moveToFront(key4);
    }
    
    
    /**
     * Uploads 9 glyphs from the songs based on the set number
     */
    public void populateGlyphs() {
        glyphs = new Glyph[9];
        for (int i = 0; i < 9; i++) {
            glyphs[i] = new Glyph(songs[set + i]);
        }
        displayGlyphs();
    }
    
    /**
     * Display glyphs
     */
    public void displayGlyphs() {
        if (!(represent.equals(""))) {
            for (int count = 0; count < 9 && glyphs[count] != null; count++) {
                double[] data = null;
                switch (represent) {
                    case "major":
                        data = glyphs[count].getMajor();
                        break;
                    case "region":
                        data = glyphs[count].getRegion();
                        break;
                    case "hobby":
                        data = glyphs[count].getHobby();
                        break;
                    default:
                        break;
                }
                
                int lengthOfBar = 100;
                
                int initialX = coordinates[count][0];
                int initialY = coordinates[count][1];
                
                int blackX = initialX + 75;
                int blackY = initialY + 40;
                
                // Make black bar
                Shape blackBar = new Shape(blackX, blackY, 7, 60,
                    Color.BLACK);
                window.addShape(blackBar);
                
                // Makes titles
                TextShape title = new TextShape(0, initialY, 
                    glyphs[count].getTitle(), Color.BLACK);
                title.setX(center(initialX, title.getWidth()));
                title.setBackgroundColor(Color.WHITE);
                window.addShape(title);
                
                // Makes Artists
                TextShape artist = new TextShape(0, initialY + 20, 
                    glyphs[count].getAuthor(), Color.BLACK);
                artist.setX(center(initialX, artist.getWidth()));
                artist.setBackgroundColor(Color.WHITE);
                window.addShape(artist);
                
                // Creates left side of blue
                int blueLWidth = (int)(lengthOfBar * data[0]);
                int blueLX = blackX - blueLWidth;
                int blueLY = initialY + 40;
                Shape blueLeft = new Shape(blueLX, blueLY, blueLWidth, 15,
                    Color.blue);
                window.addShape(blueLeft);
                
                // Creates right side of blue
                int blueRWidth = (int)(lengthOfBar * data[1]);
                int blueRX = blackX + 7;
                int blueRY = initialY + 40;
                Shape blueRight = new Shape(blueRX, blueRY, blueRWidth, 15,
                    Color.blue);
                window.addShape(blueRight);

                // Creates left side of green
                int greenLWidth = (int)(lengthOfBar * data[2]);
                int greenLX = blackX - greenLWidth;
                int greenLY = initialY + 55;
                Shape greenLeft = new Shape(greenLX, greenLY, greenLWidth,
                    15, Color.GREEN);
                window.addShape(greenLeft);

                // Creates right side of green
                int greenRWidth = (int)(lengthOfBar * data[3]);
                int greenRX = blackX + 7;
                int greenRY = initialY + 55;
                Shape greenRight = new Shape(greenRX, greenRY, greenRWidth,
                    15, Color.green);
                window.addShape(greenRight);

                // Creates left side of red
                int redLWidth = (int)(lengthOfBar * data[4]);
                int redLX = blackX - redLWidth;
                int redLY = initialY + 70;
                Shape redLeft = new Shape(redLX, redLY, redLWidth, 15,
                    Color.red);
                window.addShape(redLeft);

                // Creates right side of red
                int redRWidth = (int)(lengthOfBar * data[5]);
                int redRX = blackX + 7;
                int redRY = initialY + 70;
                Shape redRight = new Shape(redRX, redRY, redRWidth, 15,
                    Color.red);
                window.addShape(redRight);

                // Creates left side of yellow
                int yellowLWidth = (int)(lengthOfBar * data[6]);
                int yellowLX = blackX - yellowLWidth;
                int yellowLY = initialY + 85;
                Shape yellowLeft = new Shape(yellowLX, yellowLY,
                    yellowLWidth, 15, Color.yellow);
                window.addShape(yellowLeft);

                // Creates right side of yellow
                int yellowRWidth = (int)(lengthOfBar * data[7]);
                int yellowRX = blackX + 7;
                int yellowRY = initialY + 85;
                Shape yellowRight = new Shape(yellowRX, yellowRY,
                    yellowRWidth, 15, Color.yellow);
                window.addShape(yellowRight);
            }
        }
    }
    
    /**
     * Private method to center the text
     * 
     * @param num
     * @param length
     * @return int of center
     */
    private int center(int num, int length) {
        int center = num + (150 - length) / 2;
        return center;
    }
    
    
    /**
     * Handler method for previous button
     * 
     * @param button  the button 
     */
    public void clickedPrevButton(Button button) {
        if (set - 9 >= 0) {
            set -= 9;
        }
        update();
    }
    
    /**
     * Handler method for sort artist button
     * 
     * @param button  the button 
     */
    public void clickedSortArtist(Button button) {
        songs = dp.sort(Song.BY_ARTIST);
        set = 0;
        update();
    }
    
    /**
     * Handler method for sort title button
     * 
     * @param button  the button 
     */
    public void clickedSortTitle(Button button) {
        songs = dp.sort(Song.BY_TITLE);
        set = 0;
        update();
    }
    
    /**
     * Handler method for sort year button
     * 
     * @param button  the button 
     */
    public void clickedSortYear(Button button) {
        songs = dp.sort(Song.BY_GENRE);
        set = 0;
        update();
    }
    
    /**
     * Handler method for sort genre button
     * 
     * @param button  the button 
     */
    public void clickedSortGenre(Button button) {
        songs = dp.sort(Song.BY_YEAR);
        set = 0;
        update();
    }    
    
    /**
     * Handler method for next button
     * 
     * @param button  the button 
     */
    public void clickedNextButton(Button button) {
        if (set + 9 < songs.length) {
            set += 9;
        }
        update();
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
