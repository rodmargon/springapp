package com.mycompany.springapp.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.springapp.service.ProductManager;

@Controller
public class InventoryController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ProductManager productManager;
	
	@RequestMapping(value = "/hello.htm")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String now = new Date().toString();
		logger.info("Returning hello view with date " + now);
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("products", this.productManager.getProducts());
		
        return new ModelAndView("hello","model",myModel);
	}
	
	
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

}
