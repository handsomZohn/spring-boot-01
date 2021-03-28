package readandwrite.tools.zipUnzip;

import java.awt.Image;
import java.awt.Toolkit;
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
public class PictureCopyV02 {
	
	// 关键字
	static String pType01 = ".jpg", pType02 = ".png";
	// 存放遍历的文件  这个是全部文件
	static List fileList = new ArrayList();
	// 存放copy的文件 这个里面存的是图片的name
	static List pictureList = new ArrayList();
	
	
	/**
	 * 
	 * @param dwbh 单位编号
	 * @throws Exception
	 */
	public void pCopy(String dwbh) throws Exception{
		
		
		String filePath = "";/*SysConfig.getROOT_REAL_PATH() + SysConfig.getFILESEPARATOR()
				+ UploadConfig.getFILE_PATH() + SysConfig.getFILESEPARATOR()
				+ "rlzyfwxk" + SysConfig.getFILESEPARATOR() + dwbh + SysConfig.getFILESEPARATOR();*/

		filePath = "";
		
		// 源目录
		String srcFile = filePath;
		
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
		String dstDirPath = filePath + "tpyl" + File.separator;
		File dstDir = new File(dstDirPath);
		if (!dstDir.exists() && !dstDir.isDirectory()) {
			dstDir.mkdirs();
		}
		pictureList.clear();
		readAndWritePicture(fileList, pType01, pType02, dstDirPath);
		
	}
	
	/**
	 * 遍历filePath所有文件
	 * @param fileList02 指的是filePath的所有文件【包括文件夹以及文件】
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
						// ImageIO读取JPEG图片时，有时会添加红色蒙层
						// BufferedImage img = ImageIO.read(new File(file.toString()));
						// 用Toolkit中方法加以封装 不会出现红色蒙层
						Image image = Toolkit.getDefaultToolkit().getImage(file.toString());
						BufferedImage img = BufferedImageBuilder.toBufferedImage(image);
						ImageIO.write(img, isJpg ? "jpg" : "png", new File(dstDirPath + file.getName()));
						pictureList.add(file.getName());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
