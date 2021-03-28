package readandwrite.javaHightRanking.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * <p>Title:水果颜色</p>
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
public @interface FruitColor {
	/*
	 * 颜色枚举
	 */
	public enum Color{
		BLUE,
		RED,
		GREEN
	}
	
	/*
	 * 颜色属性
	 */
	Color fruitcolor() default Color.GREEN;
	
}
