package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.*;
import com.sist.web.service.CdlpService;

@RestController
@CrossOrigin(origins = "*")
public class CdlpController {
	@Autowired
	private CdlpService cService;
	
	@GetMapping("/cdlp/list_react")
	public Map cdlp_list(int page)
	{
		int rowSize=9;
		int start=(rowSize*page)-rowSize;
		List<Cdlp> list=cService.cdlpListData(start);
		int totalpage=(int)cService.count();
		Map map=new HashMap();
		map.put("list", list);
		map.put("totalpage", totalpage);
		return map;
	}
	
	@GetMapping("/cdlp/find_react")
	public Map cdlp_find(int page,String name)
	{
		int rowSize=9;
		int start=(rowSize*page)-rowSize;
		List<Cdlp> list=cService.cdlpFindData(name,start);
		int totalpage=cService.cdlpFindTotalPage(name);
		Map map=new HashMap();
		map.put("find_list", list);
		map.put("totalpage", totalpage);
		// {find_list:[],totalpage:..}
		return map;
	}
	
	@GetMapping("/cdlp/detail_react")
	public Cdlp cdlp_detail(int cno)
	{
		Cdlp cdlp=cService.findByCno(cno);
		cdlp.setHit(cdlp.getHit()+1); //조회수 증가
		cService.save(cdlp);
		cdlp=cService.findByCno(cno);
		return cdlp;
	}
}
