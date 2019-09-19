###单类模式有4种线程安全的解决方案：

####1.饿汉式
```java
public class SingletonEHan {

    private static SingletonEHan instance = new SingletonEHan();

    private SingletonEHan (){

    }

    public static SingletonEHan getInstance(){
        return instance;
    }
}
```
```
优点：实现简单，线程安全
缺点：即使该类没有被使用也会创建该类的对象，浪费内存空间

不推荐使用。

```
####2.双重锁检查
```java
public class Singleton {
    
    private static volatile Singleton instance = null;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```
```
优点：第一次被调用才创建对象，线程安全
缺点：实现复杂，暗坑多

推荐使用。

如果没有加volatile会引起什么问题？

memory = allocate() ;    //分配对象的内存空间
ctorInstance(memory);   //②初始化对象
instance=memory;        //③设置instance指向刚分配的内存地址
```
其中②和③之间，在某些编译器编译时，可能出现重排序（主要是为了代码优化），此时的代码如下：
```
memory = allocate() ;    //分配对象的内存空间
instance=memory;        //③设置instance指向刚分配的内存地址
ctorInstance(memory);   //②初始化对象
```
单线程下执行时序图如下：
![执行的示意图](https://github.com/springTeacher/java-learnning/raw/master/src/main/resources/image/20170805140022629.png)

多线程下执行时序图：
![执行的示意图](https://github.com/springTeacher/java-learnning/raw/master/src/main/resources/image/20170805140035078.png)
```
2,3两步骤可能会发生重排序，此时多线程情况下另外一个线程可能会看到一个还没有被初始化的对象。
加了volatile将不允许2,3两步重排序。

```
####3.静态内部类
```
 基于类初始化的解决方案
VM在类的初始化阶段（即在Class被加载后，且被线程使用之前），会执行类的初始化。在执行类的初始化期间，
JVM会去获取一个锁。这个锁可以同步多个线程对同一个类的初始化。基于这个特性，
可以实现另一种线程安全的延迟初始化方案
```
```java
public class InstanceFactory {
    private static class InstanceHolder {
        public static Instance instance = new Instance();
    }
 
    public static Instance getInstance() {
        return InstanceHolder.instance ;  //这里将导致InstanceHolder类被初始化
    }
  }
```
执行的示意图:
![执行的示意图](https://github.com/springTeacher/java-learnning/raw/master/src/main/resources/image/20170805140126011.png)
```
该方案的实质是，允许②和③进行重排序，但不允许非构造线程（此处是B线程）“看到”这个重排序。

优点：简单，第一次被调用才创建对象，线程安全
缺点：想起来有难度

极力推荐
```
####4.枚举
```java
public class Singleton {

    private Singleton(){

    }

    private enum HolderEnum{
        /**单类对象*/
        INSTANCE;

        private Singleton instance = null;

        HolderEnum(){
            instance = new Singleton();
        }

        public Singleton getInstance(){
            return instance;
        }
    }

    public static Singleton getInstance(){
        return HolderEnum.INSTANCE.getInstance();
    }

}

```
```
优点：第一次被调用才创建对象，线程安全
缺点：想起来有难度

推荐
```

