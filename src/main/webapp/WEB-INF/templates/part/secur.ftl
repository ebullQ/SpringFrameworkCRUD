<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>
<#if known>
    <#assign
        sessionUser = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        isAdmin = sessionUser.isAdmin()
    >
<#else>
    <#assign
        isAdmin = false
    >
</#if>