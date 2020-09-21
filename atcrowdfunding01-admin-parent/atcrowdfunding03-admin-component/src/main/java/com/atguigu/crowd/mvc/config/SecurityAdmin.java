package com.atguigu.crowd.mvc.config;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.atguigu.crowd.entity.Admin;

/**
 * ���ǵ�User�����н��������˺ź����룬Ϊ���ܹ���ȡ��ԭʼ��Admin����ר�Ŵ���������User�������չ
 * 
 * @author Lenovo
 *
 */
public class SecurityAdmin extends User {

	private static final long serialVersionUID = 1L;

	// ԭʼ��Admin���󣬰���Admin�����ȫ������
	private Admin originalAdmin;

	public SecurityAdmin(
			// ����ԭʼ��Admin����
			Admin originalAdmin,

			// ������ɫ��Ȩ����Ϣ�ļ���
			List<GrantedAuthority> authorities) {

		// ���ø��๹����
		super(originalAdmin.getLoginAcct(), originalAdmin.getUserPswd(), authorities);

		// �������this.originalAdmin��ֵ
		this.originalAdmin = originalAdmin;

		// ��ԭʼAdmin�����е��������
		this.originalAdmin.setUserPswd(null);
	}

	// �����ṩ�Ļ�ȡԭʼAdmin�����getXxx()����
	public Admin getOriginalAdmin() {
		return originalAdmin;
	}

}