package Sakancom.loginFeature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Furniture {
String userName;
String  picture;
String  description;
String price;
String  id;
String selled;

    String host = "localhost";
    int port = 3306;
    String database = "Sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
public boolean checkAvailability(String userName){

    int counter = 1;
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        System.out.println("Connected to the MySQL database!");
        Statement statement = connection.createStatement();
        String query = new String();
        query = "Select * from forniture where username_tenant='"+userName+"' and Selled='No'";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
return true;
        }

    }
    catch (Exception e){

    }
    return false;


}
public boolean displayFurniture(String userName){
if(checkAvailability(userName)){

    int counter = 1;
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        System.out.println("Connected to the MySQL database!");
        Statement statement = connection.createStatement();
        String query = new String();
        query = "Select * from forniture where username_tenant='"+userName+"'";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            System.out.println(counter+"-");
            System.out.println("ID : "+resultSet.getString(5));
            System.out.println("Picture : "+resultSet.getString(2));
            System.out.println("residence_location_desc : "+resultSet.getString(3));
            System.out.println("Price : "+resultSet.getString(4));
            System.out.println("_____________________________________________");
            counter++;
        }
        if(counter>1){
            return true;
        }

    }
    catch (Exception e){

    }

}
    return false;
}
public boolean  addFurniture(String userName,String picture,String description,String price,String id,String selled) {
    String query = "insert into forniture (id,picture,residence_location_desc,price,username_tenant,selled) value ('" + id + "','" + picture + "','" + description + "','" + price + "','" + userName + "','" + selled + "')";

    int counter = 1;
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        System.out.println("Connected to the MySQL database!");
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        return true;
    }
    catch (Exception e){
        return false;

    }



}

public boolean sellFurniture(String id,String userName){
    if(checkAvailability(id,userName)) {


        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the MySQL database!");
            Statement statement = connection.createStatement();
            String query = "update forniture set selled='Yes' where id='" + id + "'";
            statement.executeUpdate(query);

return true;
        } catch (Exception e) {

        }
    }


    return false;
}

    public boolean checkAvailability(String userName,String id){

        int counter = 1;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the MySQL database!");
            Statement statement = connection.createStatement();
            String query = new String();
            query = "Select * from forniture where username_tenant='"+userName+"' and selled='No' and id='"+id+"'";
            System.out.println(query);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
          counter++;


            }
            if(counter>1){
                return true;
            }
            System.out.println("after while");


        }
        catch (Exception e){

        }
        System.out.println("before false");

        return false;


    }


}
