package archeologicalExcavations;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ExcavationTests {

    private static final String EXPECTED_NAME = "Excavation";
    private static final int EXPECTED_CAPACITY = 10;
    private static final int EXPECTED_COUNT = 0;
    private static final Archaeologist ARCHAEOLOGIST =
    new Archaeologist("Pesho", 100);
    private Excavation excavation;

    @Before
    public void setUp() {
        excavation = new Excavation(EXPECTED_NAME, EXPECTED_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrow_When_Name_Empty() {
        excavation = new Excavation("", EXPECTED_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrow_When_Name_Blank() {
        excavation = new Excavation("        ", EXPECTED_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldThrow_When_Name_Null() {
        excavation = new Excavation(null, EXPECTED_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_ShouldThrow_When_Capacity_Negative() {
        excavation = new Excavation(EXPECTED_NAME, -10);
    }

    @Test
    public void test_Constructor_Should_Create_CorrectObject() {

        int actualCapacity = excavation.getCapacity();
        String actualName = excavation.getName();
        int actualCount = excavation.getCount();

        assertEquals(EXPECTED_CAPACITY, actualCapacity);
        assertEquals(EXPECTED_NAME, actualName);
        assertEquals(EXPECTED_COUNT, actualCount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddArchaeologist_Should_Throw_When_NoCapacity() {
        excavation = new Excavation(EXPECTED_NAME, 1);

        Archaeologist archaeologist2 = new Archaeologist("Kaloyan", 5);

        //        Archaeologist archaeologist1 = Mockito.mock(Archaeologist.class);
        //        Archaeologist archaeologist2 = Mockito.mock(Archaeologist.class);
        //
        //        Mockito.when(archaeologist1.getName()).thenReturn("Pesho");

        excavation.addArchaeologist(ARCHAEOLOGIST);
        excavation.addArchaeologist(archaeologist2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddArchaeologist_Should_Throw_When_Archeologist_Duplicated() {

        excavation.addArchaeologist(ARCHAEOLOGIST);
        excavation.addArchaeologist(ARCHAEOLOGIST);
    }

    @Test
    public void test_AddArchaeologist_Should_Add_Successfully() {

        excavation.addArchaeologist(ARCHAEOLOGIST);

        int actualCount = excavation.getCount();

        assertEquals(1, actualCount);
    }

    @Test
    public void test_RemoveArchaeologist_Should_Remove_Successfully() {
        excavation.addArchaeologist(ARCHAEOLOGIST);

        boolean isRemoved = excavation.removeArchaeologist("Pesho");

        assertTrue(isRemoved);
    }

    @Test
    public void test_RemoveArchaeologist_Should_Remove_Unsuccessfully() {
        boolean isRemoved = excavation.removeArchaeologist("Pesho");

        assertFalse(isRemoved);
    }
}
