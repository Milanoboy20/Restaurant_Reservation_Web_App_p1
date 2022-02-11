package modeltests;

import models.Customer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    private static Customer customer;

    @BeforeAll
    public static void beforeTest() {
        System.out.println("Before All Tests Start!");
        customer = new Customer();
        customer.setId(12);
        customer.setFirstname("Mallam");
        customer.setLastname("Sadat");
        customer.setPhone("785693258");
        customer.setEmail("mallam@gmail.com");
    }

    @AfterAll
    public static void afterTest() {
        System.out.println("\nAfter all Tests Print!");
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("After each Test Print!");
    }

    @Test
    public void cusID(){
        System.out.println("\nCustomer ID retrieval test");
        int expected = 12, actual = customer.getId();
        assertEquals(expected, actual);
        System.out.println("Expected CusID: " + expected + "   Actual CusID: " + actual);
    }

    @Test
    public void firstname(){
        System.out.println("\nCustomer fist name retrieval test.");
        String expected = "Mallam", actual = customer.getFirstname();
        assertTrue(expected.equals(actual));
        System.out.println("Expected: " + expected + "  Actual: " + actual);
    }

    @Test
    public void lastName() {
        System.out.println("\nCustomer last name retrieval test");
        String expected = "Sadat", actual = customer.getLastname();
        assertTrue(expected.equals(actual));
        System.out.println("Expected: " + expected + "  Actual: " +actual);
    }

    @Test
    public void phone() {
        System.out.println("\nCustomer phone retrieval test");
        String expected = "785693258", actual = customer.getPhone();
        assertTrue(expected.equals(actual));
        System.out.println("Expected #: " + expected + "  Actual #: " + actual);
    }

    @Test
    public void email() {
        System.out.println("\nCustomer email retrieval test");
        String expected = "mallam@gmail.com", actual = customer.getEmail();
        assertTrue(expected.equals(actual));
        System.out.println("Expected: " + expected + "  Actual: " + actual);
    }

    @Test
    public void toStringTest(){
        System.out.println("\nCustomer toString() Method test!");
        System.out.println(customer.toString());
        System.out.println("Method prints full customer info");
    }

    @Test
    public void cons1(){
        System.out.println("\n1st Constructor test");
        Customer cus = new Customer(2, "Sam", "Koi","896352741", "smakoi@yahoo.com");
        assertInstanceOf(Customer.class, cus);
        System.out.println(cus);
        System.out.println("Constructor 1 passed!");
    }

    @Test
    public void cons2(){
        System.out.println("\n2nd Constructor test");
        Customer cus = new Customer("James", "Taylor", "785469314", "james@gmail.com");
        assertInstanceOf(Customer.class, cus);
        System.out.println("Constructor 2 has no ID(set to 0)");
        System.out.println("Constructor 2 passed!");
    }
}
