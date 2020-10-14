package com.atguigu.crowd.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.mapper.RoleMapper;
import com.atguigu.crowd.service.api.AdminService;

//指定 Spring 给 Junit 提供的运行器类
@RunWith(SpringJUnit4ClassRunner.class)

//加载 Spring 配置文件的注解
@ContextConfiguration(locations = { "classpath:spring-persist-mybatis.xml", "classpath:spring-persist-tx.xml" })
public class CrowdTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private AdminMapper adminMapper;

	@Autowired
	private AdminService adminService;

	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Test
	public void testBCryptPasswordEncoder() {
		String source = "123123";
		String encoded = passwordEncoder.encode(source);
		System.out.println(encoded);
	}
	
	@Test
	public void testRoleSave() {
		for (int i = 0; i < 156; i++) {
			roleMapper.insert(new Role(null, "role" + i));
		}
	}

	@Test
	public void test() {
		for (int i = 0; i < 238; i++) {
			adminMapper.insert(new Admin(null, "loginAcct" + i, "userPswd" + i, "userName" + i, "email" + i, null));
		}
	}

	@Test
	public void testTx() {
		Admin admin = new Admin(null, "jack2", "123456", "杰2", "jack2.qq.com", null);
		adminService.saveAdmin(admin);
	}

	@Test
	public void tetsLog() {
		// 获取日志记录对象
		Logger logger = LoggerFactory.getLogger(CrowdTest.class);
		// 按照 Debug 级别打印日志
		logger.debug("debug消息");
		logger.info("info消息");
		;
	}

	@Test
	public void testInsertAdmin() {
		Admin admin = new Admin(null, "jack", "123456", "杰", "jack.qq.com", null);
		int count = adminMapper.insert(admin);
		System.out.println("受影响的行数" + count);
	}

	@Test
	public void testDataSource() throws SQLException {
		// 1.通过数据源对象获取数据源连接
		Connection connection = dataSource.getConnection();
		// 2.打印数据库连接
		System.out.println(connection);
	}
}