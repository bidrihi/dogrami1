package com.cono.dogrami.contest.model.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.contest.model.dao.ContestDao;
import com.cono.dogrami.contest.model.vo.Contest;
import com.cono.dogrami.contest.model.vo.ContestLike;

@Service("contestService")
public class ContestServiceImpl implements ContestService {
    @Autowired
    private ContestDao contestDao;
    
    @Override
	public ArrayList<Contest> selectList(Paging page) {
		return contestDao.selectList(page);
	}

	@Override
	public Contest selectContestBoard(int  contest_no) {
		return contestDao.selectContestBoard(contest_no);
	}
	
	//게시글 조회수 증가
	@Override
	public int updateContestBoardReadcount(int contest_no) {
		return contestDao.updateContestBoardReadcount(contest_no);
	}
	
	//조인해서 닉네임 가져오기
	@Override
	public String selectnickname(int contest_no) {
		return contestDao.selectnickname(contest_no);
	}

    @Override
    public int selectListCount() {
        return contestDao.selectListCount();
    }

    //게시글 삭제
	@Override
	public int deleteContestBoard(int contest_no) {
		return contestDao.deleteContestBoard(contest_no);
	}

    //게시글 작성
    @Override
    public int insertContestBoard(Contest contest) {
        return contestDao.insertContestBoard(contest);
    }

    //게시글 수정
    @Override
    public int updateContestBoard(Contest contest) {
        return contestDao.updateContestBoard(contest);
    }

	@Override
	public int selectListCountSearch(String action, String keyword) {
		return contestDao.selectListCountSearch(action, keyword);
	}

	@Override
	public ArrayList<Contest> selectSearch(String action, String keyword, Paging page) {
		return contestDao.selectSearch(action, keyword, page);
	}

	@Override
	public ContestLike selectLike(Contest contest) {
		return contestDao.selectLike(contest);
	}

	@Override
	public void insertLike(Contest contest) {
		contestDao.insertLike(contest);
		
	}

	@Override
	public void updateuLike(Contest contest) {
		contestDao.updateuLike(contest);
		
	}

	@Override
	public void updatedLike(Contest contest) {
		contestDao.updatedLike(contest);
		
	}

	@Override
	public void deleteLike(Contest contest) {
		contestDao.deleteLike(contest);
		
	}

	@Override
	public ArrayList<Contest> selectTop5() {
		return contestDao.selectTop5();
	}

	@Override
	public ArrayList<Contest> selectNewTop5() {
		return contestDao.selectNewTop5();
	}

	@Override
	public ContestLike selectContestLikeCheck(Map<String, Object> params) {
		return contestDao.selectContestLikeCheck(params);
	}

	@Override
	public int insertContestLike(Map<String, Object> params) {
		return contestDao.insertContestLike(params);
	}

	@Override
	public int updateContestLikeCount(int contest_no) {
		return contestDao.updateContestLikeCount(contest_no);
	}

	@Override
	public int deleteContestLike(Map<String, Object> params) {
		return contestDao.deleteContestLike(params);
	}

}
