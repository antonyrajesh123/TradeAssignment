package com.poc.tradestore;

import java.time.LocalDate;
import java.util.Map;

public class TradeStoreValidatorUtil {

	public static boolean isNotMatured(LocalDate maturityDate) {
		return maturityDate.isAfter(LocalDate.now());
	}
	
	public static boolean isTradeExpired(LocalDate createdDate, LocalDate maturityDate) {
		return maturityDate.isAfter(createdDate);
	}

	public static boolean isRightTradeVersion(Trade incomingTrade, Map tradesMap) 
			throws TradeVersionException{
		Trade currentTrade = (Trade) tradesMap.get(incomingTrade.getTradeId());
		if(null==currentTrade) {
			//Fresh tradeId, No need to check version
			return true;
		}
		if(incomingTrade.getVersion()<currentTrade.getVersion()) {
			throw new TradeVersionException("Passed version is less than "
					+ "existing trade version");
		}
		return true;
	}
}
