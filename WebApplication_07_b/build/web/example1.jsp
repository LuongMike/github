<%-- 
    Document   : example1
    Created on : Feb 10, 2025, 8:11:48 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table{
                border-collapse: collapse;
                width: 100%;
                text-align: center;
            }
            table, th,td{
                border: 1px solid black;
                padding: 8px;
            }
            th{
                background-color: red; 
            }
        </style>
    </head>
    <body>
        <table>
            <%  for (int i = 2; i <= 9; i++) {
        %>
            <hr/>
            <h3>Bang Cuu Chuong <%= i%></h3>
            
                <%  for (int j = 1; j <= 10; j++) {
                %>
                    <%= i%> X <%= j%> = <%= (i * j)%><br/>
                <% }
        
         }
        %>
        </table>

      
    </body>
</html>
