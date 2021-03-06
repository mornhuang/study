package com.huang.j2ee.ch01.action;

import com.huang.j2ee.ch01.service.BookService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/**
 * 测试Struts的action
 */
public class GetBookAction implements Action {
	private String[] books;
	
	public String[] getBooks() {
		return books;
	}

	public void setBooks(String[] books) {
		this.books = books;
	}

	@Override
	public String execute() throws Exception {
		String user = (String) ActionContext.getContext().getSession().get("user");
		if (user != null && user.equals("scott")) {
			BookService bs = new BookService();
			setBooks(bs.getBooks());
			return SUCCESS;
		} else {
			return LOGIN;
		}
	}

}
