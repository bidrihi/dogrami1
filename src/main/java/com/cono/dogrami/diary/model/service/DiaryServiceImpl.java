package com.cono.dogrami.diary.model.service;

import com.cono.dogrami.diary.model.dao.DiaryDao;
import com.cono.dogrami.diary.model.vo.DiaryLike;
import com.cono.dogrami.diary.model.vo.Diary;
import com.cono.dogrami.common.Paging;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("diaryService")
public class DiaryServiceImpl implements DiaryService {
    
	@Autowired
    private DiaryDao diaryDao;
	
	//게시글 리스트(비회원용)
	@Override
	public ArrayList<Diary> selectList(Paging page) {
		return diaryDao.selectList(page);
	}
	
	//게시글 리스트(회원용)
	@Override
	public ArrayList<Diary> selectListUser(Map<String, Object> params) {
		return diaryDao.selectListUser(params);
	}
	
	//게시글 리스트(관리자용)
	@Override
	public ArrayList<Diary> selectListAdmin(Paging page) {
		return diaryDao.selectListAdmin(page);
	}

	//게시글 검색
	@Override
	public Diary selectDiaryBoard(int board_no) {
		return diaryDao.selectDiaryBoard(board_no);
	}
	
	//게시글 조회수 증가
	@Override
	public int updateDiaryBoardReadcount(int board_no) {
		return diaryDao.updateDiaryBoardReadcount(board_no);
	}
	
	//조인해서 닉네임 가져오기
	@Override
	public String selectnickname(int board_no) {
		return diaryDao.selectnickname(board_no);
	}
	
	//게시글 목록 검색(비회원)
	@Override
	public ArrayList<Diary> selectSearch(Map<String, Object> params) {
		return diaryDao.selectSearch(params);
	}
	
	//게시글 목록 검색(회원)
	@Override
	public ArrayList<Diary> selectSearchUser(Map<String, Object> params) {
		return diaryDao.selectSearchUser(params);
	}
	
	//게시글 목록 검색(관리자)
	@Override
	public ArrayList<Diary> selectSearchAdmin(Map<String, Object> params) {
		return diaryDao.selectSearchAdmin(params);
	}
	
	//게시글 목록 갯수(비회원용)
    @Override
    public int selectListCount() {
        return diaryDao.selectListCount();
    }
    
    //게시글 목록 갯수(회원용)
    @Override
    public int selectListCountUser(String user_id) {
    	return diaryDao.selectListCountUser(user_id);
    }
    
    //게시글 목록 갯수(회원용)
    @Override
    public int selectListCountAdmin() {
    	return diaryDao.selectListCountAdmin();
    }

    //게시글 삭제
	@Override
	public int deleteDiaryBoard(int board_no) {
		return diaryDao.deleteDiaryBoard(board_no);
	}

    //게시글 작성
    @Override
    public int insertDiaryBoard(Diary diary) {
        return diaryDao.insertDiaryBoard(diary);
    }

    //게시글 수정
    @Override
    public int updateDiaryBoard(Diary diary) {
        return diaryDao.updateDiaryBoard(diary);
    }
    
    //게시글 검색(비회원)
    @Override
	public int selectListCountSearch(Map<String, Object> params) {
		return diaryDao.selectListCountSearch(params);
	}
    
    //게시글 검색(회원)
    @Override
    public int selectListCountSearchUser(Map<String, Object> params) {
    	return diaryDao.selectListCountSearchUser(params);
    }
    
    //게시글 검색(회원)
    @Override
    public int selectListCountSearchAdmin(Map<String, Object> params) {
    	return diaryDao.selectListCountSearchAdmin(params);
    }

    //좋아요 증가
    @Override
    public int insertDiaryLike(Map<String, Object> params) {
    	return diaryDao.insertDiaryLike(params);
    }

    //좋아요 감소
    @Override
    public int deleteDiaryLike(Map<String, Object> params) {
    	return diaryDao.deleteDiaryLike(params);
    }
    
    //게시판 좋아요 컬럼 숫자증가
	@Override
	public int updateDiaryLikeCount(int board_no) {
		return diaryDao.updateDiaryLikeCount(board_no);
	}

	@Override
	public DiaryLike selectDiaryLikeCheck(Map<String, Object> params) {
		return diaryDao.selectDiaryLikeCheck(params);
	}











}
