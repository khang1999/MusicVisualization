// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Khang Nguyen (khang) Nathan Kim (nathank) Jason Hassold ()
package prj5;

import student.TestCase;

/**
 * Test class for Person
 * 
 * @author nathank
 * @version 11.12.2018
 *
 */
public class PersonTest extends TestCase {
    private Person person;


    /**
     * Setup method
     */
    public void setUp() {
        person = new Person(10, "1/1/2018", "read", "Computer Science",
            "Northeast US", new int[] { 1, 0, 1, -1, 1 });
    }


    /**
     * Test getId()
     */
    public void testGetId() {
        assertEquals(person.getId(), 10);
    }


    /**
     * Test getDate()
     */
    public void testGetDate() {
        assertEquals(person.getDate(), "1/1/2018");
    }


    /**
     * Test getMajor()
     */
    public void testGetMajor() {
        assertEquals(person.getMajor(), "Computer Science");
    }


    /**
     * Test getRegion()
     */
    public void testGetRegion() {
        assertEquals(person.getRegion(), "Northeast US");
    }


    /**
     * Test getHobby() {
     */
    public void testGetHobby() {
        assertEquals(person.getHobby(), "read");
    }


    /**
     * Test getVote()
     */
    public void testGetVote() {
        Exception exception = null;
        try {
            person.getVote(-1);
            fail("getVote() did not throw an exception when index is less "
                + "than 0");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("getVote() did not throw an IndexOutOfBoundsException when "
            + "index is less 0",
            exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            person.getVote(5);
            fail("getVote() did not throw an exception when index is greater "
                + "than length - 1");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("getVote() did not throw an IndexOutOfBoundsException when "
            + "index is greater than length - 1",
            exception instanceof IndexOutOfBoundsException);

        assertEquals(1, person.getVote(0));
        assertEquals(0, person.getVote(1));
        assertEquals(-1, person.getVote(3));
    }

}
