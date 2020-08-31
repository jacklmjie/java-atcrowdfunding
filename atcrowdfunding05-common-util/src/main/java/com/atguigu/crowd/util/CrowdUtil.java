package com.atguigu.crowd.util;

import javax.servlet.http.HttpServletRequest;

public class CrowdUtil {

	/**
	 * �жϵ�ǰ�����Ƿ�ΪAjax����
	 * 
	 * @param request �������
	 * @return true����ǰ������Ajax���� false����ǰ������Ajax����
	 */
	public static boolean judgeRequestType(HttpServletRequest request) {

		// 1.��ȡ������Ϣͷ
		String acceptHeader = request.getHeader("Accept");
		String xRequestHeader = request.getHeader("X-Requested-With");

		// 2.�ж�
		return (acceptHeader != null && acceptHeader.contains("application/json"))

				||

				(xRequestHeader != null && xRequestHeader.equals("XMLHttpRequest"));
	}

}