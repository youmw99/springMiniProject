package com.ggu.guestbook;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuestController {
	
	@Autowired
	GuestDao dao;
	
	@RequestMapping(value = "/addAction" )
	public String loginAction( ModelMap model ) throws Exception
	{
		System.out.println("dao 객체 생성전");
		List<GuestVo> Guest = dao.selectlist();
		System.out.println("dao 객체 생성성공");

		for( GuestVo v : Guest )
		{
			System.out.println( " : " + v.getTitle() + " : " + v.getContent() +" : " + v.getRegdate()+ " : " + v.getUpdateDate()+ " : ");
		}
		
		
		model.addAttribute("items", Guest);
		
		return "index";
	}
	
	@RequestMapping(value = "/CreateAction",  method = RequestMethod.POST)
	public String createAction(@RequestParam("title") String title, @RequestParam("content") String content,
			@RequestParam("writer")String writer, ModelMap model ) throws Exception
	{
		System.out.println("객체 담기 전");
		GuestVo v = new GuestVo(title,content,writer);
		System.out.println("객체 담기 완료\n"+v.toString());
		dao.create(v);
		System.out.println("insert문 처리 완료");

		return "result";
	}
	
	@RequestMapping(value = "/DeleteAction",  method = RequestMethod.POST)
	public String deleteAction(@RequestParam("bno") long bno, ModelMap model ) throws Exception
	{
		dao.delete(bno);
		return "result";
	}
	
	@RequestMapping(value = "/UpdateAction" , method = RequestMethod.POST)
	public String updateAction(@RequestParam("bno") long bno,@RequestParam("title") String title, @RequestParam("content") String content,
			@RequestParam("writer")String writer, ModelMap model ) throws Exception
	{
		GuestVo v = new GuestVo(title,content,writer);
		v.setBno(bno);
		v.toString();
		dao.update(v);
		return "result";
	}

}
