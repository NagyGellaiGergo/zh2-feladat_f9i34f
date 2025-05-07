<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:page>
  <style type="text/css">
    td {
      border: 1px solid black;
    }
  </style>
  <div>
    <table>
      <thead>
      <tr>
        <th>ID</th>
        <th>Étterem</th>
        <th>Étel</th>
        <th>Ár</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${foods}" var="food">
        <tr>
          <td><c:out value="${food.id}"/></td>
          <td><c:out value="${food.restaurantName}"/></td>
          <td><c:out value="${food.foodName}"/></td>
          <td><c:out value="${food.price}"/></td>
          <td>
            <button type="button">Rendelt adag</button>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</t:page>
