<#include "part/common.ftl"/>
<#macro content>
<div align="center">
    <h1>User list</h1>
    <table class="table table-bordered table-dark">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Login</th>
            <th scope="col">Name</th>
            <th scope="col">Role</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
    <#if users ? has_content>
        <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.name}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td>
                <a class="btn btn-info" href="/admin/edit/${user.id}">Edit</a>
                <a class="btn btn-danger" href="/admin/delete/${user.id}">Delete</a>
            </td>
        </tr>
        </tbody>
        </#list>
    <#else>
        </tbody>
        <h3>No users</h3>
    </#if>
    </table>
    <a class="btn btn-dark" href="/admin/add">Add new user</a>
</div>
</#macro>
<@page title="Admin panel"/>
