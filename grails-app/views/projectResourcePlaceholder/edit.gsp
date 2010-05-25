
<%@ page import="com.pillar.fba.ProjectResourcePlaceholder" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'projectResourcePlaceholder.label', default: 'ProjectResourcePlaceholder')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${projectResourcePlaceholderInstance}">
            <div class="errors">
                <g:renderErrors bean="${projectResourcePlaceholderInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${projectResourcePlaceholderInstance?.id}" />
                <g:hiddenField name="version" value="${projectResourcePlaceholderInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="startDate"><g:message code="projectResourcePlaceholder.startDate.label" default="Start Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: projectResourcePlaceholderInstance, field: 'startDate', 'errors')}">
                                    <g:datePicker name="startDate" precision="day" value="${projectResourcePlaceholderInstance?.startDate}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="hoursPerWeek"><g:message code="projectResourcePlaceholder.hoursPerWeek.label" default="Hours Per Week" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: projectResourcePlaceholderInstance, field: 'hoursPerWeek', 'errors')}">
                                    <g:textField name="hoursPerWeek" value="${fieldValue(bean: projectResourcePlaceholderInstance, field: 'hoursPerWeek')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="perDiem"><g:message code="projectResourcePlaceholder.perDiem.label" default="Per Diem" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: projectResourcePlaceholderInstance, field: 'perDiem', 'errors')}">
                                    <g:textField name="perDiem" value="${fieldValue(bean: projectResourcePlaceholderInstance, field: 'perDiem')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="resourcePlaceholder"><g:message code="projectResourcePlaceholder.resourcePlaceholder.label" default="Resource Placeholder" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: projectResourcePlaceholderInstance, field: 'resourcePlaceholder', 'errors')}">
                                    <g:select name="resourcePlaceholder.id" from="${com.pillar.fba.ResourcePlaceholder.list()}" optionKey="id" value="${projectResourcePlaceholderInstance?.resourcePlaceholder?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="project"><g:message code="projectResourcePlaceholder.project.label" default="Project" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: projectResourcePlaceholderInstance, field: 'project', 'errors')}">
                                    <g:select name="project.id" from="${com.pillar.fba.Project.list()}" optionKey="id" value="${projectResourcePlaceholderInstance?.project?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="endDate"><g:message code="projectResourcePlaceholder.endDate.label" default="End Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: projectResourcePlaceholderInstance, field: 'endDate', 'errors')}">
                                    <g:datePicker name="endDate" precision="day" value="${projectResourcePlaceholderInstance?.endDate}"  />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
