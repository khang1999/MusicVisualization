// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Khang Nguyen (khang) Nathan Kim (nathank) Jason Hassold ()
package prj5;

/**
 * Individual information on survey results from students
 * 
 * @author khang, jasonh44
 * @version 2018.12.11
 */
public class Person {
    private int id;
    private String date;
    private String hobby;
    private String major;
    private String region;
    private int[] votes;


    /**
     * Creates a new Person object
     * 
     * @param id
     * @param date
     * @param hobby
     *            Student's hobby (read, art, sports, music)
     * @param major
     *            Major of student (Computer Science, Other Engineering, Math or
     *            CMDA, Other)
     * @param region
     *            Region of student residence (Northeast US, Southeast US, the
     *            rest of the US, outside of the US)
     * @param votes
     *            The integer array containing votes of 0 for no and 1 for yes
     */
    public Person(
        int id,
        String date,
        String hobby,
        String major,
        String region,
        int[] votes) {
        this.id = id;
        this.date = date;
        this.hobby = hobby;
        this.major = major;
        this.region = region;
        this.votes = votes;
    }


    /**
     * Get the id from person
     * 
     * @return id from person
     */
    public int getId() {
        return id;
    }

    /**
     * Get the date submitted for person
     * @return date of person
     */
    public String getDate() {
        return date;
    }
    
    /**
     * Get major of person
     * @return major of person
     */
    public String getMajor() {
        return major;
    }
    
    /**
     * Get region of person
     * @return persons region
     */
    public String getRegion() {
        return region;
    }
    
    /**
     * Get hobby of person
     * @return persons hobby
     */
    public String getHobby() {
        return hobby;
    }
    
    /**
     * Get a specific vote for this person
     * @param index  the index of the vote to get
     * @return the vote at the index
     * @throws IndexOutOfBoundsException
     *          if the index is out of range
     */
    public int getVote(int index) {
        if (index >= 0 && index < votes.length) {
            return votes[index];
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }
}
