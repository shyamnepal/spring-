<%-- 
    Document   : list
    Created on : Feb 10, 2020, 6:21:47 PM
    Author     : shyam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="pre"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table border="1px">
            <tr>
                <th>Name:</th>
                <th>Address:</th>
                <th>Phone:</th>
                <th>Email:</th>
                <th>Gender</th>
                <th>Faculty</th>
                <th>UserName:</th>
                <th>Password:</th>
                <th>Action:</th>
               
            </tr>
             <pre:forEach items="${list}" var="aa">
            <tr>
                <td>${aa.name}</td>
                <td>${aa.address}</td>
                <td>${aa.phone}</td>
                <td>${aa.email}</td>
                <td>${aa.gender}</td>
                <td>${aa.faculty}</td>
                <td>${aa.username}</td>
                <td>${aa.pass}</td>
                <td><a href="${pageContext.servletContext.contextPath}/delete?msg=${aa.admin_id}">delete</a>||<a href="${pageContext.servletContext.contextPath}/edit?msg=${aa.admin_id}">edit</a></td>
                
                    
               
            </tr>
           
                
                
            </pre:forEach>
            
        </table>
    </body>
</html>
