
<%@ page import="com.pillar.fba.ProjectResource" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'projectResource.label', default: 'ProjectResource')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="projectResource.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: projectResourceInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="projectResource.startDate.label" default="Start Date" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${projectResourceInstance?.startDate}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="projectResource.hoursPerWeek.label" default="Hours Per Week" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: projectResourceInstance, field: "hoursPerWeek")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="projectResource.perDiem.label" default="Per Diem" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: projectResourceInstance, field: "perDiem")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="projectResource.project.label" default="Project" /></td>
                            
                            <td valign="top" class="value"><g:link controller="project" action="show" id="${projectResourceInstance?.project?.id}">${projectResourceInstance?.project?.name}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="projectResource.endDate.label" default="End Date" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${projectResourceInstance?.endDate}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="projectResource.resource.label" default="Resource" /></td>
                            
                            <td valign="top" class="value"><g:link controller="resource" action="show" id="${projectResourceInstance?.resource?.id}">${projectResourceInstance?.resource?.name}</g:link></td>
                            
                        </tr>

                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${projectResourceInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
