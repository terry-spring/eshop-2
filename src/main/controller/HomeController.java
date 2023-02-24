package main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	// 為了保證使用時，不需要每次都去建立logger 物件，我們宣告靜態常量
	public static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String getHome() {
		LOGGER.info("HomeController............{}", this.getClass().getName());
//		StringBuilder sBuilder = new StringBuilder("")
//				.append("a");
		return "index";
	}

}
