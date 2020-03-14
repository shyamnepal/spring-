<%-- 
    Document   : edit
    Created on : Feb 10, 2020, 10:07:35 PM
    Author     : shyam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
         <form action="${pageContext.servletContext.contextPath}/update?admin_id=${ob.admin_id}" method="post">
            <table>
                <tr>
                    <td><label>Name:</label></td>
                    <td> <input type="text" name="name" value="${ob.name}"> </td>
                </tr>
                <tr>
                    <td><label>address:</label></td>
                    <td> <input type="text" name="address" value="${ob.address}"> </td>
                </tr>
                <tr>
                    <td><label>phone:</label></td>
                    <td> <input type="number" name="phone" value="${ob.phone}"> </td>
                </tr>
                <tr>
                    <td><label>email:</label></td>
                    <td> <input type="text" name="email" value="${ob.email}"> </td>
                </tr>
                <tr>
                    <td><label>userName:</label></td>
                    <td> <input type="text" name="username" value="${ob.username}"> </td>
                </tr>
                <tr>
                    <td><label>password:</label></td>
                    <td> <input type="password" name="pass" value="${ob.pass}"> </td>
                </tr>
                <tr>
                    <td><label>Gender:</label></td>
                    <td> <input type="radio" name="gender" value="male"${ob.gender.equals("male")?"checked":""}>male </td>
                    <td><input type="radio" name="gender" value="female"${ob.gender.equals("female")?"checked":""}>female</td>
                </tr>
                <tr>
                    <td><label>faculty</label></td>
                    <td><select name="faculty">
                <option></option>
                <option value="management" ${ob.faculty.equalsIgnoreCase("management")?"selected":""}>Management</option>
                <option value="science" ${ob.faculty.equalsIgnoreCase("science")?"selected":""}>science</option>
                <option value="humanities"${ob.faculty.equalsIgnoreCase("humanities")?"selected":""}>Humanities</option>
                </td> 
            </select>
                </tr>
                <tr>
                    <td><input type="submit" value="update"></td>
                </tr>
               
            </table>
        </form>
    </body>
</html>
