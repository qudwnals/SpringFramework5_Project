package myspring.di.xml.annot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class HelloBean {
	
	@Value("어노테이션")
	String name;
	
	@Autowired
	@Qualifier("stringPrinter")
	IPrinter printer;
	
	
	List<String> names;

	
	
	
	
	public HelloBean() {
	}

	public HelloBean(String name, IPrinter printer) {
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrinter(IPrinter printer) {
		this.printer = printer;
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
