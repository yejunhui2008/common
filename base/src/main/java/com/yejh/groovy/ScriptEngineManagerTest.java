package com.yejh.groovy;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

import groovy.lang.Binding;

public class ScriptEngineManagerTest {

	public static int testabc(int a) {
	return a * a;
	}

	@Test
	public void test() throws ScriptException, NoSuchMethodException, IOException {
	ScriptEngineManager factory = new ScriptEngineManager();
	ScriptEngine engine = factory.getEngineByName("groovy");

	PipedReader pr = new PipedReader();
	PipedWriter pw = new PipedWriter(pr);
	PrintWriter writer = new PrintWriter(pw);
	engine.getContext().setWriter(writer);
	engine.getContext().setErrorWriter(writer);

	Binding binding = new Binding();
	binding.setVariable("x", 10);

	String HelloLanguage = "System.out.println(\"aaa\");";
	System.out.println(engine.eval(HelloLanguage));
	writer.close();

	//         Invocable inv = (Invocable) engine;
	//         Object[] params = {new String("Groovy")};
	//         Object result = inv.invokeFunction("hello", params);
	//         assert result.equals("Hello Groovy");
	//         System.out.println(result);

	BufferedReader br = new BufferedReader(pr);
	String s = null;
	while ((s = br.readLine()) != null) {
		System.out.println(s);
	}
	System.out.println("end");
	}

	@Test
	public void test2() throws Exception {
	ScriptEngineManager factory = new ScriptEngineManager();
	ScriptEngine engine = factory.getEngineByName("groovy");
	ScriptContext context = engine.getContext();

	System.out.println(context.getWriter());
	System.out.println(context.getErrorWriter());
	context.setWriter(new FileWriter("output.txt"));
	context.setErrorWriter(new FileWriter("outputerror.txt"));
	System.out.println(context.getWriter());
	System.out.println(context.getErrorWriter());
	String HelloLanguage = "System.err.println(date); abc=123;def hello(language) {abc=444;println(\"aaa\");return \"Hello $language\"}; hello(\"a\")";

	Bindings binding = engine.createBindings();
	binding.put("date", 333);

	System.out.println(engine.eval(HelloLanguage, binding));
	System.out.println(binding.get("abc"));

	}

	@Test
	public void test3() throws Exception {
	ScriptEngineManager factory = new ScriptEngineManager();
	ScriptEngine engine = factory.getEngineByName("groovy");
	ScriptContext context = engine.getContext();

	PipedReader pr = new PipedReader();
	PipedWriter pw = new PipedWriter(pr);
	PrintWriter writer = new PrintWriter(pw);
	context.setWriter(writer);
	String HelloLanguage = "System.err.println(date); System.out.println(date); println(date); def test(n){ throw new RuntimeException();}; println(test(\"a\"));";

	Bindings binding = engine.createBindings();
	binding.put("date", 333);

	System.out.println(engine.eval(HelloLanguage, binding));
	writer.close();

	BufferedReader br = new BufferedReader(pr);
	String s = null;
	while ((s = br.readLine()) != null) {
		System.out.println(s);
	}
	System.out.println("end");

	}
}
