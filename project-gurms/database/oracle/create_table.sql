/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2019/11/22 22:43:50                          */
/*==============================================================*/


drop table sys_confirm cascade constraints;

drop table sys_confirm_checklog cascade constraints;

drop table sys_confirm_datalog cascade constraints;

drop table sys_confirm_user cascade constraints;

drop table sys_dict_index cascade constraints;

drop table sys_dict_value cascade constraints;

drop table sys_menu cascade constraints;

drop table sys_org cascade constraints;

drop table sys_param cascade constraints;

drop table sys_param_info cascade constraints;

drop table sys_role cascade constraints;

drop table sys_role_menu cascade constraints;

drop table sys_sno cascade constraints;

drop table sys_user cascade constraints;

drop table sys_user_actlog cascade constraints;

drop table sys_user_login cascade constraints;

drop table sys_user_role cascade constraints;

drop sequence seq_sys_logid;

drop sequence seq_sys_orgid;

drop sequence seq_sys_roleid;

drop sequence seq_sys_userid;

create sequence seq_sys_logid
increment by 1
start with 1
 maxvalue 9999999999999999
 minvalue 1;

create sequence seq_sys_orgid
increment by 1
start with 1
 maxvalue 99999999;

create sequence seq_sys_roleid
increment by 1
start with 1
 maxvalue 99999999;

create sequence seq_sys_userid
increment by 1
start with 1
 maxvalue 9999999999
 minvalue 1;

/*==============================================================*/
/* Table: sys_confirm                                           */
/*==============================================================*/
create table sys_confirm 
(
   confirmid            NUMBER(4)            default 0 not null,
   unioncode            VARCHAR2(8)          default '0000' not null,
   tablename            VARCHAR2(32)         not null,
   checklevel           NUMBER(1)            default 0 not null,
   constraint PK_SYS_CONFIRM primary key (unioncode, tablename)
);

comment on table sys_confirm is
'�������ñ�[cache]';

comment on column sys_confirm.tablename is
'�������ݱ���';

comment on column sys_confirm.checklevel is
'���˼���,����';

/*==============================================================*/
/* Table: sys_confirm_checklog                                  */
/*==============================================================*/
create table sys_confirm_checklog 
(
   logid                INTEGER              not null,
   unioncode            VARCHAR2(8)          default '0000' not null,
   datalog              INTEGER              not null,
   checker              INTEGER              not null,
   checklevel           NUMBER(1)            default 0 not null,
   checkdate            VARCHAR2(8)          not null,
   checktime            VARCHAR2(6)          not null,
   status               CHAR(1)              default '0' not null,
   summary              VARCHAR2(256),
   constraint PK_SYS_CONFIRM_CHECKLOG primary key (logid)
);

comment on column sys_confirm_checklog.logid is
'������ˮ��[identity]';

comment on column sys_confirm_checklog.datalog is
'����������ˮ��';

comment on column sys_confirm_checklog.checker is
'������';

comment on column sys_confirm_checklog.checklevel is
'���˼��𣬵���';

comment on column sys_confirm_checklog.checkdate is
'��������';

comment on column sys_confirm_checklog.checktime is
'����ʱ��';

comment on column sys_confirm_checklog.status is
'����״̬��0-δ���ˣ�1-����ͨ����2-���˲�ͨ����';

comment on column sys_confirm_checklog.summary is
'�������';

/*==============================================================*/
/* Table: sys_confirm_datalog                                   */
/*==============================================================*/
create table sys_confirm_datalog 
(
   logid                INTEGER              not null,
   unioncode            VARCHAR2(8)          default '0000' not null,
   confirmid            NUMBER(4)            default 0 not null,
   edittype             CHAR(1)              default '0' not null,
   dataid               VARCHAR2(256),
   fulldata             VARCHAR2(2048),
   extdata              VARCHAR2(2048),
   editer               INTEGER              not null,
   editdate             VARCHAR2(8)          not null,
   edittime             VARCHAR2(6)          not null,
   currentstatus        CHAR(1)              default '0' not null,
   currentlevel         NUMBER(1)            default 0 not null,
   endflag              CHAR(1)              default '0' not null,
   constraint PK_SYS_CONFIRM_DATALOG primary key (logid)
);

comment on table sys_confirm_datalog is
'������������ˮ��';

comment on column sys_confirm_datalog.logid is
'������ˮ��[identity]';

comment on column sys_confirm_datalog.confirmid is
'��������ID';

comment on column sys_confirm_datalog.edittype is
'��Ϊ��1-insert��2-update��3-delete��';

comment on column sys_confirm_datalog.dataid is
'����id��json';

comment on column sys_confirm_datalog.fulldata is
'Ҫ���˵��������ݣ�json�ַ���';

comment on column sys_confirm_datalog.extdata is
'fulldata���治�µģ����Բ�ִ�������';

comment on column sys_confirm_datalog.editer is
'�༭��';

comment on column sys_confirm_datalog.editdate is
'�༭����';

comment on column sys_confirm_datalog.edittime is
'�༭ʱ��';

comment on column sys_confirm_datalog.currentstatus is
'��ǰ����״̬��0-δ���ˣ�1-����ͨ����2-���˲�ͨ����';

comment on column sys_confirm_datalog.currentlevel is
'��ǰ���˼���';

comment on column sys_confirm_datalog.endflag is
'����־��0-δ������1-������';

/*==============================================================*/
/* Table: sys_confirm_user                                      */
/*==============================================================*/
create table sys_confirm_user 
(
   userid               INTEGER              not null,
   confirmid            NUMBER(4)            default 0 not null,
   checklevel           NUMBER(1)            default 0 not null,
   constraint PK_SYS_CONFIRM_USER primary key (userid, confirmid)
);

comment on table sys_confirm_user is
'[cache]';

comment on column sys_confirm_user.userid is
'�����û�ID';

comment on column sys_confirm_user.confirmid is
'��������ID';

comment on column sys_confirm_user.checklevel is
'���˼���';

/*==============================================================*/
/* Table: sys_dict_index                                        */
/*==============================================================*/
create table sys_dict_index 
(
   unioncode            VARCHAR2(8)          default '0000' not null,
   dictcode             NUMBER(4)            default 0 not null,
   dictname             VARCHAR2(32)         not null,
   dictgroup            CHAR(1)              default '0' not null,
   editflag             CHAR(1)              default '0' not null,
   constraint PK_SYS_DICT_INDEX primary key (dictcode, unioncode)
);

comment on table sys_dict_index is
'[cache]';

comment on column sys_dict_index.dictcode is
'�ֵ����';

comment on column sys_dict_index.dictname is
'�ֵ�����';

comment on column sys_dict_index.dictgroup is
'��������';

comment on column sys_dict_index.editflag is
'�Ƿ�ɱ༭��0-���ɼ���1-ֻ����2-��д��';

/*==============================================================*/
/* Table: sys_dict_value                                        */
/*==============================================================*/
create table sys_dict_value 
(
   unioncode            VARCHAR2(8)          default '0000' not null,
   dictcode             NUMBER(4)            default 0 not null,
   itemcode             VARCHAR2(8)          not null,
   itemname             VARCHAR2(32)         not null,
   constraint PK_SYS_DICT_VALUE primary key (dictcode, itemcode, unioncode)
);

comment on table sys_dict_value is
'[cache]';

comment on column sys_dict_value.dictcode is
'�ֵ����';

comment on column sys_dict_value.itemcode is
'ѡ�����';

comment on column sys_dict_value.itemname is
'ѡ������';

/*==============================================================*/
/* Table: sys_menu                                              */
/*==============================================================*/
create table sys_menu 
(
   menuid               VARCHAR2(8)          not null,
   sysid                NUMBER(1)            default 0 not null,
   menuname             VARCHAR2(16)         not null,
   menuurl              VARCHAR2(32),
   parentmenu           VARCHAR2(8),
   menutype             CHAR(1)              default '0' not null,
   accesstype           CHAR(1)              default '0' not null,
   status               CHAR(1)              default '0' not null,
   menucss              VARCHAR2(32),
   constraint PK_SYS_MENU primary key (menuid)
);

comment on table sys_menu is
'[cache]';

comment on column sys_menu.menuid is
'�˵�ID';

comment on column sys_menu.sysid is
'ϵͳID';

comment on column sys_menu.menuname is
'�˵�����';

comment on column sys_menu.menuurl is
'�˵���ַ';

comment on column sys_menu.parentmenu is
'�ϼ��˵�';

comment on column sys_menu.menutype is
'�˵�����0-Ŀ¼��1-�˵���2-ҳ������';

comment on column sys_menu.accesstype is
'����Ȩ�ޣ�0-��������ʣ�1-��¼���ʣ�2-����Ȩ';

comment on column sys_menu.status is
'�˵�״̬��0-��Ч��1-��Ч';

comment on column sys_menu.menucss is
'�˵���ʽ';

/*==============================================================*/
/* Table: sys_org                                               */
/*==============================================================*/
create table sys_org 
(
   orgid                INTEGER              not null,
   unioncode            VARCHAR2(8)          default '0000' not null,
   shortname            VARCHAR2(16)         not null,
   fullname             VARCHAR2(32),
   linkman              VARCHAR2(32),
   linktel              VARCHAR2(16),
   faxno                VARCHAR2(16),
   address              VARCHAR2(64),
   postcode             VARCHAR2(8),
   email                VARCHAR2(64),
   parentorg            INTEGER,
   orgtype              CHAR(1)              default '0' not null,
   remark               VARCHAR2(32),
   constraint PK_SYS_ORG primary key (orgid)
);

comment on column sys_org.orgid is
'����ID,�ڲ��Զ�����[identity]';

comment on column sys_org.shortname is
'�������';

comment on column sys_org.fullname is
'����ȫ��';

comment on column sys_org.linkman is
'��ϵ��';

comment on column sys_org.linktel is
'��ϵ�绰';

comment on column sys_org.faxno is
'����';

comment on column sys_org.address is
'��ϵ��ַ';

comment on column sys_org.postcode is
'��������';

comment on column sys_org.email is
'�����ʼ�';

comment on column sys_org.parentorg is
'�ϼ�����';

comment on column sys_org.orgtype is
'��������(0-���⣬��ѡ��1-�ܣ�2-�֣�3-֧)';

comment on column sys_org.remark is
'��ע';

/*==============================================================*/
/* Table: sys_param                                             */
/*==============================================================*/
create table sys_param 
(
   unioncode            VARCHAR2(8)          default '0000' not null,
   paramid              NUMBER(4)            default 0 not null,
   paramvalue           VARCHAR2(32)         not null,
   constraint PK_SYS_PARAM primary key (paramid, unioncode)
);

comment on table sys_param is
'[cache]';

/*==============================================================*/
/* Table: sys_param_info                                        */
/*==============================================================*/
create table sys_param_info 
(
   paramid              NUMBER(4)            default 0 not null,
   paramname            VARCHAR2(32)         not null,
   paramgroup           CHAR(1)              default '0' not null,
   edittype             CHAR(1)              default '0' not null,
   initvalue            VARCHAR2(32)         not null,
   valuelength          NUMBER(4)            default 0,
   texttitle            VARCHAR2(32),
   texttail             VARCHAR2(32),
   valuelist            VARCHAR2(256),
   constraint PK_SYS_PARAM_INFO primary key (paramid)
);

comment on table sys_param_info is
'[cache]';

comment on column sys_param_info.paramid is
'����ID';

comment on column sys_param_info.paramname is
'��������';

comment on column sys_param_info.paramgroup is
'�������飬�ֵ�';

comment on column sys_param_info.edittype is
'1 ֻ���޷��޸ģ�2 input �޸ģ�3 select �޸�';

comment on column sys_param_info.initvalue is
'��ʼֵ';

comment on column sys_param_info.valuelength is
'����ֵ����,0-����鳤�ȣ�����ֵЧ�鳤��';

comment on column sys_param_info.texttitle is
'����ͷ';

comment on column sys_param_info.texttail is
'����β';

comment on column sys_param_info.valuelist is
'�ؼ���ʾ��ֵ�б��硰0|��;1|�ǡ�';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role 
(
   roleid               INTEGER              not null,
   unioncode            VARCHAR2(8)          default '0000' not null,
   rolename             VARCHAR2(32)         not null,
   status               CHAR(1)              default '0' not null,
   startdate            VARCHAR2(8),
   enddate              VARCHAR2(8),
   belong               VARCHAR2(16),
   creator              INTEGER              not null,
   constraint PK_SYS_ROLE primary key (roleid)
);

comment on table sys_role is
'[cache]';

comment on column sys_role.roleid is
'��ɫID,�ڲ��Զ�����[identity]';

comment on column sys_role.rolename is
'��ɫ����';

comment on column sys_role.status is
'��ɫ״̬��0-��Ч��1-��Ч';

comment on column sys_role.startdate is
'��ɫ��Ч����';

comment on column sys_role.enddate is
'��ɫʧЧ����';

comment on column sys_role.belong is
'������Ԥ������������ɫ��ȣ�';

comment on column sys_role.creator is
'������';

/*==============================================================*/
/* Table: sys_role_menu                                         */
/*==============================================================*/
create table sys_role_menu 
(
   roleid               INTEGER              not null,
   menuid               VARCHAR2(8)          not null,
   constraint PK_SYS_ROLE_MENU primary key (roleid, menuid)
);

/*==============================================================*/
/* Table: sys_sno                                               */
/*==============================================================*/
create table sys_sno 
(
   unioncode            VARCHAR2(8)          default '0000' not null,
   noid                 NUMBER(4)            default 0 not null,
   noname               VARCHAR2(32)         not null,
   initvalue            INTEGER              not null,
   nextvalue            INTEGER              not null,
   fixedflag            CHAR(1)              default '0' not null,
   fixedlength          NUMBER(4)            default 0,
   fillchar             CHAR(1)              default '0',
   notype               CHAR(1)              default '0' not null,
   cycletype            CHAR(1)              default '0' not null,
   cycledate            VARCHAR2(8),
   endvalue             INTEGER              not null,
   prefix               VARCHAR2(16),
   suffix               VARCHAR2(16),
   constraint PK_SYS_SNO primary key (noid, unioncode)
);

comment on table sys_sno is
'ϵͳ��ˮ��';

comment on column sys_sno.noid is
'��ˮ��ID';

comment on column sys_sno.noname is
'��ˮ������';

comment on column sys_sno.initvalue is
'��ʼֵ';

comment on column sys_sno.nextvalue is
'�¸�ֵ';

comment on column sys_sno.fixedflag is
'������־(0-���̶���1-����)';

comment on column sys_sno.fixedlength is
'�������ȣ�������ǰ��׺';

comment on column sys_sno.fillchar is
'����ַ�';

comment on column sys_sno.notype is
'���ͣ�1-������2-�ݼ���';

comment on column sys_sno.cycletype is
'ѭ�����ڣ�0-ָ��ֵ���ã�1-����ѭ����2-����ѭ����3-����ѭ����';

comment on column sys_sno.cycledate is
'ѭ����ʼ����';

comment on column sys_sno.endvalue is
'ָ������ֵ';

comment on column sys_sno.prefix is
'ǰ׺��֧������/ʱ��ģ�壬�� ab{date}{time}cd';

comment on column sys_sno.suffix is
'��׺��֧������/ʱ��ģ�壬�� ab{date}{time}cd';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user 
(
   userid               INTEGER              not null,
   unioncode            VARCHAR2(8)          default '0000' not null,
   username             VARCHAR2(32)         not null,
   loginid              VARCHAR2(32)         not null,
   loginpasswd          CHAR(32)             not null,
   salt                 VARCHAR2(8)          not null,
   passwdvaliddate      VARCHAR2(8)          not null,
   sex                  CHAR(1)              default '0' not null,
   mobileno             VARCHAR2(16)         not null,
   email                VARCHAR2(64),
   orgid                INTEGER              not null,
   idtype               CHAR(1)              default '0',
   idcode               VARCHAR2(32),
   idname               VARCHAR2(32),
   postcode             VARCHAR2(8),
   address              VARCHAR2(64),
   logindate            VARCHAR2(8),
   logintime            VARCHAR2(6),
   status               CHAR(1)              default '0' not null,
   loginerror           NUMBER(4)            default 0 not null,
   opendate             VARCHAR2(8),
   constraint PK_SYS_USER primary key (userid)
);

comment on column sys_user.userid is
'�û�ID,�ڲ��Զ�����[identity]';

comment on column sys_user.username is
'�û�����';

comment on column sys_user.loginid is
'��¼��';

comment on column sys_user.loginpasswd is
'��¼����';

comment on column sys_user.salt is
'������';

comment on column sys_user.passwdvaliddate is
'����ʧЧ����';

comment on column sys_user.sex is
'�Ա�0-Ů��1-��';

comment on column sys_user.mobileno is
'�ֻ�����';

comment on column sys_user.email is
'�����ʼ�';

comment on column sys_user.orgid is
'��������';

comment on column sys_user.idtype is
'֤������';

comment on column sys_user.idcode is
'֤������';

comment on column sys_user.idname is
'֤������';

comment on column sys_user.postcode is
'��������';

comment on column sys_user.address is
'��ϵ��ַ';

comment on column sys_user.logindate is
'�ϴε�¼����';

comment on column sys_user.logintime is
'�ϴε�¼ʱ��';

comment on column sys_user.status is
'�û�״̬��1��������2��������3������';

comment on column sys_user.loginerror is
'������¼ʧ�ܴ���';

comment on column sys_user.opendate is
'��������';

/*==============================================================*/
/* Table: sys_user_actlog                                       */
/*==============================================================*/
create table sys_user_actlog 
(
   logid                INTEGER              not null,
   unioncode            VARCHAR2(8)          default '0000' not null,
   userid               INTEGER              not null,
   menuid               VARCHAR2(8),
   requrl               VARCHAR2(32),
   reqmethod            VARCHAR2(32),
   reqdata              VARCHAR2(256),
   actdate              VARCHAR2(8)          not null,
   acttime              VARCHAR2(6)          not null,
   accesstype           CHAR(1)              default '0' not null,
   ipaddress            VARCHAR2(16),
   constraint PK_SYS_USER_ACTLOG primary key (logid)
);

comment on table sys_user_actlog is
'�û���Ϊ��־';

comment on column sys_user_actlog.logid is
'[identity]';

comment on column sys_user_actlog.userid is
'�û�ID';

comment on column sys_user_actlog.menuid is
'�˵�ID';

comment on column sys_user_actlog.requrl is
'����URL';

comment on column sys_user_actlog.reqmethod is
'���󷽷�';

comment on column sys_user_actlog.reqdata is
'�������ݣ�json';

comment on column sys_user_actlog.actdate is
'��Ϊ����';

comment on column sys_user_actlog.acttime is
'��Ϊʱ��';

comment on column sys_user_actlog.accesstype is
'��¼��ʽ��0-pc��1-�ֻ���';

/*==============================================================*/
/* Table: sys_user_login                                        */
/*==============================================================*/
create table sys_user_login 
(
   logid                INTEGER              not null,
   unioncode            VARCHAR2(8)          default '0000' not null,
   userid               INTEGER              default 0 not null,
   logindate            VARCHAR2(8),
   logintime            VARCHAR2(6),
   loginpasswd          CHAR(32)             not null,
   loginip              VARCHAR2(16),
   logintype            CHAR(1)              default '0' not null,
   loginresult          CHAR(1)              default '0' not null,
   summary              VARCHAR2(32),
   constraint PK_SYS_USER_LOGIN primary key (logid)
);

comment on column sys_user_login.logid is
'[identity]';

comment on column sys_user_login.logindate is
'��¼����';

comment on column sys_user_login.logintime is
'��¼ʱ��';

comment on column sys_user_login.loginpasswd is
'��¼����';

comment on column sys_user_login.loginip is
'��¼IP';

comment on column sys_user_login.logintype is
'��¼��ʽ��0-pc��1-�ֻ���';

comment on column sys_user_login.loginresult is
'��¼�Ƿ�ɹ� 0-ʧ�ܣ�1-�ɹ�';

comment on column sys_user_login.summary is
'˵��';

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role 
(
   userid               INTEGER              not null,
   roleid               INTEGER              not null,
   constraint PK_SYS_USER_ROLE primary key (userid, roleid)
);

