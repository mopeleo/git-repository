delete from sys_menu;

INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1000', '设置', '', null, 0, 1, 0, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1100', '参数设置', '', '1000', 0, 1, 0, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1110', '数据字典', 'sysdict/list', '1100', 1, 1, 2, null);

INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1120', '系统参数', 'sysparam/list', '1100', 1, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1121', '参数修改', 'sysparam/update', '1120', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1122', '参数初始化', 'sysparam/reset', '1120', 2, 1, 2, null);

INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1130', '序列号维护', 'syssno/list', '1100', 1, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1131', '序列号修改', 'syssno/update', '1130', 2, 1, 2, null);

INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1200', '角色权限', '', '1000', 0, 1, 0, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1210', '角色列表', 'sysrole/list', '1200', 1, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1211', '角色详情', 'sysrole/detail', '1210', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1212', '角色新增', 'sysrole/add', '1210', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1213', '角色修改', 'sysrole/update', '1210', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1214', '角色删除', 'sysrole/delete', '1210', 2, 1, 2, null);

INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1220', '用户列表', 'sysuser/list', '1200', 1, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1221', '用户详情', 'sysuser/detail', '1220', 1, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1222', '用户新增', 'sysuser/add', '1220', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1223', '用户修改', 'sysuser/update', '1220', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1224', '用户删除', 'sysuser/delete', '1220', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1225', '分配角色', 'sysuser/grantrole', '1220', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1226', '重置密码', 'sysuser/resetpassword', '1220', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1227', '冻结用户', 'sysuser/freeze', '1220', 2, 1, 2, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1228', '解冻用户', 'sysuser/unfreeze', '1220', 2, 1, 2, null);

INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1230', '机构维护', 'sysorg/list', '1200', 1, 1, 1, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1231', '机构新增', 'sysorg/add', '1230', 2, 1, 1, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1232', '机构修改', 'sysorg/update', '1230', 2, 1, 1, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1233', '机构删除', 'sysorg/delete', '1230', 2, 1, 1, null);

INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1240', '菜单权限', 'sysmenu/list', '1200', 1, 1, 1, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1241', '菜单设置', 'sysmenu/set', '1240', 2, 1, 1, null);

INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('1300', '复核设置', '', '1000', 0, 1, 0, null);

INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2000', '应用', '', null, 0, 1, 0, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2100', '客户', '', '2000', 0, 1, 0, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2110', '客户管理', 'custinfo/list', '2100', 1, 1, 0, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2111', '客户详情', 'custinfo/detail', '2110', 2, 1, 0, null);

INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2120', '账号管理', 'custacct/list', '2100', 1, 1, 0, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2121', '账号冻结', 'custacct/freeze', '2120', 2, 1, 0, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2122', '账号解冻', 'custacct/unfreeze', '2120', 2, 1, 0, null);

INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2200', '游戏中心', '', '2000', 0, 1, 0, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2210', '游戏管理', 'gameinfo/list', '2200', 1, 1, 0, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2211', '游戏详情', 'gameinfo/detail', '2210', 2, 1, 0, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2212', '游戏新增', 'gameinfo/add', '2210', 2, 1, 0, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2213', '游戏修改', 'gameinfo/update', '2210', 2, 1, 0, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2214', '游戏删除', 'gameinfo/delete', '2210', 2, 1, 0, null);

INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2220', '场景维护', '', '2200', 1, 1, 0, null);

INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2230', '角色维护', '', '2200', 1, 1, 0, null);

INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2240', '装备维护', '', '2200', 1, 1, 0, null);

INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2250', '道具维护', '', '2200', 1, 1, 0, null);

INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2300', '运营', '', '2000', 0, 1, 0, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2400', '复核', '', '2000', 0, 1, 0, null);
INSERT INTO sys_menu (menuid, menuname, menuurl, parentmenu, menutype, status, accesstype, menucss) VALUES ('2500', '查询', '', '2000', 0, 1, 0, null);

commit;