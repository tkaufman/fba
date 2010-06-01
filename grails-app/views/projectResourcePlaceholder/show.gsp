
<%@ page import="com.pillar.fba.ProjectResourcePlaceholder" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'projectResourcePlaceholder.label', default: 'ProjectResourcePlaceholder')}" />
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
                            <td valign="top" class="name"><g:message code="projectResourcePlaceholder.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: projectResourcePlaceholderInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="projectResourcePlaceholder.startDate.label" default="Start Date" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${projectResourcePlaceholderInstance?.startDate}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="projectResourcePlaceholder.hoursPerWeek.label" default="Hours Per Week" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: projectResourcePlaceholderInstance, field: "hoursPerWeek")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="projectResourcePlaceholder.perDiem.label" default="Per Diem" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: projectResourcePlaceholderInstance, field: "perDiem")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="projectResourcePlaceholder.resourcePlaceholder.label" default="Resource Placeholder" /></td>
                            
                            <td valign="top" class="value"><g:link controller="resourcePlaceholder" action="show" id="${projectResourcePlaceholderInstance?.resourcePlaceholder?.id}">${projectResourcePlaceholderInstance?.resourcePlaceholder?.name}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="projectResourcePlaceholder.project.label" default="Project" /></td>
                            
                            <td valign="top" class="value"><g:link controller="project" action="show" id="${projectResourcePlaceholderInstance?.project?.id}">${projectResourcePlaceholderInstance?.project?.name}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="projectResourcePlaceholder.endDate.label" default="End Date" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${projectResourcePlaceholderInstance?.endDate}" /></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${projectResourcePlaceholderInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
