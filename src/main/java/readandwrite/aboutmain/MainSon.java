package readandwrite.aboutmain;

/**
 * @ClassName MainSon
 * @Description TODO
 * @Date 2021/12/27 14:30
 * @Version 1.0
 **/
public class MainSon extends MainFather {
    /**
     * 当有子类有main方法的时候，会覆盖掉父类的方法
     * 当子类没有方法的时候，子类运行就会调用父类的方法
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main son");
    }
}
