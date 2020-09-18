package com.atguigu.crowd.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//��ʾ��ǰ����һ��������
@Configuration

//����Web������Ȩ�޿��ƹ���
@EnableWebSecurity
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
				.permitAll().anyRequest() // ������������
				.authenticated() // ��֤�����
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
