/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.interf;

import com.spring.entity.stentity;
import java.util.List;

/**
 *
 * @author shyam
 */
public interface stinterf {
    public boolean register(stentity se);
    stentity checkUsername(String username);
    public boolean delete(String admin_id);
    public List<stentity> getbyid();
    public stentity alldata(stentity se);
    public boolean update(stentity se);
    stentity checkStatus(String username);
    boolean checkLogin(String username,String password);
    boolean updateAttempt(String id,int att);
    boolean updateStatus(String id,int st);
    
    
}
