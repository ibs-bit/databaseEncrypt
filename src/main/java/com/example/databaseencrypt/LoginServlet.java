package com.example.databaseencrypt;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String url = "jdbc:mysql://localhost:3306/usersdb";


        // Login check takes user input and checks sql table for authentication
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "Itsibs123");
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM users");
            System.out.println
                    ("..................................................." +
                            "...................................................." +
                            "..................Reading database..................");

            ResultSet rs = ps.executeQuery();
            rs.next();
            String userdb = rs.getString("username");
            String passdb = rs.getString("password");
            if (user.equals(userdb) && pass.equals(passdb)) {
                response.sendRedirect("home.html");
            } else {
                response.sendRedirect("error.html");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}