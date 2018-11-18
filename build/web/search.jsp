<%-- 
    Document   : search
    Created on : Nov 5, 2018, 11:12:47 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <s:property value="%{#session.USER}"/><br/>
        <s:property value="username"/>
        <%--<s:property value="password"/>--%>
        <h1>Welcome: ${USER} </h1>
        <form action="search">
            <s:textfield name="searchValue"/>
            <s:submit value="Search"/>
        </form>


        <s:if test="%{searchValue != null and searchValue !=''}">
            <s:if test="%{listAccount != null}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator var="dto" value="listAccount" status="counter">
                            <tr>
                                <td><s:property value="%{#counter.count}"/></td>
                                <td><s:property value="%{#dto.username}"/></td>
                                <td><s:property value="%{#dto.password}"/></td>
                                <td>
                                    <s:url var="delLink" value="deleteRecord">
                                        <s:param name="pk" value="%{#dto.username}"/>
                                        <s:param name="lastSearch" value="searchValue"/>
                                    </s:url> 
                                    <s:a href="%{delLink}">Delete</s:a>
                                </td>

                            </tr>
                        </s:iterator>
                    </tbody>
                </s:if>
            </s:if>
        </table>

    </body>
</html>
