package org.oversky.gurms.system.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.oversky.base.util.BeanCopyUtils;
import org.oversky.gurms.system.dao.SysMenuDao;
import org.oversky.gurms.system.dao.ext.UserRightDao;
import org.oversky.gurms.system.dto.response.SysMenuRes;
import org.oversky.gurms.system.entity.SysMenu;
import org.oversky.gurms.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "SysMenu")
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuDao menuDao;
	
	@Autowired
	private UserRightDao userRightDao;
	
	@Override
	public SysMenuRes getMenu(String menuId, boolean tree) {
		SysMenuRes res = new SysMenuRes();
		SysMenu menu = menuDao.getById(menuId);
		if(menu == null) {
			res.failure("menuId不存在:" + menuId);
		}else {
			BeanCopyUtils.copy(menu, res);
			res.setTree(tree);
		}
		if(tree) {
			this.getSubMenus(res);
		}
		return res;
	}

	@Override
	@CacheEvict(key = "'getFullMenuTree'")
	public SysMenuRes getFullMenuTree() {
		SysMenuRes root = new SysMenuRes();
		getSubMenus(root);
		return root;
	}
	
	@Override
	public SysMenuRes getMenuByUrl(String url) {
		// TODO Auto-generated method stub
		SysMenu menu = new SysMenu();
		menu.setMenuurl(url);
		List<SysMenu> menus = menuDao.selectWhere(menu);
		SysMenuRes res = null;
		if(menus != null && menus.size() > 0) {
			menu = menus.get(0);
			res = new SysMenuRes();
			BeanCopyUtils.copy(menu, res);
		}
		return res;
	}

	@Override
	public SysMenuRes getUserMenuTree(Long userId) {
		SysMenuRes root = new SysMenuRes();
		root.setTree(true);
		this.getSubMenus(root);

		List<SysMenu> userMenus = userRightDao.getUserMenus(userId);
		this.createMenuTree(root, userMenus);
		return root;
	}

	@Override
	public SysMenuRes getRoleMenuTree(Long roleId) {
		SysMenuRes root = new SysMenuRes();
		root.setTree(true);
		this.getSubMenus(root);

		List<SysMenu> userMenus = userRightDao.getRoleMenus(roleId);
		this.createMenuTree(root, userMenus);
		return root;
	}
	
	private void getSubMenus(SysMenuRes menuRes) {
		List<SysMenu> children = userRightDao.getSubMenus(menuRes.getMenuid());
		if(children != null && children.size() > 0) {
			List<SysMenuRes> childrenRes = BeanCopyUtils.convertList(children, SysMenuRes.class);
			if(menuRes.getMenutype() == null) {
				menuRes.setMenutype(0);
			}
			menuRes.setSubMenus(childrenRes);
			menuRes.setTree(true);
			for(SysMenuRes child : childrenRes) {
				//是目录，继续向下查询
				if(child.getMenutype() == 0) {
					getSubMenus(child);
				}
			}
		}
	}
	
	private void createMenuTree(SysMenuRes root, List<SysMenu> existList){
		if(root.getSubMenus() == null) {
			return;
		}
		Iterator<SysMenuRes> it = root.getSubMenus().iterator();
		List<String> menuIdList = new ArrayList<String>(existList.size());
		for(SysMenu menu : existList) {
			menuIdList.add(menu.getMenuid());
		}
		while(it.hasNext()){
			SysMenuRes menuRes = it.next();
			if(menuIdList.contains(menuRes.getMenuid())) {
				createMenuTree(menuRes, existList);
			}else {
				it.remove();				
			}
		}
	}

}
