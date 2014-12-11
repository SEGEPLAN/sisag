<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New RrhhTemaCurso</title>
            <link rel="stylesheet" type="text/css" href="/sisag_web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New RrhhTemaCurso</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{rrhhTemaCurso.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="IdTema:"/>
                    <h:inputText id="idTema" value="#{rrhhTemaCurso.rrhhTemaCurso.idTema}" title="IdTema" required="true" requiredMessage="The idTema field is required." />
                    <h:outputText value="Nombre:"/>
                    <h:inputText id="nombre" value="#{rrhhTemaCurso.rrhhTemaCurso.nombre}" title="Nombre" />
                    <h:outputText value="Descripcion:"/>
                    <h:inputText id="descripcion" value="#{rrhhTemaCurso.rrhhTemaCurso.descripcion}" title="Descripcion" />
                    <h:outputText value="Restrictiva:"/>
                    <h:inputText id="restrictiva" value="#{rrhhTemaCurso.rrhhTemaCurso.restrictiva}" title="Restrictiva" />
                    <h:outputText value="RrhhNecesidadList:"/>
                    <h:selectManyListbox id="rrhhNecesidadList" value="#{rrhhTemaCurso.rrhhTemaCurso.jsfcrud_transform[jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method.arrayToList].rrhhNecesidadList}" title="RrhhNecesidadList" size="6" converter="#{rrhhNecesidad.converter}" >
                        <f:selectItems value="#{rrhhNecesidad.rrhhNecesidadItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="IdMeta:"/>
                    <h:selectOneMenu id="idMeta" value="#{rrhhTemaCurso.rrhhTemaCurso.idMeta}" title="IdMeta" >
                        <f:selectItems value="#{poaMeta.poaMetaItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{rrhhTemaCurso.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{rrhhTemaCurso.listSetup}" value="Show All RrhhTemaCurso Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
