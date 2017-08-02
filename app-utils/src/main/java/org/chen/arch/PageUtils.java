package org.chen.arch;

import java.util.ArrayList;
import java.util.List;

public class PageUtils {

	/**
	 * 获取分页的集合
	 * 
	 * @param <T>
	 * @param list
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public static <T extends Object> List<T> getPagedList(List<T> list, int pageIndex, int pageSize) {
		List<T> result = new ArrayList<T>();
		int start = (pageIndex - 1) * pageSize;
		if (start > list.size()) {
			return result;
		}

		int end = pageIndex * pageSize;
		if (end > list.size()) {
			end = list.size();
		}
		return list.subList(start, end);
	}
}
