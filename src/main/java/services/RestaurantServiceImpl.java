package services;

import models.Customer;
import models.Reservation;
import models.TableTop;
import orm.ORM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class RestaurantServiceImpl {

    private final ORM<String> dud = new ORM<>(String.class);
    private final ORM<Reservation> revDB = new ORM<>(Reservation.class);
    private final ORM<Customer> cusDB = new ORM<>(Customer.class);
    private final ORM<TableTop> tableDB = new ORM<>(TableTop.class);



    public RestaurantServiceImpl() throws SQLException, IOException {

    }


    public String viewReservations(int cusID) throws IllegalAccessException {
        List<Reservation> reservs = revDB.selectAll(new Reservation());
        Customer cus = cusDB.selectByID(new Customer(), cusID);
        StringBuilder sb = new StringBuilder();
        TableTop top;

        sb.append("Name: ").append(cus.getFirstname()).append(" ").append(cus.getLastname()).append("  || Phone: ").append(cus.getPhone()).append(" || Email: ").append(cus.getEmail());
        for (Reservation r : reservs){
            if (r.getCustomerID() == cus.getId()){
                top = tableDB.selectByID(new TableTop(), r.getTableID());
                sb.append("TableSize: ").append(top.getTableSize()).append(" || Side: ").append(top.getTableSide()).append(" || Reservation Date: ").append(new Date(r.getDate()));
            }
        }
        return sb.toString();
    }


    public Reservation getReservation(int id) throws IllegalAccessException {
        return revDB.selectByID(new Reservation(), id);
    }



    //Customer Services
    public Customer getCustomerByID(int id) throws IllegalAccessException {
        Customer t;
        List<Customer> customers = cusDB.selectAll(new Customer());
        Stream<Customer> cuzz = customers.stream().filter(customer -> customer.getId() == id);
        t = cuzz.findFirst().get();
        return t;
    }

    public Customer addCustomer(Customer cus) throws IllegalAccessException {
        return cusDB.create(cus);
    }

    public Customer updateCustomer(Customer cus) throws IllegalAccessException {
        return cusDB.update(cus);
    }

    public Customer deleteCustomer(int id) throws IllegalAccessException {
        return cusDB.deleteByID(new Customer(), id);
    }

    public List<Customer> getAllCustomers() {
        return cusDB.selectAll(new Customer());
    }



    //Table Services
    public TableTop getTableByID(int id) throws IllegalAccessException {
        return tableDB.selectByID(new TableTop(), id);
    }

    public TableTop addTable(TableTop top) throws IllegalAccessException {
        return tableDB.create(top);
    }

    public List<TableTop> getAllTables() {
        return tableDB.selectAll(new TableTop());
    }

    public TableTop deleteTable(int id) throws IllegalAccessException {
        return tableDB.deleteByID(new TableTop(), id);
    }

    public TableTop updateTable(TableTop top) throws IllegalAccessException {
        return tableDB.update(top);
    }

}


