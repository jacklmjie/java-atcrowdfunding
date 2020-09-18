package com.atguigu.crowd.mvc.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.service.api.AuthService;
import com.atguigu.crowd.service.api.RoleService;

@Component
public class CrowdUserDetailsService implements UserDetailsService {

	@Autowired
	private AdminService adminService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private AuthService authService;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// 1.�����˺����Ʋ�ѯAdmin����
		Admin admin = adminService.getAdminByLoginAcct(username);
		
		// 2.��ȡadminId
		Integer adminId = admin.getId();

		// 3.����adminId��ѯ��ɫ��Ϣ
		List<Role> assignedRoleList = roleService.getAssignedRole(adminId);

		// 4.����adminId��ѯȨ����Ϣ
		List<String> authNameList = authService.getAssignedAuthNameByAdminId(adminId);

		// 5.�������϶��������洢GrantedAuthority
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		// 6.����assignedRoleList�����ɫ��Ϣ
		for (Role role : assignedRoleList) {

			// ע�⣺��Ҫ���˼�ǰ׺��
			String roleName = "ROLE_" + role.getName();

			SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleName);

			authorities.add(simpleGrantedAuthority);
		}

		// 7.����authNameList����Ȩ����Ϣ
		for (String authName : authNameList) {

			SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authName);

			authorities.add(simpleGrantedAuthority);
		}

		// 8.��װSecurityAdmin����
		SecurityAdmin securityAdmin = new SecurityAdmin(admin, authorities);

		return securityAdmin;
	}

}