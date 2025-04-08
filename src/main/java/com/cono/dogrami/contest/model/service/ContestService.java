package com.cono.dogrami.contest.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.contest.model.vo.Contest;
import com.cono.dogrami.contest.model.vo.ContestLike;

public interface ContestService {
	ArrayList<Contest> selectList(Paging page);	//한 페이지에 출력할 게시글 조회용
	Contest selectContestBoard(int contest_no);	//해당 게시글번호에 대한 게시글 상세 조회용
	int updateContestBoardReadcount(int contest_no); //상세보기시에 조회수 1증가 처리용
    int insertContestBoard(Contest contest);	//원글 등록용
    String selectnickname(int contest_no); //닉네임 검색용

    int updateContestBoard(Contest contest);	//원글 수정용
    int deleteContestBoard(int contest_no);	//게시글 삭제용
    int selectListCount();	//총 게시글 갯수 조회용 (페이지 수 계산용)
	int selectListCountSearch(String action, String keyword);
	ArrayList<Contest> selectSearch(String action, String keyword, Paging page);
	ContestLike selectLike(Contest contest);
	void insertLike(Contest contest);
	void updateuLike(Contest contest);
	void updatedLike(Contest contest);
	void deleteLike(Contest contest);

    ArrayList<Contest> selectTop5();

	ArrayList<Contest> selectNewTop5();
	ContestLike selectContestLikeCheck(Map<String, Object> params);
	int insertContestLike(Map<String, Object> params);
	int updateContestLikeCount(int contest_no);
	int deleteContestLike(Map<String, Object> params);
}
