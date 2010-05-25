
<%@ page import="com.pillar.fba.ProjectResource" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'projectResource.label', default: 'ProjectResource')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'projectResource.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="startDate" title="${message(code: 'projectResource.startDate.label', default: 'Start Date')}" />
                        
                            <g:sortableColumn property="hoursPerWeek" title="${message(code: 'projectResource.hoursPerWeek.label', default: 'Hours Per Week')}" />
                        
                            <g:sortableColumn property="perDiem" title="${message(code: 'projectResource.perDiem.label', default: 'Per Diem')}" />
                        
                            <th><g:message code="projectResource.project.label" default="Project" /></th>
                   	    
                            <g:sortableColumn property="endDate" title="${message(code: 'projectResource.endDate.label', default: 'End Date')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${projectResourceInstanceList}" status="i" var="projectResourceInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${projectResourceInstance.id}">${fieldValue(bean: projectResourceInstance, field: "id")}</g:link></td>
                        
                            <td><g:formatDate date="${projectResourceInstance.startDate}" /></td>
                        
                            <td>${fieldValue(bean: projectResourceInstance, field: "hoursPerWeek")}</td>
                        
                            <td>${fieldValue(bean: projectResourceInstance, field: "perDiem")}</td>
                        
                            <td>${fieldValue(bean: projectResourceInstance, field: "project.name")}</td>
                        
                            <td><g:formatDate date="${projectResourceInstance.endDate}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${projectResourceInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
