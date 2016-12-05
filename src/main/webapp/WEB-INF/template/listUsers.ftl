<!DOCTYPE html>
<html>
    <head>
        <title>List users</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>User Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
            <tbody>
                <#list users as user>
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.email}</td>
                        <td><a href="MyController?action=updateUser&userId=${user.id}">Update</a></td>
                        <td><a href="MyController?action=deleteUser&userId=${user.id}">Delete</a></td>
                    </tr>
                </#list>
            </tbody>
        </table>
        
        <p>
            <a href="MyController?action=addUser">Add new user</a>
        </p>

    </body>
</html>
