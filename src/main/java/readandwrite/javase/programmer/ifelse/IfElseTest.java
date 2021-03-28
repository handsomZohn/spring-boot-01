package readandwrite.javase.programmer.ifelse;

/**
 * @Description Java】面试官灵魂拷问：if语句执行完else语句真的不会再执行吗？
 * https://mp.weixin.qq.com/s/TmZ892ptjreKPbeRlFqdCw
 * @CreateDate 2020\6\3 0003 11:49
 * @Author z
 * @Version 1.0
 */
public class IfElseTest {
    public static void main(String[] args) {
        new IfElseTest().print(args == null || new IfElseTest() {{
            IfElseTest.main(null);
        }}.equals(null));
    }

    /**
     * 　　　┏┓　　　┏┓
     * 　　┏┛┻━━━┛┻┓
     * 　　┃　　　　　　　┃
     * 　　┃　　　━　　　┃
     * 　　┃　┳┛　┗┳　┃
     * 　　┃　　　　　　　┃
     * 　　┃　　　┻　　　┃
     * 　　┃　　　　　　　┃
     * 　　┗━┓　　　┏━┛
     * 　　　　┃　　　┃ 神兽保佑
     *      * 　　　　┃　　　┃ 代码无BUG！
     * 　　　　┃　　　┗━━━┓
     * 　　　　┃　　　　　　　┣┓
     * 　　　　┃　　　　　　　┏┛
     * 　　　　┗┓┓┏━┳┓┏┛
     * 　　　　　┃┫┫　┃┫┫
     * 　　　　　┗┻┛　┗┻┛
     *
     * Created by zz on 2020\6\11 0011.
     */
    public void print(boolean flag) {
        // 就会发现是调用了两次
        System.out.println("flag");
        if (flag) {
            System.out.println("我是if语句的分支");
        } else {
            System.out.println("我是else语句的分支");
        }
    }
}
