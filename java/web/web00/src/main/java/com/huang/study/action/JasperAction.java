package com.huang.study.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;

import org.apache.struts2.util.ServletContextAware;

import com.huang.study.model.IIreportDao;
import com.huang.study.model.Ireport;
import com.huang.study.utils.BeanContainer;
import com.opensymphony.xwork2.ActionSupport;

public class JasperAction extends ActionSupport implements ServletContextAware {
	private static final long serialVersionUID = -2657479265527219661L;
	private ServletContext context;
	private List<Ireport> rptData = null;
	private Map rptConf = new HashMap();
	private Map htmlExpConf = new HashMap();

	@Override
	public String execute() throws Exception {
		try {
			IIreportDao dao = (IIreportDao) BeanContainer.getBean("jsprDao");
			rptData = dao.getAll();

			rptConf.put("image1", new File(context.getRealPath("skin/en_US/img/icon_export.gif")));
			rptConf.put("isShowImage", Boolean.TRUE);

			htmlExpConf.put(JRHtmlExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			htmlExpConf.put(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,	Boolean.TRUE);
			htmlExpConf.put(JRHtmlExporterParameter.IMAGES_DIR_NAME, context.getRealPath("skin/en_US/img"));
			htmlExpConf.put(JRHtmlExporterParameter.IMAGES_URI, context.getContextPath() + "/skin/en_US/img/");
		} catch (Exception e) {

		}
		return SUCCESS;
	}

	public List<Ireport> getRptData() {
		return rptData;
	}

	public Map getRptConf() {
		return rptConf;
	}

	public Map getHtmlExpConf() {
		return htmlExpConf;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
}
