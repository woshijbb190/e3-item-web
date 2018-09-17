package cn.e3mall.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.e3mall.item.pojo.Item;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	@RequestMapping("/item/{Itemid}")
	public String showItemInfo(@PathVariable long Itemid,Model model) {
		TbItem tbItem = itemService.getItemById(Itemid);
		//将tbItem对象转成Item对象，可以取多张图片
		Item item = new Item(tbItem);
		model.addAttribute("item", item);
		
		TbItemDesc tbItemDesc = itemService.getItemDestById(Itemid);
		model.addAttribute("itemDesc", tbItemDesc);
		
		
		return "item";
	}
}
