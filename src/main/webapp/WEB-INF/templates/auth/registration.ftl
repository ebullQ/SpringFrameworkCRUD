<#include "../part/common.ftl"/>
<#macro content>
<div align="center">
     <form action="/registration" method="post" >
         <div class="form-group row justify-content-center align-items-center">
             <label class="col-sm-1 col-form-label" for="login">Login</label>
             <div class="col-sm-4">
                 <input type="text" class="form-control" id="login" name="login">
             </div>
         </div>
         <div class="form-group row justify-content-center align-items-center">
             <label class="col-sm-1 col-form-label" for="password">Password</label>
             <div class="col-sm-4">
                 <input type="password" class="form-control" id="password" name="password">
             </div>
         </div>
         <div class="form-group row justify-content-center align-items-center">
             <label class="col-sm-1 col-form-label" for="name">Name</label>
             <div class="col-sm-4">
                 <input type="text" class="form-control" id="name" name="name">
             </div>
         </div>
         <button type="submit" class="btn btn-primary">Submit</button>
     </form>
</div>
</#macro>
<@page title="Registration"/>