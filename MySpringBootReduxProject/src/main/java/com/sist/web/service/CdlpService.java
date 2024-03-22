package com.sist.web.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.*;
import com.sist.web.entity.*;

@Service
public interface CdlpService extends JpaRepository<Cdlp, Integer> {
	@Query(value = "SELECT * FROM cdlp "
			+"ORDER BY cno ASC LIMIT 5,3"
			,nativeQuery = true)
	public List<Cdlp> cdlpMainData();
	
	public Cdlp findByCno(int cno);
	
	@Query(value = "SELECT * FROM cdlp "
			+"ORDER BY cno ASC LIMIT :start,9",nativeQuery = true)
	public List<Cdlp> cdlpListData(@Param("start") int start);
	
	@Query(value = "SELECT * FROM cdlp "
			+"WHERE name LIKE CONCAT('%',:name,'%') "
			+"ORDER BY cno ASC LIMIT :start,9",nativeQuery = true)
	public List<Cdlp> cdlpFindData(@Param("name") String name,@Param("start") int start);
	
	@Query(value = "SELECT CEIL(COUNT(*)/9.0) FROM cdlp "
			+"WHERE name LIKE CONCAT('%',:name,'%')",nativeQuery = true)
	public int cdlpFindTotalPage(@Param("name") String name);
}
