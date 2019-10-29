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