package com.yejh.db.transaction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class TranEventListener {

	@TransactionalEventListener
	public void handleSomeTransactionalEvent(TranEventObj obj) {
		System.out.println("监听触发成功-----");
	}
}
