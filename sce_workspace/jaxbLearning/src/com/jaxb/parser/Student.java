package com.jaxb.parser;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "Student")
public class Student {

    private String name;
    private int roll;

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "roll")
    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

	@Override
	public String toString() {
		return "Student [name=" + name + ", roll=" + roll + "]";
	}
    
    
}
