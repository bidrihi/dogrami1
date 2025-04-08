package com.cono.dogrami.careboard.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.careboard.model.vo.CareBoard;
import com.cono.dogrami.careboard.model.vo.CareLike;
import com.cono.dogrami.common.Paging;

@Repository("careBoardDao")
public class CareBoardDao {

	@Autowired
	private SqlSessionTemplate session;

	//페이지처리용 전체글갯수조회용
	public int selectListCount() {
		return session.selectOne("careboardMapper.selectListCount");
	}
	
	//조회수 증가처리
	public int updateCount(int board_no) {
		return session.update("careboardMapper.updateCount", board_no);
	}
	//조회수 감소
	public int downUpdateCount(int board_no) {
		return session.update("careboardMapper.downUpdateCount", board_no);
	}
	
	//리스트 조회
	public ArrayList<CareBoard> selectList(Paging page) {
		List<CareBoard> list = session.selectList("careboardMapper.selectList", page);
		return (ArrayList<CareBoard>)list;
	}
	//검색후 리스트 구하기위함
	public int selectListCountSearch(Map<String,Object> params) {
		List<CareBoard> list = session.selectList("careboardMapper.selectListCountSearch", params);
		return list.size();
		
	}
	//키워드로 리스트 뽑기위함
	public ArrayList<CareBoard> selectSearch(Map<String,Object> params) {
		List<CareBoard> list = session.selectList("careboardMapper.selectSearch", params);
		return (ArrayList<CareBoard>)list;
	}
	
	
	//지역 리스트 갯수
	public int selectListLocatonCount(Map<String, Object> params) {		
		List<CareBoard> list = session.selectList("careboardMapper.selectListLocatonCount", params);
		return list.size();
	}
	
	//지역으로 조회
	public ArrayList<CareBoard> selectLocation(Map<String,Object> params) {
		List<CareBoard> list = session.selectList("careboardMapper.selectLocation", params);
		return (ArrayList<CareBoard>)list;
	}
	

	
	//게시글 작성
	public int insertBoard(CareBoard careBoard) {
		return session.insert("careboardMapper.insertBoard", careBoard);
	}
	//게시글 수정
	public int updateBoard(CareBoard careBoard) {
		return session.update("careboardMapper.updateBoard", careBoard);
	}
	//게시글 삭제
	public int deleteBoard(CareBoard careBoard) {
		return session.delete("careboardMapper.deleteBoard", careBoard);
	}

	//게시글 상세보기
	public CareBoard selectCareBoard(int board_no) {
		return session.selectOne("careboardMapper.selectCareBoard", board_no);
	
	}
	
	//좋아요 증가
	public int insertCareLike(Map<String, Object> params) {
		return session.insert("careboardMapper.insertCareLike", params);
	}
	
	//좋아요 감소
	public int deleteCareLike(Map<String, Object> params) {
		return session.delete("careboardMapper.deleteCareLike", params);
	}
	
	//게시글 좋아요 증가 처리용
	public int updateCareLikeCount(int board_no) {
		return session.update("careboardMapper.updateCareLikeCount",board_no);
	}
	
	//좋아요 체크여부
	public CareLike selectCareLikeCheck(Map<String, Object> params) {
		return session.selectOne("careboardMapper.selectCareLikeCheck", params);
	}

	public ArrayList<CareBoard> selectNewTop5() {
		List<CareBoard> list = session.selectList("careboardMapper.selectNewTop5");
		return (ArrayList<CareBoard>)list;
	}
}
