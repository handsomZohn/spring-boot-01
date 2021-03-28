package org.fenixsoft.jvm.chapter4;

import java.util.ArrayList;
import java.util.List;

public class JConsoleTestCase {

    /**
     * 内存占位符对象，一个OOMObject大约占64K
     */
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            // 稍作延时，令监视曲线的变化更加明显
            Thread.sleep(100);
            list.add(new OOMObject());
        }
        // 方法没有退出 不能回收掉全部的内存：：
        System.gc();
    }

    // System.gc();

    /**
     * @Description 以64kb/100ms的速度向java堆中填充数据，一共填充10w次
     * @Author z
     * @Date 2020/10/12 22:02
     * @Param [args]
     * @Return void
     */
    public static void main(String[] args) throws Exception {
        fillHeap(100000);
    }

}
