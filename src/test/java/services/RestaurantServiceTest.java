package services;

import org.junit.jupiter.api.*;
import orm.ORM;
import models.Customer;
import models.Reservation;
import models.TableTop;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RestaurantServiceTest {

    private static Customer customer, cus;
    private static TableTop table, tab;
    private static Reservation rev;
    private static ORM<Customer> cusDB;
    private static ORM<TableTop> top;
    private static ORM<Reservation> resv;
    private static RestaurantServiceImpl rs;

    static {
        try {
            cusDB = new ORM<>(Customer.class);
            top   = new ORM<>(TableTop.class);
            resv  = new ORM<>(Reservation.class);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void beforeAll() throws SQLException, IOException {
        System.out.println("Before All Tests Start!");
        customer = new Customer("FirstTest", "lastTest", "0101010101", "test@test.com");
        table    = new TableTop(100, "Upper", true);
        rev      = new Reservation();
        rs       = new RestaurantServiceImpl();
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("After All Tests!");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("After Each Test!");
    }

    @Test
    public void addService() throws IllegalAccessException {
        System.out.println("\nService to add data");
        cus = rs.addCustomer(customer);
        tab = rs.addTable(table);
        Assertions.assertInstanceOf(Customer.class, cus);
        Assertions.assertInstanceOf(TableTop.class, tab);
        System.out.println(cus);
        System.out.println(tab);
    }

    @Test
    public void serviceByID() throws IllegalAccessException {
        System.out.println("\nGetting by ID service");
        Customer cc = rs.getCustomerByID(2);
        TableTop tt = rs.getTableByID(3);
        Assertions.assertInstanceOf(Customer.class, cc);
        Assertions.assertInstanceOf(TableTop.class, tt);
        System.out.println(cc);
        System.out.println(tt);
    }

    @Test
    public void updateService() throws IllegalAccessException {
        System.out.println("\nService to update");
        cus.setFirstname("SecondTest");
        tab.setTableSide("Lower");
        cus = rs.updateCustomer(cus);
        tab = rs.updateTable(tab);
        Assertions.assertEquals("SecondTest", cus.getFirstname());
        Assertions.assertEquals("Lower", tab.getTableSide());
        System.out.println(cus);
        System.out.println(tab);
    }

    @Test
    public void listService(){
        System.out.println("\nService to get List of data");
        List<Customer> cs = rs.getAllCustomers();
        List<TableTop> tb = rs.getAllTables();
        System.out.println("Customers: \n" + cs);
        System.out.println("Tables: \n" + tb);
        Assertions.assertInstanceOf(Customer.class, cs.get(0));
        Assertions.assertInstanceOf(TableTop.class, tb.get(0));

    }

    @Test
    public void deleteService() throws IllegalAccessException {
        System.out.println("\nDeletion Service");
        TableTop t = rs.deleteTable(tab.getId());
        Customer c = rs.deleteCustomer(cus.getId());
        Assertions.assertInstanceOf(Customer.class, c);
        Assertions.assertInstanceOf(TableTop.class, t);
        System.out.println("Deleted : \n" + c + " \n" + t);
    }

    @Test
    public void viewReservation() throws IllegalAccessException {
        System.out.println("\nView Reservation Service Test");
        System.out.println("Reservation Info: \n" + rs.viewReservations(2));
    }

}
