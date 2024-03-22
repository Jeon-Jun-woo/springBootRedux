package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.*;
import com.sist.web.service.BdService;

@RestController
@CrossOrigin(origins = "*")
public class BdController {
	@Autowired
	private BdService bService;
	
	@GetMapping("/bd/list_react")
	public Map bd_list(int page)
	{
		int rowSize=9;
		int start=(rowSize*page)-rowSize;
		List<Bd> list=bService.bdListData(start);
		int totalpage=(int)bService.count();
		Map map=new HashMap();
		map.put("list", list);
		map.put("totalpage", totalpage);
		return map;
	}
	
	@GetMapping("/bd/detail_react")
	public Bd bd_detail(int bno)
	{
		Bd bd=bService.findByBno(bno);
		bd.setHit(bd.getHit()+1); //조회수 증가
		bService.save(bd);
		bd=bService.findByBno(bno);
		return bd;
	}
	
	
	
}
