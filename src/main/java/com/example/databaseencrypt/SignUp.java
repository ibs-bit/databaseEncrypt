package com.example.databaseencrypt;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "signUp", value = "/sign-up")
public class SignUp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Print out html response to display web page
        PrintWriter out = response.getWriter();

        // user parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        try {
            // load sql driver
            Class.forName("com.mysql.jdbc.Driver");

            // create connection to database
            Connection con = DriverManager.getConnection("");// TODO add SQL Database

            // statement to query database
            PreparedStatement ps = con.prepareStatement("insert into dbLogin values(?,?,?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pass);

            int i = ps.executeUpdate();

            if (i > 0) {
                out.println("Successfully Registered");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}