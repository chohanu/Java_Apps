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
                CustomerDAO customerDAO= new CustomerDAO(connection);
              Customer customer = customerDAO.findbyId(1000);
              System.out.println(customer.getFirstname() + customer.getLastName());

            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
}
