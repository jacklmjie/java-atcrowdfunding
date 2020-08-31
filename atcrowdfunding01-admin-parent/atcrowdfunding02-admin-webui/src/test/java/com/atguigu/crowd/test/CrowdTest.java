package com.atguigu.crowd.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;

//ָ�� Spring �� Junit �ṩ����������
@RunWith(SpringJUnit4ClassRunner.class)

//���� Spring �����ļ���ע��
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CrowdTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	private AdminService adminService;
	
	@Test
	public void testTx() {
		Admin admin = new Admin(null, "jack2", "123456", "��2", "jack2.qq.com", null);
		adminService.saveAdmin(admin);
	}

	@Test
	public void tetsLog() {
		// ��ȡ��־��¼����
		Logger logger = LoggerFactory.getLogger(CrowdTest.class);
		// ���� Debug �����ӡ��־
		logger.debug("debug��Ϣ");
		logger.info("info��Ϣ");;
	}
	
	@Test
	public void testInsertAdmin() {
		Admin admin = new Admin(null, "jack", "123456", "��", "jack.qq.com", null);
		int count = adminMapper.insert(admin);
		System.out.println("��Ӱ�������" + count);
	}

	@Test
	public void testDataSource() throws SQLException {
		// 1.ͨ������Դ�����ȡ����Դ����
		Connection connection = dataSource.getConnection();
		// 2.��ӡ���ݿ�����
		System.out.println(connection);
	}
}