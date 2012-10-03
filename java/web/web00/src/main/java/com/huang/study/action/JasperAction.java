package com.huang.study.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;

import org.apache.struts2.util.ServletContextAware;

import com.huang.study.model.IIreportDao;
import com.huang.study.model.Ireport;
import com.huang.study.utils.BeanContainer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class JasperAction extends ActionSupport implements ServletContextAware {
	private static final long serialVersionUID = -2657479265527219661L;
	private ServletContext context;

	private List<Ireport> rptData = null;
	private Map expConf = new HashMap();
	private Map rptConf = new HashMap();
	

	@Override
	public String execute() throws Exception {
		try {
			IIreportDao dao = (IIreportDao)BeanContainer.getBean("jsprDao");
			rptData = dao.getAll();
			
			rptConf.put("imageFileName", "icon_export");
			rptConf.put("isShowImage", Boolean.FALSE);

			expConf.put(JRHtmlExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			expConf.put(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			//expConf.put(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
			expConf.put(JRHtmlExporterParameter.IMAGES_DIR_NAME, context.getRealPath("skin/en_US/img")); 
			expConf.put(JRHtmlExporterParameter.IMAGES_URI, context.getRealPath("skin/en_US/img")); 

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

	public Map getExpConf() {
		return expConf;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
}
