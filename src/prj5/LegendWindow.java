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

/**
 * Creates window that displays legend and glyphs
 * 
 * @author Nathan Kim, Khang Nguyen, Jason Hassold
 * @version 11.12.2018
 * 
 */
public class LegendWindow {
    // fields
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
    private Shape legend;
    private Shape outline;

    // Constructor
    /**
     * Creates a new LegendWindow
     */
    public LegendWindow() {
        window = new Window();
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
        outline = new Shape(200, 100, 100, 200, Color.BLACK);
        window.addShape(outline);   
        legend = new Shape(500, 100, 50, 150, Color.RED);
        window.addShape(legend);
    }


    // Method
    /**
     * Click button that sorts songs by Artist alphabetically
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedSortArtist(Button button) {

    }


    /**
     * Click button that sorts songs by song title alphabetically
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedSortSong(Button button) {

    }


    /**
     * Click button that sorts songs by genre alphabetically
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedSortGenre(Button button) {

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

    }


    /**
     * Click button that represents legend by major
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedMajorButton(Button button) {

    }


    /**
     * Click button that represents legend by region
     * 
     * @param button
     *            Button that is clicked
     */
    public void clickedRegionButton(Button button) {

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
