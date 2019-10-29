###
![add image](https://github.com/carmen-zhy/job/raw/master/image/*.png)

https://github.com/用户名/仓库名/raw（不动）/master（不动）/文件夹名（没有请忽略）/文件名.后缀名

[add link](https://github.com/carmen-zhy/job/raw/master/image/*.png)

###解决过问题汇总
```
1.post请求传递的参数，接口必须要接收，否则报错； Unrecognized field , not marked as ignorable
https://blog.csdn.net/bigtree_3721/article/details/70738337
  （1）原因：项目中用了MappingJackson2HttpMessageConverter默认要求必须存在相应的字段。
  如果没有前台传来的某个字段，就会报错。
    @Bean
    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        //设置日期格式
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat smt = new SimpleDateFormat(DateUtils.DATE_TIME_PATTERN);
        objectMapper.setDateFormat(smt);
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        //设置中文编码格式
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON_UTF8);
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
        return mappingJackson2HttpMessageConverter;
    }
    
  （2）解决方案：
        (I)接收参数中添加上该字段；
        (II)在类上加上JsonIgnoreProperties注解。
          @JsonIgnoreProperties(ignoreUnknown = true)
          @JsonIgnoreProperties({ "internalId", "secretKey" })
          
          解决方法有如下几种：
          
              (a).格式化输入内容，保证传入的JSON串不包含目标对象的没有的属性。
              (b).@JsonIgnoreProperties(ignoreUnknown = true) 在目标对象的类级别上加上该注解，
              并配置ignoreUnknown = true，则Jackson在反序列化的时候，会忽略该目标对象不存在的属性。
              (c).全局DeserializationFeature配置 
              objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
              配置该objectMapper在反序列化时，忽略目标对象没有的属性。凡是使用该objectMapper反序列化时，都会拥有该特性。

          
  
  (3)源码分析：
  RequestResponseBodyAdviceChain这个类会处理@RequestBody和@ResponseBody注解,
  并组成一个链,由HttpMessageConverter处理。
  
  
  Spring Boot 内置了jackson来完成JSON的序列化和反序列化操作。
  Jackson使用ObjectMapper类将POJO对象序列化成JSON字符串，也能将JSON字符串反序列化成POJO对象。
  
  JackSon支持三种层次的序列化和反序列化方式：
      采用JsonParser来解析JSON，解析结果是一串Tokens，采用JsonGenerator来生成JSON，这是最底层的方式。
      采用树遍历方式，JSON被读入到JsonNode对象中，可以像操作XML DOM那样读取JSON。
      采用DataBind方式，将POJO序列化成JSON，或者反序列化到POJO，这是最直接和最简单的一种方式，不过有时候需要辅助Jackson的注解或者上述序列化实现类来个性化序列化和反序列化操作。
  




```

0 = {SimpleUrlHandlerMapping@6584} 
1 = {RequestMappingHandlerMapping@6589} 
2 = {BeanNameUrlHandlerMapping@6590} 
3 = {SimpleUrlHandlerMapping@6591} 
4 = {WelcomePageHandlerMapping@6592} 

```

分享思路：
两大块内容：

1.接口规范：gateway验签，签名算法，请求头header的作用，分析原理引入拦截器；

2.中间件的使用,原理,如redis几种客户端比较，使用场景。
引入自动装配


先更新数据库，后删除缓存。

拦截器可以获取IOC容器中的各个bean，而过滤器就不行，这点很重要，在拦截器里注入一个service，可以调用业务逻辑

HttpServletBean
init();
	initServletBean();
		FrameworkServlet   initWebApplicationContext();
						onRefresh(wac);
								DispathcerServlet initStrategies(context);

Servlet接口
	GenericServlet 抽象类
		HttpServlet 抽象类
			HttpServletBean抽象类
				FrameworkServlet抽象类
					DispatcherServlet类
					
					



    Http请求和响应报文本质上都是一串字符串。

        请求报文——》被封装成为一个ServletInputStream的输入流，供我们读取报文，把报文转成java对象
        响应报文——》被封装成为一个ServletOutputStream的输出流，来输出响应报文。
        
    根据@RequestBody注解选择适当的HttpMessageConverter实现类来将请求参数解析到name变量中，
    具体来说是使用了StringHttpMessageConverter类，它的canRead()方法返回true，
    然后它的read()方法会从请求中读出请求参数，绑定到test()方法的name变量中。
    
    当SpringMVC执行test方法后：
    由于返回值标识了@ResponseBody，SpringMVC将使用StringHttpMessageConverter的write()方法，
    将结果作为String值写入响应报文，当然，此时canWrite()方法返回true。


```

###问题2：
```
springAOP环绕通知必须要执行  joinPoint.proceed();或者带参数的那个joinPoint.proceed(args);
否则请求不到controller.

问题了解：
  @Around注解可以用来在调用一个具体方法前和调用后来完成一些具体的任务。拦截器、事务、日志、权限验证


```

```
并发编程专题
JAVA内存模型（JMM）
java当中的线程通讯和消息传递
什么是重排序和顺序一致性？Happens-Before？As-If-Serial？
Synchronized的概念和分析
同步、重量级锁以及Synchronized的原理分析
自旋锁、偏向锁、轻量级锁、重量级锁的概念、使用以及如何来优化他们
Volatile和DCL的知识
Volatile的使用场景和Volatile实现机制、内存语义、内存模型
DCL的单例模式，什么是DCL？如何来解决DCL的问题
并发基础之AQS的深度分析
AbstractAueuedSynchronizer同步器的概念、CLH同步队列是什么？
同步状态的获取和释放、线程阻塞和唤醒
Lock和并发常用工具类
java当中的Lock、ReentrantLock、ReentrantReadWriteLock、Condition
java当中的并发工具类CyclicBarrier、CountDownLatch、Semphore
java当中的并发集合类ConcurrentHashMap、ConcurrentLinkedQueue.......
原子操作常用知识讲解
基本类型的原子操作比如经典的AtomicBoolean、AtomicLnteger、AtomicLong
数组类型的原子操作代表几个类AtomicIntegerArray、AtomicLongArray、AtomicReferenceArray
引用类型的原子操作的典型AtomicReference、AtomicReferenceFieldUpdater。。。。
CAS的概念和知识、Compare And Swap 以及他的缺陷
线程池和并发并行
Executor、ThreadPoolExecutor、Callable & Future、ScheduledExecutorService
ThreadLocal、Fork & Join？什么是并行？线程池如何保证核心线程不被销毁？
互联网工程专题
maven
整体认知maven的体系结构
maven核心命令
maven的pom配置体系
搭建Nexus私服
git专题
动手搭建Git客户端与服务端
Git的核心命令
Git企业应用
git的原理，git底层指针介绍
Linux
Linux原理、启动、目录介绍
Linux运维常用命令、Linux用户与权限介绍
shell脚本编写
框架应用和源码专题
mybatis应用和源码解析
myBatis应用
mybatis优缺点、spring 与mybatis 集成
Config、Sql配置、Mapper配置、有几种注册mapper的方法，优先级如何？
mybaits的一级缓存、二级缓存、mybatis的二级缓存为什么是鸡肋？
通用mapper的实现、mybaits编写sql语句的三种方式
Mybatis源码分析
@MapperScan的源码分析？mapperScan如何生效的？
mybatis如何扩展spring的扫描器的、mybatis扫描完之后如何利用FactoryBean的？
mybaits底层如何把一个代理对象放到spring容器中？用到了spring的哪些知识？
mybaits和spring的核心接口ImportBeanDefinitionRegistrar之间千丝万缕的关系
从原来来说明mybaits的一级缓存为什么会失效？spring为什么把他失效？有没有办法解决？
从mybatis来分析mybatis的执行流程、mybaits的sql什么时候缓存的？缓存在哪里？
mybaits当中的方法名为什么需要和mapper当中的id一致？从源码来说明
tomcat源码解析
tomat的总体概述和tomcat的启动流程源码分析
tomcat当中web请求的源码分析？一个http如何请求到tomcat的？tomcat如何处理的？
tomcat的协议分析，从源码来分析tomcat当中的各种详细配置的意义
tomcat和apache、nginx等等主流静态服务器的搭配使用
tomcat的性能调优？生成环境上如何让你的tomcat容器的性能达到最高
spring源码分析
spring-jcl 日志源码分析
spring的基本应用和spring源码的编译
java 混乱的日志系统，Jul、jcl、log4j、slf4j.....
spring4和spring在日志方面的源码对比
springaop源码分析
AspectJ和springAop，aspectj的静态织入
JDK动态代理的源码分析，JDK是如何操作字节码
spring通过cglib完成AOP，cglib如果完成方法拦截
AnnotationAwareAspectJAutoProxyCreator如何完成代理织入的
springIOC、AOP、MVC源码分析
BeanDefinition是什么东西，sping当中的各种BeanDefinition的作用
BeanDefinition有什么作用？如果来改变一个bean的行为
BeanDefinitionRegistry的作用，源码分析
BeanNameGenerator如何改变beanName的生成策略
BeanPostProcessor如何插手bean的实例化过程、经典的应用场景有哪些？spring内部哪里用到了这个接口
BeanFactoryPostProcessor和BeanPostProcessor的区别、经典应用场景、spring内部如何把他应用起来的
BeanDefinitionRegistryPostProcessor和BeanFactoryPostProcessor的关系已经区别，spring底层如何调用他们
ConfigurationClassPostProcessor这个类如何完成bean的扫描，如何完成@Bean的扫描、如何完成对@Import的解析
@Imoprt的三种类型，普通类、配置类、ImportSelector
如何利用ImportSelector来完成对spring的扩展？
@Configuration这注解为什么可以不加？加了和不加的区别，底层为什么使用cglib
@Bean的方法是如何保证单例的？如果不需要单例需要这么配置？为什么需要这么配置
springFacoryBean和BeanFacory的区别，有哪些经典应用场景？spring的factoryMethod的经典应用场景？
ImportBeanDefinitionRegistrar这个接口的作用，其他主流框架如何利用这个类来完成和spring的结合的？
spring是什么时候来执行后置处理器的？有哪些重要的后置处理器，比如CommonAnnotationBeanPostProcessor
CommonAnnotationBeanPostProcessor如何来完成spring初始化方法的回调。spring内部的各种Procesor的作用分别是什么
spring和springBoot当中的各种@Enablexxxx的原理是什么？如何自己实现一个？比如动态开启某某些自定义功能
spring如何来完成bean的循环依赖并且实例化的，什么是spring的IOC容器，怎么通过源码来理解？
其他，比如Bean的实例化过程，源码中的两次gegetSingleton的不同和相比如SpringMvc的源码分析等等........
Spring微服务专题
Spring Cloud
Eureka的源码分析服务注册和服务发现
Ribbon源码分析和客服端负载均衡，比如从源码理解随机策略和轮训策略
Fegin源码分析和声明式服务调用
Hystrix实现服务限流、降级
Hystrix实现自定义接口降级、监控数据、数据聚合
Zuul统一网关详解、服务路由、过滤器使用等
分布式配置中心Config详解
分布式链路跟踪详解
Zuul应用之统一异常处理、Cookie和重定向处理
Spring Boot的源码分析和基本应用
Docker
Docker的镜像、仓库、容器讲解及快速开发搭建Docker环境
DockerFile、DockerCompose使用详解及服务编排实现
分布式专题
分布式协调框架(Zookeeper)
什么是分布式系统？分布式系统有何挑战？Zookeeper快速入门&集群搭建基本使用
Zookeeper有哪些常用命令以及注意事项、zkclient客户端与curator框架有什么功能以及如何使用
手写Zookeeper常见应用场景：分布式配置中心、分布式锁、分布式定时任务
Zookeeper核心概念znode、watch机制、序列化、持久化机制讲解及其源码解析
Zookeeper怎么解决分布式中的一致性问题？领导选举流程讲解及其源码解析
RPC服务框架(Dubbo)
手写RPC框架以及为什么要使用Dubbo? 传统应用系统如何演变成分布式系统详解
Dubbo的六大特性是什么？对企业级开发有何好处？Dubbo的作用简要说明、快速演示Dubbo 调用示例
Dubbo中协议、注册中心、动态代理机制是怎么达到可扩展的？Dubbo的扩展机制源码解析
Dubbo从服务提供者到注册中心到消费者调用服务中间的流程源码解析
Dubbo的监控中心以及管理平台的使用，方便企业级开发与管理
分布式数据缓存(Redis)
关系型数据库瓶颈与优化、ehcache和redis的对比？nosql的使用场景
Redis基本数据类型、比如map的使用场景？有什么优缺点？什么时候用map等等
Redis高级特性、如何来理解redis的单线程但是高性能？如何理解redis和epoll
Redis持久化、什么情况下需要持久化？方案是什么？有什么优缺点？如何优雅的选择持久化方案
Redis项目中应用、reids的高级命令mget、scan？为什么有scan这条命令，如何理解redis的游标？
Redis分布式集群
单机版redis的安装以及redis生产环境启动方案
redis持久化机对于生产环境中的灾难恢复的意义
redis主从架构下如何才能做到99.99%的高可用性
在项目中重新搭建一套主从复制+高可用+多master的redis cluster集群
redis在实践中的一些常见问题以及优化思路（包含linux内核参数优化）
redis的RDB持久化配置以及数据恢复实验
redis的RDB和AOF两种持久化机制的优劣势对比
分布式数据存储(mycat)
分库分表场景介绍
Mycat原理解析
分库分表实战
分布式Rabbitmq
RabbitMQ环境安装&RabbitMQ整体架构与消息流转&交换机详解
消息如何保障 100% 的投递成功方案&企业消息幂等性概念及业界主流解决方案
Confirm确认消息详解&Return返回消息详解&消费端的限流策略&消费端ACK与重回队列机制
SpringAMQP用户管理组件-RabbitAdmin应用&SpringAMQP消息模板组件-RabbitTemplate实战
SpringAMQP消息容器-SimpleMessageListenerContainer详解&SpringAMQP消息适配器-MessageListenerAdapter使用
RabbitMQ与SpringBoot2.0整合实战&RabbitMQ与Spring Cloud Stream整合实战
RabbitMQ集群架构模式&RabbitMQ集群镜像队列构建实现可靠性存储&RabbitMQ集群整合负载均衡基础组件HaProxy_
性能调优
mysql性能调优
mysql中为什么不使用其他数据结构而就用B+树作为索引的数据结构
mysql执行计划详解&mysql查询优化器详解
 mysql索引优化实战，包括普通查询、group by、order by
java数据结构算法
hash算法详解、java当中hashmap源码解析、手写一个hashmap
从源码理解hashmapJDK7和JDK8的变化、为什么有这样的变化，Java8新特性
顺序存储、双向链表、单向链表、java当中linkedList的源码分析
java当中线性结构、树形结构以及图形结构分析以及应用场景和经典使用
大数字运算和经典排序、二叉树红黑树排序、查找
JVM性能调优
java内存模型总体概述、类加载过程和classloader、运行时数据区当中的总体内容、编译原理
内存区域与内存溢出异常、虚拟机对象、程序计数器、java栈、本地方法栈、操作数、方法区、堆内存和元数据等等
Classloader的知识详细、默认全盘负责机制、从JDK源码来理解双亲委派模式、如何打破双亲委派？为什么需要打破？
虚拟机性能监控与故障处理、jvm基本命令，jinfo命令的使用jmap命令使用、jstak命令的使用、使用jvisualvm分析
垃圾收集器与内存分配策略、垃圾回收算法与基础、串型收集器、并行收集器、内存分配与回收策略、
程序编译与代码优化、运行期优化、编译期优化、JVM调优的本质是什么？什么是轻gc？什么是Full gc？如何调优
JVM执行子系统、类文件结构、类加载机制、字节码执行引擎、字节码编译模式、如何改变字节码编译模式？
项目实战专题
大型互联网电商项目
面试专题
职业生涯规划
面试问题剖析
简历技术优化、项目优化
面试题详解&offer选择
```
