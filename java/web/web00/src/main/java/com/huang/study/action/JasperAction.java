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
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("rawtypes")
public class JasperAction extends ActionSupport implements ServletContextAware {
	private static final long serialVersionUID = -2657479265527219661L;
	private ServletContext context;
	private List<Ireport> htmlRptData;
	private List<Ireport> xlsRptData;	
	private Map htmlRptConf;
	private Map htmlExpConf;
	private Map xlsRptConf;
	private Map xlsExpConf;
	private String xlsFileName;
	
	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public String execute() throws Exception {
		/** 获取报表数据 */
		IIreportDao dao = (IIreportDao) BeanContainer.getBean("jsprDao");
		htmlRptData = dao.getAll();
		ActionContext.getContext().getSession().put("rptData", htmlRptData);

		/** 报表参数设置 */
		htmlRptConf = new HashMap();
		htmlRptConf.put("image1", new File(context.getRealPath("skin/en_US/img/icon_export.gif")));
		htmlRptConf.put("isShowImage", Boolean.TRUE);
		htmlRptConf.put("image1Link", context.getContextPath() + "/JsprXls.action");
		
		/** 导出参数设置 */
		htmlExpConf = new HashMap();
		htmlExpConf.put(JRHtmlExporterParameter.IS_WHITE_PAGE_BACKGROUND, 
				Boolean.FALSE);
		htmlExpConf.put(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
				Boolean.TRUE);
		htmlExpConf.put(JRHtmlExporterParameter.IMAGES_DIR_NAME, 
				context.getRealPath("skin/en_US/img"));
		htmlExpConf.put(JRHtmlExporterParameter.IMAGES_URI,
				context.getContextPath() + "/skin/en_US/img/");
		htmlExpConf.put(JRHtmlExporterParameter.SIZE_UNIT,        //解决生成HTML报表缩小问题
				"pt"); 
//		htmlExpConf.put(JRHtmlExporterParameter.ZOOM_RATIO,
//				(float) 1.5);
		
		return SUCCESS;
	}

	@SuppressWarnings({ "unchecked" })
	public String exportXls() throws Exception {
		xlsRptData = (List<Ireport>)ActionContext.getContext().getSession().get("rptData");

		xlsRptConf = new HashMap();
		xlsRptConf.put("image1", new File(context.getRealPath("skin/en_US/img/icon_export.gif")));
		xlsRptConf.put("isShowImage", Boolean.FALSE);
		
		xlsExpConf = new HashMap();
		xlsExpConf.put(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		xlsExpConf.put(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
		
		xlsFileName = "测试一下";
		
		return SUCCESS;
	}
	
	public List<Ireport> getHtmlRptData() {
		return htmlRptData;
	}

	public List<Ireport> getXlsRptData() {
		return xlsRptData;
	}

	public Map getHtmlRptConf() {
		return htmlRptConf;
	}
	
	public Map getXlsRptConf() {
		return xlsRptConf;
	}
	
	public Map getHtmlExpConf() {
		return htmlExpConf;
	}

	public Map getXlsExpConf() {
		return xlsExpConf;
	}
	
	public String getXlsFileName() {
		return xlsFileName;
	}
	
}
