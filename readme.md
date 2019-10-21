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
```