package com.kenco.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller
public class TestController {

	private static final Logger LOGGER = LogManager.getLogger(TestController.class);

	@RequestMapping(value="/test-items/{pathVariable}/test", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"})
	@ResponseBody
	public TestObject test(@PathVariable String pathVariable, @MatrixVariable(required = false) String matrixVariable) {
		LOGGER.info("Method test (/test-items/{pathVariable}/test) called with PathVariable \"" + pathVariable + "\" and MatrixVariable \"" + matrixVariable + "\".");
		Link link = linkTo(methodOn(TestController.class).test(pathVariable, matrixVariable)).withSelfRel();
		String href = link.getHref();
		LOGGER.info("Link href is: " + href);
		return new TestObject(href);
	}

}
