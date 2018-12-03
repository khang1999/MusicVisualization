// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Khang Nguyen (khang) Nathan Kim (nathank) Jason Hassold (jasonh44)
package prj5;

import CS2114.Window;
import java.util.Comparator;
import java.util.Scanner;
import java.util.*;
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
    private LinkedList<Person> people;
    private LinkedList<Song> songs;
    private LinkedList<Glyph> glyphs;


    /**
     * Constructor
     * Loads in data from SongList2018S.csv and MusicSurveyData2018S.csv
     * 
     * @param surveyDataFile
     *            file path to the survey data
     * @param musicFile
     *            file path to the music file
     */
    public DataProcessor(String surveyDataFile, String musicFile) {
        // Initialize fields
        people = new LinkedList<Person>();
        songs = new LinkedList<Song>();
        glyphs = new LinkedList<Glyph>();

        // Load in data
        loadSongs(musicFile);
        loadSurveys(surveyDataFile);

        calculateVotes();
    }


    /**
     * Loads in the songs
     */
    private void loadSongs(String musicFile) {
        // Load file into scanner
        Scanner songFile = null;
        try {
            songFile = new Scanner(new File(musicFile));

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
    }


    /**
     * Load in the survey data
     */
    private void loadSurveys(String surveyDataFile) {
        // Load file into scanner
        Scanner surveyFile = null;
        try {
            surveyFile = new Scanner(new File(surveyDataFile));

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
     * Get songs linkedlist to test
     * 
     * @return List of songs
     */
    public LinkedList<Song> getSongs() {
        return songs;
    }


    /**
     * Get people linkedlist to test
     * 
     * @return List of people
     */
    public LinkedList<Person> getPeople() {
        return people;
    }


    /**
     * Calculates votes
     */
    public void calculateVotes() {
        for (Person person : people) {
            int hobby = subgroupIndex(person.getHobby());
            int major = subgroupIndex(person.getMajor());
            int region = subgroupIndex(person.getRegion());

            for (int songPos = 0; songPos < songs.size(); songPos++) {
                Song song = songs.get(songPos);

                if (hobby != -1 && person.getVote(songPos * 2) != -1 && person
                    .getVote(songPos * 2 + 1) != -1) {
                    int[][] hobbyData = song.getHobbyData();
                    hobbyData[hobby][0] += person.getVote(songPos * 2);
                    hobbyData[hobby][1] += person.getVote(songPos * 2 + 1);
                    hobbyData[hobby][2]++;

                    song.setHobbyData(hobbyData);
                }

                if (major != -1 && person.getVote(songPos * 2) != -1 && person
                    .getVote(songPos * 2 + 1) != -1) {
                    int[][] majorData = song.getMajorData();
                    majorData[major][0] += person.getVote(songPos * 2);
                    majorData[major][1] += person.getVote(songPos * 2 + 1);
                    majorData[major][2]++;

                    song.setMajorData(majorData);
                }

                if (region != -1 && person.getVote(songPos * 2) != -1 && person
                    .getVote(songPos * 2 + 1) != -1) {
                    int[][] regionData = song.getRegionData();
                    regionData[region][0] += person.getVote(songPos * 2);
                    regionData[region][1] += person.getVote(songPos * 2 + 1);
                    regionData[region][2]++;

                    song.setRegionData(regionData);
                }
            }
        }
    }


    /**
     * Gets index position of category subgroup
     * example category: hobby
     * example subgroup: music
     * 
     * @param subgroup
     *            the subgroup of a category
     * @return the index position of the subgroup for the Song data feild array
     */
    private int subgroupIndex(String subgroup) {
        if (subgroup.equals("art") || subgroup.equals("Computer Science")
            || subgroup.equals("Northeast")) {
            return 0;
        }
        else if (subgroup.equals("music") || subgroup.equals("Math or CMDA")
            || subgroup.equals("Outside of United States")) {
            return 1;
        }
        else if (subgroup.equals("reading") || subgroup.equals(
            "Other Engineering") || subgroup.equals("Southeast")) {
            return 2;
        }
        else if (subgroup.equals("sports") || subgroup.equals("Other")
            || subgroup.equals(
                "United States (other than Southeast or Northwest)")) {
            return 3;
        }
        else {
            return -1;
        }
    }


    /**
     * swaps in array
     * 
     * @param a
     *            list
     * @param i
     *            first value
     * @param j
     *            second value
     */
    private static void swap(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    /**
     * Sorts based on comparator
     * 
     * @param c
     *            comparator
     * @return array list of songs
     */
    public Song[] sort(Comparator<Song> c) {
        Song[] s = (Song[])songs.toArray();
        int n = s.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (c.compare(s[j], s[j - 1]) < 0) {
                    swap(s, j, j - 1);
                }
                else {
                    break;
                }
            }
        }
        return s;
    }
}
