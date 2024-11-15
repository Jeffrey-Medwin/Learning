package com.scelearning.main;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.scelearning.service.ServiceAdapter;

public class CurrencyConveterLoader {
	
	private static CurrencyConveterLoader _instance;
	private ServiceLoader<ServiceAdapter> loader;
	
	public static synchronized CurrencyConveterLoader getInstance() {
		if(_instance == null) {
			_instance = new CurrencyConveterLoader();
		}
		
		return _instance;
	}
	
	public CurrencyConveterLoader() {
		loader = ServiceLoader.load(ServiceAdapter.class);
	}
	
	public void convertCurrncy(double money) {
		Iterator<ServiceAdapter> iter = loader.iterator();
		
		while(iter.hasNext()) {
			ServiceAdapter adapter = iter.next();
			adapter.currencyConvert(money);
		}
	}
}
