package org.chen.arch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.servlet.ServletRequest;

/**
 * 工具类
* @author Chengang
* @date 2016年11月23日
 */
public class HttpUtil {
	
	/**
	 * 从request中获取requestBody
	 * 
	 * @param request
	 * @return
	 */
	public static String getRequestBodyStr(ServletRequest request) {
		StringBuffer sb = new StringBuffer();
		InputStream stream = null;
		BufferedReader reader = null;
		try {
			stream = request.getInputStream();
			reader = new BufferedReader(new InputStreamReader(stream,
					Charset.forName("UTF-8")));
			String line = "";
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

}
