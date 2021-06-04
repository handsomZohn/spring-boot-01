package thread.juc.automicreference;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference详细解释
 * 参考连接https://www.cnblogs.com/fhblikesky/p/13692643.html
 */
public class AutomicReferenceTest {
    public static void main(String[] args) {
        User user1 = new User("张三", 23);
        User user2 = new User("李四", 25);
        User user3 = new User("王五", 20);

        //初始化为 user1
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(user1);

        //把 user2 赋给 atomicReference
        // atomicReference的初始值为user1，调用compareAndSet（user1，user2）因为user1==user1所以会把user2赋给atomicReference。此时值为“李四”
        // 第二次调用atomicReference.compareAndSet(user1, user3)，由于user2 != user1，所以set失败。atomicReference仍然为“李四”
        atomicReference.compareAndSet(user1, user2);
        System.out.println(atomicReference.get().getName() + atomicReference.get().getAge());

        //把 user3 赋给 atomicReference
        atomicReference.compareAndSet(user1, user3);
        System.out.println(atomicReference.get().getName() + atomicReference.get().getAge());
    }
}
