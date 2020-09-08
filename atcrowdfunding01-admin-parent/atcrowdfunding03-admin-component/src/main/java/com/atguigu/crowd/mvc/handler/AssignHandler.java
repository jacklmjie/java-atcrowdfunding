package com.atguigu.crowd.mvc.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.service.api.RoleService;

@Controller
public class AssignHandler {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private RoleService	roleService;
	
	@RequestMapping("/assign/do/role/assign.html")
	public String saveAdminRoleRelationship(
				@RequestParam("adminId") Integer adminId,
				@RequestParam("pageNum") Integer pageNum,
				@RequestParam("keyword") String keyword,
				
				// ���������û���ҳ����ȡ�������ѷ����ɫ���ύ�������Կ��Բ��ṩroleIdList�������
				// ����required=false��ʾ�������������Ǳ����
				@RequestParam(value="roleIdList", required=false) List<Integer> roleIdList
			) {
		
		adminService.saveAdminRoleRelationship(adminId, roleIdList);
		
		return "redirect:/admin/get/page.html?pageNum="+pageNum+"&keyword="+keyword;
	}

	@RequestMapping("/assign/to/assign/role/page.html")
	public String toAssignRolePage(
			
			@RequestParam("adminId") Integer adminId,
			
			ModelMap modelMap
			
			) {
		
		// 1.��ѯ�ѷ����ɫ
		List<Role> assignedRoleList = roleService.getAssignedRole(adminId);
		
		// 2.��ѯδ�����ɫ
		List<Role> unAssignedRoleList = roleService.getUnAssignedRole(adminId);
		
		// 3.����ģ�ͣ���������ʵ�ǣ�request.setAttribute("attrName",attrValue);
		modelMap.addAttribute("assignedRoleList", assignedRoleList);
		modelMap.addAttribute("unAssignedRoleList", unAssignedRoleList);
		
		return "assign-role";
	}
}
