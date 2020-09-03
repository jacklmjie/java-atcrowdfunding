package com.atguigu.crowd.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.exception.AccessForbiddenException;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 1.ͨ��request�����ȡSession����
		HttpSession session = request.getSession();

		// 2.���Դ�Session���л�ȡAdmin����
		Admin admin = (Admin) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN);

		// 3.�ж�admin�����Ƿ�Ϊ��
		if (admin == null) {

			// 4.�׳��쳣
			throw new AccessForbiddenException(CrowdConstant.MESSAGE_ACCESS_FORBIDEN);

		}

		// 5.���Admin����Ϊnull���򷵻�true����
		return true;
	}
}