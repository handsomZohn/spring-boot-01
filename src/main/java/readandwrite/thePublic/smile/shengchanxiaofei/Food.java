package readandwrite.thePublic.smile.shengchanxiaofei;

/**
 *@Description  
 *@CreateDate   18/08/13 8:51
 *@Author        zohn
 *@Version       1.0
 *
 */
public class Food {
    private int id;

    // 用不到无参构造 可以不写无参构造函数 否则新建对象出错
    public Food(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
