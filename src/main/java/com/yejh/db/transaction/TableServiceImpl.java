package com.yejh.db.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.yejh.db.transaction.mybatis.Table;
import com.yejh.db.transaction.mybatis.TableDao;

@Service
public class TableServiceImpl implements TableService {

	@Autowired
	private TableDao tableDao;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private DataSourceTransactionManager transactionManager;

	@Autowired
	private TableService2 tableService2;

	//	@Transactional
	@Override
	public void insert1(Table table) {

		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			tableDao.insert1(table);
			tableService2.insert1(table);
//			String s = null;
//			if (s.equals("")) {
//
//			}
			transactionManager.commit(status);
		} catch (Exception e) {
			transactionManager.rollback(status);
		}
		//applicationEventPublisher.publishEvent(new TranEventObj("1", "2"));
	}

	@Transactional
	@Override
	public void insert2(Table table) {
		tableDao.insert2(table);
		applicationEventPublisher.publishEvent(new TranEventObj("1", "2"));
	}

}
