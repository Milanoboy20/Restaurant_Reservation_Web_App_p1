package modeltests;

import models.Reservation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class ReservationTest {

    private static Reservation rev;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All Tests Start!");
        rev = new Reservation();
        rev.setId(8);
        rev.setTableID(2);
        rev.setCustomerID(20);
        rev.setDate(1643000400000L);
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("\nAfter All Tests Print!");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("After Each Test Print!");
    }

    @Test
    public void revID(){
        System.out.println("\nReservation ID retrieval Test");
        int expected = 8, actual = rev.getId();
        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + "  Actual: " + actual);
    }

    @Test
    public void revCusID(){
        System.out.println("\nReservation customer ID retrieval Test");
        int expected = 20, actual = rev.getCustomerID();
        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + "  Actual: " + actual);
    }

    @Test
    public void revTabID(){
        System.out.println("\n" +
                "Reservation Table ID retrieval Test");
        int expected = 2, actual = rev.getTableID();
        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + "  Actual: " + actual);
    }

    @Test
    public void revDate(){
        System.out.println("\nReservation Date retrieval Test");
        long expected = 1643000400000L, actual = rev.getDate();
        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " Actual: " + actual);
    }

    @Test
    public void toStringTest(){
        System.out.println("\ntoString() method Test");
        System.out.println(rev.toString());
        System.out.println("Method passed!");
    }

    @Test
    public void cons1(){
        System.out.println("\nConstructor 1 Test");
        Reservation rev = new Reservation(5, 10, 6, 1683000500000L);
        assertInstanceOf(Reservation.class, rev);
        System.out.println(rev);
        System.out.println("Constructor 1 Passed!");
    }

    @Test
    public void cons2(){
        System.out.println("\nConstructor 2 Test(No Reservation ID/set to 0)");
        Reservation rev = new Reservation(16, 4, 1698005200000L);
        assertInstanceOf(Reservation.class, rev);
        System.out.println(rev);
        System.out.println("Constructor 2 passed!");
    }
}
