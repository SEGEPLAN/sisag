/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     19/11/2014 09:04:24 a.m.                     */
/*==============================================================*/


alter table SCHE$SISAG.GEN_PERIODO
   drop constraint PERIODO_PERIODO_FK;

alter table SCHE$SISAG.GEN_SOLICITUD_FINACIERA
   drop constraint GEN_SOLICITUD_FINACIERA_FK1;

alter table SCHE$SISAG.GEN_SOLICITUD_FINACIERA
   drop constraint SOLICITUD_META_FK;

alter table SCHE$SISAG.GEN_SOLICITUD_FINACIERA
   drop constraint SOLICITUD_PERIODO_FK;

alter table SCHE$SISAG.GEN_SOLICITUD_FINACIERA
   drop constraint SOLICITUD_TIPO_SOLICITUD_FK;

alter table SCHE$SISAG.KATUN_EJE
   drop constraint KATUN_EJE_PRIORIDAD_FK;

alter table SCHE$SISAG.KATUN_PRIORIDAD
   drop constraint KATUN_PRIORIDAD_META_FK;

alter table SCHE$SISAG.POA_META
   drop constraint META_KATUN_META_FK;

alter table SCHE$SISAG.POA_META
   drop constraint META_SUB_PRODUCTO_FK;

alter table SCHE$SISAG.POA_META
   drop constraint META_UNIDAD_MEDIDA_FK;

alter table SCHE$SISAG.POA_META_DIRECCION
   drop constraint META_DIRECCION_META_FK;

alter table SCHE$SISAG.POA_META_DIRECCION
   drop constraint META_DIRECCION_UNIDAD_FK;

alter table SCHE$SISAG.POA_META_PERIODO
   drop constraint META_PERIODO_META_FK;

alter table SCHE$SISAG.POA_META_PERIODO
   drop constraint META_PERIODO_PERIODO_FK;

alter table SCHE$SISAG.POA_SUB_PRODUCTO
   drop constraint SUB_PRODUCTO_PRODUCTO_FK;

alter table SCHE$SISAG.RRHH_DETALLE_NECESIDAD
   drop constraint GEN_DETALLE_CAPACITACION_FK1;

alter table SCHE$SISAG.RRHH_DETALLE_NECESIDAD
   drop constraint FK_RRHH_DET_REFERENCE_RRHH_CAR;

alter table SCHE$SISAG.RRHH_DETALLE_NECESIDAD
   drop constraint FK_RRHH_DET_REFERENCE_RRHH_TEM;

alter table SCHE$SISAG.RRHH_NECESIDAD_PUESTO
   drop constraint GEN_ASIGNA_CAPACITACION_FK1;

alter table SCHE$SISAG.RRHH_NECESIDAD_PUESTO
   drop constraint GEN_ASIGNA_CAPACITACION_FK2;

alter table SCHE$SISAG.RRHH_PERSONA
   drop constraint SEG_PERSONA_FK1;

alter table SCHE$SISAG.RRHH_PERSONA
   drop constraint SEG_PERSONA_FK2;

alter table SCHE$SISAG.RRHH_SOLICITUD_CAPACITACION
   drop constraint GEN_SOLICITUD_CAPACITACIO_FK2;

alter table SCHE$SISAG.RRHH_SOLICITUD_CAPACITACION
   drop constraint GEN_SOLICITUD_CAPACITACIO_FK4;

alter table RRHH_TEMA_CURSO
   drop constraint FK_RRHH_TEM_REFERENCE_POA_META;

alter table SCHE$SISAG.RRHH_TIPO_PUESTO
   drop constraint FK_RRHH_TIP_REFERENCE_RRHH_UNI;

alter table SCHE$SISAG.SEG_BITACORA
   drop constraint BITACORA_PAGINA_FK;

alter table SCHE$SISAG.SEG_BITACORA
   drop constraint BITACORA_SESION_FK;

alter table SCHE$SISAG.SEG_PAGINA
   drop constraint PAGINA_MODULO_FK;

alter table SCHE$SISAG.SEG_PAGINA
   drop constraint SEG_PAGINA_FK1;

alter table SCHE$SISAG.SEG_PAGINA_ASIGNADA
   drop constraint PAGINA_ASIGNADA_PAGINA_FK;

alter table SCHE$SISAG.SEG_PAGINA_ASIGNADA
   drop constraint PAGINA_ASIGNADA_ROL_FK;

alter table SCHE$SISAG.SEG_PAGINA_ASIGNADA
   drop constraint PAGINA_ASIGNADA_USUARIO_FK;

alter table SCHE$SISAG.SEG_PRIVILEGIO_PAGINA
   drop constraint SEG_PRIVILEGIO_PAGINA_FK1;

alter table SCHE$SISAG.SEG_PRIVILEGIO_PAGINA
   drop constraint SEG_PRIVILEGIO_PAGINA_FK2;

alter table SCHE$SISAG.SEG_ROL
   drop constraint ROL_UNIDAD_ADMINISTRATIVA_FK;

alter table SCHE$SISAG.SEG_ROL_USUARIO
   drop constraint ROL_USUARIO_ROL_FK;

alter table SCHE$SISAG.SEG_ROL_USUARIO
   drop constraint ROL_USUARIO_USUARIO_FK;

alter table SCHE$SISAG.SEG_SESION
   drop constraint SESION_USUARIO_FK;

alter table SCHE$SISAG.SEG_USUARIO
   drop constraint FK_SEG_USUA_REFERENCE_RRHH_PER;

alter table SCHE$SISAG.GEN_ESTADO
   drop primary key cascade;

drop table SCHE$SISAG.GEN_ESTADO cascade constraints;

alter table SCHE$SISAG.GEN_PERIODO
   drop primary key cascade;

drop table SCHE$SISAG.GEN_PERIODO cascade constraints;

alter table SCHE$SISAG.GEN_SOLICITUD_FINACIERA
   drop primary key cascade;

drop table SCHE$SISAG.GEN_SOLICITUD_FINACIERA cascade constraints;

alter table SCHE$SISAG.GEN_TIPO_SOLICITUD
   drop primary key cascade;

drop table SCHE$SISAG.GEN_TIPO_SOLICITUD cascade constraints;

alter table SCHE$SISAG.GEN_UNIDAD_MEDIDA
   drop primary key cascade;

drop table SCHE$SISAG.GEN_UNIDAD_MEDIDA cascade constraints;

alter table SCHE$SISAG.KATUN_EJE
   drop primary key cascade;

drop table SCHE$SISAG.KATUN_EJE cascade constraints;

alter table SCHE$SISAG.KATUN_META
   drop primary key cascade;

drop table SCHE$SISAG.KATUN_META cascade constraints;

alter table SCHE$SISAG.KATUN_PRIORIDAD
   drop primary key cascade;

drop table SCHE$SISAG.KATUN_PRIORIDAD cascade constraints;

alter table SCHE$SISAG.POA_META
   drop primary key cascade;

drop table SCHE$SISAG.POA_META cascade constraints;

alter table SCHE$SISAG.POA_META_DIRECCION
   drop primary key cascade;

drop table SCHE$SISAG.POA_META_DIRECCION cascade constraints;

alter table SCHE$SISAG.POA_META_PERIODO
   drop primary key cascade;

drop table SCHE$SISAG.POA_META_PERIODO cascade constraints;

alter table SCHE$SISAG.POA_PRODUCTO
   drop primary key cascade;

drop table SCHE$SISAG.POA_PRODUCTO cascade constraints;

alter table SCHE$SISAG.POA_SUB_PRODUCTO
   drop primary key cascade;

drop table SCHE$SISAG.POA_SUB_PRODUCTO cascade constraints;

alter table SCHE$SISAG.RRHH_CARACTER_NECESIDAD
   drop primary key cascade;

drop table SCHE$SISAG.RRHH_CARACTER_NECESIDAD cascade constraints;

alter table SCHE$SISAG.RRHH_DETALLE_NECESIDAD
   drop primary key cascade;

drop table SCHE$SISAG.RRHH_DETALLE_NECESIDAD cascade constraints;

alter table SCHE$SISAG.RRHH_NECESIDAD_PUESTO
   drop primary key cascade;

drop table SCHE$SISAG.RRHH_NECESIDAD_PUESTO cascade constraints;

alter table SCHE$SISAG.RRHH_PERSONA
   drop primary key cascade;

drop table SCHE$SISAG.RRHH_PERSONA cascade constraints;

alter table SCHE$SISAG.RRHH_SOLICITUD_CAPACITACION
   drop primary key cascade;

drop table SCHE$SISAG.RRHH_SOLICITUD_CAPACITACION cascade constraints;

alter table RRHH_TEMA_CURSO
   drop primary key cascade;

drop table RRHH_TEMA_CURSO cascade constraints;

alter table SCHE$SISAG.RRHH_TIPO_PUESTO
   drop primary key cascade;

drop table SCHE$SISAG.RRHH_TIPO_PUESTO cascade constraints;

alter table SCHE$SISAG.RRHH_UNIDAD_ADMINISTRATIVA
   drop primary key cascade;

drop table SCHE$SISAG.RRHH_UNIDAD_ADMINISTRATIVA cascade constraints;

alter table SCHE$SISAG.SEG_BITACORA
   drop primary key cascade;

drop table SCHE$SISAG.SEG_BITACORA cascade constraints;

alter table SCHE$SISAG.SEG_MODULO
   drop primary key cascade;

drop table SCHE$SISAG.SEG_MODULO cascade constraints;

alter table SCHE$SISAG.SEG_PAGINA
   drop primary key cascade;

drop table SCHE$SISAG.SEG_PAGINA cascade constraints;

alter table SCHE$SISAG.SEG_PAGINA_ASIGNADA
   drop primary key cascade;

drop table SCHE$SISAG.SEG_PAGINA_ASIGNADA cascade constraints;

alter table SCHE$SISAG.SEG_PRIVILEGIO
   drop primary key cascade;

drop table SCHE$SISAG.SEG_PRIVILEGIO cascade constraints;

alter table SCHE$SISAG.SEG_PRIVILEGIO_PAGINA
   drop primary key cascade;

drop table SCHE$SISAG.SEG_PRIVILEGIO_PAGINA cascade constraints;

alter table SCHE$SISAG.SEG_ROL
   drop primary key cascade;

drop table SCHE$SISAG.SEG_ROL cascade constraints;

alter table SCHE$SISAG.SEG_ROL_USUARIO
   drop primary key cascade;

drop table SCHE$SISAG.SEG_ROL_USUARIO cascade constraints;

alter table SCHE$SISAG.SEG_SESION
   drop primary key cascade;

drop table SCHE$SISAG.SEG_SESION cascade constraints;

alter table SCHE$SISAG.SEG_TIPO_PAGINA
   drop primary key cascade;

drop table SCHE$SISAG.SEG_TIPO_PAGINA cascade constraints;

alter table SCHE$SISAG.SEG_USUARIO
   drop primary key cascade;

drop table SCHE$SISAG.SEG_USUARIO cascade constraints;

drop user SCHE$SISAG;

/*==============================================================*/
/* User: SCHE$SISAG                                             */
/*==============================================================*/
create user SCHE$SISAG identified by '';

grant ADMINISTER ANY SQL TUNING SET,ADMINISTER DATABASE TRIGGER,ADMINISTER SQL TUNING SET,ADVISOR,ALTER ANY CLUSTER,ALTER ANY CUBE,ALTER ANY CUBE DIMENSION,ALTER ANY DIMENSION,ALTER ANY INDEX,ALTER ANY INDEXTYPE,ALTER ANY MATERIALIZED VIEW,ALTER ANY MINING MODEL,ALTER ANY OPERATOR,ALTER ANY OUTLINE,ALTER ANY PROCEDURE,ALTER ANY ROLE,ALTER ANY SEQUENCE,ALTER ANY SQL PROFILE,ALTER ANY TABLE,ALTER ANY TRIGGER,ALTER ANY TYPE,ALTER DATABASE,ALTER PROFILE,ALTER RESOURCE COST,ALTER ROLLBACK SEGMENT,ALTER SESSION,ALTER SYSTEM,ALTER TABLESPACE,ALTER USER,ANALYZE ANY,ANALYZE ANY DICTIONARY,AQ_ADMINISTRATOR_ROLE,AQ_USER_ROLE,AUDIT ANY,AUDIT SYSTEM,BACKUP ANY TABLE,BECOME USER,CHANGE NOTIFICATION,COMMENT ANY MINING MODEL,COMMENT ANY TABLE,CONNECT,CREATE ANY CLUSTER,CREATE ANY CONTEXT,CREATE ANY CUBE,CREATE ANY CUBE BUILD PROCESS,CREATE ANY CUBE DIMENSION,CREATE ANY DIMENSION,CREATE ANY DIRECTORY,CREATE ANY INDEX,CREATE ANY INDEXTYPE,CREATE ANY JOB,CREATE ANY LIBRARY,CREATE ANY MATERIALIZED VIEW,CREATE ANY MEASURE FOLDER,CREATE ANY MINING MODEL,CREATE ANY OPERATOR,CREATE ANY OUTLINE,CREATE ANY PROCEDURE,CREATE ANY SEQUENCE,CREATE ANY SQL PROFILE,CREATE ANY SYNONYM,CREATE ANY TABLE,CREATE ANY TRIGGER,CREATE ANY TYPE,CREATE ANY VIEW,CREATE CLUSTER,CREATE CUBE,CREATE CUBE BUILD PROCESS,CREATE CUBE DIMENSION,CREATE DATABASE LINK,CREATE DIMENSION,CREATE EXTERNAL JOB,CREATE INDEXTYPE,CREATE JOB,CREATE LIBRARY,CREATE MATERIALIZED VIEW,CREATE MEASURE FOLDER,CREATE MINING MODEL,CREATE OPERATOR,CREATE PROCEDURE,CREATE PROFILE,CREATE PUBLIC DATABASE LINK,CREATE PUBLIC SYNONYM,CREATE ROLE,CREATE ROLLBACK SEGMENT,CREATE SEQUENCE,CREATE SESSION,CREATE SYNONYM,CREATE TABLE,CREATE TABLESPACE,CREATE TRIGGER,CREATE TYPE,CREATE USER,CREATE VIEW,DBA,DEBUG ANY PROCEDURE,DEBUG CONNECT SESSION,DELETE ANY CUBE DIMENSION,DELETE ANY MEASURE FOLDER,DELETE ANY TABLE,DELETE_CATALOG_ROLE,DROP ANY CLUSTER,DROP ANY CONTEXT,DROP ANY CUBE,DROP ANY CUBE BUILD PROCESS,DROP ANY CUBE DIMENSION,DROP ANY DIMENSION,DROP ANY DIRECTORY,DROP ANY INDEX,DROP ANY INDEXTYPE,DROP ANY LIBRARY,DROP ANY MATERIALIZED VIEW,DROP ANY MEASURE FOLDER,DROP ANY MINING MODEL,DROP ANY OPERATOR,DROP ANY OUTLINE,DROP ANY PROCEDURE,DROP ANY ROLE,DROP ANY SEQUENCE,DROP ANY SQL PROFILE,DROP ANY SYNONYM,DROP ANY TABLE,DROP ANY TRIGGER,DROP ANY TYPE,DROP ANY VIEW,DROP PROFILE,DROP PUBLIC DATABASE LINK,DROP PUBLIC SYNONYM,DROP ROLLBACK SEGMENT,DROP TABLESPACE,DROP USER,EXECUTE ANY CLASS,EXECUTE ANY INDEXTYPE,EXECUTE ANY OPERATOR,EXECUTE ANY PROCEDURE,EXECUTE ANY PROGRAM,EXECUTE ANY TYPE,EXECUTE_CATALOG_ROLE,EXEMPT ACCESS POLICY,EXP_FULL_DATABASE,FLASHBACK ANY TABLE,FLASHBACK ARCHIVE ADMINISTER,FORCE ANY TRANSACTION,FORCE TRANSACTION,GLOBAL QUERY REWRITE,GRANT ANY OBJECT PRIVILEGE,GRANT ANY PRIVILEGE,GRANT ANY ROLE,IMP_FULL_DATABASE,INSERT ANY CUBE DIMENSION,INSERT ANY MEASURE FOLDER,INSERT ANY TABLE,LOCK ANY TABLE,MANAGE SCHEDULER,MANAGE TABLESPACE,MERGE ANY VIEW,ON COMMIT REFRESH,QUERY REWRITE,RECOVERY_CATALOG_OWNER,RESOURCE,RESTRICTED SESSION,RESUMABLE,SELECT ANY CUBE,SELECT ANY CUBE DIMENSION,SELECT ANY DICTIONARY,SELECT ANY MINING MODEL,SELECT ANY SEQUENCE,SELECT ANY TABLE,SELECT ANY TRANSACTION,SELECT_CATALOG_ROLE,SNMPAGENT,SYSDBA,SYSOPER,UNDER ANY TYPE,UNDER ANY VIEW,UNLIMITED TABLESPACE,UPDATE ANY CUBE,UPDATE ANY CUBE BUILD PROCESS,UPDATE ANY CUBE DIMENSION,UPDATE ANY TABLE to SCHE$SISAG;

/*==============================================================*/
/* Table: GEN_ESTADO                                            */
/*==============================================================*/
create table SCHE$SISAG.GEN_ESTADO 
(
   "id_estado"          NUMBER               not null,
   "nombre"             VARCHAR2(50 BYTE),
   "descripcion"        VARCHAR2(100 BYTE),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.GEN_ESTADO
   add constraint GEN_ESTADO_PK primary key ("id_estado")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: GEN_PERIODO                                           */
/*==============================================================*/
create table SCHE$SISAG.GEN_PERIODO 
(
   "id_periodo"         NUMBER               not null,
   "per_id_periodo"     NUMBER,
   "mes"                VARCHAR2(50 BYTE),
   "descripcion"        VARCHAR2(50 BYTE),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.GEN_PERIODO
   add constraint PERIODO_PK primary key ("id_periodo")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: GEN_SOLICITUD_FINACIERA                               */
/*==============================================================*/
create table SCHE$SISAG.GEN_SOLICITUD_FINACIERA 
(
   "id_solicitud"       NUMBER               not null,
   "codigo"             NUMBER,
   "id_fuente_financiamiento" NUMBER,
   "id_tipo_solicitud"  NUMBER,
   "id_periodo"         NUMBER,
   "id_meta"            NUMBER,
   "monto"              NUMBER(8,2),
   "descripcion"        VARCHAR2(100 BYTE),
   "fecha_realizacion"  DATE,
   "fecha_pago"         DATE,
   "id_estado"          NUMBER,
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.GEN_SOLICITUD_FINACIERA
   add constraint SOLICITUD_PK primary key ("id_solicitud")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: GEN_TIPO_SOLICITUD                                    */
/*==============================================================*/
create table SCHE$SISAG.GEN_TIPO_SOLICITUD 
(
   "id_tipo_solicitud"  NUMBER               not null,
   "nombre"             VARCHAR2(50 BYTE),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.GEN_TIPO_SOLICITUD
   add constraint TIPO_SOLICITUD_PK primary key ("id_tipo_solicitud")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: GEN_UNIDAD_MEDIDA                                     */
/*==============================================================*/
create table SCHE$SISAG.GEN_UNIDAD_MEDIDA 
(
   "id_unidad_medida"   NUMBER               not null,
   "descripcion"        VARCHAR2(50 BYTE),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.GEN_UNIDAD_MEDIDA
   add constraint UNIDAD_MEDIDA_PK primary key ("id_unidad_medida")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: KATUN_EJE                                             */
/*==============================================================*/
create table SCHE$SISAG.KATUN_EJE 
(
   "id_katun_eje"       NUMBER               not null,
   "id_katun_prioridad" NUMBER,
   "descripcion"        VARCHAR2(100 BYTE),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.KATUN_EJE
   add constraint KATUN_EJE_PK primary key ("id_katun_eje")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: KATUN_META                                            */
/*==============================================================*/
create table SCHE$SISAG.KATUN_META 
(
   "id_katun_meta"      NUMBER               not null,
   "descripcion"        VARCHAR2(100 BYTE),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.KATUN_META
   add constraint KATUN_META_PK primary key ("id_katun_meta")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: KATUN_PRIORIDAD                                       */
/*==============================================================*/
create table SCHE$SISAG.KATUN_PRIORIDAD 
(
   "id_katun_prioridad" NUMBER               not null,
   "id_katun_meta"      NUMBER,
   "descripcion"        VARCHAR2(100 BYTE),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.KATUN_PRIORIDAD
   add constraint KATUN_PRIORIDAD_PK primary key ("id_katun_prioridad")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: POA_META                                              */
/*==============================================================*/
create table SCHE$SISAG.POA_META 
(
   "id_meta"            NUMBER               not null,
   "id_sub_producto"    NUMBER,
   "id_unidad_medida"   NUMBER,
   "descripcion"        VARCHAR2(100 BYTE),
   "resultado_esperado" NUMBER,
   "id_katun_meta"      NUMBER,
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.POA_META
   add constraint META_PK primary key ("id_meta")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: POA_META_DIRECCION                                    */
/*==============================================================*/
create table SCHE$SISAG.POA_META_DIRECCION 
(
   "id_meta"            NUMBER               not null,
   "id_unidad"          NUMBER               not null,
   "observaciones"      VARCHAR2(100 BYTE),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.POA_META_DIRECCION
   add constraint META_DIRECCION_PK primary key ("id_meta", "id_unidad")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: POA_META_PERIODO                                      */
/*==============================================================*/
create table SCHE$SISAG.POA_META_PERIODO 
(
   "id_periodo"         NUMBER               not null,
   "id_meta"            NUMBER               not null,
   "resultado_programado" NUMBER,
   "resultado_ejecutado" NUMBER,
   "observaciones"      VARCHAR2(1024 BYTE),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.POA_META_PERIODO
   add constraint META_PERIODO_PK primary key ("id_periodo", "id_meta")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: POA_PRODUCTO                                          */
/*==============================================================*/
create table SCHE$SISAG.POA_PRODUCTO 
(
   "id_producto"        NUMBER               not null,
   "descripcion"        VARCHAR2(100 BYTE),
   "inciso"             NUMBER,
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.POA_PRODUCTO
   add constraint PRODUCTO_PK primary key ("id_producto")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: POA_SUB_PRODUCTO                                      */
/*==============================================================*/
create table SCHE$SISAG.POA_SUB_PRODUCTO 
(
   "id_sub_producto"    NUMBER               not null,
   "id_producto"        NUMBER,
   "descripcion"        VARCHAR2(100 BYTE),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.POA_SUB_PRODUCTO
   add constraint SUB_PRODUCTO_PK primary key ("id_sub_producto")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: RRHH_CARACTER_NECESIDAD                               */
/*==============================================================*/
create table SCHE$SISAG.RRHH_CARACTER_NECESIDAD 
(
   "id_caracter"        NUMBER               not null,
   "nombre"             VARCHAR2(25 BYTE),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.RRHH_CARACTER_NECESIDAD
   add constraint GEN_CARACTER_CAPACITACION_PK primary key ("id_caracter")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: RRHH_DETALLE_NECESIDAD                                */
/*==============================================================*/
create table SCHE$SISAG.RRHH_DETALLE_NECESIDAD 
(
   "id_detalle"         NUMBER               not null,
   "id_solicitud_capacitacion" NUMBER,
   "id_caracter"        NUMBER,
   "id_tema"            NUMBER,
   "prioridad"          CHAR(1 BYTE),
   "nivel_conocimiento" CHAR(1 BYTE),
   "duracion"           NUMBER(2,2),
   "restrictiva"        CHAR(1 BYTE),
   "necesidad"          VARCHAR(100)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.RRHH_DETALLE_NECESIDAD
   add constraint GEN_DETALLE_CAPACITACION_PK primary key ("id_detalle")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: RRHH_NECESIDAD_PUESTO                                 */
/*==============================================================*/
create table SCHE$SISAG.RRHH_NECESIDAD_PUESTO 
(
   "id_detalle_capacitacion" NUMBER               not null,
   "id_tipo_puesto"     NUMBER               not null,
   "descripcion"        VARCHAR2(50 BYTE),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.RRHH_NECESIDAD_PUESTO
   add constraint ASIGNA_CAPACITACION_PK primary key ("id_detalle_capacitacion", "id_tipo_puesto")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: RRHH_PERSONA                                          */
/*==============================================================*/
create table SCHE$SISAG.RRHH_PERSONA 
(
   "id_persona"         NUMBER               not null,
   "nombres"            VARCHAR2(100 BYTE),
   "apellidos"          VARCHAR2(100 BYTE),
   "direccion"          VARCHAR2(100 BYTE),
   "telefono"           NUMBER(10,0),
   "correo_electronico" VARCHAR2(100 BYTE),
   "id_tipo_puesto"     NUMBER,
   "id_encargado"       NUMBER,
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.RRHH_PERSONA
   add constraint SEG_PERSONA_PK primary key ("id_persona")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: RRHH_SOLICITUD_CAPACITACION                           */
/*==============================================================*/
create table SCHE$SISAG.RRHH_SOLICITUD_CAPACITACION 
(
   "id_solicitud_capacitacion" NUMBER               not null,
   "total_personal"     NUMBER,
   "usr_crea"           NUMBER,
   "id_estado"          NUMBER,
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.RRHH_SOLICITUD_CAPACITACION
   add constraint GEN_SOLICITUD_CAPACITACION_PK primary key ("id_solicitud_capacitacion")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: RRHH_TEMA_CURSO                                       */
/*==============================================================*/
create table RRHH_TEMA_CURSO 
(
   "id_tema"            NUMBER               not null,
   "id_meta"            NUMBER,
   "nombre"             VARCHAR(20),
   "descripcion"        VARCHAR(100)
);

alter table RRHH_TEMA_CURSO
   add constraint PK_RRHH_TEMA_CURSO primary key ("id_tema");

/*==============================================================*/
/* Table: RRHH_TIPO_PUESTO                                      */
/*==============================================================*/
create table SCHE$SISAG.RRHH_TIPO_PUESTO 
(
   "id_tipo_puesto"     NUMBER               not null,
   "id_unidad_admin"    NUMBER,
   "nombre"             VARCHAR2(50 BYTE),
   "descripcion"        VARCHAR2(100 BYTE),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.RRHH_TIPO_PUESTO
   add constraint SEG_TIPO_PUESTO_PK primary key ("id_tipo_puesto")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: RRHH_UNIDAD_ADMINISTRATIVA                            */
/*==============================================================*/
create table SCHE$SISAG.RRHH_UNIDAD_ADMINISTRATIVA 
(
   "id_unidad_admin"    NUMBER               not null,
   "id_subordinado"     NUMBER(38,0),
   "nombre"             VARCHAR2(100 BYTE),
   "descripcion"        VARCHAR2(100 BYTE),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.RRHH_UNIDAD_ADMINISTRATIVA
   add constraint UNIDAD_ADMINISTRATIVA_PK primary key ("id_unidad_admin")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: SEG_BITACORA                                          */
/*==============================================================*/
create table SCHE$SISAG.SEG_BITACORA 
(
   "id_bitacora"        NUMBER               not null,
   "id_sesion"          NUMBER,
   "fecha_crea"         DATE,
   "fecha_mod"          DATE,
   "operacion"          VARCHAR2(100 BYTE),
   "id_pagina"          NUMBER,
   "tablas"             VARCHAR2(100 BYTE),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.SEG_BITACORA
   add constraint BITACORA_PK primary key ("id_bitacora")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: SEG_MODULO                                            */
/*==============================================================*/
create table SCHE$SISAG.SEG_MODULO 
(
   "id_modulo"          NUMBER               not null,
   "nombre"             VARCHAR2(50 BYTE),
   "descripcion"        VARCHAR2(100 BYTE),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.SEG_MODULO
   add constraint MODULO_PK primary key ("id_modulo")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: SEG_PAGINA                                            */
/*==============================================================*/
create table SCHE$SISAG.SEG_PAGINA 
(
   "id_pagina"          NUMBER               not null,
   "nombre"             VARCHAR2(50 BYTE),
   "url"                VARCHAR2(100 BYTE),
   "descripcion"        VARCHAR2(100 BYTE),
   "id_modulo"          NUMBER(38,0),
   "restrictiva"        CHAR(1 BYTE),
   "id_tipo_pagina"     NUMBER
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.SEG_PAGINA
   add constraint PAGINA_PK primary key ("id_pagina")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: SEG_PAGINA_ASIGNADA                                   */
/*==============================================================*/
create table SCHE$SISAG.SEG_PAGINA_ASIGNADA 
(
   "id_asignacion"      NUMBER               not null,
   "id_pagina"          NUMBER,
   "id_rol"             NUMBER,
   "id_usuario"         NUMBER,
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.SEG_PAGINA_ASIGNADA
   add constraint PAGINA_ASIGNADA_PK primary key ("id_asignacion")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: SEG_PRIVILEGIO                                        */
/*==============================================================*/
create table SCHE$SISAG.SEG_PRIVILEGIO 
(
   "id_privilegio"      NUMBER               not null,
   "nombre"             VARCHAR2(50 BYTE),
   "descripcion"        VARCHAR2(100 BYTE),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.SEG_PRIVILEGIO
   add constraint PRIVILEGIO_PK primary key ("id_privilegio")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: SEG_PRIVILEGIO_PAGINA                                 */
/*==============================================================*/
create table SCHE$SISAG.SEG_PRIVILEGIO_PAGINA 
(
   "id_privilegio"      NUMBER               not null,
   "id_asignacion_pagina" NUMBER               not null,
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.SEG_PRIVILEGIO_PAGINA
   add constraint PRIVILEGIO_PAGINA_PK primary key ("id_privilegio", "id_asignacion_pagina")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: SEG_ROL                                               */
/*==============================================================*/
create table SCHE$SISAG.SEG_ROL 
(
   "id_rol"             NUMBER               not null,
   "nombre"             VARCHAR2(50 BYTE),
   "descripcion"        VARCHAR2(100 BYTE),
   "id_unidad_admin"    NUMBER(38,0),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.SEG_ROL
   add constraint ROL_PK primary key ("id_rol")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: SEG_ROL_USUARIO                                       */
/*==============================================================*/
create table SCHE$SISAG.SEG_ROL_USUARIO 
(
   "id_rol"             NUMBER               not null,
   "id_usuario"         NUMBER               not null,
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.SEG_ROL_USUARIO
   add constraint ROL_USUARIO_PK primary key ("id_usuario", "id_rol")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: SEG_SESION                                            */
/*==============================================================*/
create table SCHE$SISAG.SEG_SESION 
(
   "id_sesion"          NUMBER               not null,
   "id_usuario"         NUMBER,
   "hora_inicio"        DATE,
   "hora_fin"           DATE,
   "fecha_sesion"       DATE,
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.SEG_SESION
   add constraint SESION_PK primary key ("id_sesion")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: SEG_TIPO_PAGINA                                       */
/*==============================================================*/
create table SCHE$SISAG.SEG_TIPO_PAGINA 
(
   "id_tipo_pagina"     NUMBER               not null,
   "nombre"             VARCHAR2(50 BYTE),
   "descripcion"        VARCHAR2(100 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.SEG_TIPO_PAGINA
   add constraint SEG_TIPO_PAGINA_PK primary key ("id_tipo_pagina")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

/*==============================================================*/
/* Table: SEG_USUARIO                                           */
/*==============================================================*/
create table SCHE$SISAG.SEG_USUARIO 
(
   "id_usuario"         NUMBER(38,0)         not null,
   "id_persona"         NUMBER,
   "nombre"             VARCHAR2(50 BYTE),
   "pwd"                VARCHAR2(100 BYTE),
   "pregunta"           VARCHAR2(100 BYTE),
   "respuesta"          VARCHAR2(100 BYTE),
   "estado"             CHAR(1 BYTE),
   "email"              VARCHAR2(100 BYTE),
   "telefono"           NUMBER(10,0),
   "restrictiva"        CHAR(1 BYTE)
)
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG";

alter table SCHE$SISAG.SEG_USUARIO
   add constraint USUARIO_PK primary key ("id_usuario")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SCHE_SISAG"  ENABLE;

alter table SCHE$SISAG.GEN_PERIODO
   add constraint PERIODO_PERIODO_FK foreign key ("per_id_periodo")
      references SCHE$SISAG.GEN_PERIODO ("id_periodo");

alter table SCHE$SISAG.GEN_SOLICITUD_FINACIERA
   add constraint GEN_SOLICITUD_FINACIERA_FK1 foreign key ("id_estado")
      references SCHE$SISAG.GEN_ESTADO ("id_estado");

alter table SCHE$SISAG.GEN_SOLICITUD_FINACIERA
   add constraint SOLICITUD_META_FK foreign key ("id_meta")
      references SCHE$SISAG.POA_META ("id_meta");

alter table SCHE$SISAG.GEN_SOLICITUD_FINACIERA
   add constraint SOLICITUD_PERIODO_FK foreign key ("id_periodo")
      references SCHE$SISAG.GEN_PERIODO ("id_periodo");

alter table SCHE$SISAG.GEN_SOLICITUD_FINACIERA
   add constraint SOLICITUD_TIPO_SOLICITUD_FK foreign key ("id_tipo_solicitud")
      references SCHE$SISAG.GEN_TIPO_SOLICITUD ("id_tipo_solicitud");

alter table SCHE$SISAG.KATUN_EJE
   add constraint KATUN_EJE_PRIORIDAD_FK foreign key ("id_katun_prioridad")
      references SCHE$SISAG.KATUN_PRIORIDAD ("id_katun_prioridad");

alter table SCHE$SISAG.KATUN_PRIORIDAD
   add constraint KATUN_PRIORIDAD_META_FK foreign key ("id_katun_meta")
      references SCHE$SISAG.KATUN_META ("id_katun_meta");

alter table SCHE$SISAG.POA_META
   add constraint META_KATUN_META_FK foreign key ("id_katun_meta")
      references SCHE$SISAG.KATUN_META ("id_katun_meta");

alter table SCHE$SISAG.POA_META
   add constraint META_SUB_PRODUCTO_FK foreign key ("id_sub_producto")
      references SCHE$SISAG.POA_SUB_PRODUCTO ("id_sub_producto");

alter table SCHE$SISAG.POA_META
   add constraint META_UNIDAD_MEDIDA_FK foreign key ("id_unidad_medida")
      references SCHE$SISAG.GEN_UNIDAD_MEDIDA ("id_unidad_medida");

alter table SCHE$SISAG.POA_META_DIRECCION
   add constraint META_DIRECCION_META_FK foreign key ("id_meta")
      references SCHE$SISAG.POA_META ("id_meta");

alter table SCHE$SISAG.POA_META_DIRECCION
   add constraint META_DIRECCION_UNIDAD_FK foreign key ("id_unidad")
      references SCHE$SISAG.RRHH_UNIDAD_ADMINISTRATIVA ("id_unidad_admin");

alter table SCHE$SISAG.POA_META_PERIODO
   add constraint META_PERIODO_META_FK foreign key ("id_meta")
      references SCHE$SISAG.POA_META ("id_meta");

alter table SCHE$SISAG.POA_META_PERIODO
   add constraint META_PERIODO_PERIODO_FK foreign key ("id_periodo")
      references SCHE$SISAG.GEN_PERIODO ("id_periodo");

alter table SCHE$SISAG.POA_SUB_PRODUCTO
   add constraint SUB_PRODUCTO_PRODUCTO_FK foreign key ("id_producto")
      references SCHE$SISAG.POA_PRODUCTO ("id_producto");

alter table SCHE$SISAG.RRHH_DETALLE_NECESIDAD
   add constraint GEN_DETALLE_CAPACITACION_FK1 foreign key ("id_solicitud_capacitacion")
      references SCHE$SISAG.RRHH_SOLICITUD_CAPACITACION ("id_solicitud_capacitacion");

alter table SCHE$SISAG.RRHH_DETALLE_NECESIDAD
   add constraint FK_RRHH_DET_REFERENCE_RRHH_CAR foreign key ("id_caracter")
      references SCHE$SISAG.RRHH_CARACTER_NECESIDAD ("id_caracter");

alter table SCHE$SISAG.RRHH_DETALLE_NECESIDAD
   add constraint FK_RRHH_DET_REFERENCE_RRHH_TEM foreign key ("id_tema")
      references RRHH_TEMA_CURSO ("id_tema");

alter table SCHE$SISAG.RRHH_NECESIDAD_PUESTO
   add constraint GEN_ASIGNA_CAPACITACION_FK1 foreign key ("id_detalle_capacitacion")
      references SCHE$SISAG.RRHH_DETALLE_NECESIDAD ("id_detalle");

alter table SCHE$SISAG.RRHH_NECESIDAD_PUESTO
   add constraint GEN_ASIGNA_CAPACITACION_FK2 foreign key ("id_tipo_puesto")
      references SCHE$SISAG.RRHH_TIPO_PUESTO ("id_tipo_puesto");

alter table SCHE$SISAG.RRHH_PERSONA
   add constraint SEG_PERSONA_FK1 foreign key ("id_encargado")
      references SCHE$SISAG.RRHH_PERSONA ("id_persona");

alter table SCHE$SISAG.RRHH_PERSONA
   add constraint SEG_PERSONA_FK2 foreign key ("id_tipo_puesto")
      references SCHE$SISAG.RRHH_TIPO_PUESTO ("id_tipo_puesto");

alter table SCHE$SISAG.RRHH_SOLICITUD_CAPACITACION
   add constraint GEN_SOLICITUD_CAPACITACIO_FK2 foreign key ("usr_crea")
      references SCHE$SISAG.SEG_USUARIO ("id_usuario");

alter table SCHE$SISAG.RRHH_SOLICITUD_CAPACITACION
   add constraint GEN_SOLICITUD_CAPACITACIO_FK4 foreign key ("id_estado")
      references SCHE$SISAG.GEN_ESTADO ("id_estado");

alter table RRHH_TEMA_CURSO
   add constraint FK_RRHH_TEM_REFERENCE_POA_META foreign key ("id_meta")
      references SCHE$SISAG.POA_META ("id_meta");

alter table SCHE$SISAG.RRHH_TIPO_PUESTO
   add constraint FK_RRHH_TIP_REFERENCE_RRHH_UNI foreign key ("id_unidad_admin")
      references SCHE$SISAG.RRHH_UNIDAD_ADMINISTRATIVA ("id_unidad_admin");

alter table SCHE$SISAG.SEG_BITACORA
   add constraint BITACORA_PAGINA_FK foreign key ("id_pagina")
      references SCHE$SISAG.SEG_PAGINA ("id_pagina");

alter table SCHE$SISAG.SEG_BITACORA
   add constraint BITACORA_SESION_FK foreign key ("id_sesion")
      references SCHE$SISAG.SEG_SESION ("id_sesion");

alter table SCHE$SISAG.SEG_PAGINA
   add constraint PAGINA_MODULO_FK foreign key ("id_modulo")
      references SCHE$SISAG.SEG_MODULO ("id_modulo");

alter table SCHE$SISAG.SEG_PAGINA
   add constraint SEG_PAGINA_FK1 foreign key ("id_tipo_pagina")
      references SCHE$SISAG.SEG_TIPO_PAGINA ("id_tipo_pagina");

alter table SCHE$SISAG.SEG_PAGINA_ASIGNADA
   add constraint PAGINA_ASIGNADA_PAGINA_FK foreign key ("id_pagina")
      references SCHE$SISAG.SEG_PAGINA ("id_pagina");

alter table SCHE$SISAG.SEG_PAGINA_ASIGNADA
   add constraint PAGINA_ASIGNADA_ROL_FK foreign key ("id_rol")
      references SCHE$SISAG.SEG_ROL ("id_rol");

alter table SCHE$SISAG.SEG_PAGINA_ASIGNADA
   add constraint PAGINA_ASIGNADA_USUARIO_FK foreign key ("id_usuario")
      references SCHE$SISAG.SEG_USUARIO ("id_usuario");

alter table SCHE$SISAG.SEG_PRIVILEGIO_PAGINA
   add constraint SEG_PRIVILEGIO_PAGINA_FK1 foreign key ("id_asignacion_pagina")
      references SCHE$SISAG.SEG_PAGINA_ASIGNADA ("id_asignacion");

alter table SCHE$SISAG.SEG_PRIVILEGIO_PAGINA
   add constraint SEG_PRIVILEGIO_PAGINA_FK2 foreign key ("id_privilegio")
      references SCHE$SISAG.SEG_PRIVILEGIO ("id_privilegio");

alter table SCHE$SISAG.SEG_ROL
   add constraint ROL_UNIDAD_ADMINISTRATIVA_FK foreign key ("id_unidad_admin")
      references SCHE$SISAG.RRHH_UNIDAD_ADMINISTRATIVA ("id_unidad_admin");

alter table SCHE$SISAG.SEG_ROL_USUARIO
   add constraint ROL_USUARIO_ROL_FK foreign key ("id_rol")
      references SCHE$SISAG.SEG_ROL ("id_rol");

alter table SCHE$SISAG.SEG_ROL_USUARIO
   add constraint ROL_USUARIO_USUARIO_FK foreign key ("id_usuario")
      references SCHE$SISAG.SEG_USUARIO ("id_usuario");

alter table SCHE$SISAG.SEG_SESION
   add constraint SESION_USUARIO_FK foreign key ("id_usuario")
      references SCHE$SISAG.SEG_USUARIO ("id_usuario");

alter table SCHE$SISAG.SEG_USUARIO
   add constraint FK_SEG_USUA_REFERENCE_RRHH_PER foreign key ("id_persona")
      references SCHE$SISAG.RRHH_PERSONA ("id_persona");

