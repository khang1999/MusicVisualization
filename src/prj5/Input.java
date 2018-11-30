// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- Khang Nguyen (khang) Nathan Kim (nathank) Jason Hassold (jasonh44)
package prj5;

import CS2114.Button;

/**
 * Displays the functionality of LegendWindow 
 * @author Nathan Kim, Khang Nguyen, Jason Hassold
 * @version 11.12.2018
 *
 */
public class Input {
    /**
     * Input default constructor
     */
    public Input() {
        
    }
    
    /**
     * Main Method
     */
    public static void main(String[] args) {
        LegendWindow wind = new LegendWindow(args[0], args[1]);
        wind.clickedHobbyButton(new Button());
        //wind.clickedSortSong(new Button());
        wind.update(); //hello
    }
}
