package com.huang.j2ee.ch01.action;

import java.util.HashMap;
import java.util.logging.Level;

import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineConstants;
import org.eclipse.birt.report.engine.api.HTMLActionHandler;
import org.eclipse.birt.report.engine.api.HTMLEmitterConfig;
import org.eclipse.birt.report.engine.api.HTMLRenderContext;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.HTMLServerImageHandler;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;

import com.opensymphony.xwork2.ActionSupport;

public class BirtAction extends ActionSupport {

	public String execute() throws Exception {
		HashMap<String, Integer> parameters = new HashMap<String, Integer>();

		String name = "Top Count";
		Integer pvalue = new Integer(4);
		parameters.put(name, pvalue);

		IReportEngine engine = null;
		EngineConfig config = null;

		try {
			// 设置Engine并且启动报表平台
			config = new EngineConfig();
			config.setEngineHome("C:/birt-runtime-2_1_1/birt-runtime-2_1_1/ReportEngine");

			// 设置报表日志保存的位置和等级( null, Level ) 如果你不需要日志可以设置为null
			config.setLogConfig("c:/birt/logs", Level.FINE);

			// 平台初始化，启用
			Platform.startup(config);
			IReportEngineFactory factory = (IReportEngineFactory) Platform
					.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
			engine = factory.createReportEngine(config);
			engine.changeLogLevel(Level.WARNING);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// 设置发起者的一些操作，比如显示图片，报表生成到html页面，很关键的部分
		HTMLEmitterConfig emitterConfig = new HTMLEmitterConfig();
		emitterConfig.setActionHandler(new HTMLActionHandler());
		HTMLServerImageHandler imageHandler = new HTMLServerImageHandler();
		emitterConfig.setImageHandler(imageHandler);
		config.getEmitterConfigs().put("html", emitterConfig); //$NON-NLS-1$

		IReportRunnable design = null;

		// 打开设计好的报表，取绝对路径，最好使用context.getRealPath();这种方法实现，官方这个比较呆
		design = engine.openReportDesign("C:/test/2.1/executereport/test.rptdesign");

		// 创建报表任务
		IRunAndRenderTask task = engine.createRunAndRenderTask(design);

		// 设置报表的路径和图片显示的路径
		HTMLRenderContext renderContext = new HTMLRenderContext();

		// 为所有的actions设置Base URL，这个不写就是默认服务器URL的
		renderContext.setBaseURL("http://localhost/");

		// 设置所有图片显示的URL - 如果之前没有emitterConfig.setImageHandler( imageHandler
		// );的话会造成显示的URL是本地的绝对路径，其实http://localhost不写也是可以的，
		// 会自动添加服务器的URL
		renderContext.setBaseImageURL("http://localhost/myimages");

		// 设置所有图片存放的位置，最好使用context.getRealPath();
		renderContext.setImageDirectory("C:/xampplite/htdocs/myimages");

		// 设置图片支持的格式，据官方说必须有SVG，我没写也没出错
		renderContext.setSupportedImageFormats("JPG;PNG;BMP;SVG");
		HashMap<String, HTMLRenderContext> contextMap = new HashMap<String, HTMLRenderContext>();
		contextMap.put(EngineConstants.APPCONTEXT_HTML_RENDER_CONTEXT,
				renderContext);
		task.setAppContext(contextMap);

		// 设置参数
		task.setParameterValues(parameters);

		// 要所有的参数一条一条的写入
		// 例如： task.setParameterValue("Top Count", new Integer(12));
		task.validateParameters();

		// 增加scrpit参考下面的例子
		// pFilter.myjavamethod()
		// ProcessFilter pf = new ProcessFilter();
		// task.addScriptableJavaObject("pFilter", pf);

		// 设置rendering操作
		// 例如file or stream output, output format, whether it is embeddable, etc
		HTMLRenderOption options = new HTMLRenderOption();

		// 例如：Remove HTML and Body tags
		// options.setEmbeddable(true);

		// 设置输出本地文件
		options.setOutputFileName("C:/test/2.1/output.html");

		// 设置输出文件格式
		options.setOutputFormat("html");
		task.setRenderOption(options);

		// 运行report任务，然后关闭
		// 如果要长期留驻的话可以不关闭，建议不关闭engine和Platform，要不每次打开报表都要等好久……
		task.run();
		task.close();
		engine.shutdown();
		Platform.shutdown();

		return SUCCESS;
	}
}
