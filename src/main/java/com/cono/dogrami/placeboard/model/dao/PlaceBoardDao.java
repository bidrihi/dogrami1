package com.cono.dogrami.placeboard.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.placeboard.model.vo.PlaceLike;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.placeboard.model.vo.PlaceBoard;

@Repository("placeBoardDao")
public class PlaceBoardDao {

	@Autowired
	private SqlSessionTemplate session;

	// 페이지처리용 전체글갯수조회용
	public int selectListCount() {
		return session.selectOne("placeboardMapper.selectListCount");
	}

	// 조회수 증가처리
	public int updateCount(int board_no) {
		return session.update("placeboardMapper.updateCount", board_no);
	}

	// 조회수 감소
	public int downUpdateCount(int board_no) {
		return session.update("placeboardMapper.downUpdateCount", board_no);
	}

	// 리스트 조회
	public ArrayList<PlaceBoard> selectList(Paging page) {
		List<PlaceBoard> list = session.selectList("placeboardMapper.selectList", page);
		return (ArrayList<PlaceBoard>) list;
	}

	// 검색후 리스트 구하기위함
	public int selectListCountSearch(Map<String, Object> params) {
		List<PlaceBoard> list = session.selectList("placeboardMapper.selectListCountSearch", params);
		return list.size();

	}

	// 키워드로 리스트 뽑기위함
	public ArrayList<PlaceBoard> selectSearch(Map<String, Object> params) {
		List<PlaceBoard> list = session.selectList("placeboardMapper.selectSearch", params);
		return (ArrayList<PlaceBoard>) list;
	}

	// 지역 리스트 갯수
	public int selectListLocatonCount(Map<String, Object> params) {
		List<PlaceBoard> list = session.selectList("placeboardMapper.selectListLocatonCount", params);
		return list.size();
	}

	// 지역으로 조회
	public ArrayList<PlaceBoard> selectLocation(Map<String, Object> params) {
		List<PlaceBoard> list = session.selectList("placeboardMapper.selectLocation", params);
		return (ArrayList<PlaceBoard>) list;
	}

	// 게시글 작성
	public int insertBoard(PlaceBoard placeBoard) {
		return session.insert("placeboardMapper.insertBoard", placeBoard);
	}

	// 게시글 수정
	public int updateBoard(PlaceBoard placeBoard) {
		return session.update("placeboardMapper.updateBoard", placeBoard);
	}

	// 게시글 삭제
	public int deleteBoard(PlaceBoard placeBoard) {
		return session.delete("placeboardMapper.deleteBoard", placeBoard);
	}

	// 게시글 상세보기
	public PlaceBoard selectPlaceBoard(int board_no) {
		return session.selectOne("placeboardMapper.selectPlaceBoard", board_no);
	}

	//좋아요 증가
	public int insertPlaceLike(Map<String, Object> params) {
		return session.insert("placeboardMapper.insertPlaceLike", params);
	}

	//좋아요 감소
	public int deletePlaceLike(Map<String, Object> params) {
		return session.delete("placeboardMapper.deletePlaceLike", params);
	}

	//게시글 좋아요 증가 처리용
	public int updatePlaceLikeCount(int board_no) {
		return session.update("placeboardMapper.updatePlaceLikeCount",board_no);
	}

	//좋아요 체크여부
	public PlaceLike selectPlaceLikeCheck(Map<String, Object> params) {
		return session.selectOne("placeboardMapper.selectPlaceLikeCheck", params);
	}

	public ArrayList<PlaceBoard> selectNewTop5() {
		List<PlaceBoard> list = session.selectList("placeboardMapper.selectNewTop5");
		return (ArrayList<PlaceBoard>) list;
	}
}
