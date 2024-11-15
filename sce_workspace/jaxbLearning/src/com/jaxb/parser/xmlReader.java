package com.jaxb.parser;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class xmlReader<T> {
	
	private String filePath;
	private Class<T> glass;
	
	public xmlReader(String filePath, Class<T> glass) {
		this.filePath = filePath;
		this.glass = glass;
	}
	
	@SuppressWarnings("unchecked")
	public void displayAsBean() {
		JAXBContext context = null;
		Unmarshaller unmarshaller = null;
		T beanObj = null;
		
		try {
			context = JAXBContext.newInstance(glass);
			unmarshaller = context.createUnmarshaller();
			beanObj = (T) unmarshaller.unmarshal(new File(filePath));
			
			System.out.println(beanObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
