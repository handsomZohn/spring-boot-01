package readandwrite.tools.zipUnzip;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;


import java.util.List;

import javax.imageio.ImageIO;

/**
 * 
 * <p>Title:PictureCopy</p>
 * <p>Description:图片copy</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>Company:bksx</p>
 * <p>CreateDate:2019年3月21日</p>
 * @author Administrator
 * @version 1.0
 */
public class PictureCopyV01 {
	
	// 关键字
	static String pType01 = ".jpg", pType02 = ".png";
	// 存放遍历的文件  这个是全部文件
	static List fileList = new ArrayList();
	
	/**
	 * 
	 * @param unRarFilePath 解压后文件路径
	 * @throws Exception
	 */
	public void pCopy(String unRarFilePath) throws Exception{
		
		
		// 源目录
		String srcFile = unRarFilePath;
		// E:\workspace\myeclipse2014\bjldlsc\root\\\sysfiles\rlzyfwxk\fb33a3b3651800\
		
		ArrayList fileList02 = new ArrayList();
		
		File file = new File(srcFile);
		File[] listFiles = file.listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			fileList02.add(listFiles[i]);
		}
		
		// 先搜索文件夹下所有文件
		searchDir(fileList02);
		
		// 再创建一个放图片的文件夹
		// 图片copy至目录
		String dstDirPath = unRarFilePath + "tpyl" + File.separator;
		File dstDir = new File(dstDirPath);
		if (!dstDir.exists() && !dstDir.isDirectory()) {
			dstDir.mkdirs();
		}
		readAndWritePicture(fileList, pType01, pType02, dstDirPath);
		
	}
	
	/**
	 * 遍历unRarFilePath所有文件
	 * @param fileList02 指的是unRarFilePath的所有文件【包括文件夹以及文件】
	 */
	public void searchDir(List fileList02){
		// 一级目录
		List dirList01 = new ArrayList();
		// 一级目录下子目录
		List dirList02 = new ArrayList();
		// 遍历文件夹，将文件夹和文件分类
		int size = fileList02.size();
		for (int i = 0; i < size; i++) {
			File file = (File) fileList02.get(i);
			if (file.isDirectory()) {
				dirList01.add(file);
			} else {
				fileList.add(file);
			}
		}
		
		if (dirList01.size() > 0 || !dirList01.isEmpty()) {
			int size02 = dirList01.size();
			for (int i = 0; i < size02; i++) {
				File file = (File) dirList01.get(i);
				File[] listFiles = file.listFiles();
				for (int j = 0; j < listFiles.length; j++) {
					dirList02.add(listFiles[j]);
				}
			}
			searchDir(dirList02);
		}
		return;
	}
	
	/**
	 * 读写图片
	 * @param fileList 文件夹下文件列表
	 * @param pType01 图片类型01 .jpg
	 * @param pType02 图片类型02 .png
	 * @param dstDirPath 目标路径
	 */
	public void readAndWritePicture(List fileList, String pType01, String pType02, String dstDirPath){
		int size = fileList.size();
		for (int i = 0; i < size; i++) {
			File file = (File)fileList.get(i);
			if (file.isFile()) {
				// 判断是否图片
				boolean isJpg = file.toString().toLowerCase().endsWith(pType01);
				boolean isPng = file.toString().toLowerCase().endsWith(pType02);
				if (isJpg || isPng) {
					// 把文件写到指定文件夹
					try {
						BufferedImage img = ImageIO.read(new File(file.toString()));
						ImageIO.write(img, isJpg ? "jpg" : "png", new File(dstDirPath + file.getName()));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
