package com.cono.dogrami.diary.model.dao;

import com.cono.dogrami.diary.model.vo.Diary;
import com.cono.dogrami.diary.model.vo.DiaryLike;
import com.cono.dogrami.common.Paging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("diaryDao")
public class DiaryDao {

    @Autowired
    private SqlSessionTemplate session;

	public ArrayList<Diary> selectList(Paging page) {
	List<Diary> list = session.selectList("diaryboardMapper.selectList", page);
		return (ArrayList<Diary>)list;
	}
	
	public ArrayList<Diary> selectListUser(Map<String, Object> params) {
		List<Diary> list = session.selectList("diaryboardMapper.selectListUser", params);
		return (ArrayList<Diary>)list;
	}
	
	public ArrayList<Diary> selectListAdmin(Paging page) {
		List<Diary> list = session.selectList("diaryboardMapper.selectListAdmin", page);
		return (ArrayList<Diary>)list;
	}
    
	public Diary selectDiaryBoard(int board_no) {
		return session.selectOne("diaryboardMapper.selectDiaryBoard",board_no);
	}
	
	
	public int updateDiaryBoardReadcount(int board_no) {
		return session.update("diaryboardMapper.updateDiaryBoardReadcount",board_no);
	}

	public String selectnickname(int board_no) {
		return session.selectOne("diaryboardMapper.selectnickname",board_no);
	}
	
	public ArrayList<Diary> selectSearch(Map<String, Object> params) {
		List<Diary> list = session.selectList("diaryboardMapper.selectSearch", params);
		return (ArrayList<Diary>)list;
	}
	
	public ArrayList<Diary> selectSearchUser(Map<String, Object> params) {
		List<Diary> list = session.selectList("diaryboardMapper.selectSearchUser", params);
		return (ArrayList<Diary>)list;
	}
	
	public ArrayList<Diary> selectSearchAdmin(Map<String, Object> params) {
		List<Diary> list = session.selectList("diaryboardMapper.selectSearchAdmin", params);
		return (ArrayList<Diary>)list;
	}
	
    public int selectListCount() {
        return session.selectOne("diaryboardMapper.selectListCount");
    }
    
    public int selectListCountUser(String user_id) {
    	return session.selectOne("diaryboardMapper.selectListCountUser", user_id);
    }
    
    public int selectListCountAdmin() {
        return session.selectOne("diaryboardMapper.selectListCountAdmin");
    }


    public int insertDiaryBoard(Diary diary) {
        return session.insert("diaryboardMapper.insertDiaryBoard",diary);
    }


    public int updateDiaryBoard(Diary diary) {
        return session.update("diaryboardMapper.updateDiaryBoard",diary);
    }


    public int deleteDiaryBoard(int board_no) {
        return session.delete("diaryboardMapper.deleteDiaryBoard",board_no);
    }

    public int selectListCountSearch(Map<String, Object> params) {
		List<Diary> list = session.selectList("diaryboardMapper.selectListCountSearch", params);
		return list.size();
    }
    
    public int selectListCountSearchUser(Map<String, Object> params) {
    	List<Diary> list = session.selectList("diaryboardMapper.selectListCountSearchUser", params);
    	return list.size();
    }
    
    public int selectListCountSearchAdmin(Map<String, Object> params) {
    	List<Diary> list = session.selectList("diaryboardMapper.selectListCountSearchAdmin", params);
    	return list.size();
    }
    
    //좋아요 증가
    public int insertDiaryLike(Map<String, Object> params) {
    	return session.insert("diaryboardMapper.insertDiaryLike", params);
    }

    //좋아요 감소
    public int deleteDiaryLike(Map<String, Object> params) {
    	return session.delete("diaryboardMapper.deleteDiaryLike", params);
    }

    //게시판 좋아요 컬럼 숫자증가
	public int updateDiaryLikeCount(int board_no) {
		return session.update("diaryboardMapper.updateDiaryLikeCount", board_no);
	}

	//좋아요 체크여부
	public DiaryLike selectDiaryLikeCheck(Map<String, Object> params) {
		return session.selectOne("diaryboardMapper.selectDiaryLikeCheck",params);
	}



}
