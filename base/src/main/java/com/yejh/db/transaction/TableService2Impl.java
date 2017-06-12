package com.yejh.db.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yejh.db.transaction.mybatis.Table;
import com.yejh.db.transaction.mybatis.TableDao;

@Service
public class TableService2Impl implements TableService2 {

	@Autowired
	private TableDao tableDao;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Transactional
	@Override
	public void insert1(Table table) {
		tableDao.insert1(table);
//		applicationEventPublisher.publishEvent(new TranEventObj("1", "2"));
//		applicationEventPublisher.publishEvent("");
	}

}
