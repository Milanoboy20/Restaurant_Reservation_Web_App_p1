package modeltests;

import models.TableTop;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class TableTopTest {
    private static TableTop top;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All Tests Start!");
        top = new TableTop();
        top.setId(2);
        top.setTableSize(6);
        top.setTableSide("Upper");
        top.setAvailable(true);
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("\nAfter All Tests Print!");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("After each Test Print!");
    }

    @Test
    public void tableID(){
        System.out.println("\nTable ID retrieval Test");
        int expected = 2, actual = top.getId();
        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + "  Actual: " + actual);

    }

    @Test
    public void tableSize(){
        System.out.println("\nTable Size retrieval Test");
        int expected = 6, actual = top.getTableSize();
        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + "  Actual: " +actual);
    }

    @Test
    public void tableSide(){
        System.out.println("\nTable Side retrieval Test");
        String expected = "Upper", actual = top.getTableSide();
        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + "  Actual: " + actual);
    }

    @Test
    public void available(){
        System.out.println("\nTable available retrieval Test");
        boolean expected = true, actual = top.isAvailable();
        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + "  Actual: " + actual);
    }

    @Test
    public void cons1(){
        System.out.println("\nConstructor 1 Test!(Includes table ID)");
        TableTop top = new TableTop(5, 4, "Lower", true);
        assertInstanceOf(TableTop.class, top);
        System.out.println(top);
        System.out.println("Constructor 1 passed!");
    }

    @Test
    public void cons2(){
        System.out.println("\nConstructor 2 Test!(No table ID)");
        TableTop top = new TableTop(2, "Upper", false);
        assertInstanceOf(TableTop.class, top);
        System.out.println(top);
        System.out.println("Constructor 2 passed!");
    }

    @Test
    public void toStringTest(){
        System.out.println("\ntoString() method test");
        System.out.println(top.toString());
        System.out.println("Method passed!");
    }
}
