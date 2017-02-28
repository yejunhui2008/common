package com.yejh.db.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yejh.db.transaction.mybatis.Table;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/yejh/db/transaction/spring-transaction.xml")
public class Main {

	@Autowired
	private TableService tableService;

	@Test
	public void test1() {
		Table table = new Table();
		table.setColumn1("column1");
		table.setColumn2("column2");
		tableService.insert1(table);
	}
}
