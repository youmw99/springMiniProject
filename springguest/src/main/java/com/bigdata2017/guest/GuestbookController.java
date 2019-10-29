package com.bigdata2017.guest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/addAction")
public class GuestbookController {

	@Autowired
	GuestbookDao dao;

	@RequestMapping( method = RequestMethod.GET )
	public String loginAction(@RequestParam("name") String name, @RequestParam("pw") String pw,
			@RequestParam("content")String content, ModelMap model) throws Exception {
		
		List<GuestbookVo> Guestbook = dao.selectlist();
		
		model.addAttribute("items", Guestbook);

		return "index";
	}
	
	@RequestMapping( method = RequestMethod.POST )
	public void insertAction(@RequestParam("name") String name, @RequestParam("pw") String pw,
			@RequestParam("content")String content, ModelMap model) throws Exception {
		
		GuestbookVo addGuest = new GuestbookVo(name, pw, content);
		dao.create(addGuest);
	}
	
	
	@RequestMapping( value="index", method=RequestMethod.POST ) public String join( @ModelAttribute GuestbookVo guestbookVo ) {
	return "index";
	}

	@RequestMapping(value = "/CreateAction")
	public String createAction(@RequestParam("name") String name, @RequestParam("pw") String pw,
			@RequestParam("content")String content, ModelMap model) throws Exception {

		GuestbookVo v = new GuestbookVo();
		model.addAttribute("user", v);
		dao.create(v);
		return "Result";
	}

	@RequestMapping(value = "/DeleteAction")
	public String deleteAction(ModelMap model) throws Exception {
		dao.delete(4);
		return "Result";
	}

	@RequestMapping(value = "/UpdateAction")
	public String updateAction(ModelMap model) throws Exception {

		GuestbookVo v = new GuestbookVo();
		dao.update(v);
		return "Result";
	}
}

