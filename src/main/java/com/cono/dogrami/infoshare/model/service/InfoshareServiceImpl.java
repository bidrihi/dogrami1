package com.cono.dogrami.infoshare.model.service;

import com.cono.dogrami.infoshare.model.dao.InfoshareDao;
import com.cono.dogrami.infoshare.model.vo.InfoshareLike;
import com.cono.dogrami.infoshare.model.vo.Infoshare;
import com.cono.dogrami.common.Paging;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("infoshareService")
public class InfoshareServiceImpl implements InfoshareService {
    
	@Autowired
    private InfoshareDao infoshareDao;
	
	//게시글 리스트
	@Override
	public ArrayList<Infoshare> selectList(Paging page) {
		return infoshareDao.selectList(page);
	}

	//게시글 검색
	@Override
	public Infoshare selectInfoshareBoard(int board_no) {
		return infoshareDao.selectInfoshareBoard(board_no);
	}
	
	//게시글 조회수 증가
	@Override
	public int updateInfoshareBoardReadcount(int board_no) {
		return infoshareDao.updateInfoshareBoardReadcount(board_no);
	}
	
	//조인해서 닉네임 가져오기
	@Override
	public String selectnickname(int board_no) {
		return infoshareDao.selectnickname(board_no);
	}
	
	//게시글 목록 검색
	@Override
	public ArrayList<Infoshare> selectSearch(String action, String keyword, Paging page) {
		return infoshareDao.selectSearch(action, keyword, page);
	}
	
	//게시글 검색시 목록 갯수
    @Override
    public int selectListCount() {
        return infoshareDao.selectListCount();
    }

    //게시글 삭제
	@Override
	public int deleteInfoshareBoard(int board_no) {
		return infoshareDao.deleteInfoshareBoard(board_no);
	}

    //게시글 작성
    @Override
    public int insertInfoshareBoard(Infoshare infoshare) {
        return infoshareDao.insertInfoshareBoard(infoshare);
    }

    //게시글 수정
    @Override
    public int updateInfoshareBoard(Infoshare infoshare) {
        return infoshareDao.updateInfoshareBoard(infoshare);
    }
    
    //게시글 검색
    @Override
	public int selectListCountSearch(String keyField, String keyword) {
		return infoshareDao.selectListCountSearch(keyField, keyword);
	}

    //좋아요 증가
    @Override
    public int insertInfoshareLike(Map<String, Object> params) {
    	return infoshareDao.insertInfoshareLike(params);
    }

    //좋아요 감소
    @Override
    public int deleteInfoshareLike(Map<String, Object> params) {
    	return infoshareDao.deleteInfoshareLike(params);
    }
    
    //게시판 좋아요 컬럼 숫자증가
	@Override
	public int updateInfoshareLikeCount(int board_no) {
		return infoshareDao.updateInfoshareLikeCount(board_no);
	}

	@Override
	public InfoshareLike selectInfoshareLikeCheck(Map<String, Object> params) {
		return infoshareDao.selectInfoshareLikeCheck(params);
	}











}
