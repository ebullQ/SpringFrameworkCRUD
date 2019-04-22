<html>
<head>
    <title>Admin</title>
</head>
<body>
<a href="/">User page</a>
<a href="/logout">Logout</a>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>User List</h2></caption>
        <tr>
            <th>Id</th>
            <th>Login</th>
            <th>Name</th>
            <th>Role</th>
            <th>Action</th>
        </tr>
    <#if users ? has_content>
        <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.name}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td>
                <a href="/admin/edit/${user.id}">Edit</a>
                <a href="/admin/delete/${user.id}">Delete</a>
            </td>
        </tr>
        </#list>
    <#else>
        <td><p>No users</p></td>
    </#if>
    </table>
    <a href="/admin/add">Add new user</a>
</div>
</body>
</html>