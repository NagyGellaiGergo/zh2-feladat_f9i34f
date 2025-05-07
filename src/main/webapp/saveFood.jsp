<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:page>
  <div>
    <form action="save-food" method="post">
      <table>
        <tr>
          <td>Étterem:</td>
          <td><input name="restaurantName"/></td>
        </tr>
        <tr>
          <td>Étel:</td>
          <td><input name="foodName"/></td>
        </tr>
        <tr>
          <td>Ár:</td>
          <td><input name="price"/></td>
        </tr>
        <tr>
          <td><input type="submit" value="Mentés"/></td>
          <td>
            <button type="button" onclick="window.history.back()">Back</button>
          </td>
        </tr>
      </table>
    </form>
  </div>
</t:page>
