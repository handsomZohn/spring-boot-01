import com.zohn.springboot01.ZohnApplication;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZohnApplication.class) //启动整个springboot工程
public class SpringBootTestDemo {

    @Test
    public void testOne() {
        System.out.println("Hello Test 1");
        TestCase.assertEquals(1, 1);// 断言 就是：我想让程序返回的值与实际程序返回值的比较
        // Assert.assertEquals();
    }


    @Test
    public void test() {
        System.out.println("Hello Test 2");
        TestCase.assertEquals(1, 1);// 断言 就是：我想让程序返回的值与实际程序返回值的比较
        // Assert.assertEquals();
    }

    @Before
    public void testBefore(){
        System.out.println("Before");
    }

    @After
    public void testAfter(){// 资源的回收利用
        System.out.println("After");
    }
}
