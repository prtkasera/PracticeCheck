<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="springcore"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<springform:form modelAttribute="product" method="post" action="addproduct.htm">
<table>
<tr>
<td><springform:label path="product_id">Product ID : </springform:label>
<td><springform:input path="product_id"/>
<springform:errors path="product_id" style="color:red">

</springform:errors>
</td></tr>

<tr>
<td><springform:label path="product_name">Product Name : </springform:label>
<td><springform:input path="product_name"/>
</td></tr>

<tr>
<td><springform:label path="product_description">Product Description : </springform:label>
<td><springform:input path="product_description"/>
</td></tr>

<tr>
<td><springform:label path="product_category">Product Category : </springform:label>
<td><springform:select path="product_category">
<springform:options items="${categorylist}"></springform:options>
</springform:select>
<springform:errors path="product_category" style="color:red"></springform:errors>

</tr>

<tr>
<td><springform:label path="product_price">Product Price : </springform:label>
<td><springform:input path="product_price"/>
</td></tr>
<tr>
<td><input type="submit" value="ADD PRODUCT"></td>
</tr>
</table>

</springform:form>
${status}
</body>
</html>