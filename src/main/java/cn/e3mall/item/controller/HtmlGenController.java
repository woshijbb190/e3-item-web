package cn.e3mall.item.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;
import freemarker.template.Template;
import jline.WindowsTerminal;
@Controller
public class HtmlGenController {
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	@RequestMapping("/genhtml")
	@ResponseBody
	public String genHtml() throws Exception{
		//从容器中获得freeMarkerConfigurer对象
		//获得configuration对象
		Configuration configuration = freeMarkerConfigurer.getConfiguration();
		//获得模板对象
		Template template = configuration.getTemplate("hello.ftl");
		//创建数据集
		Map dataModel = new HashMap<>();
		dataModel.put("hello", "你好啊");
		//输出文件承德writer对象
		Writer writer = new FileWriter("D:\\freemarker\\temp\\hello.html");
		//调用模板对象的process方法，生成文件。
		template.process(dataModel, writer);
		//关闭流
		writer.close();
		
		return "ok";
		
	}
}
