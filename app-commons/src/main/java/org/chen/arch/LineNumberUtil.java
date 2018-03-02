package org.chen.arch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LineNumberUtil {
	    static List<File> list = new ArrayList<File>();
	    static int cntCode=0, cntNode=0, cntSpace=0;
	    static boolean flagNode = false;
	    
	    public static void count(String path) {
	        File file = new File(path);
	        File files[] = null;
	        files = file.listFiles();
	        addFile(files);
	        isDirectory(files);
	        readLinePerFile();
	    }
	 
	    // 判断是否是目录
	    private static void isDirectory(File[] files) {
	        for (File s : files) {
	            if (s.isDirectory()) {
	                File file[] = s.listFiles();
	                addFile(file);
	                isDirectory(file);
	                continue;
	            }
	        }
	    }
	 
	    //将src下所有文件组织成list
	    private static void addFile(File file[]) {
	        for (int index = 0; index < file.length; index++) {
	            list.add(file[index]);
	        }
	    }
	     
	    //读取非空白行
	    private static void readLinePerFile() {
	    	FileReader fr = null;
	    	BufferedReader br = null;
	        try {
	            for (File s : list) {
	                if (s.isDirectory()) {
	                    continue;
	                }
	                fr = new FileReader(s);
	                br = new BufferedReader(fr);
	                String line = "";
	                while ((line = br.readLine()) != null) {
	                	pattern(line);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (Exception e) {
	                }
	            }
	            if (fr != null) {
	                try {
	                    fr.close();
	                } catch (Exception e) {
	                }
	            }
	        }
	    }
	     
	    private static void pattern(String line) {
			// TODO Auto-generated method stub
			String regxNodeBegin = "\\s*/\\*.*";
			String regxNodeEnd = ".*\\*/\\s*";
			String regx = "//.*";
			String regxSpace = "\\s*";
			if(line.matches(regxNodeBegin) && line.matches(regxNodeEnd)){
				++cntNode;
				return ;
			}
			if(line.matches(regxNodeBegin)){
				++cntNode;
				flagNode = true;
			} else if(line.matches(regxNodeEnd)){
				++cntNode;
				flagNode = false;
			} else if(line.matches(regxSpace))
				 ++cntSpace;
			else if(line.matches(regx))
				 ++cntNode;
			else if(flagNode)
				 ++cntNode;
			else ++cntCode;
		}

	    public static void main(String args[]) {
	    	count("C:/Users/yang_/Desktop/cz");
	    	System.out.println("注释行： " + cntNode);
			System.out.println("空行： " + cntSpace);
			System.out.println("代码行： " + cntCode);
			System.out.println("总行： " + (cntNode+cntSpace+cntCode));
	    }
}
