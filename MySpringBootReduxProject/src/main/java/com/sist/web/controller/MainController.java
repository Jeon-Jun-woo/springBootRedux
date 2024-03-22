package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.BdService;
import com.sist.web.service.CdlpService;
import com.sist.web.entity.*;
import java.util.*;
@RestController
@CrossOrigin(origins = "*")
public class MainController {
	@Autowired
	private CdlpService cService;
	
	@Autowired
	private BdService bService;
	
	@GetMapping("/")
	public List<Cdlp> cdlpMainData()
	{
	
		List<Cdlp> list=cService.cdlpMainData();
		return list;
	}
	
	
	@GetMapping("/main")
	public Cdlp foodMainVO() {
		Cdlp cdlp=cService.findByCno(180);
		return cdlp;
	}
}
