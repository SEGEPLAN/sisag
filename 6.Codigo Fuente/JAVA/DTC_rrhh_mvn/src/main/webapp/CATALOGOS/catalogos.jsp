<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%--
    This file is an entry point for JavaServer Faces application.
--%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
<link rel="stylesheet" type="text/css" href="../../sisag_web/faces/jsfcrud.css" />
        </head>
        <body>
            <h1><h:outputText value="JavaServer Faces"/></h1>
                <h:form>
                    <h:commandLink action="#{rrhhTemaCurso.listSetup}" value="Show All RrhhTemaCurso Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{poaSubProducto.listSetup}" value="Show All PoaSubProducto Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{poaProducto.listSetup}" value="Show All PoaProducto Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{poaMeta.listSetup}" value="Show All PoaMeta Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{katunMeta.listSetup}" value="Show All KatunMeta Items"/>
                </h:form>

                <h:form>
                    <h:commandLink action="#{genUnidadMedida.listSetup}" value="Show All GenUnidadMedida Items"/>
                </h:form>

        </body>
    </html>
</f:view>
