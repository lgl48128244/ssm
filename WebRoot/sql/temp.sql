prompt PL/SQL Developer import file
prompt Created on 2015年6月24日 by Administrator
set feedback off
set define off
prompt Creating EMAIL...
create table EMAIL
(
  e_id       NUMBER(5) not null,
  recipients VARCHAR2(50),
  title      VARCHAR2(50),
  content    VARCHAR2(4000),
  sender     VARCHAR2(50),
  accessory  VARCHAR2(200),
  isread     VARCHAR2(8) default '未读',
  time       VARCHAR2(50),
  isdeleted  NUMBER(2) default 0
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table EMAIL
  add constraint PK_EID primary key (E_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table EMAIL
  add constraint E_ISDELETED
  check (isdeleted in(0,1,2));

prompt Creating USERS...
create table USERS
(
  u_id       NUMBER(5) not null,
  uname      VARCHAR2(20) not null,
  nickname   VARCHAR2(20) not null,
  upassword  VARCHAR2(16) not null,
  usex       VARCHAR2(4) default '男',
  uage       NUMBER(3) default 20 not null,
  utelephone VARCHAR2(20) not null,
  uaddress   VARCHAR2(50),
  role       VARCHAR2(20) default '普通用户' not null,
  isdeleted  NUMBER(2) default 0 not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table USERS
  add constraint PK_UID primary key (U_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table USERS
  add constraint ROLE
  check (role in('普通用户','经理'));
alter table USERS
  add constraint USEX
  check (usex in('男','女'));
alter table USERS
  add constraint U_ISDELETED
  check (ISDELETED in(0,1));

prompt Creating VACATION...
create table VACATION
(
  v_id      NUMBER(5) not null,
  name      VARCHAR2(20),
  starttime VARCHAR2(50) not null,
  endtime   VARCHAR2(50) not null,
  totalday  NUMBER(3) not null,
  reason    VARCHAR2(100),
  applicant VARCHAR2(20) not null,
  examiner  VARCHAR2(20) not null,
  isstatus  VARCHAR2(12) default '未审核',
  isdeleted NUMBER(2) default 0 not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table VACATION
  add constraint PK_VID primary key (V_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table VACATION
  add constraint V_ISDELETED
  check (ISDELETED in(0,1));

prompt Disabling triggers for EMAIL...
alter table EMAIL disable all triggers;
prompt Disabling triggers for USERS...
alter table USERS disable all triggers;
prompt Disabling triggers for VACATION...
alter table VACATION disable all triggers;
prompt Loading EMAIL...
insert into EMAIL (e_id, recipients, title, content, sender, accessory, isread, time, isdeleted)
values (1, 'haha', '我的中国心', '式', 'admin', 'temp.sql', '未读', '2015-06-20', 0);
insert into EMAIL (e_id, recipients, title, content, sender, accessory, isread, time, isdeleted)
values (1009, 'admin001', '我的中国心', '1111', 'admin', 'temp.sql', '已读', '2015-06-24', 1);
insert into EMAIL (e_id, recipients, title, content, sender, accessory, isread, time, isdeleted)
values (1011, 'admin001', '我的中国心', 'qqqqqq', 'admin', 'LibAntiPrtSc_INFORMATION.log', '已读', '2015-06-24', 1);
insert into EMAIL (e_id, recipients, title, content, sender, accessory, isread, time, isdeleted)
values (1012, 'admin001', '端午节', '345', 'admin', '12779881_980x1200_850.jpg', '已读', '2015-06-24', 0);
insert into EMAIL (e_id, recipients, title, content, sender, accessory, isread, time, isdeleted)
values (101, '青鸟', '我的中国心', '很好，很强大！', 'accp', 'qedit.rar', '未读', '2015-06-12', 0);
insert into EMAIL (e_id, recipients, title, content, sender, accessory, isread, time, isdeleted)
values (120, '青鸟', '1111', '在那遥远的地方', 'accp', 'QQ图片20150410153200.png', '未读', '2015-06-12', 0);
insert into EMAIL (e_id, recipients, title, content, sender, accessory, isread, time, isdeleted)
values (141, 'bear', '111', 'aaaaaa', 'accp', 'MXML 3.chm', '已读', '2015-06-12', 0);
insert into EMAIL (e_id, recipients, title, content, sender, accessory, isread, time, isdeleted)
values (142, 'temper', 'title', '很好，很强大！', 'accp', 'QQ图片20150410153200.png', '未读', '2015-06-12', 0);
insert into EMAIL (e_id, recipients, title, content, sender, accessory, isread, time, isdeleted)
values (189, 'hahaa', '我的中国心', '鑫', 'accp', 'Java面试宝典2013_PDF版.pdf', '已读', '2015-06-14', 0);
insert into EMAIL (e_id, recipients, title, content, sender, accessory, isread, time, isdeleted)
values (4, 'bear', 'word', '电子文档', 'admin001', '../webapps/MyOffice/file/JSP分页代码.doc', '已读', '2012-05-22', 0);
insert into EMAIL (e_id, recipients, title, content, sender, accessory, isread, time, isdeleted)
values (3, 'bear', '狗狗', '看看', 'admin001', '../webapps/MyOffice/file/03421034O-9.gif', '已读', '2012-05-22', 0);
commit;
prompt 11 records loaded
prompt Loading USERS...
insert into USERS (u_id, uname, nickname, upassword, usex, uage, utelephone, uaddress, role, isdeleted)
values (102, 'user', 'haha', 'user', '男', 23, '18201508824', '北京', '普通用户', 0);
insert into USERS (u_id, uname, nickname, upassword, usex, uage, utelephone, uaddress, role, isdeleted)
values (101, 'admin', 'admin001', 'admin', '男', 25, '18201508824', '合肥包河区', '经理', 0);
commit;
prompt 2 records loaded
prompt Loading VACATION...
insert into VACATION (v_id, name, starttime, endtime, totalday, reason, applicant, examiner, isstatus, isdeleted)
values (1000, 'admin', '2015-07-02', '2015-07-03', 1, 'sad', 'admin001', 'admin', '未审核', 0);
insert into VACATION (v_id, name, starttime, endtime, totalday, reason, applicant, examiner, isstatus, isdeleted)
values (1001, 'user', '2015-06-24', '2015-06-26', 2, 'sad', 'haha', 'admin', '已审核', 0);
insert into VACATION (v_id, name, starttime, endtime, totalday, reason, applicant, examiner, isstatus, isdeleted)
values (1002, 'user', '2015-06-16', '2015-06-16', 12, '111', 'haha', 'admin', '审核拒绝', 0);
insert into VACATION (v_id, name, starttime, endtime, totalday, reason, applicant, examiner, isstatus, isdeleted)
values (120, 'accp', '2015-06-15', '2015-06-17', 2, 'sad', 'hahaa', 'admin', '未审核', 0);
insert into VACATION (v_id, name, starttime, endtime, totalday, reason, applicant, examiner, isstatus, isdeleted)
values (100, 'admin', '2015-06-15', '2015-06-17', 12, 'aaaaaaaaa', 'admin001', 'bear', '未审核', 0);
insert into VACATION (v_id, name, starttime, endtime, totalday, reason, applicant, examiner, isstatus, isdeleted)
values (101, 'bear', '2015-06-15', '2015-06-25', 13, '222222', 'bear', 'admin', '已审核', 0);
insert into VACATION (v_id, name, starttime, endtime, totalday, reason, applicant, examiner, isstatus, isdeleted)
values (4, 'bear', '2012-5-8', '2012-5-16', 8, '该死', 'bear', 'admin', '已审核', 0);
insert into VACATION (v_id, name, starttime, endtime, totalday, reason, applicant, examiner, isstatus, isdeleted)
values (5, 'admin', '2012-5-9', '2012-5-11', 2, '看病', 'admin001', 'bdqn', '未审核', 0);
commit;
prompt 8 records loaded
prompt Enabling triggers for EMAIL...
alter table EMAIL enable all triggers;
prompt Enabling triggers for USERS...
alter table USERS enable all triggers;
prompt Enabling triggers for VACATION...
alter table VACATION enable all triggers;
set feedback on
set define on
prompt Done.
