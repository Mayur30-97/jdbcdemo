package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public final class App {
    public static Connection createConnection()
    {
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            return con;
       } catch(SQLException | ClassNotFoundException se)
       {
            System.out.println(se.getMessage());

       }
       return null;
    }
    public static void main(String[] args) {
        try{
            Connection con =createConnection();
            String query="SELECT * from test1";
            PreparedStatement ps=con.prepareStatement(query);

            ResultSet rs=ps.executeQuery();

            System.out.println("Names :-");
            while(rs.next())
            {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("age"));
            }

            con.close();
        }catch(SQLException se)
        {
            System.out.println(se.getMessage());
        }
    }
}
