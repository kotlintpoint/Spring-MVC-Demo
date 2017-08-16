package com.tops.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController{

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index()
	{
		return "index";
	}
	
	@RequestMapping("/hello")
	public String hello()
	{
		return "redirect:welcome";
	}
	@RequestMapping("/contact")
	public String contact()
	{	
		return "redirect:/pages/contact.html";
	}
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public ModelAndView callForm(HttpServletRequest request, 
			HttpServletResponse response){
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		ModelMap modelMap=new ModelMap();
		modelMap.addAttribute("name", name);
		modelMap.addAttribute("mobile",mobile);
		ModelAndView modelAndView=new ModelAndView("show", "model", modelMap);
		return modelAndView;
	}
	@RequestMapping(value="/form1", method=RequestMethod.POST)
	public String multiParam(HttpServletRequest request, 
			HttpServletResponse response, ModelMap modelMap){
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		modelMap.addAttribute("name", name);
		modelMap.addAttribute("mobile",mobile);
		return "show";
	}
	
	@RequestMapping("/welcome")
	public ModelAndView welcome()
	{
		ModelAndView modelAndView=new ModelAndView("WelcomePage");
		modelAndView.addObject("welcomeMessage","Hi user, welcome to the first "
				+ "Spring MVC Application");
		return modelAndView;
	}
}
