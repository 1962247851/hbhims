# Host: 47.100.91.123  (Version 5.7.26-log)
# Date: 2020-05-13 18:34:28
# Generator: MySQL-Front 6.1  (Build 1.26)

#
# Data for table "sys_permission"
#

INSERT INTO `sys_permission` (`id`,`code`,`name`) VALUES
#user
(1,'insert_health_data','新增健康数据'),
#admin
(2,'delete_health_data','删除健康数据'),
#admin
(3,'update_health_data','修改健康数据'),
#user
(4,'query_health_data','查询健康数据'),

#professional
(5,'insert_medical_suggestion','新增医疗意见和建议'),
#admin
(6,'delete_medical_suggestion','删除医疗意见和建议'),
#admin
(7,'update_medical_suggestion','修改医疗意见和建议'),
#user
(8,'query_medical_suggestion','查询医疗意见和建议'),

#user
(9,'insert_medical_suggestion_request','新增医疗意见和建议请求'),
#user
(10,'delete_medical_suggestion_request','删除医疗意见和建议请求'),
#admin
(11,'update_medical_suggestion_request','修改医疗意见和建议请求'),
#user
(12,'query_medical_suggestion_request','查询医疗意见和建议请求'),

#user
(13,'insert_medical_suggestion_evaluation','新增医疗意见和建议评分'),
#admin
(14,'delete_medical_suggestion_evaluation','删除医疗意见和建议评分'),
#admin
(15,'update_medical_suggestion_evaluation','修改医疗意见和建议评分'),

#admin
(16,'delete_user','删除用户'),
#admin
(17,'update_user','修改用户'),
#user
(18,'query_user','查询用户'),

#developer
(19,'modify_role','增、删、改角色'),
#user
(20,'query_role','查询角色'),

#developer
(21,'modify_request_path','增、删、改请求路径'),
#user
(22,'query_request_path','查询请求路径'),

#developer
(23,'modify_permission','增、删、改权限'),
#user
(24,'query_permission','查询权限'),

#developer
(25,'modify_user_role','增、删、改用户角色关系'),
#user
(26,'query_user_role','查询用户角色关系'),

#developer
(27,'modify_role_permission','增、删、改角色权限关系'),
#user
(28,'query_role_permission','查询角色权限关系'),

#developer
(29,'modify_request_path_permission','增、删、改请求路径权限关系'),
#user
(30,'query_request_path_permission','查询请求路径权限关系');

#
# Data for table "sys_permission_seq"
#

INSERT INTO `sys_permission_seq` (`sequence_name`,`sequence_next_hi_value`) VALUES ('sys_permission_id',30);

#
# Data for table "sys_request_path"
#

INSERT INTO `sys_request_path` (`id`,`description`,`url`) VALUES
(1,'记录运动记录','/sport/insertOrReplace'),
(2,'删除运动记录','/sport/delete'),
(3,'更新运动记录','/sport/update'),
(4,'查询某天的运动记录','/sport/queryByDate'),
(5,'查询运动记录','/sport/query'),

(6,'记录睡眠质量','/sleep/insertOrReplace'),
(7,'删除睡眠质量','/sleep/delete'),
(8,'更新睡眠质量','/sleep/update'),
(9,'查询某天的睡眠质量','/sleep/queryByDate'),
(10,'查询睡眠质量','/sleep/query'),

(11,'新增体重','/weight/insert'),
(12,'删除体重','/weight/delete'),
(13,'更新体重','/weight/update'),
(14,'查询体重','/weight/query'),

(15,'记录身高','/height/insertOrReplace'),
(16,'更新身高','/height/update'),
(17,'删除身高','/height/delete'),
(18,'查询身高','/height/query'),

(19,'新增血压','/bloodPressure/insert'),
(20,'删除血压','/bloodPressure/delete'),
(21,'更新血压','/bloodPressure/update'),
(22,'查询血压','/bloodPressure/query'),

(23,'新增血糖','/bloodSugar/insert'),
(24,'删除血糖','/bloodSugar/delete'),
(25,'更新血糖','/bloodSugar/update'),
(26,'查询血糖','/bloodSugar/query'),

(27,'新增血氧','/bloodOxygen/insert'),
(28,'删除血氧','/bloodOxygen/delete'),
(29,'更新血氧','/bloodOxygen/update'),
(30,'查询血氧','/bloodOxygen/query'),

(31,'新增医疗意见和建议','/medicalSuggestion/insert'),
(32,'删除医疗意见和建议','/medicalSuggestion/delete'),
(33,'更新医疗意见和建议','/medicalSuggestion/update'),
(34,'查询收到的医疗意见和建议','/medicalSuggestion/queryReceive'),
(35,'查询发出的医疗意见和建议','/medicalSuggestion/querySend'),

(36,'新增医疗意见和建议请求','/medicalSuggestionRequest/insert'),
(37,'删除医疗意见和建议请求','/medicalSuggestionRequest/delete'),
(38,'更新医疗意见和建议请求','/medicalSuggestionRequest/update'),
(39,'查询收到的医疗意见和建议请求','/medicalSuggestionRequest/queryReceive'),
(40,'查询发出的医疗意见和建议请求','/medicalSuggestionRequest/querySend'),

(41,'新增医疗意见和建议评分','/medicalSuggestionEvaluation/insert'),
(42,'删除医疗意见和建议评分','/medicalSuggestionEvaluation/delete'),
(43,'更新医疗意见和建议评分','/medicalSuggestionEvaluation/update'),

(44,'删除用户','/user/delete'),
(45,'修改用户','/user/update'),
(46,'查询用户','/user/query'),
(47,'查询所有专业人员','/user/queryProfessional'),

(48,'新增角色','/role/insert'),
(49,'删除角色','/role/delete'),
(50,'更新角色','/role/modify'),
(51,'查询角色','/role/query'),

(52,'新增请求路径','/requestPath/insert'),
(53,'删除请求路径','/requestPath/delete'),
(54,'更新请求路径','/requestPath/modify'),
(55,'查询请求路径','/requestPath/query'),

(56,'新增权限','/permission/insert'),
(57,'删除权限','/permission/delete'),
(58,'更新权限','/permission/modify'),
(59,'查询权限','/permission/query'),

(60,'新增用户角色关系','/userRoleRelation/insert'),
(61,'删除用户角色关系','/userRoleRelation/delete'),
(62,'更新用户角色关系','/userRoleRelation/modify'),
(63,'查询用户角色关系','/userRoleRelation/queryByUserIdAndRoleId'),
(64,'查询用户角色关系','/userRoleRelation/query'),

(65,'新增角色权限关系','/rolePermissionRelation/insert'),
(66,'删除角色权限关系','/rolePermissionRelation/delete'),
(67,'更新角色权限关系','/rolePermissionRelation/modify'),
(68,'查询角色权限关系','/rolePermissionRelation/query'),

(69,'新增请求路径权限关系','/requestPathPermissionRelation/insert'),
(70,'删除请求路径权限关系','/requestPathPermissionRelation/delete'),
(71,'更新请求路径权限关系','/requestPathPermissionRelation/modify'),
(72,'查询请求路径权限关系','/requestPathPermissionRelation/query');

#
# Data for table "sys_request_path_permission_relation"
#

INSERT INTO `sys_request_path_permission_relation` (`id`,`permission_id`,`request_path_id`) VALUES
(1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,4,5),
(6,1,6),(7,2,7),(8,3,8),(9,4,9),(10,4,10),
(11,1,11),(12,2,12),(13,3,13),(14,4,14),
(15,1,15),(16,2,16),(17,3,17),(18,4,18),
(19,1,19),(20,2,20),(21,3,21),(22,4,22),
(23,1,23),(24,2,24),(25,3,25),(26,4,26),
(27,1,27),(28,2,28),(29,3,29),(30,4,30),
(31,5,31),(32,6,32),(33,7,33),(34,8,34),(35,8,35),
(36,9,36),(37,10,37),(38,11,38),(39,12,39),(40,12,40),
(41,13,41),(42,14,42),(43,15,43),
(44,16,44),(45,17,45),(46,18,46),(47,18,47),
(48,19,48),(49,19,49),(50,19,50),(51,20,51),
(52,21,52),(53,21,53),(54,21,54),(55,22,55),
(56,23,56),(57,23,57),(58,23,58),(59,24,59),
(60,25,60),(61,25,61),(62,25,62),(63,26,63),(64,26,64),
(65,27,65),(66,27,66),(67,27,67),(68,28,68),
(69,29,69),(70,29,70),(71,29,71),(72,30,72);


#
# Data for table "sys_request_path_permission_relation_seq"
#

INSERT INTO `sys_request_path_permission_relation_seq` (`sequence_name`,`sequence_next_hi_value`) VALUES ('sys_request_path_permission_relation_id',72);

#
# Data for table "sys_request_path_seq"
#

INSERT INTO `sys_request_path_seq` (`sequence_name`,`sequence_next_hi_value`) VALUES ('sys_request_path_id',72);

#
# Data for table "sys_role"
#

INSERT INTO `sys_role` (`id`,`code`,`description`,`name`) VALUES
(1,'user','普通用户，注册后即可获得，具有部分权限','普通用户'),
(2,'professional','专业人员，可以收到普通用户的请求并发表医疗意见和建议','专业人员'),
(3,'admin','管理员','管理员，可以删改健康数据、医疗意见和建议请求、用户'),
(4,'developer','开发组，拥有所有权限','开发组');

#
# Data for table "sys_role_permission_relation"
#

INSERT INTO `sys_role_permission_relation` (`id`,`permission_id`,`role_id`) VALUES
(1,1,1),(2,4,1),(3,8,1),(4,9,1),(5,10,1),(6,12,1),(7,13,1),(8,18,1),(9,20,1),(10,22,1),(11,24,1),(12,26,1),(13,28,1),(14,30,1),
(15,5,2),
(16,2,3),(17,3,3),(18,6,3),(19,7,3),(20,11,3),(21,14,3),(22,15,3),(23,16,3),(24,17,3),
(25,19,4),(26,21,4),(27,23,4),(28,25,4),(29,27,4),(30,29,4);

#
# Data for table "sys_role_permission_relation_seq"
#

INSERT INTO `sys_role_permission_relation_seq` (`sequence_name`,`sequence_next_hi_value`) VALUES ('sys_role_permission_relation_id',30);

#
# Data for table "sys_role_seq"
#

INSERT INTO `sys_role_seq` (`sequence_name`,`sequence_next_hi_value`) VALUES ('sys_role_id',4);