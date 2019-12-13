
##高并发httpClient原理与优化使用详解
```
https://blog.csdn.net/ZYC88888/article/details/86979279

HTTP是应用层协议，HTTP协议的长连接和短连接，实质上是TCP协议的长连接和短连接。
TCP传输层协议，TCP协议主要解决如何在IP层之上可靠地传递数据包，使得网络上接收端收到发送端所发出的所有包，并且顺序与发送顺序一致。TCP协议是可靠的、面向连接的。
IP网络层协议，IP协议主要解决网络路由和寻址问题

备注Socket属于传输层协议。




HttpURLConnection是Socket封装来的。

创建Socket，获取输入输出流，传送数据，这样就封装成了HttpURLConnection

```
