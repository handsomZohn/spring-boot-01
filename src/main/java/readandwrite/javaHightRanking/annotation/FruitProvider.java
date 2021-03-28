package readandwrite.javaHightRanking.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * <p>Title:水果供应者</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company:bksx</p>
 * <p>CreateDate:2018年3月26日</p>
 * @author zohn
 * @version 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
	/*
	 * 供应商编号
	 */
	public int id() default 1;
	/*
	 * 供应商名字
	 */
	public String name() default "";
	/*
	 * 供应商地址
	 */
	public String address() default "";
}
