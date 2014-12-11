<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>RrhhTemaCurso Detail</title>
            <link rel="stylesheet" type="text/css" href="/sisag_web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>RrhhTemaCurso Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="IdTema:"/>
                    <h:outputText value="#{rrhhTemaCurso.rrhhTemaCurso.idTema}" title="IdTema" />
                    <h:outputText value="Nombre:"/>
                    <h:outputText value="#{rrhhTemaCurso.rrhhTemaCurso.nombre}" title="Nombre" />
                    <h:outputText value="Descripcion:"/>
                    <h:outputText value="#{rrhhTemaCurso.rrhhTemaCurso.descripcion}" title="Descripcion" />
                    <h:outputText value="Restrictiva:"/>
                    <h:outputText value="#{rrhhTemaCurso.rrhhTemaCurso.restrictiva}" title="Restrictiva" />
                    <h:outputText value="IdMeta:"/>
                    <h:panelGroup>
                        <h:outputText value="#{rrhhTemaCurso.rrhhTemaCurso.idMeta}"/>
                        <h:panelGroup rendered="#{rrhhTemaCurso.rrhhTemaCurso.idMeta != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{poaMeta.detailSetup}">
                                <f:param name="jsfcrud.currentRrhhTemaCurso" value="#{jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][rrhhTemaCurso.rrhhTemaCurso][rrhhTemaCurso.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentPoaMeta" value="#{jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][rrhhTemaCurso.rrhhTemaCurso.idMeta][poaMeta.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="rrhhTemaCurso"/>
                                <f:param name="jsfcrud.relatedControllerType" value="gt.gob.segeplan.sisag.core.web.session.RrhhTemaCursoController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{poaMeta.editSetup}">
                                <f:param name="jsfcrud.currentRrhhTemaCurso" value="#{jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][rrhhTemaCurso.rrhhTemaCurso][rrhhTemaCurso.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentPoaMeta" value="#{jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][rrhhTemaCurso.rrhhTemaCurso.idMeta][poaMeta.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="rrhhTemaCurso"/>
                                <f:param name="jsfcrud.relatedControllerType" value="gt.gob.segeplan.sisag.core.web.session.RrhhTemaCursoController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{poaMeta.destroy}">
                                <f:param name="jsfcrud.currentRrhhTemaCurso" value="#{jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][rrhhTemaCurso.rrhhTemaCurso][rrhhTemaCurso.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentPoaMeta" value="#{jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][rrhhTemaCurso.rrhhTemaCurso.idMeta][poaMeta.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="rrhhTemaCurso"/>
                                <f:param name="jsfcrud.relatedControllerType" value="gt.gob.segeplan.sisag.core.web.session.RrhhTemaCursoController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>

                    <h:outputText value="RrhhNecesidadList:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty rrhhTemaCurso.rrhhTemaCurso.rrhhNecesidadList}" value="(No Items)"/>
                        <h:dataTable value="#{rrhhTemaCurso.rrhhTemaCurso.rrhhNecesidadList}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty rrhhTemaCurso.rrhhTemaCurso.rrhhNecesidadList}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="IdNecesidad"/>
                                </f:facet>
                                <h:outputText value="#{item.idNecesidad}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="HorasDia"/>
                                </f:facet>
                                <h:outputText value="#{item.horasDia}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Restrictiva"/>
                                </f:facet>
                                <h:outputText value="#{item.restrictiva}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ProblemaNecesidad"/>
                                </f:facet>
                                <h:outputText value="#{item.problemaNecesidad}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="TotalHoras"/>
                                </f:facet>
                                <h:outputText value="#{item.totalHoras}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="UsrCrea"/>
                                </f:facet>
                                <h:outputText value="#{item.usrCrea}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="UsrModifica"/>
                                </f:facet>
                                <h:outputText value="#{item.usrModifica}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="FechaCrea"/>
                                </f:facet>
                                <h:outputText value="#{item.fechaCrea}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="FechaModifica"/>
                                </f:facet>
                                <h:outputText value="#{item.fechaModifica}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="IdTema"/>
                                </f:facet>
                                <h:outputText value="#{item.idTema}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="IdSolicitudCapacitacion"/>
                                </f:facet>
                                <h:outputText value="#{item.idSolicitudCapacitacion}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="IdPrioridad"/>
                                </f:facet>
                                <h:outputText value="#{item.idPrioridad}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="IdCaracter"/>
                                </f:facet>
                                <h:outputText value="#{item.idCaracter}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="IdEstado"/>
                                </f:facet>
                                <h:outputText value="#{item.idEstado}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="IdDisponibilidad"/>
                                </f:facet>
                                <h:outputText value="#{item.idDisponibilidad}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="IdNivelConocimiento"/>
                                </f:facet>
                                <h:outputText value="#{item.idNivelConocimiento}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{rrhhNecesidad.detailSetup}">
                                    <f:param name="jsfcrud.currentRrhhTemaCurso" value="#{jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][rrhhTemaCurso.rrhhTemaCurso][rrhhTemaCurso.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentRrhhNecesidad" value="#{jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][rrhhNecesidad.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="rrhhTemaCurso" />
                                    <f:param name="jsfcrud.relatedControllerType" value="gt.gob.segeplan.sisag.core.web.session.RrhhTemaCursoController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{rrhhNecesidad.editSetup}">
                                    <f:param name="jsfcrud.currentRrhhTemaCurso" value="#{jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][rrhhTemaCurso.rrhhTemaCurso][rrhhTemaCurso.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentRrhhNecesidad" value="#{jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][rrhhNecesidad.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="rrhhTemaCurso" />
                                    <f:param name="jsfcrud.relatedControllerType" value="gt.gob.segeplan.sisag.core.web.session.RrhhTemaCursoController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{rrhhNecesidad.destroy}">
                                    <f:param name="jsfcrud.currentRrhhTemaCurso" value="#{jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][rrhhTemaCurso.rrhhTemaCurso][rrhhTemaCurso.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentRrhhNecesidad" value="#{jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][rrhhNecesidad.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="rrhhTemaCurso" />
                                    <f:param name="jsfcrud.relatedControllerType" value="gt.gob.segeplan.sisag.core.web.session.RrhhTemaCursoController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{rrhhTemaCurso.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentRrhhTemaCurso" value="#{jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][rrhhTemaCurso.rrhhTemaCurso][rrhhTemaCurso.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{rrhhTemaCurso.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentRrhhTemaCurso" value="#{jsfcrud_class['gt.gob.segeplan.sisag.core.web.session.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][rrhhTemaCurso.rrhhTemaCurso][rrhhTemaCurso.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{rrhhTemaCurso.createSetup}" value="New RrhhTemaCurso" />
                <br />
                <h:commandLink action="#{rrhhTemaCurso.listSetup}" value="Show All RrhhTemaCurso Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
