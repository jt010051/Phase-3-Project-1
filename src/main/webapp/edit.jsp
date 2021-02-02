<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>${UserName}'s Details</title>
    <script> 
function validate()
{ 
     var n = document.form.n.value;
     var e = document.form.e.value;
     var u = document.form.u.value; 
     var p = document.form.p.value;
     var cop= document.form.cop.value;
     
     if (n==null || n=="")
     { 
     alert("Full Name can't be blank"); 
     return false; 
     }
     else if (e==null || e=="")
     { 
     alert("Email can't be blank"); 
     return false; 
     }
     else if (u==null || u=="")
     { 
     alert("Username can't be blank"); 
     return false; 
     }
     else if(p.length<6)
     { 
     alert("Password must be at least 6 characters long."); 
     return false; 
     } 
     else if (cop!=conpassword)
     { 
     alert("Confirm Password should match with the Password"); 
     return false; 
     } 
 } 
</script> 
</head>
<body>

    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Details</h2></caption>
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Password</th>
                <th>Email</th>
                <th>User Name</th>
                <th>Actions</th>
                
            </tr>
          
                <tr>
                    <td><c:out value="${id}" /></td>
                    <td><c:out value="${name}" /></td>
                    <td><c:out value="${password}" /></td>
                    <td><c:out value="${email}" /></td>
                    <td><c:out value="${UserName}" /></td>
                </tr>
        <div align="center">
    
        <form action="update" method="post" onsubmit="return validate()">
       
        <table border="1" cellpadding="5">
            <caption>
                <h2>Edit details</h2>
            </caption>
                
                    <input type="hidden" name="i" value="<c:out value= "${id}" />" />
               
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="n" size="45" 
                            value="<c:out value="${name}" />"
                        />
                </td>
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                    <input type="email" name="e"  size="45"
                            value="<c:out value="${email}" />"
                    />
                </td>
            </tr>
            <tr>
                <th>User Name: </th>
                <td>
                    <input type="text" name="u" size="45" 
                            value="<c:out value="${UserName}" />"
                    />
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="password" name="p" size="45" 
                            value="<c:out value="${password}" />"
                    />
                </td>
            </tr>
                 <tr>
                <th>Confirm Password: </th>
                <td>
                    <input type="password" name="cop" size="45"
                            value="<c:out value="${password}" />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
                 <tr>
         <td><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></td>
         </tr>
                  <td></td>
         
        </table>
        </form>
        
    </div>   
</body>
</html>