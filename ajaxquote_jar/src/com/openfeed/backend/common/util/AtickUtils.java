package com.openfeed.backend.common.util;

public class AtickUtils {
	
	private static final String P_SIGN = "#";
	private static final String S_SIGN = "/";
	public static final String DOLLAR_SIGN = "$";
	
	public static String format2CurrencySymbol(String symbol){
		StringBuilder sb = new StringBuilder();
		sb.append(P_SIGN).append(symbol);
		return sb.toString();
	}
	
	public static boolean isCurrency(String symbol){
		return symbol.contains(S_SIGN);
	}

	public static boolean isIndex(String symbol){
		return symbol.startsWith(DOLLAR_SIGN);
	}
	
	public static String format2IndexSymbol(String symbol) {
		StringBuilder sb = new StringBuilder();
		sb.append(DOLLAR_SIGN).append(symbol);
		return sb.toString();
	}

}
