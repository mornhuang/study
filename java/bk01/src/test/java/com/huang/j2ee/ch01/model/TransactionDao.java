package com.huang.j2ee.ch01.model;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class TransactionDao {
	private PlatformTransactionManager transactionManager;
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	public Object create(Object obj) {
		TransactionTemplate transTempl = new TransactionTemplate(transactionManager);
		Object result = transTempl.execute(
			new TransactionCallback() {
				
				@Override
				public Object doInTransaction(TransactionStatus status) {
					return null;
				}
			}
		);
		return result;
	}
}
