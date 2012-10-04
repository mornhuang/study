package com.huang.study.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import org.apache.struts2.util.ServletContextAware;

import com.huang.study.model.IIreportDao;
import com.huang.study.model.Ireport;
import com.huang.study.utils.BeanContainer;
import com.opensymphony.xwork2.ActionSupport;

public class JasperAction extends ActionSupport implements ServletContextAware {
	private static final long serialVersionUID = -2657479265527219661L;
	private ServletContext context;
	private List<Ireport> rptData;
	private Map htmlRptConf;
	private Map htmlExpConf;
	private Map xlsRptConf;
	private Map xlsExpConf;
	
	@Override
	public String execute() throws Exception {
		IIreportDao dao = (IIreportDao) BeanContainer.getBean("jsprDao");
		rptData = dao.getAll();

		htmlRptConf = new HashMap();
		htmlRptConf.put("image1", new File(context.getRealPath("skin/en_US/img/icon_export.gif")));
		htmlRptConf.put("isShowImage", Boolean.TRUE);
		htmlRptConf.put("image1Link", context.getContextPath() + "/JsprXls.action");
		
		htmlExpConf = new HashMap();
		htmlExpConf.put(JRHtmlExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		htmlExpConf.put(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,	Boolean.TRUE);
		htmlExpConf.put(JRHtmlExporterParameter.IMAGES_DIR_NAME, context.getRealPath("skin/en_US/img"));
		htmlExpConf.put(JRHtmlExporterParameter.IMAGES_URI, context.getContextPath() + "/skin/en_US/img/");
		
		return SUCCESS;
	}

	public String exportXls() throws Exception {
		IIreportDao dao = (IIreportDao) BeanContainer.getBean("jsprDao");
		rptData = dao.getAll();

		xlsRptConf = new HashMap();
		xlsRptConf.put("image1", new File(context.getRealPath("skin/en_US/img/icon_export.gif")));
		xlsRptConf.put("isShowImage", Boolean.FALSE);
		
		xlsExpConf = new HashMap();
		xlsExpConf.put(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		xlsExpConf.put(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
		
		return SUCCESS;
	}
	
	public List<Ireport> getRptData() {
		return rptData;
	}

	public Map getHtmlRptConf() {
		return htmlRptConf;
	}

	public Map getHtmlExpConf() {
		return htmlExpConf;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	public Map getXlsRptConf() {
		return xlsRptConf;
	}

	public Map getXlsExpConf() {
		return xlsExpConf;
	}
}
