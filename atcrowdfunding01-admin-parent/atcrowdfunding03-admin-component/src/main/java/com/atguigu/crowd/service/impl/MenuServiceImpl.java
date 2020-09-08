package com.atguigu.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowd.entity.Menu;
import com.atguigu.crowd.entity.MenuExample;
import com.atguigu.crowd.mapper.MenuMapper;
import com.atguigu.crowd.service.api.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	public List<Menu> getAll() {
		return menuMapper.selectByExample(new MenuExample());
	}

	public void saveMenu(Menu menu) {
		menuMapper.insert(menu);
	}

	public void updateMenu(Menu menu) {
		// ����pidû�д��룬һ��Ҫʹ����ѡ��ĸ��£���֤��pid���ֶβ��ᱻ�ÿ�
		menuMapper.updateByPrimaryKeySelective(menu);
	}

	public void removeMenu(Integer id) {
		menuMapper.deleteByPrimaryKey(id);
	}

}