<html>
<head>
    <title>Home</title>
</head>
<body>
<form action="/admin/edit/${user.id}" method="post">
    <input name="login" type="text" value="${user.login}"/>
    <input name="name" type="text" value="${user.name}"/>
    <input name="password" type="text" value="${user.password}"/>
    <#list roles as role>
    <div>
        <label><input name="${role}" type="checkbox" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
    </div>
    </#list>
    <input type="submit">
</form>
</body>
</html>