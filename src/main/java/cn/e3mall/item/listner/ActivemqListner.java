package cn.e3mall.item.listner;

import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import cn.e3mall.item.pojo.Item;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.service.ItemService;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class ActivemqListner implements MessageListener{
	@Autowired
	private ItemService itemService;
	@Autowired 
	private FreeMarkerConfigurer freemarkerConfig;
	@Value("${HTMLDEST}")
	private String HTMLDEST;
	@Override
	public void onMessage(Message message) {
		try {
			//获取商品消息的商品id
			TextMessage textMessage = (TextMessage) message;
			String id = textMessage.getText();
			Long itemId = Long.valueOf(id);
			Thread.sleep(1000);
			//根据id查找商品和商品描述
			TbItem tbitem = itemService.getItemById(itemId);
			Item item = new Item(tbitem);
			TbItemDesc itemDesc = itemService.getItemDestById(itemId);
			//从容器中获得configurate
			//configurate获得configuration
			Configuration configuration = freemarkerConfig.getConfiguration();
			//创建模板对象
			Template template = configuration.getTemplate("item.ftl");
			//将商品写入数据源
			Map datasource = new HashMap<>();
			datasource.put("item", item);
			datasource.put("itemDesc", itemDesc);
			//获得输入流
			Writer out = new FileWriter(HTMLDEST+item.getId()+".html");
			//模板对象的process方法创建html文件
			template.process(datasource, out);
			//关闭流
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
