package servlets;

import controllers.RestaurantController;
import services.RestaurantServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class RequestHelper {

   static RestaurantServiceImpl rs;
    static {
        try {
            rs = new RestaurantServiceImpl();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }


    static RestaurantController rc;
    static {
        try {
            rc = new RestaurantController(rs);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }



    public static void getProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        System.out.println(uri);


        String[] uriTokens = uri.split("/");
        if (uriTokens.length <= 2){
            response.sendError(400, "BAD REQUEST");
        }
        else if (uriTokens.length == 3){
            if ("customers".equals(uriTokens[2])){
                rc.allCustomers(request, response);
            }
            else if ("tables".equals(uriTokens[2])) rc.allTables(request, response);
            else response.sendError(400, "Collection does not exist");
        }
        else if (uriTokens.length == 4){
            request.setAttribute("id", uriTokens[3]);
            if (("customers").equals(uriTokens[2])) {
                try {
                    rc.getCustomerByID(request, response);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if ("view".equals(uriTokens[2])){
                try {
                    rc.viewReservations(request, response);
                }
                catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }

            if ("reservation".equals(uriTokens[2])){
                try {
                    rc.getReservation(request, response);
                }
                catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }

            if (("tables").equals(uriTokens[2])) {
                try {
                    rc.getTableByID(request, response);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            response.sendError(404);
        }


    }

    public static void postProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getRequestURI();
        String[] uriTokens = uri.split("/");

        switch (uriTokens.length){
            case 0:
            case 1:
            case 2:
                response.sendError(400);
                break;

            case 3: {
                if ("customers".equals(uriTokens[2])) {
                    try {
                        rc.addCustomer(request, response);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                else if("tables".equals(uriTokens[2])) {
                    try {
                        rc.addTable(request, response);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                else response.sendError(400, "Collection does not exist");
                break;
            }
            default:
                response.sendError(404);
        }
    }

    public static void putProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalAccessException {
        String uri = request.getRequestURI();
        String[] uriTokens = uri.split("/");

        switch (uriTokens.length){
            case 0:
            case 1:
            case 2:{
                response.sendError(400);
                break;
            }
            case 4: {
                int id = 0;
                String input = uriTokens[3];
                if (input.matches("[0-9]+")){
                    id = Integer.parseInt(input);
                } else {
                    response.sendError(400, "ID not found");
                }
                request.setAttribute("id", id);
                if ("customers".equals(uriTokens[2])) rc.updateCustomer(request, response);
                else if ("tables".equals(uriTokens[2])) rc.updateTable(request, response);
                else response.sendError(400, "ID does not exist");
                break;
            }
            default:
                response.sendError(404);
                break;
        }
    }

    public static void deleteProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalAccessException {
        String uri = request.getRequestURI();
        String[] uriTokens = uri.split("/");

        switch (uriTokens.length){
            case 0:
            case 1:
            case 2:
                response.sendError(400);
                break;

            case 4: {
                int id = 0;
                String input = uriTokens[3];

                if(input.matches("[0-9]+")) {
                    id = Integer.parseInt(input);
                } else {
                    response.sendError(400, "ID is not a number");
                }

                request.setAttribute("id", id);
                if ("customers".equals(uriTokens[2])) rc.deleteCustomer(request, response);
                else if ("tables".equals(uriTokens[2])) rc.deleteTable(request, response);
                else response.sendError(400, "Collection does not exist");
                break;
            }
            default:
                response.sendError(404);
        }
    }
}
