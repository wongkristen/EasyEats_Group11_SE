package model;
/**
 * Created by Elizabeth on 2/18/2017.
 */
import java.sql.*;
public class Driver {

    public static void main(String[] args){
        try{
            //1. get connection
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver).newInstance();
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyeats","root", "root");

            //2. create statement
            Statement myStat = myConn.createStatement();
            //3. execue sql query
            ResultSet myRa = myStat.executeQuery("select * from easyeats.kitchen_goods");
            //4. process result set
            while(myRa.next()){
                System.out.println(myRa.getString("item")+" ");
            }
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
    }
}
