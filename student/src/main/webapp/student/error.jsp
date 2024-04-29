<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Error Page</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body>

<table>
    <tbody>
    <tr>
        <th>Status Code</th>
        <td>${status_code}</td>
    </tr>
    <tr>
        <th>Exception Type</th>
        <td>${exception_type}</td>
    </tr>
    <tr>
        <th>Message</th>
        <td>${message}</td>
    </tr>
    <tr>
        <th>Exception</th>
        <td>${exception}</td>
    </tr>
    <tr>
        <th>Request URI</th>
        <td>${request_uri}</td>
    </tr>
    </tbody>
</table>
</body>
</html>