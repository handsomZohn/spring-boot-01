package readandwrite.test;/*
package com;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class IdCardTest {

	*/
/**
	 * @param args
	 *//*

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String sfzhm = "142201199805213064";

		Object obj = new Object(); // 强引用
		SoftReference softReference = new SoftReference(obj); // 软引用
		WeakReference weakReference = new WeakReference(obj); // 弱引用
		ReferenceQueue q = null;
		PhantomReference phantomReference = new PhantomReference(obj, q); // 虚引用

		getNlBySfzhm(sfzhm);

	}

	//根据身份证获取年龄
	public static String getNlBySfzhm(String sfzhm) throws Exception {
		String year = IDCardHelper.getYear(sfzhm);
		String month = IDCardHelper.getMonth(sfzhm);
		System.out.println("year:" + year);
		System.out.println("month:" + month);
		return "";
	}

}


*/
