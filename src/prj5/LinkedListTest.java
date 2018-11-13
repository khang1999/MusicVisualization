// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Khang Nguyen (khang) Nathan Kim (nathank) Jason Hassold (jasonh44)
package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * Test Class for LinkedList
 * @author khang, nathank, jasonh44
 * @version 12.11.2018
 */
public class LinkedListTest extends TestCase {
    // Fields
    private LinkedList<String> empty;
    private LinkedList<String> list;
    
    /**
     * Constructor
     */
    public LinkedListTest() {
        // This was left blank intentionally
    }
    
    /**
     * Set up
     */
    public void setUp() {
        empty = new LinkedList<String>();
        list = new LinkedList<String>();
        
        list.add("soccer");
        list.add("swimming");
        list.add("gymnastics");
    }
    
    /**
     * Test for add(obj) method illegal argument exception
     */
    public void testAddIllegalArgument() {
        Exception exception = null;
        try {
            list.add(null);
            fail("add(obj) isn't throwing an illegal argument "
                + "exception when null");
        }
        catch (Exception e) {
            exception = e;
        }
        
        assertTrue("add(obj) is throwing the wrong exception when null", 
            exception instanceof IllegalArgumentException);
    }
    
    /**
     * Test for add(obj) method
     */
    public void testAdd() {
        list.add("test");
        
        assertEquals("test", list.get(3));
    }
    
    /**
     * Test for isEmpty() method
     */
    public void testIsEmpty() {
        assertTrue(empty.isEmpty());
        
        assertFalse(list.isEmpty());
    }
    
    /**
     * Test for remove(obj) method
     */
    public void testRemoveObj() {
        assertFalse(empty.remove("test"));
        
        assertFalse(list.remove("test"));
        assertEquals(3, list.size());
        
        assertTrue(list.remove("soccer"));
        assertEquals(2, list.size());
        
        assertTrue(list.remove("swimming"));
        assertEquals(1, list.size());
        
        assertTrue(list.remove("gymnastics"));
        assertEquals(0, list.size());
    }
    
    /**
     * Test for remove(index) method out of bounds exception
     */
    public void testRemoveIndexOutOfBounds() {
        Exception exception = null;
        try {
            list.remove(-1);
            fail("remove(index) isn't throwing an index out of bounds error "
                + "when it sould for -1");
        }
        catch (Exception e) {
            exception = e;
        }
        
        assertTrue("remove(index) is throwing the wrong expection for -1", 
            exception instanceof IndexOutOfBoundsException);
        
        try {
            list.remove(3);
            fail("remove(index) isn't throwing an index out of bounds error "
                + "when it sould for the size");
        }
        catch (Exception e) {
            exception = e;
        }
        
        assertTrue("remove(index) is throwing the wrong expection "
                    + "for the size", 
                    exception instanceof IndexOutOfBoundsException);
        
        try {
            empty.remove(0);
            fail("remove(index) isn't throwing an index out of bounds error "
                + "when it sould for empty");
        }
        catch (Exception e) {
            exception = e;
        }
        
        assertTrue("remove(index) is throwing the wrong expection for empty", 
                    exception instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Test for remove(index) method
     */
    public void testRemoveIndex() {
        assertTrue(list.remove(1));
        assertEquals(2, list.size());
        assertEquals("soccer", list.get(0));
        assertEquals("gymnastics", list.get(1));
        
        assertTrue(list.remove(0));
        assertEquals(1, list.size());
        assertEquals("gymnastics", list.get(0));
        
        assertTrue(list.remove(0));
        assertEquals(0, list.size());
    }
    
    /**
     * Test for get() method out of bounds exception
     */
    public void testGetOutOfBounds() {
        Exception exception = null;
        try {
            list.get(-1);
            fail("get(index) isn't throwing an index out of bounds error "
                + "when it sould for -1");
        }
        catch (Exception e) {
            exception = e;
        }
        
        assertTrue("get(index) is throwing the wrong expection for -1", 
            exception instanceof IndexOutOfBoundsException);
        
        try {
            list.get(3);
            fail("get(index) isn't throwing an index out of bounds error "
                + "when it sould for the size");
        }
        catch (Exception e) {
            exception = e;
        }
        
        assertTrue("get(index) is throwing the wrong expection "
                    + "for the size", 
                    exception instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Test for get() method 
     */
    public void testGet() {
        assertEquals("soccer", list.get(0));
        
        assertEquals("swimming", list.get(1));
        
        assertEquals("gymnastics", list.get(2));
    }
    
    /**
     * Test for contains() method
     */
    public void testContains() {
        assertFalse(list.contains("test"));
        
        assertTrue(list.contains("gymnastics"));
    }
    
    /**
     * Test for clear() method
     */
    public void testClear() {
        list.clear();
        
        assertEquals(0, list.size());
    }
    
    /**
     * Test for iterator method next()
     */
    public void testIteratorNext() {
        Iterator<String> it = list.iterator();
        assertEquals("soccer", it.next());
        
        it.next();
        it.next();
        
        Exception exception = null;
        try {
            it.next();
            fail("iterator next() method did not throw exception");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("iterator next() did not throw the right exception", 
            exception instanceof NoSuchElementException);
    }
    
    /**
     * Test for iterator method hasNext()
     */
    public void testIteratorHasNext() {
        assertFalse(empty.iterator().hasNext());
        
        Iterator<String> it = list.iterator();
        assertTrue(it.hasNext());
        it.next();
        it.next();
        it.next();
        assertFalse(it.hasNext());
    }
}
