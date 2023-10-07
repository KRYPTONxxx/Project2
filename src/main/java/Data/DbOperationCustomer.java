package Data;

import com.codeborne.selenide.Selenide;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
public class DbOperationCustomer {
    private List<Object> addInfo;

    public DbOperationCustomer insertCustomerInfo() throws SQLException {
        Connection connection = Data.DbConnection.getConnection();
        String query = "INSERT INTO users (firstName, lastName, phone,email,dateOfBirth,password) VALUES (?,?,?,?,?,?)";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, RegisterData.firstName);
            statement.setString(2, RegisterData.lastName);
            statement.setString(3, RegisterData.phoneNumber);
            statement.setString(4, RegisterData.email);
            statement.setString(5, RegisterData.dateOfBirth + "");
            statement.setString(6, RegisterData.password);
            statement.executeUpdate();
        }
        return this;
    }

    public List<Object[]> getCustomerInfo(){
        List<Object[]> list = new ArrayList<>();
        Connection connection = Data.DbConnection.getConnection();
        try (Statement statement = connection.createStatement()){
            String query = "SELECT * FROM users";
            ResultSet resultSet =statement.executeQuery(query);
            while (resultSet.next()){
                list.add(new Object[]{resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                });
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public DbOperationCustomer deleteCustomerInfo(){
        Connection connection = Data.DbConnection.getConnection();
        try (Statement statement = connection.createStatement()){
            String query = "Delete FROM users where email = " + "'" +RegisterData.email + "'";
            statement.executeUpdate(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this;
    }



}
