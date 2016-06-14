package com.tc.smlang.lang.io;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileHandlerTest {

	@Test
	public void test() {
		String test = FileHandler.readToString("test.txt");
		assertEquals(test, "test");
	}
	
	@Test
	public void testStripWhitespace() {
		String contents = FileHandler.readToString("test-whitespace.txt");
		contents = FileHandler.stripWhitespace(contents);
		assertEquals(contents, "deftestFunc(){ret1+1;}");
	}
	
	@Test 
	public void testLoadFileWithoutWhitespace() {
		String contents = FileHandler.loadClassFile("test-whitespace.txt");
		assertEquals(contents, "deftestFunc(){ret1+1;}");
	}
}
