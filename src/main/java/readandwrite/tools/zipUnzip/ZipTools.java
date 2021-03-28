/**
 * 
 *//*

package readandwrite.tools.zipUnzip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.util.zip.ZipEntry;
import java.util.Enumeration;
//import java.util.zip.ZipInputStream;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;
//import java.util.zip.ZipOutputStream;


import com.sx.utility.DateTools;

*/
/**
 * @author admin
 * 
 *//*

public class ZipTools {

	*/
/**
	 * 
	 *//*

	public ZipTools() {
		// TODO Auto-generated constructor stub
	}

	*/
/**
	 * zip压缩
	 * 
	 * @param zipFileName
	 *            zip文件名
	 * @param fileName
	 *            需要压缩的文件名数组
	 * @return
	 *//*

	public boolean Zip(String zipFileName, String[] fileName) {
		if (fileName == null) {
			return false;
		}
		FileOutputStream out;
		FileInputStream in;
		ZipOutputStream zipOut;
		ZipEntry entry;
		int size;
		try {
			// 创建文件输出流对象
			out = new FileOutputStream(zipFileName);
			// 创建ZIP数据输出流对象
			zipOut = new ZipOutputStream(out);
			for (int i = 0; i < fileName.length; i++) {
				// 创建文件输入流对象
				in = new FileInputStream(fileName[i]);
				// 创建指向压缩原始文件的入口
				File file = new File(fileName[i]);
				entry = new ZipEntry(file.getName());
				zipOut.putNextEntry(entry);
				// 向压缩文件中输出数据
				byte[] buffer = new byte[8092];
				while ((size = in.read(buffer)) != -1) {
					zipOut.write(buffer, 0, size);
				}
				zipOut.setEncoding("GBK");
				zipOut.closeEntry();
				zipOut.flush();
				in.close();
			}
			// 关闭创建的流对象
			out.flush();
			
			zipOut.close();
			out.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	*/
/**
	 * 解压缩
	 * 
	 * @param zipFileName
	 *            zip文件名
	 * @param fileSavePath
	 *            解压文件路径
	 * @return
	 *//*

	public boolean unZip(String zipFileName, String fileSavePath) {
		try {
			fileSavePath += "/";
			int size;
			File file = new File(zipFileName);
			File savePath = new File(fileSavePath);
			// 验证待解压文件是否存在
			if (!file.exists()) {
				return false;
			}
			// 创建解压缩目录
			if (!savePath.exists()) {
				savePath.mkdirs();
			}
			ZipFile zf = new ZipFile(file);
			//ZipInputStream zis = new ZipInputStream(new FileInputStream(file));
			Enumeration enu = zf.getEntries();
			FileOutputStream fos = null;
			ZipEntry entry = null;
			while (enu.hasMoreElements()) {
				entry=(ZipEntry) enu.nextElement();
				file = new File(fileSavePath + entry.getName());
				if (entry.isDirectory()) {
					// 目录
					file.mkdirs();
				} else {
					// 文件
					InputStream in = zf.getInputStream(entry);
					file.createNewFile();
					fos = new FileOutputStream(file);
					byte[] buffer = new byte[8092];
					while ((size = in.read(buffer)) != -1) {
						fos.write(buffer, 0, size);
					}
					fos.flush();
					fos.close();
					in.close();
				}
			}
			zf.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	*/
/**
	 * @param args
	 *//*

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SysConfig.getROOT_REAL_PATH()+SysConfig.getFILESEPARATOR()+UploadConfig.getFILE_PATH()+SysConfig.getFILESEPARATOR()+"nc"+;
		ZipTools zt = new ZipTools();
		String zipFileName = "d:\\ziptest\\test.zip";
		String[] fileName = new String[] { "d:\\ziptest\\startWebLogic.sh",
				"d:\\ziptest\\tracert1.txt", "d:\\ziptest\\副本人力资源信息系统_业务互动进度计划(用户)_2010 0505.xls",
				"d:\\ziptest\\dbpc_init测试.log"};
		System.out.println(new DateTools().getDate());
		zt.Zip(zipFileName, fileName);
		System.out.println(new DateTools().getDate());
		zt.unZip("d:\\ziptest\\test.zip", "d:\\ziptest\\test1");
		System.out.println(new DateTools().getDate());
	}

}*/
