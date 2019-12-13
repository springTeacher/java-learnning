###EMQ搭建：

```
1.参考地址：
    https://www.hangge.com/blog/cache/detail_2348.html
   
a.官网下载linux centOS emqx-ee-centos7-v3.4.5.zip zip包；
b.上传到服务器上unzip解压;
c.执行如下命令开始编辑系统环境配置：
vi /etc/profile
内容：
# emqtt
export EMQPATH=/usr/local/emqttd
export PATH=$EMQPATH/bin:$PATH
退出执行：
source /etc/profile

到emqx/etc目录下修改emqx.conf 文件node.name=xxxx

d.emqx console查看是否安装成功；
e.emqx start 启动emq;
f.emqx_ctl status查看状态；
g.emqx stop停止emq.


4，使用 EMQ 服务
（1）当 EMQ 启动之后我们就可以使用客户端进行连接了，各个服务端口如下：
1883：MQTT 协议端口
8883：MQTT/SSL 端口
8083：MQTT/WebSocket 端口
8080：HTTP API 端口
18083：Dashboard 管理控制台端口


http://139.196.100.40:8083/#/monitor

（2）EMQ 提供了一个后端 Web 控制台，用户可通过 Web 控制台，查看服务器运行状态、统计数据、客户端（Client）、会话（Session）、主题（Topic）、订阅（Subscription）、插件（Plugin）。
访问地址：http://服务器IP:18083
默认用户名：admin
默认密码：public
    
    
    
```
