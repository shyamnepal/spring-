/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.impl;

import com.spring.entity.stentity;
import com.spring.interf.stinterf;
import com.spring.util.dbconnection;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
/**
 *
 * @author shyam
 */
@Repository("dao")
public class stimpl implements stinterf{
@Autowired
dbconnection db;
    @Override
    public boolean register(stentity se) {
        
       boolean temp=false;
        try {
            PreparedStatement ps=db.ln.prepareStatement("insert into userdetail values(null,?,?,?,?,?,?,?)");
           ps.setString(1, se.getName());
           ps.setString(2, se.getAddress());
           ps.setString(3, se.getPhone());
           ps.setString(4, se.getEmail());
           ps.setString(5, se.getGender());
           ps.setString(6, se.getFaculty());
           ps.setString(7, se.getAdmin_id());
           int i=ps.executeUpdate();
           if(i>0){
            PreparedStatement pss=db.ln.prepareStatement("insert into info values(?,?,?,?,?,?)");
            
            pss.setInt(1,se.getId());
            pss.setString(2,se.getUsername());
            pss.setString(3,se.getPass());
            pss.setInt(4,se.getAttempt());
            pss.setInt(5,se.getStatus());
            pss.setString(6,se.getAdmin_id());
            int j=pss.executeUpdate();
               
            if(j>0){
                temp=true;
             
           }
           }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
       
        return temp;
    }

    @Override
    public stentity checkUsername(String username) {
    stentity se=null;
        try {
            PreparedStatement ps=db.ln.prepareStatement("select * from info where username=?");
            ps.setString(1, username);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                se=new stentity(rs.getInt(1), rs.getInt(5), rs.getInt(4),rs.getString(6), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
        }
        return se;
    }

    

    @Override
    public List<stentity> getbyid() {
        List<stentity> li=new ArrayList<>();
        try {
            PreparedStatement ps=db.ln.prepareStatement("select * from userdetail");
            ResultSet rs=ps.executeQuery();
         
            while(rs.next()){
                
                PreparedStatement pss=db.ln.prepareStatement("select * from info");
                ResultSet rss=pss.executeQuery();
                
                while(rss.next()){
                    
                    li.add(new stentity(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rss.getString(2), rss.getString(3)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return li;
    }
    @Override
    public boolean delete(String admin_id) {
        boolean temp=false;
        try {
            PreparedStatement ps=db.ln.prepareStatement("delete from userdetail where admin_id=?");
            ps.setString(1, admin_id);
            int i=ps.executeUpdate();
            if(i>0){
                PreparedStatement pss=db.ln.prepareStatement("delete from info where admin_id=?");
                pss.setString(1, admin_id);
                int j=pss.executeUpdate();
                if(j>0){
                    temp=true;
                }
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public stentity alldata(stentity se) {
        stentity ses=null;
        try {
            PreparedStatement ps=db.ln.prepareStatement("select * from userdetail");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                PreparedStatement pss=db.ln.prepareStatement("select * from info");
                ResultSet rss=pss.executeQuery();
                if(rss.next()){
                   ses=new stentity(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rss.getString(2), rss.getString(3));
                }
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ses;
    }

    @Override
    public boolean update(stentity se) {
        boolean temp=false;
        try {
            PreparedStatement ps=db.ln.prepareStatement("update userdetail set name=?,address=?,phone=?,email=?,gender=?,faculty=? where admin_id=?");
            ps.setString(1, se.getName());
            ps.setString(2, se.getAddress());
            ps.setString(3, se.getPhone());
            ps.setString(4, se.getEmail());
            ps.setString(5, se.getGender());
            ps.setString(6, se.getFaculty());
            ps.setString(7, se.getAdmin_id());
     
            int i=ps.executeUpdate();
            if(i>0){
                PreparedStatement pss=db.ln.prepareStatement("update info set username=?,pass=? where admin_id=?");
                pss.setString(1, se.getUsername());
                pss.setString(2, se.getPass());
                pss.setString(3, se.getAdmin_id());
                int j=pss.executeUpdate();
                if(i>0){
                   temp=true; 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public stentity checkStatus(String username) {
        stentity se=null;
        try {
            PreparedStatement ps=db.ln.prepareStatement("select * from info where username=?");
            ps.setString(1, username);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                se=new stentity(rs.getInt(1), rs.getInt(4), rs.getInt(5), rs.getString(2), rs.getString(3), rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return se;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        boolean temp=false;
        try {
            PreparedStatement ps=db.ln.prepareStatement("select * from info where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                temp=true;
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
         return temp;
    }

    @Override
    public boolean updateAttempt(String id, int att) {
        boolean temp=false;
        try {
            PreparedStatement ps=db.ln.prepareStatement("update info set attempt=? where admin_id=?");
            ps.setInt(1, att);
            ps.setString(2, id);
            int i=ps.executeUpdate();
            if(i>0){
                temp=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public boolean updateStatus(String id, int st) {
         boolean temp=false;
        try {
            PreparedStatement ps=db.ln.prepareStatement("update info set status=? where admin_id=?");
            ps.setInt(1, st);
            ps.setString(2, id);
            int i=ps.executeUpdate();
            if(i>0){
                temp=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
    
    
}
