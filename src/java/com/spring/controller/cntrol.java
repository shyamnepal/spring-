/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controller;

import com.spring.entity.stentity;
import com.spring.interf.stinterf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author shyam
 */
@Controller
public class cntrol {
    @Autowired
    stinterf dao;
    @RequestMapping("/")
    public String home(){
    return "index";
}
    @RequestMapping("/login")
    public String log(@RequestParam("username") String user, @RequestParam("pass") String pass,@RequestParam("confirm") String con, Model md){
       stentity se=dao.checkStatus(user);
        System.out.println(user);
       if(se!=null){
        System.out.println(se.getStatus());
       if(se.getStatus()==1){
           md.addAttribute("msg", "dear "+user+" your id has been blocked");
           return "redirect:/";
       }
       else{
       if(dao.checkLogin(user, pass)){
          dao.updateAttempt(se.getAdmin_id(), 0);
         return "redirect:/list";
       }
       
       else{
       if(se.getAttempt()>=3){
        dao.updateStatus(se.getAdmin_id(), 1);
        dao.updateAttempt(se.getAdmin_id(), 0);
        md.addAttribute("msg", "your id is blocked");
        return "redirect:/";
       }
       
       else{
      dao.updateAttempt(se.getAdmin_id(), se.getAttempt()+1);
      md.addAttribute("msg", "incorrect information");
      return "redirect:/";
       }
       
       }
       }
        
       }  
       else{
           md.addAttribute("msg", "username not found");
           return "redirect:/";
       }
        
    }
    @RequestMapping("/regis")
    public String reg(){
       
    return "register";
    
}
    @RequestMapping("/registerdata")
    public String registers(@ModelAttribute("stentity")stentity se,Model md){
        se.setStatus(0);
        se.setAttempt(0);
        double aid=Math.round(Math.random()*10000);
        se.setAdmin_id(aid+""); 
        if(dao.checkUsername(se.getUsername())!=null){
            md.addAttribute("msg", "Username is already taken");
            return "redirect:/regis";
        }
        else{
        if(dao.register(se)){
            md.addAttribute("msg1", "register successfully");
            return "redirect:/";
        }else{
            md.addAttribute("msg1", "register failed");
            return "redirect:/";
        }
        
        }  
   
    
    
}
    @RequestMapping("/list")
    public String alldata(Model md){
       md.addAttribute("list", dao.getbyid());
        return "list";
    }
    @RequestMapping("/delete")
    public String deletedata(@ModelAttribute("stentity") stentity se,@RequestParam("msg")String admin,Model md){
        if(dao.delete(admin)){
            md.addAttribute("msg","delete successfully");
             return "redirect:/list";
    }else{
           md.addAttribute("msg", "delete failed");
           return "redirect:/list"; 
        }
        
        }
    @RequestMapping("/edit")
    public String getalldata(@ModelAttribute("stentity") stentity se, Model md){
        md.addAttribute("ob", dao.alldata(se));
        return "edit";
       
    }
    @RequestMapping ("/update")
    public String updatedata(@ModelAttribute("stentity") stentity se, Model md){
        if(dao.update(se)){
        md.addAttribute("msg", "update sucessfully");
        return "redirect:/list";
    }else{
             md.addAttribute("msg", "update update failed");
        return "redirect:/list";
            
        }
        }

}
    
    

