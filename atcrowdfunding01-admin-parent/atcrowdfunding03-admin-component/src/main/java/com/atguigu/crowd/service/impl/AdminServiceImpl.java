package com.atguigu.crowd.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.AdminExample;
import com.atguigu.crowd.entity.AdminExample.Criteria;
import com.atguigu.crowd.exception.LoginAcctAlreadyInUseException;
import com.atguigu.crowd.exception.LoginFailedException;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.util.CrowdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class AdminServiceImpl implements AdminService {

	private Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	private AdminMapper adminMapper;

	public List<Admin> getAll() {
		return adminMapper.selectByExample(new AdminExample());
	}

	public Admin getAdminByLoginAcct(String loginAcct, String userPswd) {

		// 1.���ݵ�¼�˺Ų�ѯAdmin����
		// �ٴ���AdminExample����
		AdminExample adminExample = new AdminExample();

		// �ڴ���Criteria����
		Criteria criteria = adminExample.createCriteria();

		// ����Criteria�����з�װ��ѯ����
		criteria.andLoginAcctEqualTo(loginAcct);

		// �ܵ���AdminMapper�ķ���ִ�в�ѯ
		List<Admin> list = adminMapper.selectByExample(adminExample);

		// 2.�ж�Admin�����Ƿ�Ϊnull
		if (list == null || list.size() == 0) {
			throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
		}

		if (list.size() > 1) {
			throw new RuntimeException(CrowdConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
		}

		Admin admin = list.get(0);

		// 3.���Admin����Ϊnull���׳��쳣
		if (admin == null) {
			throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
		}

		// 4.���Admin����Ϊnull�����ݿ������Admin������ȡ��
		String userPswdDB = admin.getUserPswd();

		// 5.�����ύ������������м���
		String userPswdForm = CrowdUtil.md5(userPswd);

		// 6.��������бȽ�
		if (!Objects.equals(userPswdDB, userPswdForm)) {
			// 7.����ȽϽ���ǲ�һ�����׳��쳣
			throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
		}

		// 8.���һ���򷵻�Admin����
		return admin;
	}

	public PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {
		// 1.����PageHelper�ľ�̬����������ҳ����
		// ������������PageHelper�ġ�������ʽ����ƣ�ԭ��Ҫ���Ĳ�ѯ�������κ��޸�
		String orderBy = "Id desc";
		PageHelper.startPage(pageNum, pageSize, orderBy);

		// 2.ִ�в�ѯ
		List<Admin> list = adminMapper.selectAdminByKeyword(keyword);

		// 3.��װ��PageInfo������
		return new PageInfo<Admin>(list);
	}

	public void remove(Integer adminId) {
		adminMapper.deleteByPrimaryKey(adminId);
	}

	public void saveAdmin(Admin admin) {

		// 1.�������
		String userPswd = admin.getUserPswd();
		userPswd = CrowdUtil.md5(userPswd);
		admin.setUserPswd(userPswd);

		// 2.���ɴ���ʱ��
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime = format.format(date);
		admin.setCreateTime(createTime);

		// 3.ִ�б���
		try {
			adminMapper.insert(admin);
		} catch (Exception e) {
			e.printStackTrace();

			logger.info("�쳣ȫ����=" + e.getClass().getName());

			if (e instanceof DuplicateKeyException) {
				throw new LoginAcctAlreadyInUseException(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
			}
		}

	}
}
