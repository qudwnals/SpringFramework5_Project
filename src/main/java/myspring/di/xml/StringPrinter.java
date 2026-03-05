package myspring.di.xml;

import org.springframework.stereotype.Component;


public class StringPrinter implements Printer {
	private StringBuffer buffer = new StringBuffer();

	
	public StringPrinter() {
		System.out.println(this.getClass().getName() + " 기본생성자 호출됨!");
	}
	
	public void print(String message) {
		this.buffer.append(message);
	}

	public String toString() {
		return this.buffer.toString();
	}
}
