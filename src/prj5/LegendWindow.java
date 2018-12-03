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
    // Set number must be first number of set
    // ex: 0, 9, 18
    private int set;

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

    // manually inserting glyph
    private TextShape cali;
    private TextShape artist2;
    private Shape blue;
    private Shape green;
    private Shape red;
    private Shape yellow;
    private Shape black;


    // Constructor
    /**
     * Creates a new LegendWindow
     * 
     * @param surveyDataFile
     *            File of Survey data
     * @param musicFile
     *            File of songs
     */
    public LegendWindow(String surveyDataFile, String musicFile) {
        dp = new DataProcessor(surveyDataFile, musicFile);
        represent = "";
        glyphs = new Glyph[9];
        set = 0;

        
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

        // Set up the legend

        hobby = new TextShape((window.getWidth() - 175), (window.getHeight() / 2
            - 80), "Hobby Legend", Color.BLACK);
        hobby.setBackgroundColor(Color.WHITE);
        window.addShape(hobby);

        art = new TextShape((window.getWidth() - 175), (window.getHeight() / 2
            - 60), "Art", Color.BLACK);
        art.setBackgroundColor(Color.WHITE);
        art.setForegroundColor(Color.BLUE);
        window.addShape(art);

        music = new TextShape((window.getWidth() - 175), (window.getHeight() / 2
            - 40), "Music", Color.BLACK);
        music.setBackgroundColor(Color.WHITE);
        music.setForegroundColor(Color.GREEN);
        window.addShape(music);

        read = new TextShape((window.getWidth() - 175), (window.getHeight() / 2
            - 20), "Read", Color.BLACK);
        read.setBackgroundColor(Color.WHITE);
        read.setForegroundColor(Color.RED);
        window.addShape(read);

        sports = new TextShape((window.getWidth() - 175), (window.getHeight()
            / 2 - 0), "Sports", Color.BLACK);
        sports.setBackgroundColor(Color.WHITE);
        sports.setForegroundColor(Color.YELLOW);
        window.addShape(sports);

        songTitle = new TextShape((window.getWidth() - 160), (window.getHeight()
            / 2 + 20), "Song Title", Color.BLACK);
        songTitle.setBackgroundColor(Color.WHITE);
        songTitle.setForegroundColor(Color.BLACK);
        window.addShape(songTitle);

        heard = new TextShape((window.getWidth() - 175), (window.getHeight() / 2
            + 60), "Heard", Color.BLACK);
        heard.setBackgroundColor(Color.WHITE);
        heard.setForegroundColor(Color.BLACK);
        window.addShape(heard);

        likes = new TextShape((window.getWidth() - 110), (window.getHeight() / 2
            + 60), "Likes", Color.BLACK);
        likes.setBackgroundColor(Color.WHITE);
        likes.setForegroundColor(Color.BLACK);
        window.addShape(likes);
        

        
        line = new Shape((window.getWidth() - 125), (window.getHeight() / 2
            + 50), 10, 40, Color.BLACK);
        window.addShape(line);
        
        inside = new Shape((window.getWidth() - 180), (window.getHeight() / 2
            - 85), 120, 200, Color.WHITE);
        window.addShape(inside);
        
        outline = new Shape((window.getWidth() - 185), (window.getHeight() / 2
            - 90), 130, 210, Color.BLACK);
        window.addShape(outline);
        
        //Sample Glyphs
        //How you center a text
        /*String testTitle = "Hotel California";
        cali = new TextShape(0, 30, testTitle,
            Color.BLACK);
        int center = 50 + (150 - cali.getWidth())/2;
        cali.setX(center);

        cali.setBackgroundColor(Color.WHITE);
        window.addShape(cali);

        String artistTest = "by The Eagles";
        artist2 = new TextShape(0, 50, artistTest, Color.BLACK);
        int center2 = 50 + (150 - artist2.getWidth()) / 2;
        artist2.setX(center2);
        artist2.setBackgroundColor(Color.WHITE);
        window.addShape(artist2);

        black = new Shape(125, 70, 7, 60, Color.BLACK);
        window.addShape(black);

        blue = new Shape(50, 70, 150, 15, Color.BLUE);
        window.addShape(blue);

        green = new Shape(50, 85, 150, 15, Color.GREEN);
        window.addShape(green);

        red = new Shape(50, 100, 150, 15, Color.RED);
        window.addShape(red);

        yellow = new Shape(50, 115, 150, 15, Color.YELLOW);

        window.addShape(yellow);*/
        
        //End Sample Glyph
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
        this.populateGlyph();
        System.out.print(out.toString());
    }


    /**
     * Display glyph
     */
    public void displayGlyph() {
        //variables for locations
        int[][] placements = new int[][] {{100, 25}, {433, 25}, {766, 25},
                                          {100, 175}, {433, 175}, {766, 175},
                                          {100, 325}, {433, 325}, {766, 325}};
        int num = 0;
        /**
         * Center text
         * Y - string.length();
         */
        switch (represent) {
            case "major":
                num = 0;
                for (int i = 0; i < placements.length; i++) {
                    // Makes titles
                    String song = glyphs[num].getTitle();
                    int initialX = placements[i][0];
                    int initialY = placements[i][1];

                    TextShape title = new TextShape(0, initialY, song,
                        Color.BLACK);
                    int centerSong = center(initialX, song.length());
                    title.setX(centerSong);
                    title.setBackgroundColor(Color.WHITE);
                    window.addShape(title);

                    // Makes Artists
                    String a = glyphs[num].getAuthor();
                    TextShape artist = new TextShape(0, initialY + 20, a,
                        Color.BLACK);
                    int centerArtist = center(initialX, a.length());
                    artist.setX(centerArtist);
                    artist.setBackgroundColor(Color.WHITE);
                    window.addShape(artist);

                    // Black bar
                    int blackX = initialX + 75;
                    int blackY = initialY + 40;
                    Shape blackBar = new Shape(blackX, blackY, 7, 60,
                        Color.BLACK);
                    window.addShape(blackBar);

                    // Sets default length of bar to 100
                    int lengthOfBar = 100;

                    // Creates left side of blue
                    int blueLWidth = (int)(lengthOfBar * glyphs[num]
                        .getMajor()[0]);
                    int blueLX = blackX - blueLWidth;
                    int blueLY = initialY + 40;
                    Shape blueLeft = new Shape(blueLX, blueLY, blueLWidth, 15,
                        Color.blue);
                    window.addShape(blueLeft);

                    // Creates right side of blue
                    int blueRWidth = (int)(lengthOfBar * glyphs[num]
                        .getMajor()[1]);
                    int blueRX = blackX + 7;
                    int blueRY = initialY + 40;
                    Shape blueRight = new Shape(blueRX, blueRY, blueRWidth, 15,
                        Color.blue);
                    window.addShape(blueRight);

                    // Creates left side of green
                    int greenLWidth = (int)(lengthOfBar * glyphs[num]
                        .getMajor()[2]);
                    int greenLX = blackX - greenLWidth;
                    int greenLY = initialY + 55;
                    Shape greenLeft = new Shape(greenLX, greenLY, greenLWidth,
                        15, Color.GREEN);
                    window.addShape(greenLeft);

                    // Creates right side of green
                    int greenRWidth = (int)(lengthOfBar * glyphs[num]
                        .getMajor()[3]);
                    int greenRX = blackX + 7;
                    int greenRY = initialY + 55;
                    Shape greenRight = new Shape(greenRX, greenRY, greenRWidth,
                        15, Color.green);
                    window.addShape(greenRight);

                    // Creates left side of red
                    int redLWidth = (int)(lengthOfBar * glyphs[num]
                        .getMajor()[4]);
                    int redLX = blackX - redLWidth;
                    int redLY = initialY + 70;
                    Shape redLeft = new Shape(redLX, redLY, redLWidth, 15,
                        Color.red);
                    window.addShape(redLeft);

                    // Creates right side of red
                    int redRWidth = (int)(lengthOfBar * glyphs[num]
                        .getMajor()[5]);
                    int redRX = blackX + 7;
                    int redRY = initialY + 70;
                    Shape redRight = new Shape(redRX, redRY, redRWidth, 15,
                        Color.red);
                    window.addShape(redRight);

                    // Creates left side of yellow
                    int yellowLWidth = (int)(lengthOfBar * glyphs[num]
                        .getMajor()[6]);
                    int yellowLX = blackX - yellowLWidth;
                    int yellowLY = initialY + 85;
                    Shape yellowLeft = new Shape(yellowLX, yellowLY,
                        yellowLWidth, 15, Color.yellow);
                    window.addShape(yellowLeft);

                    // Creates right side of yellow
                    int yellowRWidth = (int)(lengthOfBar * glyphs[num]
                        .getMajor()[7]);
                    int yellowRX = blackX + 7;
                    int yellowRY = initialY + 85;
                    Shape yellowRight = new Shape(yellowRX, yellowRY,
                        yellowRWidth, 15, Color.yellow);
                    window.addShape(yellowRight);

                    if (num < 9) {
                        num++;
                    }

                }
                break;

            // NEW CASE
            case "region":
                num = 0;
                for (int i = 0; i < placements.length; i++) {
                    // Makes titles
                    String song = glyphs[num].getTitle();
                    int initialX = placements[i][0];
                    int initialY = placements[i][1];

                    TextShape title = new TextShape(0, initialY, song,
                        Color.BLACK);
                    int centerSong = center(initialX, song.length());
                    title.setX(centerSong);
                    title.setBackgroundColor(Color.WHITE);
                    window.addShape(title);

                    // Makes Artists
                    String a = glyphs[num].getAuthor();
                    TextShape artist = new TextShape(0, initialY + 20, a,
                        Color.BLACK);
                    int centerArtist = center(initialX, a.length());
                    artist.setX(centerArtist);
                    artist.setBackgroundColor(Color.WHITE);
                    window.addShape(artist);

                    int blackX = initialX + 75;
                    int blackY = initialY + 40;
                    Shape blackBar = new Shape(blackX, blackY, 7, 60,
                        Color.BLACK);
                    window.addShape(blackBar);

                    // Sets default length of bar to 100
                    int lengthOfBar = 100;

                    // Creates left side of blue
                    int blueLWidth = (int)(lengthOfBar * glyphs[num]
                        .getRegion()[0]);
                    int blueLX = blackX - blueLWidth;
                    int blueLY = initialY + 40;
                    Shape blueLeft = new Shape(blueLX, blueLY, blueLWidth, 15,
                        Color.blue);
                    window.addShape(blueLeft);

                    // Creates right side of blue
                    int blueRWidth = (int)(lengthOfBar * glyphs[num]
                        .getRegion()[1]);
                    int blueRX = blackX + 7;
                    int blueRY = initialY + 40;
                    Shape blueRight = new Shape(blueRX, blueRY, blueRWidth, 15,
                        Color.blue);
                    window.addShape(blueRight);

                    // Creates left side of green
                    int greenLWidth = (int)(lengthOfBar * glyphs[num]
                        .getRegion()[2]);
                    int greenLX = blackX - greenLWidth;
                    int greenLY = initialY + 55;
                    Shape greenLeft = new Shape(greenLX, greenLY, greenLWidth,
                        15, Color.GREEN);
                    window.addShape(greenLeft);

                    // Creates right side of green
                    int greenRWidth = (int)(lengthOfBar * glyphs[num]
                        .getRegion()[3]);
                    int greenRX = blackX + 7;
                    int greenRY = initialY + 55;
                    Shape greenRight = new Shape(greenRX, greenRY, greenRWidth,
                        15, Color.green);
                    window.addShape(greenRight);

                    // Creates left side of red
                    int redLWidth = (int)(lengthOfBar * glyphs[num]
                        .getRegion()[4]);
                    int redLX = blackX - redLWidth;
                    int redLY = initialY + 70;
                    Shape redLeft = new Shape(redLX, redLY, redLWidth, 15,
                        Color.red);
                    window.addShape(redLeft);

                    // Creates right side of red
                    int redRWidth = (int)(lengthOfBar * glyphs[num]
                        .getRegion()[5]);
                    int redRX = blackX + 7;
                    int redRY = initialY + 70;
                    Shape redRight = new Shape(redRX, redRY, redRWidth, 15,
                        Color.red);
                    window.addShape(redRight);

                    // Creates left side of yellow
                    int yellowLWidth = (int)(lengthOfBar * glyphs[num]
                        .getRegion()[6]);
                    int yellowLX = blackX - yellowLWidth;
                    int yellowLY = initialY + 85;
                    Shape yellowLeft = new Shape(yellowLX, yellowLY,
                        yellowLWidth, 15, Color.yellow);
                    window.addShape(yellowLeft);

                    // Creates right side of yellow
                    int yellowRWidth = (int)(lengthOfBar * glyphs[num]
                        .getRegion()[7]);
                    int yellowRX = blackX + 7;
                    int yellowRY = initialY + 85;
                    Shape yellowRight = new Shape(yellowRX, yellowRY,
                        yellowRWidth, 15, Color.yellow);
                    window.addShape(yellowRight);

                    if (num < 9) {
                        num++;
                    }

                }
                break;

            // NEW CASE
            case "hobby":
                num = 0;
                for (int i = 0; i < placements.length; i++) {
                    // Makes titles
                    String song = glyphs[num].getTitle();
                    int initialX = placements[i][0];
                    int initialY = placements[i][1];

                    TextShape title = new TextShape(0, initialY, song,
                        Color.BLACK);
                    int centerSong = center(initialX, song.length());
                    title.setX(centerSong);
                    title.setBackgroundColor(Color.WHITE);
                    window.addShape(title);

                    // Makes Artists
                    String a = glyphs[num].getAuthor();
                    TextShape artist = new TextShape(0, initialY + 20, a,
                        Color.BLACK);
                    int centerArtist = center(initialX, a.length());
                    artist.setX(centerArtist);
                    artist.setBackgroundColor(Color.WHITE);
                    window.addShape(artist);

                    int blackX = initialX + 75;
                    int blackY = initialY + 40;
                    Shape blackBar = new Shape(blackX, blackY, 7, 60,
                        Color.BLACK);
                    window.addShape(blackBar);

                    // Sets default length of bar to 100
                    int lengthOfBar = 100;

                    // Creates left side of blue
                    int blueLWidth = (int)(lengthOfBar * glyphs[num]
                        .getHobby()[0]);
                    int blueLX = blackX - blueLWidth;
                    int blueLY = initialY + 40;
                    Shape blueLeft = new Shape(blueLX, blueLY, blueLWidth, 15,
                        Color.blue);
                    window.addShape(blueLeft);

                    // Creates right side of blue
                    int blueRWidth = (int)(lengthOfBar * glyphs[num]
                        .getHobby()[1]);
                    int blueRX = blackX + 7;
                    int blueRY = initialY + 40;
                    Shape blueRight = new Shape(blueRX, blueRY, blueRWidth, 15,
                        Color.blue);
                    window.addShape(blueRight);

                    // Creates left side of green
                    int greenLWidth = (int)(lengthOfBar * glyphs[num]
                        .getHobby()[2]);
                    int greenLX = blackX - greenLWidth;
                    int greenLY = initialY + 55;
                    Shape greenLeft = new Shape(greenLX, greenLY, greenLWidth,
                        15, Color.GREEN);
                    window.addShape(greenLeft);

                    // Creates right side of green
                    int greenRWidth = (int)(lengthOfBar * glyphs[num]
                        .getHobby()[3]);
                    int greenRX = blackX + 7;
                    int greenRY = initialY + 55;
                    Shape greenRight = new Shape(greenRX, greenRY, greenRWidth,
                        15, Color.green);
                    window.addShape(greenRight);

                    // Creates left side of red
                    int redLWidth = (int)(lengthOfBar * glyphs[num]
                        .getHobby()[4]);
                    int redLX = blackX - redLWidth;
                    int redLY = initialY + 70;
                    Shape redLeft = new Shape(redLX, redLY, redLWidth, 15,
                        Color.red);
                    window.addShape(redLeft);

                    // Creates right side of red
                    int redRWidth = (int)(lengthOfBar * glyphs[num]
                        .getHobby()[5]);
                    int redRX = blackX + 7;
                    int redRY = initialY + 70;
                    Shape redRight = new Shape(redRX, redRY, redRWidth, 15,
                        Color.red);
                    window.addShape(redRight);

                    // Creates left side of yellow
                    int yellowLWidth = (int)(lengthOfBar * glyphs[num]
                        .getHobby()[6]);
                    int yellowLX = blackX - yellowLWidth;
                    int yellowLY = initialY + 85;
                    Shape yellowLeft = new Shape(yellowLX, yellowLY,
                        yellowLWidth, 15, Color.yellow);
                    window.addShape(yellowLeft);

                    // Creates right side of yellow
                    int yellowRWidth = (int)(lengthOfBar * glyphs[num]
                        .getHobby()[7]);
                    int yellowRX = blackX + 7;
                    int yellowRY = initialY + 85;
                    Shape yellowRight = new Shape(yellowRX, yellowRY,
                        yellowRWidth, 15, Color.yellow);
                    window.addShape(yellowRight);

                    if (num < 9) {
                        num++;
                    }

                }
                break;
            default:
                break;

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
        
    }


    /**
     * Uploads 9 glyphs from the songs based on the set number
     */
    public void populateGlyph() {
        for (int i = 0; i < 9; i++) {
            glyphs[i] = new Glyph(songs[set + i]);
        }
        displayGlyph();
    }


    /**
     * Click button that goes to previous legend
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedPrevButton(Button button) {
        set -= 9;
    }


    /**
     * Click button that goes to next legend
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedNextButton(Button button) {
        set += 9;
    }


    /**
     * Click button that represents legend by hobby
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedHobbyButton(Button button) {
        represent = "hobby";
        update();
    }


    /**
     * Click button that represents legend by major
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedMajorButton(Button button) {
        represent = "major";
        update();
    }


    /**
     * Click button that represents legend by region
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedRegionButton(Button button) {
        represent = "region";
        update();
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

}
