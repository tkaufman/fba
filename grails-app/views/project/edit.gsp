
<%@ page import="com.pillar.fba.Project" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>

<span class="menuButton"><g:link controller="projectResource" action="create" params="['project.id': projectInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'projectResource.label', default: 'ProjectResource')])}</g:link></span>
<span class="menuButton"><g:link controller="projectResourcePlaceholder" action="create" params="['project.id': projectInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'projectResourcePlaceholder.label', default: 'ProjectResourcePlaceholder')])}</g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${projectInstance}">
            <div class="errors">
                <g:renderErrors bean="${projectInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${projectInstance?.id}" />
                <g:hiddenField name="version" value="${projectInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="project.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: projectInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${projectInstance?.name}" />
                                </td>
                            </tr>



                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="project.price.label" default="Price" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: projectInstance, field: 'price', 'errors')}">
                                    <g:textField name="price" value="${projectInstance?.price}" />
                                </td>
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="project.projectStatus.label" default="Project Status" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: projectInstance, field: 'projectStatus', 'errors')}">
                                    <g:textField name="projectStatus" value="${projectInstance?.projectStatus}" />
                                </td>
                            </tr>



                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="description"><g:message code="project.description.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: projectInstance, field: 'description', 'errors')}">
                                    <g:textField name="description" value="${projectInstance?.description}" />
                                </td>
                            </tr>
                        
                          
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="client"><g:message code="project.client.label" default="Client" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: projectInstance, field: 'client', 'errors')}">
                                    <g:select name="client.id" from="${com.pillar.fba.Client.list()}" optionKey="id" optionValue="name" value="${projectInstance?.client?.id}"  />
                                </td>
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="resources"><g:message code="project.resources.label" default="Resources" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: projectInstance, field: 'resources', 'errors')}">
                                    
<ul>
<g:each in="${projectInstance?.resources?}" var="r">
    <li><g:link controller="projectResource" action="edit" id="${r.id}">${r?.resource.name}</g:link></li>
</g:each>
</ul>
<g:link controller="projectResource" action="create" params="['project.id': projectInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'projectResource.label', default: 'ProjectResource')])}</g:link>

                                </td>
                            </tr>

			    <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="resourcePlaceHolders"><g:message code="project.resourcePlaceHolders.label" default="Resource Place Holders" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: projectInstance, field: 'resourcePlaceHolders', 'errors')}">
                                    
<ul>
<g:each in="${projectInstance?.resourcePlaceHolders?}" var="r">
    <li><g:link controller="projectResourcePlaceholder" action="edit" id="${r.id}">${r?.resourcePlaceholder.name}</g:link></li>
</g:each>
</ul>
<g:link controller="projectResourcePlaceholder" action="create" params="['project.id': projectInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'projectResourcePlaceholder.label', default: 'ProjectResourcePlaceholder')])}</g:link>

                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button">
                        <g:actionSubmit 
                            class="save" 
                            action="update" 
                            value="${message(code: 'default.button.update.label', default: 'Update')}" />
                    </span>
                    <span class="button"><g:actionSubmit class="save" action="copy" value="Save as New Project" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
