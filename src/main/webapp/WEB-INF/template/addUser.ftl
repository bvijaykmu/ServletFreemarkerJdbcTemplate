<!DOCTYPE html>
<html>
    <head>
        <title>Add new user</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
    <body>
        
        <form action="MyController?action=addUser" method="post"> 
            
            <label for="fname">First name:</label>
            <input id="fname" type="text" name="firstName">
            <br>
            
            <label for="lname">Last name:</label>
            <input id="lname" type="text" name="lastName">
            <br>

            <label for="email">Email:</label>
            <input id="email" type="text" name="email">            
            <br>
            
            <button type="submit">Submit</button>
            
        </form>

    </body>
</html>
