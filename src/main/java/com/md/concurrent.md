AtomicInteger是对int类型的一个封装，提供原子性的访问和更新操作，其原子性操作的实现是基于CAS（compare-and-swap）技术。

所谓CAS，表现为一组指令，当利用CAS执行试图进行一些更新操作时。会首先比较当前数值，如果数值未变，
代表没有其它线程进行并发修改，则成功更新。如果数值改变，则可能出现不同的选择，要么进行重试，要么就返回是否成功。也就是所谓的“乐观锁”。

i++操作不是原子性的。

lock-free机制

ReentrantLock 非公平锁性能比公平锁好，但是公平锁能够防止饥饿。 


tryLock 尝试获取锁，非阻塞的，返回boolean。


为什么wait/notify/notifyAll一定要放到synchronized中使用？

这是Java设计者为了避免使用者出现lost wake up问题而搞出来的
