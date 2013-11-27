package net.codebuff;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**********************************
 @author Deepankar Tyagi
 **********************************/

public class FileUtil {
	static List<String> javaDir = new ArrayList<String>();
	static List<String> javaFiles = new ArrayList<String>();
	static String parentDir;
	public static String name;
	public static String rollno;

	public FileUtil() {
		findFiles();

		// System.out.println(javaDir);
		// System.out.println(javaFiles);
		new PdfUtils().createPDF();
		// traverseArray();

	}

	public static void walk(String path) {
		File root = new File(path);
		File[] list = root.listFiles();
		String filename;

		if (list == null)
			return;

		for (File f : list) {
			if (f.isDirectory()) {
				walk(f.getAbsolutePath());
			} else {
				filename = f.getName();
				if (filename.endsWith(".java")) {
					// System.out.println("parent:" + f.getParent());
					addtojavaDir(f.getParent());
					javaFiles.add(f.getPath());
					// System.out.println("File:" + f.getPath());
				}
			}
		}
	}
	
	public static void addtojavaDir(String string) {
		if (javaDir.contains(string)) {

		} else {

			javaDir.add(string);
		}


	}

	public void findFiles() {
		File currentDir = new File("");
		FileUtil.parentDir = currentDir.getAbsolutePath();
		FileUtil.walk(FileUtil.parentDir);

	}



		
	}


