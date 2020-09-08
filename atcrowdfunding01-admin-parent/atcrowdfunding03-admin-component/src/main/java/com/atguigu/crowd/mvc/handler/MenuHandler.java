package com.atguigu.crowd.mvc.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.crowd.entity.Menu;
import com.atguigu.crowd.service.api.MenuService;
import com.atguigu.crowd.util.ResultEntity;

//@RestControllerע��=@ResponseBody+@Controller
@RestController
//@ResponseBody
//@Controller
public class MenuHandler {

	@Autowired
	private MenuService menuService;

	// @ResponseBody
	@RequestMapping("/menu/remove.json")
	public ResultEntity<String> removeMenu(@RequestParam("id") Integer id) {

		menuService.removeMenu(id);

		return ResultEntity.successWithoutData();
	}

	// @ResponseBody
	@RequestMapping("/menu/update.json")
	public ResultEntity<String> updateMenu(Menu menu) {

		menuService.updateMenu(menu);

		return ResultEntity.successWithoutData();
	}

	// @ResponseBody
	@RequestMapping("/menu/save.json")
	public ResultEntity<String> saveMenu(Menu menu) {

		// Thread.sleep(2000);

		menuService.saveMenu(menu);

		return ResultEntity.successWithoutData();
	}

	// @ResponseBody
	@RequestMapping("/menu/get/whole/tree.json")
	public ResultEntity<Menu> getWholeTreeNew() {

		// 1.��ѯȫ����Menu����
		List<Menu> menuList = menuService.getAll();

		// 2.����һ�����������洢�ҵ��ĸ��ڵ�
		Menu root = null;

		// 3.����Map���������洢id��Menu����Ķ�Ӧ��ϵ���ڲ��Ҹ��ڵ�
		Map<Integer, Menu> menuMap = new HashMap<Integer, Menu>();

		// 4.����menuList���menuMap
		for (Menu menu : menuList) {

			Integer id = menu.getId();

			menuMap.put(id, menu);
		}

		// 5.�ٴα���menuList���Ҹ��ڵ㡢��װ���ӽڵ�
		for (Menu menu : menuList) {

			// 6.��ȡ��ǰmenu�����pid����ֵ
			Integer pid = menu.getPid();

			// 7.���pidΪnull���ж�Ϊ���ڵ�
			if (pid == null) {
				root = menu;

				// 8.�����ǰ�ڵ��Ǹ��ڵ㣬��ô�϶�û�и��ڵ㣬���ؼ���ִ��
				continue;
			}

			// 9.���pid��Ϊnull��˵����ǰ�ڵ��и��ڵ㣬��ô���Ը���pid��menuMap�в��Ҷ�Ӧ��Menu����
			Menu father = menuMap.get(pid);

			// 10.����ǰ�ڵ���븸�ڵ��children����
			father.getChildren().add(menu);
		}

		// 11.������������㣬���ڵ�������������νṹ�����ظ��ڵ���Ƿ���������
		return ResultEntity.successWithData(root);
	}
}