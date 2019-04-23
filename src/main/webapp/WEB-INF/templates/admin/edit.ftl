<#include "../part/common.ftl"/>
<#macro content>
<div align="center">
    <h1>Editing ID(${user.id}) user</h1>
     <form action="/admin/edit/${user.id}" method="post">
         <div class="form-group row justify-content-center align-items-center">
             <label class="col-sm-1 col-form-label" for="login">Login</label>
             <div class="col-sm-4">
                 <input type="text" class="form-control" id="login" name="login" value="${user.login}">
             </div>
         </div>
         <div class="form-group row justify-content-center align-items-center">
             <label class="col-sm-1 col-form-label" for="password">Password</label>
             <div class="col-sm-4">
                 <input type="text" class="form-control" id="password" name="password" value="${user.password}">
             </div>
         </div>
         <div class="form-group row justify-content-center align-items-center">
             <label class="col-sm-1 col-form-label" for="name">Name</label>
             <div class="col-sm-4">
                 <input type="text" class="form-control" id="name" name="name" value="${user.name}">
             </div>
         </div>
         <div class="form-group row justify-content-center align-items-center">
             <label class="col-sm-1 col-form-label">Roles</label>
    <#list roles as role>
        <label class="col-sm-2"><input class="form-check-input" class="form-control" name="${role}" type="checkbox"
            ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
    </#list>
         </div>
         <button type="submit" class="btn btn-dark">Submit</button>
     </form>
</div>
</#macro>
<@page title="Edit user"/>