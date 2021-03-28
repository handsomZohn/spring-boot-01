/*
package readandwrite.tools.zipUnzip;

import java.io.File;
import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.junrar.Archive;
import com.github.junrar.VolumeManager;
import com.github.junrar.rarfile.FileHeader;
import com.sx.conf.SysConfig;
import com.sx.conf.UploadConfig;
import readandwrite.tools.helper.stringhelper.StringHelper;


*/
/**
 * 
 * <p>Title:UnRar</p>
 * <p>Description:rar文件解压缩</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>Company:bksx</p>
 * <p>CreateDate:2019年3月21日</p>
 * @author Administrator
 * @version 1.0
 *//*

public class UnRarV01 {
	
	*/
/**
	 * 此方法接收名字、拼接路径
	 * 下面重载方法为解压缩
	 * @param scclfwqwjmc 上传材料服务器文件名字
	 *//*

	public void unRar(String scclfwqwjmc) {
		if (StringHelper.isNotEmpty(scclfwqwjmc) && scclfwqwjmc.toLowerCase().endsWith(".rar")) {
			String filePath = SysConfig.getROOT_REAL_PATH() + SysConfig.getFILESEPARATOR()
					+ UploadConfig.getFILE_PATH() + SysConfig.getFILESEPARATOR()
					+ "rlzyfwxk" + SysConfig.getFILESEPARATOR();
			// rar文件名字前缀
			String prefix = "";
			// 解压缩后文件存放路径=filePath + rar文件前缀 
			String unRarFilePath = "";
			try {
				if (scclfwqwjmc.lastIndexOf(".") != -1) {
					prefix = scclfwqwjmc.substring(0, scclfwqwjmc.indexOf("."));
					unRarFilePath = filePath + prefix + SysConfig.getFILESEPARATOR();
					// unRar(filePath + scclfwqwjmc, unRarFilePath);
					ZipTools zipTools = new ZipTools();
					zipTools.unZip(filePath + scclfwqwjmc, unRarFilePath);
				}
			} catch (Exception e) {
				System.out.println("=============文件解压缩异常==============");
				e.printStackTrace();
			}
		}
	}
	
	*/
/**
	 * 解压缩
	 * @param srcRarPath 源文件路径 e.g.E:\workspace\myeclipse2014\bjldlsc\root\sysfiles\rlzyfwxk\fb33a37aa9c900.rar
	 * @param dstDirectoryPath 解压至目录 e.g.E:\workspace\myeclipse2014\bjldlsc\root\sysfiles\rlzyfwxk\fb33a37aa9c900\
	 * @throws Exception
	 *//*

	public void unRar(String srcRarPath, String dstDirectoryPath) throws Exception{
		// 验证是否rar文件
		if (!srcRarPath.toLowerCase().endsWith(".rar")) {
			throw new Exception("非rar文件！");
		}
		
		// 创建解压至目录
		File file = new File(dstDirectoryPath);
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
		
		// 解压操作
		File fol = null, out = null;
		Archive archive = null;
		try {
			archive = new Archive((VolumeManager) new File(srcRarPath));
			if (archive != null) {
				// 打印文件信息
				// archive.getMainHeader().print();
				FileHeader nextFileHeader = archive.nextFileHeader();
				while(nextFileHeader != null){
					// 是文件夹
					if (nextFileHeader.isDirectory()) {
						if (existsZH(nextFileHeader.getFileNameW())) {
							fol = new File(dstDirectoryPath + SysConfig.getFILESEPARATOR() + nextFileHeader.getFileNameW());
						} else {
							fol = new File(dstDirectoryPath + SysConfig.getFILESEPARATOR() + nextFileHeader.getFileNameString());
						}
						fol.mkdirs();
					// 文件
					} else {
						if (existsZH(nextFileHeader.getFileNameW())) {
							out = new File(dstDirectoryPath + SysConfig.getFILESEPARATOR() + nextFileHeader.getFileNameW());
						} else {
							out = new File(dstDirectoryPath + SysConfig.getFILESEPARATOR() + nextFileHeader.getFileNameString());
						}
					}
					
					// 避免出现异常之后不会继续解压
					FileOutputStream fileOutputStream = null;
					try {
						if (!out.exists()) {
							if (!out.getParentFile().exists()) {
								out.getParentFile().mkdirs();
							}
							out.createNewFile();
						}
						fileOutputStream = new FileOutputStream(out);
						archive.extractFile(nextFileHeader, fileOutputStream);
						
					} catch (Exception e) {
						// 警告: exception in archive constructor maybe file is encrypted or currupt
						// e.printStackTrace();
					} finally {
						fileOutputStream.close();
					}
				}
				nextFileHeader = archive.nextFileHeader();
			}
		} catch (Exception e) {
			// 警告: exception in archive constructor maybe file is encrypted or currupt
			// e.printStackTrace();
		} finally {
			archive.close();
		}
	}
	
	
	*/
/**
	 * 是否有中文
	 * @param str 要判断的字符串
	 * @return flase没有中文
	 *//*

	private static boolean existsZH(String str) {
		String regStr = "[\\u4e00-\\u9fa5]";
		Pattern pattern = Pattern.compile(regStr);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			return true;
		}
		return false;
	}
}
*/
