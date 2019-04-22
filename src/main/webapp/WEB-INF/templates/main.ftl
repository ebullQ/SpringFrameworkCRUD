<html>
<head>
    <title>Main page</title>
</head>
<body>
    <a href="/">User page</a>
    <a href="/logout">Logout</a>
    <h2>Hello ${user.name}</h2>
    <#if isAdmin==true><a href="/admin">User list</a></#if>
</body>
</html>