package com.poc.tradestore;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TradeStore {

	private Map<String, Trade> tradesMap = new HashMap<String, Trade> ();
	public void transmitTrade(Trade trade) {
		try {
			if(TradeStoreValidatorUtil.isRightTradeVersion(trade, tradesMap) 
					&& TradeStoreValidatorUtil.isNotMatured(trade.getMaturityDate())) {
				if(TradeStoreValidatorUtil.isTradeExpired(
						trade.getCreatedDate(), trade.getMaturityDate())) {
					trade.setExpired(true);
				}
				tradesMap.put(trade.getTradeId(), trade);
			}
		} catch (TradeVersionException e) {
			//Have to log here
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void showTradeStore() {
		
		tradesMap.entrySet().stream().forEach(trade-> System.out.println(trade));
	}
	
	//Some verification
	public static void main(String[] args) {
		Trade trade1=new Trade("T1",1,"CP-1","B1",LocalDate.of(2020,5,20),LocalDate.of(2021,3,21));
		Trade trade2=new Trade("T2",2,"CP-2","B1",LocalDate.of(2021,5,20),LocalDate.of(2021,3,21));
		Trade trade3=new Trade("T2",1,"CP-1","B1",LocalDate.of(2021,5,20),LocalDate.of(2015,5,14));
		Trade trade4=new Trade("T3",3,"CP-3","B2",LocalDate.of(2014,5,20),LocalDate.of(2021,3,21));
		Trade trade5=new Trade("T5",1,"CP-1","B1",LocalDate.of(2021,5,20),LocalDate.of(2021,3,21));

		TradeStore tradeStore = new TradeStore();
		tradeStore.transmitTrade(trade1);
		tradeStore.transmitTrade(trade2);
		tradeStore.transmitTrade(trade3);
		tradeStore.transmitTrade(trade4);
		tradeStore.transmitTrade(trade5);

		tradeStore.showTradeStore();
	}
}
