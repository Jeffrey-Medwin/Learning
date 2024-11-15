package com.scelearning.dinartoinr;

import com.scelearning.service.ServiceAdapter;

public class DinarToInr implements ServiceAdapter {
	
	@Override
	public void currencyConvert(double money) {
		System.out.println("Dinar: " + money + " -> Inr: " + (money * 274.54));
	}
}
