package com.scelearning.main;

public class Main {
	public static void main(String[] args) {
		
		double money = 1;
		
		CurrencyConveterLoader conveterLoader = CurrencyConveterLoader.getInstance();
		conveterLoader.convertCurrncy(money);
		System.out.println("done");
	}
}
