###Mongodb介绍：

```

mongodb端口：27017
客户端：Studio-3T.exe，Navicat 12 for MongoDB

如何查看版本：db.version(); //返回 3.4.23

特征：基于文档存储的非关系型数据库
数据结构由键值(key=>value)JSON存储格式。

实现语言：C++


存储方式：虚拟内存+持久化。
架构特点：可以通过副本集，以及分片来实现高可用。

高扩展！
自身的Failover机制！
支持索引，不支持事务，关联查询

使用场景：
1.Mongodb用于收集日志，做社区等；
2.Mysql...

MongoDB建议集群部署，更多的考虑到集群方案，
Redis更偏重于进程顺序写入，虽然支持集群，也仅限于主-从模式。支持事务 ；实现语言： 	C/C++



补充：
SQL术语/概念 	MongoDB术语/概念 	解释/说明
database 	database 	数据库
table 	collection 	数据库表/集合
row 	document 	数据记录行/文档
column 	field 	数据字段/域
index 	index 	索引
table joins 	  	表连接,MongoDB不支持
primary key 	primary key 	主键,MongoDB自动将_id字段设置为主键

```






