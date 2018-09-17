package cn.e3mall.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerTest {
		@Test
		public void run1() throws Exception{
	// 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
			Configuration configuration = new Configuration(Configuration.getVersion());
			// 第二步：设置模板文件所在的路径。
			configuration.setDirectoryForTemplateLoading(new File("E:\\e_workspace\\e3-item-web\\src\\main\\webapp\\WEB-INF\\ftl"));
			// 第三步：设置模板文件使用的字符集。一般就是utf-8.
			configuration.setDefaultEncoding("utf-8");
			// 第四步：加载一个模板，创建一个模板对象。
			Template template = configuration.getTemplate("hello.ftl");
			// 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
			Map dataModel = new HashMap<>();
			//向数据集中添加数据
			dataModel.put("hello", "this is my first freemarker test.");
			// 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
			Writer out = new FileWriter(new File("D:\\freemarker\\temp\\hello.html"));
			// 第七步：调用模板对象的process方法输出文件。
			template.process(dataModel, out);
			// 第八步：关闭流。
			out.close();
		}
		@Test
		public void run2() throws Exception{
			// 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
			Configuration configuration = new Configuration(Configuration.getVersion());
			// 第二步：设置模板文件所在的路径。
			configuration.setDirectoryForTemplateLoading(new File("E:\\e_workspace\\e3-item-web\\src\\main\\webapp\\WEB-INF\\ftl"));
			// 第三步：设置模板文件使用的字符集。一般就是utf-8.
			configuration.setDefaultEncoding("utf-8");
			// 第四步：加载一个模板，创建一个模板对象。
			Template template = configuration.getTemplate("hello.ftl");
			// 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
			Map dataModel = new HashMap<>();
			//向数据集中添加数据
			Student student = new Student("zhangsan",10);
			dataModel.put("student", student);
			// 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
			Writer out = new FileWriter(new File("D:\\freemarker\\temp\\hello.html"));
			// 第七步：调用模板对象的process方法输出文件。
			template.process(dataModel, out);
			// 第八步：关闭流。
			out.close();
		}
		@Test
		public void run3() throws Exception{
			// 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
			Configuration configuration = new Configuration(Configuration.getVersion());
			// 第二步：设置模板文件所在的路径。
			configuration.setDirectoryForTemplateLoading(new File("E:\\e_workspace\\e3-item-web\\src\\main\\webapp\\WEB-INF\\ftl"));
			// 第三步：设置模板文件使用的字符集。一般就是utf-8.
			configuration.setDefaultEncoding("utf-8");
			// 第四步：加载一个模板，创建一个模板对象。
			Template template = configuration.getTemplate("studentList.ftl");
			// 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
			Map dataModel = new HashMap<>();
			//向数据集中添加数据
			List<Student> studentList = new ArrayList<>();
			studentList.add(new Student("张三", 10));
			studentList.add(new Student("李四", 11));
			studentList.add(new Student("王五", 12));
			dataModel.put("studentList", studentList);
			// 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
			Writer out = new FileWriter(new File("D:\\freemarker\\temp\\studentList.html"));
			// 第七步：调用模板对象的process方法输出文件。
			template.process(dataModel, out);
			// 第八步：关闭流。
			out.close();
		}
		@Test
		public void run4() throws Exception{
			// 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
			Configuration configuration = new Configuration(Configuration.getVersion());
			// 第二步：设置模板文件所在的路径。
			configuration.setDirectoryForTemplateLoading(new File("E:\\e_workspace\\e3-item-web\\src\\main\\webapp\\WEB-INF\\ftl"));
			// 第三步：设置模板文件使用的字符集。一般就是utf-8.
			configuration.setDefaultEncoding("utf-8");
			// 第四步：加载一个模板，创建一个模板对象。
			Template template = configuration.getTemplate("data.ftl");
			// 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
			Map dataModel = new HashMap<>();
			//向数据集中添加数据
			dataModel.put("date", new Date());
			// 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
			Writer out = new FileWriter(new File("D:\\freemarker\\temp\\date.html"));
			// 第七步：调用模板对象的process方法输出文件。
			template.process(dataModel, out);
			// 第八步：关闭流。
			out.close();
		}
		@Test
		public void run5() throws Exception{
			// 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
			Configuration configuration = new Configuration(Configuration.getVersion());
			// 第二步：设置模板文件所在的路径。
			configuration.setDirectoryForTemplateLoading(new File("E:\\e_workspace\\e3-item-web\\src\\main\\webapp\\WEB-INF\\ftl"));
			// 第三步：设置模板文件使用的字符集。一般就是utf-8.
			configuration.setDefaultEncoding("utf-8");
			// 第四步：加载一个模板，创建一个模板对象。
			Template template = configuration.getTemplate("null.ftl");
			// 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
			Map dataModel = new HashMap<>();
			dataModel.put("myval", null);
			dataModel.put("date", new Date());
			//向数据集中添加数据
			// 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
			Writer out = new FileWriter(new File("D:\\freemarker\\temp\\null.html"));
			// 第七步：调用模板对象的process方法输出文件。
			template.process(dataModel, out);
			// 第八步：关闭流。
			out.close();
		}
}
