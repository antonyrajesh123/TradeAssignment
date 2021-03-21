package com.poc.tradestore;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TradeStoreValidatorUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsNotMatured() {
		LocalDate now=LocalDate.now();
		now = now.plusDays(10);
		assertTrue(TradeStoreValidatorUtil.isNotMatured(now));
		now = now.minusDays(20);
		assertFalse(TradeStoreValidatorUtil.isNotMatured(now));
	}
	
	@Test
	public void testIsTradeExpired() {
		LocalDate createdDate=LocalDate.now();
		LocalDate maturityDate=LocalDate.now().plusDays(10);
		assertTrue(TradeStoreValidatorUtil.isTradeExpired(createdDate, maturityDate));
		maturityDate=LocalDate.now().minusMonths(1);
		assertFalse(TradeStoreValidatorUtil.isTradeExpired(createdDate, maturityDate));
	}
	
	@Test
	public void testIsRightTradeVersion() throws TradeVersionException {
		Trade trade1=new Trade("T1",1,"CP-1","B1",LocalDate.of(2020,5,20),LocalDate.of(2021,3,21));
		Trade trade2=new Trade("T1",2,"CP-2","B1",LocalDate.of(2021,5,20),LocalDate.of(2021,3,21));
		Map<String, Trade> tradesMap = new HashMap<String, Trade>();
		tradesMap.put("T1", trade1);
		assertTrue(TradeStoreValidatorUtil.isRightTradeVersion(trade2, tradesMap));
	}
	
	@Test(expected = TradeVersionException.class)
	public void whenExceptionThrown_thenExpectationSatisfied() throws TradeVersionException {
		Trade trade1=new Trade("T1",1,"CP-1","B1",LocalDate.of(2020,5,20),LocalDate.of(2021,3,21));
		Trade trade2=new Trade("T1",2,"CP-2","B1",LocalDate.of(2021,5,20),LocalDate.of(2021,3,21));
		Map<String, Trade> tradesMap = new HashMap<String, Trade>();
		tradesMap.put("T1", trade2);
		TradeStoreValidatorUtil.isRightTradeVersion(trade1, tradesMap);
	}

}
