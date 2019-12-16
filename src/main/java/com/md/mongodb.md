###Mongodb介绍：

```

mongodb端口：27017
客户端：Studio-3T.exe，Navicat 12 for MongoDB

如何查看版本：db.version(); //返回 3.4.23

特征：基于文档存储的非关系型数据库
数据结构由键值(key=>value)JSON存储格式。

实现语言：C++


存储方式：虚拟内存+持久化。
架构特点：可以通过副本集(Relica Set)，以及分片来实现高可用。

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

###Mongodb集群
```
Master-Slave、Relica Set、Sharding




Relica Set(副本集)：当主节点挂掉之后，可以自动选举主节点，仲裁节点必须保证奇数。
主节点，从节点，仲裁节点。
主备节点存储数据，仲裁节点不存储数据。客户端同时连接主节点与备节点，不连接仲裁节点。

       默认设置下，主节点提供所有增删查改服务，备节点不提供任何服务。
       但是可以通过设置使备节点提供查询服务，这样就可以减少主节点的压力，当客户端进行数据查询时，请求自动转到备节点上。
       这个设置叫做Read Preference Modes，同时Java客户端提供了简单的配置方式，可以不必直接对数据库进行操作。
  仲裁节点是一种特殊的节点，它本身并不存储数据，主要的作用是决定哪一个备节点在主节点挂掉之后提升为主节点，所以客户端不需要连接此节点。




Mongodb的主从模式不支持链式结构，Slave只能直接连接Master。
Redis的Master-Slave支持链式结构，Slave可以连接Slave，成为Slave的Slave。

```





