<#include "../part/common.ftl"/>
<#macro content>
<div align="center">
    <h1>Welcome</h1>
    <h2>Please sign in with you login</h2>
    <h4 class="mb-5">if you have no your account on this Website, please <a href="/registration">sign up</a></h4>
     <form action="/login" method="post">
         <div class="form-group row justify-content-center align-items-center">
             <label class="col-form-label" for="login">User login</label>
             <div class="col-sm-4">
                <input type="text" class="form-control" id="login" name="login" placeholder="Enter login">
             </div>
         </div>
         <div class="form-group row justify-content-center align-items-center">
             <label class="col-form-label" for="password">Password</label>
             <div class="col-sm-4">
                 <input type="password" class="form-control" id="password" name="password"placeholder="Password">
             </div>
         </div>
         <button type="submit" class="btn btn-primary">Submit</button>
     </form>
</div>
</#macro>
<@page title="Login"/>