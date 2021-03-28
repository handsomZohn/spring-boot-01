package readandwrite.javaHightRanking.annotation;


import java.awt.*;

/**
 * 
 * <p>Title:注解使用</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company:bksx</p>
 * <p>CreateDate:2018年3月26日</p>
 * @author zohn
 * @version 1.0
 */
public class Apple {
	
	 // @FruitName(value = "Apple")
	@FruitName("Apple")
	private String appleName;
	
	// @FruitColor(fruitcolor = Color.RED)
	private String appleColor;
	
	@FruitProvider(id = 1, name = "望京红富士集团", address = "北京市朝阳区阜通大街一号院望京SOHO塔三A座三层")
	private String appleProvider;

	public String getAppleName() {
		return appleName;
	}

	public void setAppleName(String appleName) {
		this.appleName = appleName;
	}

	public String getAppleColor() {
		return appleColor;
	}

	public void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}

	public String getAppleProvider() {
		return appleProvider;
	}

	public void setAppleProvider(String appleProvider) {
		this.appleProvider = appleProvider;
	}
	
	public void displayName() {
		System.out.println("水果的名字: 苹果~~");
	}
}
