package p02_ExtendedDatabase;

import javax.naming.OperationNotSupportedException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ExtendedDatabaseTest {

    private static final Person PERSON1 = Mockito.mock(Person.class);
    private static final Person PERSON2 = Mockito.mock(Person.class);
    private static final Person PERSON3 = Mockito.mock(Person.class);
    private static final Person[] EXPECTED_PEOPLE = {PERSON1, PERSON2, PERSON3};

    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(EXPECTED_PEOPLE);
    }

    @After
    public void tearDown() {
        Mockito.reset(PERSON1, PERSON2, PERSON3);
    }

    @Test
    public void test_Constructor_Should_Create_Correct_Object() {
        Person[] actualPeople = database.getElements();

        assertArrayEquals(EXPECTED_PEOPLE, actualPeople);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Constructor_should_Throw_When_Elements_Greater_Than16() throws OperationNotSupportedException {
        database = new Database(new Person[20]);
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
        Person mockedPerson = Mockito.mock(Person.class);

        database.add(mockedPerson);

        Person[] people = database.getElements();
        int actualCount = people.length;

        assertEquals("Person is not added correctly!", mockedPerson, people[actualCount - 1]);
    }

    @Test
    public void test_Add_Should_Increase_Elements_Count_When_Add_Element() throws OperationNotSupportedException {
        Person mockedPerson = Mockito.mock(Person.class);

        //        Mockito.when(mockedPerson.getUsername()).thenReturn("Kaloyan");
        //        Mockito.when(mockedPerson.getId()).thenReturn(1);
        //
        //        System.out.println(mockedPerson.getId());
        //        System.out.println(mockedPerson.getUsername());

        database.add(mockedPerson);

        Person[] people = database.getElements();
        int actualCount = people.length;

        assertEquals("Invalid people count!", 4, actualCount);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Remove_Should_Throw_When_EmptyDatabase() throws OperationNotSupportedException {
        database = new Database();
        database.remove();
    }

    @Test
    public void test_Remove_Should_Remove_Successfully() throws OperationNotSupportedException {
        Person removedPerson = database.getElements()[2];

        database.remove();

        assertEquals(PERSON3, removedPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByUserName_Should_Throw_When_Username_Null() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByUserName_Should_Throw_When_Username_NotPresent() throws OperationNotSupportedException {
        database.findByUsername("Peter");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByUserName_Should_Throw_When_Duplicated_Persons() throws OperationNotSupportedException {
        Mockito.when(PERSON1.getUsername()).thenReturn("Kaloyan");
        Mockito.when(PERSON2.getUsername()).thenReturn("Kaloyan");

        database.findByUsername("Kaloyan");
    }

    @Test
    public void test_FindByUserName_Should_Return_CorrectPerson() throws OperationNotSupportedException {
        Mockito.when(PERSON1.getUsername()).thenReturn("Kaloyan");

        Person actualPerson = database.findByUsername("Kaloyan");

        assertEquals(PERSON1, actualPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_FindById_Should_Throw_When_Duplicated_Persons() throws OperationNotSupportedException {
        Mockito.when(PERSON1.getId()).thenReturn(1);
        Mockito.when(PERSON2.getId()).thenReturn(1);

        database.findById(1);
    }

    @Test
    public void test_FindById_Should_Return_CorrectPerson() throws OperationNotSupportedException {
        Mockito.when(PERSON1.getId()).thenReturn(1);

        Person actualPerson = database.findById(1);

        assertEquals(PERSON1, actualPerson);
    }

}
