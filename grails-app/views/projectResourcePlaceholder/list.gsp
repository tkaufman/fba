
<%@ page import="com.pillar.fba.ProjectResourcePlaceholder" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'projectResourcePlaceholder.label', default: 'ProjectResourcePlaceholder')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'projectResourcePlaceholder.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="startDate" title="${message(code: 'projectResourcePlaceholder.startDate.label', default: 'Start Date')}" />
                        
                            <g:sortableColumn property="hoursPerWeek" title="${message(code: 'projectResourcePlaceholder.hoursPerWeek.label', default: 'Hours Per Week')}" />
                        
                            <g:sortableColumn property="perDiem" title="${message(code: 'projectResourcePlaceholder.perDiem.label', default: 'Per Diem')}" />
                        
                            <th><g:message code="projectResourcePlaceholder.resourcePlaceholder.label" default="Resource Placeholder" /></th>
                   	    
                            <th><g:message code="projectResourcePlaceholder.project.label" default="Project" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${projectResourcePlaceholderInstanceList}" status="i" var="projectResourcePlaceholderInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${projectResourcePlaceholderInstance.id}">${fieldValue(bean: projectResourcePlaceholderInstance, field: "id")}</g:link></td>
                        
                            <td><g:formatDate date="${projectResourcePlaceholderInstance.startDate}" /></td>
                        
                            <td>${fieldValue(bean: projectResourcePlaceholderInstance, field: "hoursPerWeek")}</td>
                        
                            <td>${fieldValue(bean: projectResourcePlaceholderInstance, field: "perDiem")}</td>
                        
                            <td>${fieldValue(bean: projectResourcePlaceholderInstance, field: "resourcePlaceholder.name")}</td>
                        
                            <td>${fieldValue(bean: projectResourcePlaceholderInstance, field: "project.name")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${projectResourcePlaceholderInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
