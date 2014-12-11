<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing RrhhTemaCurso Items</title>
            <link rel="stylesheet" type="text/css" href="/sisag_web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing RrhhTemaCurso Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No RrhhTemaCurso Items Found)<br />" rendered="#{rrhhTemaCurso.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{rrhhTemaCurso.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{rrhhTemaCurso.pagingInfo.firstItem + 1}..#{rrhhTemaCurso.pagingInfo.lastItem} of #{rrhhTemaCurso.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{rrhhTemaCurso.prev}" value="Previous #{rrhhTemaCurso.pagingInfo.batchSize}" rendered="#{rrhhTemaCurso.pagingInfo.firstItem >= rrhhTemaCurso.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{rrhhTemaCurso.next}" value="Next #{rrhhTemaCurso.pagingInfo.batchSize}" rendered="#{rrhhTemaCurso.pagingInfo.lastItem + rrhhTemaCurso.pagingInfo.batchSize <= rrhhTemaCurso.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{rrhhTemaCurso.next}" value="Remaining #{rrhhTemaCurso.pagingInfo.itemCount - rrhhTemaCurso.pagingInfo.lastItem}"
                                   rendered="#{rrhhTemaCurso.pagingInfo.lastItem < rrhhTemaCurso.pagingInfo.itemCount && rrhhTemaCurso.pagingInfo.lastItem + rrhhTemaCurso.pagingInfo.batchSize > rrhhTemaCurso.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{rrhhTemaCurso.rrhhTemaCursoItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="IdTema"/>
                            </f:facet>
                            <h:outputText value="#{item.idTema}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Nombre"/>
                            </f:facet>
                            <h:outputText value="#{item.nombre}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Descripcion"/>
                            </f:facet>
                            <h:outputText value="#{item.descripcion}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Restrictiva"/>
                            </f:facet>
                            <h:outputText value="#{item.restrictiva}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="IdMeta"/>
                            </f:facet>
                            <h:outputText value="#{item.idMeta}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{rrhhTemaCurso.detailSetup}">
                                <f:param name="jsfcrud.currentRrhhTemaCurso" value="#{jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][rrhhTemaCurso.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{rrhhTemaCurso.editSetup}">
                                <f:param name="jsfcrud.currentRrhhTemaCurso" value="#{jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][rrhhTemaCurso.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{rrhhTemaCurso.remove}">
                                <f:param name="jsfcrud.currentRrhhTemaCurso" value="#{jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][rrhhTemaCurso.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{rrhhTemaCurso.createSetup}" value="New RrhhTemaCurso"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
