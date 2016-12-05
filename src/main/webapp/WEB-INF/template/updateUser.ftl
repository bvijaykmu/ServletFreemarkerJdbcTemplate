<!DOCTYPE html>
<html>
    <head>
        <title>Update user</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            input[readonly] {
                background-color:lightGray;
            }
        </style>
        </head>
    <body>
        
        <form action="MyController?action=updateUser" method="post"> 
            
            <label for="id">Id:</label>
            <input id="id" type="text" name="id" readonly value="${user.id}">
            <br>                
            
            <label for="fname">First name:</label>
            <input id="fname" type="text" name="firstName" value="${user.firstName}">
            <br>
            
            <label for="lname">Last name:</label>
            <input id="lname" type="text" name="lastName" value="${user.lastName}">
            <br>

            <label for="email">Email:</label>
            <input id="email" type="text" name="email" value="${user.email}">            
            <br>
            
            <button type="submit">Submit</button>
            
        </form>

    </body>
</html>
