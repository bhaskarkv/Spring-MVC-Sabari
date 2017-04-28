package com.balaji.logistics.controllers;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.balaji.ProjectService;
import com.balaji.logistics.model.Logistics;
import com.balaji.logistics.model.Project;

@Controller
public class LogisticsController {

	@Autowired
	ProjectService projectService;

	@RequestMapping(value="/findAll")
	public ModelAndView displayAllLogisticsDetails(){
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("alllogistics");
		
		//mv.addObject("listLogistics",projectService.getAllLogistics());
		
		return mv;
		}
	
	@RequestMapping(value="/open",method=RequestMethod.GET)
	public String addProject(){
		
		return "addProject";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.GET)
	public ModelAndView saveProject(){
		
		ModelAndView mv = new ModelAndView("addSpringProject","project",new Project());
		
		
		return mv;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String submitProject(@ModelAttribute Project project){
		
		boolean b= projectService.saveProject(project);
		
		return "addSpringProject";
	}
	
	
	@RequestMapping(value="/show")
	@ResponseBody
	public String getShow(){
		return "Welcome To Spring MVC";
	}
	
	@RequestMapping(value="/index")
	public String getIndex(){
		return "index";
	}
	
	
/*	@RequestMapping(value="/index/{logName}")
	public String getIndex(@PathVariable(value="logName") String logNameSabari){
		System.out.println(logNameSabari);
		
		return "index";
	}*/
	
	@RequestMapping(value="/index/{logName}/{password}")
	public ModelAndView getIndex(@PathVariable(value="logName") String logNameSabari){
		/*System.out.println(logNameSabari);*/
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("index");			
		
		mv.addObject("logisticsName", logNameSabari);
		
		return mv;
	}
	
	
	@RequestMapping(value="/findlogistic/{logId}")
	public ModelAndView findLogistic(@PathVariable(value="logId") String logisticID){
		/*System.out.println(logNameSabari);*/
		
		Logistics logistics1 = new Logistics(101, "Hathway", 45.4f);
		Logistics logistics2 = new Logistics(103, "Amazon", 125.6f);
		Logistics logistics3 = new Logistics(104, "FireWay", 35.4f);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("findlogistics");			
		
		switch (Integer.parseInt(logisticID)) {
		case 101:
			mv.addObject("logisticData",logistics1);
			break;
		case 103:
			mv.addObject("logisticData",logistics2);
			break;
		
		case 104:
			mv.addObject("logisticData",logistics3);
			break;
		
		default:
			break;
		}
		
		
		return mv;
	}
	
}
