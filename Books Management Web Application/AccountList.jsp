<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Service Ticket Management System</title>
</head>
<body>
    <center>
        <h1>Accounts Management</h1>
        <h2>
            <a href="/JSPCRUDsample/new">Add New Account</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/JSPCRUDsample/list">List All Accounts</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Accounts</h2></caption>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Password</th>
                <th>Usertype</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="account" items="${listAccount}">
                <tr>
                    <td><c:out value="${account.id}" /></td>
                    <td><c:out value="${account.username}" /></td>
                    <td><c:out value="${account.password}" /></td>
                    <td><c:out value="${account.usertype}" /></td>
                    <td><c:out value="${account.status}" /></td>
                    <td>
                        <a href="/JSPJSPCRUDsample/edit?id=<c:out value='${account.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/JSPCRUDsample/delete?id=<c:out value='${account.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>
