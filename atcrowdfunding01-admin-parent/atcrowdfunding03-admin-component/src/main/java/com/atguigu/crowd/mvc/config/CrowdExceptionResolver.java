package com.atguigu.crowd.mvc.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.exception.AccessForbiddenException;
import com.atguigu.crowd.exception.LoginAcctAlreadyInUseException;
import com.atguigu.crowd.exception.LoginFailedException;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import com.google.gson.Gson;

// @ControllerAdvice��ʾ��ǰ����һ������ע����쳣��������
@ControllerAdvice
public class CrowdExceptionResolver {

	@ExceptionHandler(value = LoginFailedException.class)
	public ModelAndView resolveLoginFailedException(LoginFailedException exception, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String viewName = "admin-login";

		return commonResolve(viewName, exception, request, response);
	}

	@ExceptionHandler(value = AccessForbiddenException.class)
	public ModelAndView resolveAccessForbiddenException(AccessForbiddenException exception, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String viewName = "admin-login";

		return commonResolve(viewName, exception, request, response);
	}

	@ExceptionHandler(value = LoginAcctAlreadyInUseException.class)
	public ModelAndView resolveLoginAcctAlreadyInUseException(LoginAcctAlreadyInUseException exception,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		String viewName = "admin-add";

		return commonResolve(viewName, exception, request, response);
	}

	// @ExceptionHandler��һ��������쳣���ͺ�һ��������������
	private ModelAndView commonResolve(

			// �쳣������ɺ�Ҫȥ��ҳ��
			String viewName,

			// ʵ�ʲ��񵽵��쳣����
			Exception exception,

			// ��ǰ�������
			HttpServletRequest request,

			// ��ǰ��Ӧ����
			HttpServletResponse response) throws IOException {

		// 1.�жϵ�ǰ��������
		boolean judgeResult = CrowdUtil.judgeRequestType(request);

		// 2.�����Ajax����
		if (judgeResult) {

			// 3.����ResultEntity����
			ResultEntity<Object> resultEntity = ResultEntity.failed(exception.getMessage());

			// 4.����Gson����
			Gson gson = new Gson();

			// 5.��ResultEntity����ת��ΪJSON�ַ���
			String json = gson.toJson(resultEntity);

			// 6.��JSON�ַ�����Ϊ��Ӧ�巵�ظ������
			response.getWriter().write(json);

			// 7.���������Ѿ�ͨ��ԭ����response���󷵻�����Ӧ�����Բ��ṩModelAndView����
			return null;
		}

		// 8.�������Ajax�����򴴽�ModelAndView����
		ModelAndView modelAndView = new ModelAndView();

		// 9.��Exception�������ģ��
		modelAndView.addObject(CrowdConstant.ATTR_NAME_EXCEPTION, exception);

		// 10.���ö�Ӧ����ͼ����
		modelAndView.setViewName(viewName);

		// 11.����modelAndView����
		return modelAndView;
	}

}