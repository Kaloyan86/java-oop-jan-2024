package p01_Database;

import javax.naming.OperationNotSupportedException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(1, 2, 3, 4, 5);
    }

    @Test
    public void test_Constructor_Should_Create_Correct_Object() {
        // AAA pattern
        // Arrange - done in setUp()
        Integer[] expectedArray = {1, 2, 3, 4, 5};

        // Act
        Integer[] actualArray = database.getElements();

        // Assert                expected,      actual
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Constructor_should_Throw_When_Elements_Greater_Than16() throws OperationNotSupportedException {
        Integer[] elements = new Integer[17];
        database = new Database(elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Constructor_should_Throw_When_Elements_Smaller_Than1() throws OperationNotSupportedException {
        database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Add_Should_Throw_When_Element_Null() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void test_Add_Should_Add_Element_OnTheLast_Position() throws OperationNotSupportedException {
        database.add(15);

        Integer[] elements = database.getElements();
        int size = elements.length;

        assertEquals(Integer.valueOf(15), elements[size - 1]);
    }

    @Test
    public void test_Add_Should_Increase_Elements_Count_When_Add_Element() throws OperationNotSupportedException {
        database.add(15);

        Integer[] elements = database.getElements();
        int size = elements.length;

        assertEquals(6, size);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Remove_Should_Throw_When_EmptyDatabase() throws OperationNotSupportedException {
        database = new Database();
        database.remove();
    }

    @Test
    public void test_Remove_Should_Remove_Successfully() throws OperationNotSupportedException {

        Integer[] elements = database.getElements();
        Integer removedElement = elements[elements.length - 1];

        database.remove();

        int actualSize = database.getElements().length;
        int expectedSize = 4;

        assertEquals(expectedSize, actualSize);
        assertEquals(Integer.valueOf(5), removedElement);
    }
}
