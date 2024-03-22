package com.sist.web.service;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.sist.web.entity.Bd;
import com.sist.web.entity.Cdlp;

@Service
public interface BdService extends JpaRepository<Bd, Integer>{
	
	@Query(value = "SELECT * FROM bd "
			+"ORDER BY bno ASC LIMIT 5,3"
			,nativeQuery = true)
	public List<Bd> bdMainData();

	
	@Query(value = "SELECT * FROM bd "
			+"ORDER BY bno ASC LIMIT :start,9",nativeQuery = true)
	public List<Bd> bdListData(@Param("start") int start);
	
	public Bd findByBno(int bno);
}
