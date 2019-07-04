package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class JDBCExecutor {

    public static void main(String[] args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "hplussport", "postgres", "password");

            try {
                Connection connection = dcm.getConnection();

               /* Statement statement = connection.createStatement();
               // ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM CUSTOMER");
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1));
                }
        */
               CustomerDAO customerDAO= new CustomerDAO(connection);
              /* Customer customer = new Customer();
               customer.setFirstName("George");
               customer.setLastName("Washington");
               customer.setEmail("george.washington@wh.gov");
               customer.setPhone("(555) 555-6543");
               customer.setAddress("1234 Main st");
               customer.setCity("Missisaauga");
               customer.setAddress("ON");
               customer.setZipCode("2212");
               customerDAO.create(customer);

               */


              // readById code
              Customer customer = customerDAO.findbyId(1000);
              System.out.println(customer.getFirstname() + customer.getLastName());



                //challenge dao
              //  OrderDAO orderDAO = new OrderDAO(connection);
              //  Order order =orderDAO.findbyId(1000);
              // System.out.println(order);



            } catch (SQLException e) {
                e.printStackTrace();

            }
        } // end of main function


}
