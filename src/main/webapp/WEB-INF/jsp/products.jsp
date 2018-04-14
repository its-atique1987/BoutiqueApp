<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html xmlns:th="http://www.thymeleaf.org">
   <head>
      <title>Spring MVC Form Handling</title>
	   </head>
   <body>

   <h2>Product Information</h2>
       <form:form method = "POST" modelAttribute="model" action = "/product"> 
         <table>
            <tr>
               <td>Category A: </td>
               <td>
               		<form:checkboxes path = "categoryAproducts" items = "${productsA}"/>
               </td>
               <td><input type = "submit" name = "categoryA" value = "Add 'A' category product to cart"></td>
               <td><p th:text="' + ${productAdded} + '!'" /></td>
            </tr>
         </table>
         </form:form>
         <br></br>
         <form:form method = "POST" modelAttribute="model" action = "/product"> 
         <table>
            <tr>
               <td>Category B: </td>
               <td>
               		<form:checkboxes path = "categoryBproducts" items = "${productsB}"/>
               </td>
               <td><input type = "submit" name = "categoryB" value = "Add 'B' caegory product to cart"></td>
            </tr>
         </table>
         </form:form>
         <br></br>
         <form:form method = "POST" modelAttribute="model" action = "/product"> 
         <table>
            <tr>
               <td>Category C: </td>
               <td>
               		<form:checkboxes path = "categoryCproducts" items = "${productsC}"/>
               </td>
               <td><input type = "submit" name = "categoryC" value = "Add 'C' caegory product to cart"></td>
            </tr>
         </table>
        </form:form>
    </body>
</html>