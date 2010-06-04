
<%@ page import="com.pillar.fba.Project" %>
<html>
<%
def projectTotalCost = projectInstance.calculateTotalProjectCost()
%>
<%
def estimates = projectInstance.retrieveAllEstimatesForProject()
%>
<%
def profitMargin = projectInstance.calculateProfitMargin()
%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
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
                            <td valign="top" class="name"><g:message code="project.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: projectInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="project.name.label" default="Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: projectInstance, field: "name")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="project.description.label" default="Description" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: projectInstance, field: "description")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="project.client.label" default="Client" /></td>
                            
                            <td valign="top" class="value"><g:link controller="client" action="show" id="${projectInstance?.client?.id}">${projectInstance?.client?.name}</g:link></td>
                            
                        </tr>


                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="project.resources.label" default="Resources" /></td>
                            
                            <td valign="top" style="text-align: left;" class="value">
                                <ul>
                                <g:each in="${projectInstance.resources}" var="r">
                                    <li><g:link controller="projectResource" action="show" id="${r.id}">${r?.resource.name}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="project.resourcePlaceHolders.label" default="Resource Place Holders" /></td>
                            
                            <td valign="top" style="text-align: left;" class="value">
                                <ul>
                                <g:each in="${projectInstance.resourcePlaceHolders}" var="r">
                                    <li><g:link controller="projectResourcePlaceholder" action="show" id="${r.id}">${r?.resourcePlaceholder.name}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
			<tr class="prop">
				<td>Project Total Cost</td>
				<td><g:formatNumber number="${projectTotalCost}" format="\$###,##0" /></td>
			</tr>
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="project.price.label" default="Price" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: projectInstance, field: 'price')}</td>
                            
                        </tr>
			<tr class="prop">
				<td>Profit Margin</td>
				<td>${profitMargin}%</td>
			</tr>
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="project.projectStatus.label" default="Project Status" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: projectInstance, field: "projectStatus")}</td>
                            
                        </tr>
                          <g:each var="estimate" in="${estimates}">
                            <tr class="prop">
                              <td>Estimate for ${estimate.key}%</td>
                              <td><g:formatNumber number="${estimate.value}" format="\$###,###.##" /></td>
                            </tr>
                          </g:each>
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${projectInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
