###
![add image](https://github.com/carmen-zhy/job/raw/master/image/*.png)

https://github.com/用户名/仓库名/raw（不动）/master（不动）/文件夹名（没有请忽略）/文件名.后缀名

[add link](https://github.com/carmen-zhy/job/raw/master/image/*.png)

###解决过问题汇总
```
1.post请求传递的参数，接口必须要接收，否则报错； Unrecognized field , not marked as ignorable
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
  




```