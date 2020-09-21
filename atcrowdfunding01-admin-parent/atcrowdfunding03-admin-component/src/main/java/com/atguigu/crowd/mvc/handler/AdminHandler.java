package com.atguigu.crowd.mvc.handler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.util.ResultEntity;
import com.github.pagehelper.PageInfo;

@Controller
public class AdminHandler {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/admin/do/login.html")
	public String doLogin(@RequestParam("loginAcct") String loginAcct, @RequestParam("userPswd") String userPswd,
			HttpSession session) {

		// ����Service����ִ�е�¼���
		// �����������ܹ�����admin����˵����¼�ɹ�������˺š����벻��ȷ����׳��쳣
		Admin admin = adminService.getAdminByLoginAcct(loginAcct, userPswd);

		// ����¼�ɹ����ص�admin�������Session��
		session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN, admin);

		return "redirect:/admin/to/main/page.html";
	}

	@RequestMapping("/admin/do/logout.html")
	public String doLogout(HttpSession session) {

		// ǿ��SessionʧЧ
		session.invalidate();

		return "redirect:/admin/to/login/page.html";
	}

	@RequestMapping("/admin/get/page.html")
	public String getPageInfo(
			// ʹ��@RequestParamע���defaultValue���ԣ�ָ��Ĭ��ֵ����������û��Я����Ӧ����ʱʹ��Ĭ��ֵ
			// keywordĬ��ֵʹ�ÿ��ַ�������SQL������ʵ�������������
			@RequestParam(value = "keyword", defaultValue = "") String keyword,
			// pageNumĬ��ֵʹ��1
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			// pageSizeĬ��ֵʹ��5
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, ModelMap modelMap) {
		// ����Service������ȡPageInfo����
		PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, pageSize);

		// ��PageInfo�������ģ��
		modelMap.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO, pageInfo);

		return "admin-page";
	}

	@RequestMapping("/admin/remove/{adminId}/{pageNum}/{keyword}.html")
	public String remove(@PathVariable("adminId") Integer adminId, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("keyword") String keyword) {

		// ִ��ɾ��
		adminService.remove(adminId);

		// ͬʱΪ�˱���ԭ�����ڵ�ҳ��Ͳ�ѯ�ؼ����ٸ���pageNum��keyword�����������
		return "redirect:/admin/get/page.html?pageNum=" + pageNum + "&keyword=" + keyword;
	}

	@PreAuthorize("hasAuthority('user:save')")
	@RequestMapping("/admin/save.html")
	public String save(Admin admin) {

		adminService.saveAdmin(admin);

		return "redirect:/admin/get/page.html";
	}
	
	@RequestMapping("/admin/to/edit/page.html")
	public String toEditPage(
				@RequestParam("adminId") Integer adminId,
				ModelMap modelMap
			) {
		
		// 1.����adminId��ѯAdmin����
		Admin admin = adminService.getAdminById(adminId);
		
		// 2.��Admin�������ģ��
		modelMap.addAttribute("admin", admin);
		
		return "admin-edit";
	}
	
	@RequestMapping("/admin/update.html")
	public String update(Admin admin, @RequestParam("pageNum") Integer pageNum, @RequestParam("keyword") String keyword) {
		
		adminService.update(admin);
		
		return "redirect:/admin/get/page.html?pageNum="+pageNum+"&keyword="+keyword;
	}
	
	//ֻ����ż�����Բ���ǰ���й��ˣ�ֻ�ܲ�������
	//PostFilter,�Բ�������й��ˣ�ֻ�ܲ�������
	@PreFilter(value="filterObject%2==0")
	@ResponseBody
	@RequestMapping("/admin/test/pre/filter")
	public ResultEntity<List<Integer>> saveList(@RequestBody List<Integer> valueList) {
		return ResultEntity.successWithData(valueList);
	}
}