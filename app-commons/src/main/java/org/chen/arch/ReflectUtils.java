package org.chen.arch;

import java.lang.reflect.Field;

public class ReflectUtils {

	/**
	 * 通过fieldName查询对象obj中的Field
	 * 
	 * @param obj
	 * @param fieldName
	 * @return
	 */
	public static Field getFieldByFieldName(Object obj, String fieldName) {
		for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				return superClass.getDeclaredField(fieldName);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 通过fieldName获取对象obj中对应Field的值
	 * 
	 * @param obj
	 * @param fieldName
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Object getValueByFieldName(Object obj, String fieldName)
			throws IllegalArgumentException, IllegalAccessException {
		Field field = getFieldByFieldName(obj, fieldName);
		return getValueByField(obj, field);
	}

	/**
	 * 获取对象obj中field的值
	 * 
	 * @param obj
	 * @param field
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Object getValueByField(Object obj, Field field)
			throws IllegalArgumentException, IllegalAccessException {
		Object value = null;
		if (field != null) {
			if (field.isAccessible()) {
				value = field.get(obj);
			} else {
				field.setAccessible(true);
				value = field.get(obj);
				field.setAccessible(false);
			}
		}
		return value;
	}

	/**
	 * 将value值塞入obj对象的fieldName字段
	 * @param obj
	 * @param fieldName
	 * @param value
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void setValueByFieldName(Object obj, String fieldName,
			Object value) throws IllegalArgumentException,
			IllegalAccessException {
		Field field = getFieldByFieldName(obj, fieldName);
		setValueByField(obj, field, value);
	}
	
	/**
	 * 将value值塞入obj对象的field字段
	 * @param obj
	 * @param field
	 * @param value
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void setValueByField(Object obj, Field field,
			Object value) throws IllegalArgumentException,
			IllegalAccessException {
		if (field != null) {
			if (field.isAccessible()) {
				field.set(obj, value);
			} else {
				field.setAccessible(true);
				field.set(obj, value);
				field.setAccessible(false);
			}
		}
	}


}
