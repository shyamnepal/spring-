<%-- 
    Document   : register
    Created on : Feb 9, 2020, 1:58:04 PM
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
        <form action="${pageContext.servletContext.contextPath}/registerdata" method="post">
            <table>
                <tr>
                    <td><label>Name:</label></td>
                    <td> <input type="text" name="name"> </td>
                </tr>
                <tr>
                    <td><label>address:</label></td>
                    <td> <input type="text" name="address"> </td>
                </tr>
                <tr>
                    <td><label>phone:</label></td>
                    <td> <input type="number" name="phone"> </td>
                </tr>
                <tr>
                    <td><label>email:</label></td>
                    <td> <input type="text" name="email"> </td>
                </tr>
                <tr>
                    <td><label>userName:</label></td>
                    <td> <input type="text" name="username"> </td>
                </tr>
                <tr>
                    <td><label>password:</label></td>
                    <td> <input type="password" name="pass"> </td>
                </tr>
                <tr>
                    <td><label>Gender:</label></td>
                    <td> <input type="radio" name="gender" value="male">male </td>
                    <td><input type="radio" name="gender" value="female">female</td>
                </tr>
                <tr>
                    <td><label>faculty</label></td>
                    <td><select name="faculty">
                <option></option>
                <option value="management">Management</option>
                <option value="science">science</option>
                <option value="humanities">Humanities</option>
                </td> 
            </select>
                </tr>
                <tr>
                    <td><input type="submit" value="register"></td>
                </tr>
                
            </table>
        </form>
        <a href="${pageContext.servletContext.contextPath}/list">alldata</a>
    </body>
</html>
