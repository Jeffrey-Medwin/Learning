package com.jaxb.parser;

public class CallParser {
	public static void main(String[] args) {
		xmlReader<Student> reader = new xmlReader<Student>(
				"D:\\Learning\\sce_workspace\\jaxbLearning\\src\\com\\jaxb\\parser\\NewFile.xml", Student.class);
		
		
		reader.displayAsBean();
	}
}
