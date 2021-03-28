package readandwrite.javase.programmer.lambda;

/**
 * @Description 用户信息实体类
 * @Author zohn
 * @Date 2020\1\14 0014 13:59
 * @Param
 * @Return 
 */
public class Yhxx {
    // 姓名
    private String xm;

    // 身份证号码
    private String sfzhm;

    // 手机个数
    private Integer sjgs;


    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getSfzhm() {
        return sfzhm;
    }

    public void setSfzhm(String sfzhm) {
        this.sfzhm = sfzhm;
    }

    public Integer getSjgs() {
        return sjgs;
    }

    public void setSjgs(Integer sjgs) {
        this.sjgs = sjgs;
    }

    @Override
    public String toString() {
        return "Yhxx{" +
                "xm='" + xm + '\'' +
                ", sfzhm='" + sfzhm + '\'' +
                ", sjgs='" + sjgs + '\'' +
                '}';
    }

    public Yhxx(String xm, String sfzhm, Integer sjgs) {
        this.xm = xm;
        this.sfzhm = sfzhm;
        this.sjgs = sjgs;
    }
}
