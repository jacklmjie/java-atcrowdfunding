package com.atguigu.crowd.mvc.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.atguigu.crowd.constant.CrowdConstant;

//��ʾ��ǰ����һ��������
@Configuration

//����Web������Ȩ�޿��ƹ���
@EnableWebSecurity

//����ȫ�ַ���Ȩ�޿��ƹ��ܣ���������prePostEnabled = true����֤@PreAuthority��@PostAuthority��@PreFilter��@PostFilter��Ч
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	/*
	 * 
	 * �������������޷���XxxService��װ��
	 * 
	 * @Bean public BCryptPasswordEncoder getPasswordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {

		// ��ʱʹ���ڴ���¼��ģʽ���Դ���
		// builder.inMemoryAuthentication().withUser("jack").password("123123").roles("ADMIN");

		// ��ʽ������ʹ�û������ݿ����֤
		builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	public void configure(HttpSecurity security) throws Exception {

		security.authorizeRequests() // �����������Ȩ
				.antMatchers("/admin/to/login/page.html") // ��Ե�¼ҳ��������
				.permitAll() // ����������
				.antMatchers("/bootstrap/**") // ��Ծ�̬��Դ�������ã�����������
				.permitAll() // ��Ծ�̬��Դ�������ã�����������
				.antMatchers("/crowd/**") // ��Ծ�̬��Դ�������ã�����������
				.permitAll() // ��Ծ�̬��Դ�������ã�����������
				.antMatchers("/css/**") // ��Ծ�̬��Դ�������ã�����������
				.permitAll() // ��Ծ�̬��Դ�������ã�����������
				.antMatchers("/fonts/**") // ��Ծ�̬��Դ�������ã�����������
				.permitAll() // ��Ծ�̬��Դ�������ã�����������
				.antMatchers("/img/**") // ��Ծ�̬��Դ�������ã�����������
				.permitAll() // ��Ծ�̬��Դ�������ã�����������
				.antMatchers("/jquery/**") // ��Ծ�̬��Դ�������ã�����������
				.permitAll() // ��Ծ�̬��Դ�������ã�����������
				.antMatchers("/layer/**") // ��Ծ�̬��Դ�������ã�����������
				.permitAll() // ��Ծ�̬��Դ�������ã�����������
				.antMatchers("/script/**") // ��Ծ�̬��Դ�������ã�����������
				.permitAll() // ��Ծ�̬��Դ�������ã�����������
				.antMatchers("/ztree/**") // ��Ծ�̬��Դ�������ã�����������
				.permitAll().antMatchers("/admin/get/page.html") // ��Է�ҳ��ʾAdmin�����趨���ʿ���
				//.hasRole("����") // Ҫ��߱������ɫ
				.access("hasRole('����') OR hasAuthority('user:get')")	// Ҫ��߱���������ɫ�͡�user:get��Ȩ�޶���֮һ
				.anyRequest() // ������������
				.authenticated() // ��֤�����
				.and()
				.exceptionHandling()
				.accessDeniedHandler(new AccessDeniedHandler() {
					public void handle(HttpServletRequest request, HttpServletResponse response,
							AccessDeniedException accessDeniedException) throws IOException, ServletException {
						request.setAttribute("exception", new Exception(CrowdConstant.MESSAGE_ACCESS_DENIED));
						request.getRequestDispatcher("/WEB-INF/system-error.jsp").forward(request, response);
					}
				})
				.and().csrf() // ����վ����α�칦��
				.disable() // ����
				.formLogin() // ��������¼�Ĺ���
				.loginPage("/admin/to/login/page.html") // ָ����¼ҳ��
				.loginProcessingUrl("/security/do/login.html") // ָ�������¼����ĵ�ַ
				.defaultSuccessUrl("/admin/to/main/page.html") // ָ����¼�ɹ���ǰ���ĵ�ַ
				.usernameParameter("loginAcct") // �˺ŵ������������
				.passwordParameter("userPswd") // ����������������
				.and().logout() // �����˳���¼����
				.logoutUrl("/seucrity/do/logout.html") // ָ���˳���¼��ַ
				.logoutSuccessUrl("/admin/to/login/page.html") // ָ���˳��ɹ��Ժ�ǰ���ĵ�ַ
		;
	}
}
