package controllers;

import com.google.gson.Gson;
import models.Customer;
import models.Reservation;
import models.TableTop;
import services.RestaurantServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RestaurantController {

    RestaurantServiceImpl rs;
    Gson gson = new Gson();

    public RestaurantController(RestaurantServiceImpl rs) throws SQLException, IOException {
        this.rs = rs;
    }


    //Customer operations
    public void getCustomerByID(HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalAccessException {

        String input = request.getAttribute("id").toString();
        int id = 0;
        if (input.matches("[0-9]+")){
            id = Integer.parseInt(input);
        }
        else {
            response.sendError(400, "ID is not a number");
            return;
        }

        Customer cus = rs.getCustomerByID(id);
        response.getWriter().append((cus != null) ? gson.toJson(cus) : "{}");
    }

    public void addCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalAccessException {
        BufferedReader reader = request.getReader();
        Customer cus = gson.fromJson(request.getReader(), Customer.class);

        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
        Customer c = rs.addCustomer(cus);
        response.getWriter().append((c != null) ? gson.toJson(c) : "{}");
    }

    public void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalAccessException {
        Customer cus = gson.fromJson(request.getReader(), Customer.class);
        cus.setId((int) request.getAttribute("id"));

        cus = rs.updateCustomer(cus);

        response.getWriter().append((cus != null) ? gson.toJson(cus) : "{}");

    }

    public void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, IOException {

        int id = (int) request.getAttribute("id");
        Customer c = rs.deleteCustomer(id);
//        System.out.println("Removed: " + c);
        response.getWriter().append("Removed Customer: ").append(gson.toJson(c));
//        response.setStatus(204);
    }

    public void allCustomers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Customer> customers = rs.getAllCustomers();

        response.getWriter().append((customers != null) ? gson.toJson(customers) : "{}");
    }


    //Table operations
    public void getTableByID(HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalAccessException {

        String input = request.getAttribute("id").toString();
        int id = 0;
        if (input.matches("[0-9]+")){
            id = Integer.parseInt(input);
        }
        else {
            response.sendError(400, "ID is not a number");
            return;
        }

        TableTop top = rs.getTableByID(id);
        response.getWriter().append((top != null) ? gson.toJson(top) : "{}");
    }

    public void addTable(HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalAccessException {
        BufferedReader reader = request.getReader();
        TableTop top = gson.fromJson(reader, TableTop.class);

        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
        TableTop t = rs.addTable(top);
        response.getWriter().append((t != null) ? gson.toJson(t) : "{}");
    }

    public void updateTable(HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalAccessException {
        TableTop top = gson.fromJson(request.getReader(), TableTop.class);
        top.setId((int) request.getAttribute("id"));

        top = rs.updateTable(top);

        response.getWriter().append((top != null) ? gson.toJson(top) : "{}");

    }

    public void deleteTable(HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalAccessException {

        int id = (int) request.getAttribute("id");
        TableTop top = rs.deleteTable(id);
        response.getWriter().append("Removed TableTop: ").append(gson.toJson(top));
    }


    public void allTables(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<TableTop> tables = rs.getAllTables();

        response.getWriter().append(gson.toJson(tables));
    }



    ///Reservation
    public void getReservation(HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalAccessException {
        int id = 0;
        String input = request.getAttribute("id").toString();
        if (input.matches("[0-9]+")){
            id = Integer.parseInt(input);
        }
        else {
            response.sendError(400, "ID invalid");
        }
        Reservation r = rs.getReservation(id);
        response.getWriter().append((r != null) ? (gson.toJson(r) ) : "{}");
    }

    public void viewReservations(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, IOException {
        String input = request.getAttribute("id").toString();
        int id = 0;
        if (input.matches("[0-9]+")){
            id = Integer.parseInt(input);
        }
        else {
            response.sendError(400, "ID not found");
            return;
        }
        String s = rs.viewReservations(id);
        response.getWriter().append((s != null) ? gson.toJson(s) : "{}");
    }
}
