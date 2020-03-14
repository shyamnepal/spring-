/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.util;

import java.sql.Connection;
import java.sql.DriverManager;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shyam
 */
@Repository("db")
public class dbconnection {
    public Connection ln=null;
    public dbconnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ln=DriverManager.getConnection("jdbc:mysql://localhost:3306/springlogin","root","");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
