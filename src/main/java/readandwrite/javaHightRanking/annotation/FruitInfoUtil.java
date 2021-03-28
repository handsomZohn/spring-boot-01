package readandwrite.javaHightRanking.annotation;

import java.lang.reflect.Field;


/**
 * 
 * <p>Title:注解处理器</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company:bksx</p>
 * <p>CreateDate:2018年3月26日</p>
 * @author zohn
 * @version 1.0
 */
public class FruitInfoUtil {
	public static void getFruitInfo(Class<?> clazz) {
		String strFruitName = "水果名称:";
		String strFruitColor = "水果颜色:";
		String strFruitProvicer = "水果供应商:";
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(FruitName.class)) {
				FruitName fruitName = field.getAnnotation(FruitName.class);
				strFruitName = strFruitName + fruitName.value();
				System.out.println(strFruitName);
			} else if (field.isAnnotationPresent(FruitColor.class)) {
				FruitColor fruitColor = field.getAnnotation(FruitColor.class);
				strFruitColor = strFruitColor + fruitColor.fruitcolor();
				System.out.println(strFruitColor);
			} else if (field.isAnnotationPresent(FruitProvider.class)) {
			    FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
			    strFruitProvicer = " 供应商编号:" + fruitProvider.id() + ", 供应商名称:" + fruitProvider.name() + ", 供应商地址:" + fruitProvider.address();
			    System.out.println(strFruitProvicer);
			}
		}
	}
}
