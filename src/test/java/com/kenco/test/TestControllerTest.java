package com.kenco.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class TestControllerTest {

	private TestController testController;

	@Before
	public void setUp() throws Exception {
		testController = new TestController();

		MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(mockHttpServletRequest));
	}

	@Test
	public void testTest() throws Exception {
		TestObject testObject = testController.test("firstString;matrixVariable=secondString", "secondString");
		Assert.assertEquals(testObject.getHref(), "http://localhost/test-items/firstString;matrixVariable=secondString/test");
	}

}