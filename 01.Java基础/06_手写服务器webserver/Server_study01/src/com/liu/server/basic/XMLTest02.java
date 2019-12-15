package com.liu.server.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * XML解析：熟悉SAX解析流程
 * @author liujy
 *
 */
public class XMLTest02 {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		//1、获取解析工厂
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2、从解析工厂获取解析器
		SAXParser parse =factory.newSAXParser();
		//3、编写处理器
		//4、加载文档 Document 注册处理器
		PersonHandler handler=new PersonHandler();
		parse.parse(Thread.currentThread().getContextClassLoader()
		.getResourceAsStream("com/liu/server/basic/p.xml")
		,handler );
		
		List<Person> persons = handler.getPersons();
		for (Person person : persons) {
			System.out.println(person.getName()+"-->"+person.getAge());
		}
	}
	
}

class PersonHandler extends DefaultHandler{
	
	private String tag;
	private List<Person> persons;
	private Person person;
	
	public PersonHandler() {
		persons = new ArrayList<Person>();
	}
	
	public List<Person> getPersons() {
		return persons;
	}

	@Override
	public void startDocument() throws SAXException {
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName != null) {
			tag = qName;
			if (tag.equals("person")) {
				person = new Person();
			}
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch,start,length).trim();
		if (tag != null) {
			if (tag.equals("name")) {
				person.setName(contents);
			} else if (tag.equals("age")) {
				if (contents.length() > 0) {
					person.setAge(Integer.parseInt(contents));
				}
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName != null) {
			if (qName.equals("person")) {
				persons.add(person);
			}
		}
		tag = null;
	}
	
	@Override
	public void endDocument() throws SAXException {
	}
}
