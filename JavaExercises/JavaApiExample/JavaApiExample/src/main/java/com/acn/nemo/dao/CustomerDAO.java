package com.acn.nemo.dao;

import com.acn.nemo.dto.CustomerDTO;
import com.acn.nemo.model.Customer;
import com.acn.nemo.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.DriverManager.getConnection;

public class CustomerDAO {
    public Connection connection;
   public CustomerDAO(){
        connection = DBConnection.getInstance().getConnection();
        // Establish connection here
       // Establish connection here
   }
    public List<CustomerDTO> findAllCustomerDAO() {
       List<CustomerDTO> list = new ArrayList<>();
        String query = "SELECT * FROM customer";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {

                CustomerDTO c = new CustomerDTO(rs.getInt("customer_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"));

                list.add(c);
              //  System.out.println(STR."customer_id: \{rs.getInt("customer_id")}, First Name: \{rs.getString("first_name")}, Last Name: \{rs.getString("last_name")}, Email: \{rs.getString("email")}");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public CustomerDTO findCustomerByIdDAO(int id) {

        String query = "SELECT * FROM customer WHERE customer_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new CustomerDTO(rs.getInt("customer_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"));

                //System.out.println(STR."custome_id: \{rs.getInt("customer_id")},first_name: \{rs.getString("first_name")}, last_name: \{rs.getString("last_name")}, email: \{rs.getString("email")}");
            } //else {
               // System.out.println("Customer not found.");
            }
         catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CustomerDTO> findCustomerByFirstNameAndLastNameDAO(String first_name, String last_name) {
       List<CustomerDTO> customerList = new ArrayList<>();

        String query = "SELECT * FROM customer WHERE first_name =? AND last_name =?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CustomerDTO c = new CustomerDTO(rs.getInt("customer_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"));
                customerList.add(c);
                //System.out.println(STR."ID: \{rs.getInt("customer_id")}, First Name: \{rs.getString("first_name")}, Last Name: \{rs.getString("last_name")}, Email: \{rs.getString("email")}");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public CustomerDTO findCustomerByEmailAddressDAO(String email) {
       // Connection connection = DBConnection.getConnection();
        String query = "SELECT * FROM customer WHERE email =?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new CustomerDTO(rs.getInt("customer_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"));
                //System.out.println(STR."ID: \{rs.getInt("customer_id")}, First Name: \{rs.getString("first_name")}, Last Name: \{rs.getString("last_name")}, Email: \{rs.getString("email")}");
            } //else {
               // System.out.println("Customer not found.");
            }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Optional<CustomerDTO> updateCustomerFirstNameDAO(int id, String newFirstName) {

        String query = "UPDATE customer SET first_name =? WHERE customer_id =?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, newFirstName);
            pstmt.setInt(2, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                return Optional.of(findCustomerByIdDAO(id));

              //  System.out.println("Customer updated successfully.");
            } //else {
               // System.out.println("Customer not found.");
           // }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<CustomerDTO> updateCustomerEmailDAO(int id, String newEmail) {
        //Connection connection = DBConnection.getConnection();
        String query = "UPDATE customer SET email =? WHERE customer_id =?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, newEmail);
            pstmt.setInt(2, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                return Optional.of(findCustomerByIdDAO(id));
//                System.out.println("Customer updated successfully.");
//            } else {
//                System.out.println("Customer not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void deleteCustomerByIdDAO(int id) {



        //Connection connection = DBConnection.getConnection();
        String query = "DELETE FROM customer WHERE customer_id =?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {


                System.out.println("Customer deleted successfully.");
            } else {
                System.out.println("Customer not found.");
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCustomerDAO(int storeId, String first_name, String last_name, String email, int address_id) {

        // Connection connection = DBConnection.getConnection();
        String query = "INSERT INTO customer (store_id, first_name, last_name, email, address_id) VALUES (?,?,?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, storeId);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.setString(4, email);
            pstmt.setInt(5, address_id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer inserted successfully.");
            } else {
                System.out.println("Failed to insert customer.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
