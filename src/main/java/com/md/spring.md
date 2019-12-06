###spring如何解决循环依赖？
```
1.spring循环依赖是指：两个单例的bean通过setter注入可以相互持有对方的实例。
  a.循环依赖支持两个单例的bean,一个单例一个原型的bean相互依赖；不支持两个原型的bean相互依赖；
  b.循环依赖支持setter方法注入，不支持构造方法注入。
  
在doGetBean方法里有两个getSingleton方法，第一个getSingleton(String beanName)方法获取不到
接着执行第二个getSingleton(String beanName, ObjectFactory<?> singletonFactory)，在创建
bean之前会往singletonsCurrentlyInCreation Set放到集合中(表示当前正在创建)，接着创建bean,
创建完成后进行属性填充完成后续的声明周期，在进行属性填充的时候，发现依赖了A,
  
spring实例化的bean: 不是abstract,是singleton,不是lazy

spring声明周期回调：先MyBeanPostProcessor(后置处理器)，再@PostConstruct，再InitializingBean(接口)，再initMethod（@Bean）。


bean工厂的后置处理器的作用:修改bean工厂;
bean的后置处理器的作用:修改bean，这个时候的bean还不完整，正在创建中。
bean工厂的后置处理器有不同的执行时机。


Spring中的设计模式:
策略模式:spring在完成属性注入的时候，根据@Autowired或者@Resource使用不同的策略，不同的后置处理器处理。
单例模式:spring中的bean默认是单例的，并没有提供一个私有的构造。
观察者:各种listener监听器。
spring中用到的包装器模式在类名上有两种表现：一种是类名中含有Wrapper，另一种是类名中含有Decorator。
基本上都是动态地给一个对象添加一些额外的职责。
但Proxy是控制，更像是一种对功能的限制，而Decorator是增加职责。 
spring的Proxy模式在aop中有体现，比如JdkDynamicAopProxy和Cglib2AopProxy。

@Autowired和@Resource的区别:
1.@Autowired先根据类型找，找不到再根据名称找，有一个required属性默认是true，找不到就会抛出异常；
@Resource先根据名称找，找不到再根据类型找，有一个required属性默认是true，找不到就会抛出异常；
2.@Autowired是spring自带的，@Resource是JSR250标准。
3.通过不同的后置处理器解析的，@Autowired是AutowiredAnnotationBeanPostProcessr解析的，
@Resource是CommonAnnotationBeanPostProcessor解析的。


spring自动装配的模型有4种：no、bytype、byname、constructor 默认no;



循环依赖:getBean()，正在创建，3个map

aop在初始化bean和循环引用


/** Cache of singleton objects: bean name to bean instance. */
private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

/** Cache of singleton factories: bean name to ObjectFactory. */
private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16);

/** Cache of early singleton objects: bean name to bean instance. */
private final Map<String, Object> earlySingletonObjects = new HashMap<>(16);



首先spring在单例的情况下是默认支持循环引用的(当然原形也有办法，今天先不讨论)；
在不做任何配置的情况下，两个bean相互依赖是能初始化成功的；
spring源码中在创建bean的时候先创建这个bean的对象，
创建对象完成之后通过判断容器对象的allowCircularReferences属性决定是否允许缓存这个临时对象，
如果能被缓存成功则通过缓存提前暴露这个临时对象来完成循环依赖；而这个属性默认为true，
所以说spring默认支持循环依赖的，但是这个属性spring提供了api让程序员来修改，
所以spring也提供了关闭循环引用的功能；再就是spring完成这个临时对象的生命周期的过程中
当执行到注入属性或者自动装配的周期时候会通过getSingleton方法去得到需要注入的b对象；
而b对象这个时候肯定不存在故而会创建b对象创建b对象成功后继续b对象的生命周期，
当执行到b对象的自动注入周期时候会要求注入a对象；调用getSingleton；
从map缓存中得到a的临时对象（因为这个时候a在set集合中；这里可以展开讲），
而且获取的时候也会判断是否允许循环引用，但是判断的这个值是通过参数传进来的，
也就是spring内部调用的，spring源码当中写死了为true，故而如果需要扩展spring、
或者对spring二次开发的的时候程序员可以自定义这个值来实现自己的功能；不管放到缓存还是从缓存中取出这个临时都需要判断；
而这两次判断spring源码当中都是默认为true；这里也能再次说明spring默认是支持循环引用的；

然后面试中可以在说说两次调用getSingleton的意义，正在创建的那个set集合有什么用；
最后在说说你在看spring循环引用的时候得出的aop实例化过程的新发现；就比较完美了

​
```


```
spring初始化过程：
1.调用this(); 实例化reader,注册5个类的后置处理器，添加到beanDefinitionMaps中；实例化scanner，扫描@Compent；
registry.registerBeanDefinition(beanName, definition);
2.调用register(annotatedClasses)，注册配置类的registry.registerBeanDefinition(beanName, definitionHolder.getBeanDefinition());
3.
//执行bean工厂的后置处理器  postProcessor.postProcessBeanDefinitionRegistry(registry); 代理配置类，包括@Import...
invokeBeanFactoryPostProcessors(beanFactory);
//注册bean的后置处理器  this.beanPostProcessors.add(beanPostProcessor); 添加到list当中
registerBeanPostProcessors(beanFactory);
































```
