<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <h2>this is the login form</h2>
        <form action="${pageContext.servletContext.contextPath}/login" method="post">
            <table>
                <tr>
                    <td><label>userName:</label></td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td><label>password:</label></td>
                    <td><input type="password" name="pass"></td>
                </tr>
                <tr>
                    <td><label>confirm password:</label></td>
                    <td><input type="password" name="confirm"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="login"></td>  
                </tr>
                <br>
                <br>
                <br>
                
                
            </table>
            
        </form>
        <a href="${pageContext.servletContext.contextPath}/regis">sign up</a>
            ${param.msg}
            ${msg1}
    </body>
</html>
