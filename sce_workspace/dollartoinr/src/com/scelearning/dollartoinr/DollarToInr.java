package com.scelearning.dollartoinr;

import com.scelearning.service.ServiceAdapter;

public class DollarToInr implements ServiceAdapter {
	
	@Override
	public void currencyConvert(double money) {
		System.out.println(money * 84.43);
	}
}
