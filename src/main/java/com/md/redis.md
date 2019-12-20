###对Redis主从模式必须的理解
```
一个Master可以有多个Slaves
默认配置下，master节点可以进行读和写，slave节点只能进行读操作，写操作被禁止
不要修改配置让slave节点支持写操作，没有意义，
原因一，写入的数据不会被同步到其他节点；原因二，当master节点修改同一条数据后，slave节点的数据会被覆盖掉.

主从节点的缺点:
master节点挂了以后，redis就不能对外提供写服务了，因为剩下的slave不能成为master
　　这个缺点影响是很大的，尤其是对生产环境来说，是一刻都不能停止服务的，所以一般的生产坏境是不会单单只有主从模式的。

redis的主从模式，支持链式结构，Slave可以连接Slave，成为Slave的Slave。
```

###Sentinel哨兵模式：

```
为了解决主从master挂掉以后，Slaves节点不能主动选举master节点的问题，引入sentinel,
sentinel的中文含义是哨兵、守卫。也就是说既然主从模式中，当master节点挂了以后，slave节点不能主动选举一个master节点出来，
那么我就安排一个或多个sentinel来做这件事，当sentinel发现master节点挂了以后，sentinel就会从slave中重新选举一个master。
```

###Cluster模式：
```
cluster的出现是为了解决单机Redis容量有限的问题，将Redis的数据根据一定的规则分配到多台机器。对cluster的一些理解：

cluster可以说是sentinel和主从模式的结合体，通过cluster可以实现主从和master重选功能，所以如果配置两个副本三个分片的话，
就需要六个Redis实例。
因为Redis的数据是根据一定规则分配到cluster的不同机器的，当数据量过大时，可以新增机器进行扩容
　　这种模式适合数据量巨大的缓存要求，当数据量不是很大使用sentinel即可。


为了防止单点故障就需要引副本（Replication），当发生硬件故障或者其它原因造成的宕机时，
可以使用副本进行恢复，最好能够自动的故障转移（failover）。有时引入副本是为了读写分离，
将读的请求分流到副本上，减轻主（Primary）的读压力。而Mongodb的Replica Set都能满足这些要求。


```

###Redis安装教程
```
1.下载： wget http://download.redis.io/releases/redis-4.0.9.tar.gz命令即可在线下载redis安装包;
2.解压：tar -zxvf redis-4.0.9.tar.gz;
3.编译：进入到redis解压目录，执行make命令;
  编译完成后能看到src,conf等目录。
4.安装：进入到src目录，执行make install进行redis的安装;
5.部署：为了方便管理，创建etc,bin目录，将redis.conf移到etc目录，
mkreleasehdr.sh  redis-benchmark  redis-check-aof  redis-check-rdb  redis-cli  redis-server移动到bin目录；
修改redis.conf文件：
   bind 127.0.0.1 改成指定ip;
   daemonize 改为yes,表示支持后台启动。
6.再次启动redis,并指定配置文件：
   ./redis-server ../etc/redis.conf 启动redis
7.客户端连接：
   ./redis-cli
   ./redis-cli shutdown停止服务
```

































