package com.cono.dogrami.infoshare.model.dao;

import com.cono.dogrami.infoshare.model.vo.Infoshare;
import com.cono.dogrami.infoshare.model.vo.InfoshareLike;
import com.cono.dogrami.common.Paging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("infoshareDao")
public class InfoshareDao {

    @Autowired
    private SqlSessionTemplate session;
    
	public ArrayList<Infoshare> selectList(Paging page) {
	List<Infoshare> list = session.selectList("infoshareboardMapper.selectList", page);
		return (ArrayList<Infoshare>)list;
	}
    
	public Infoshare selectInfoshareBoard(int board_no) {
		return session.selectOne("infoshareboardMapper.selectInfoshareBoard",board_no);
	}
	
	
	public int updateInfoshareBoardReadcount(int board_no) {
		return session.update("infoshareboardMapper.updateInfoshareBoardReadcount",board_no);
	}

	public String selectnickname(int board_no) {
		return session.selectOne("infoshareboardMapper.selectnickname",board_no);
	}
	
	public ArrayList<Infoshare> selectSearch(String action, String keyword, Paging page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("action", action);
		params.put("keyword", keyword);
		params.put("page", page);
		List<Infoshare> list = session.selectList("infoshareboardMapper.selectSearch", params);
		return (ArrayList<Infoshare>)list;
	}
	
    public int selectListCount() {
        return session.selectOne("infoshareboardMapper.selectListCount");
    }


    public int insertInfoshareBoard(Infoshare infoshare) {
        return session.insert("infoshareboardMapper.insertInfoshareBoard",infoshare);
    }


    public int updateInfoshareBoard(Infoshare infoshare) {
        return session.update("infoshareboardMapper.updateInfoshareBoard",infoshare);
    }


    public int deleteInfoshareBoard(int board_no) {
        return session.delete("infoshareboardMapper.deleteInfoshareBoard",board_no);
    }

    public int selectListCountSearch(String keyField, String keyword) {
    	Map<String, Object> params = new HashMap<String, Object>();
		params.put("keyField", keyField);
		params.put("keyword", keyword);
		List<Infoshare> list = session.selectList("infoshareboardMapper.selectListCountSearch", params);
		return list.size();
    }
    
    //좋아요 증가
    public int insertInfoshareLike(Map<String, Object> params) {
    	return session.insert("infoshareboardMapper.insertInfoshareLike", params);
    }

    //좋아요 감소
    public int deleteInfoshareLike(Map<String, Object> params) {
    	return session.delete("infoshareboardMapper.deleteInfoshareLike", params);
    }

    //게시판 좋아요 컬럼 숫자증가
	public int updateInfoshareLikeCount(int board_no) {
		return session.update("infoshareboardMapper.updateInfoshareLikeCount", board_no);
	}

	//좋아요 체크여부
	public InfoshareLike selectInfoshareLikeCheck(Map<String, Object> params) {
		return session.selectOne("infoshareboardMapper.selectInfoshareLikeCheck",params);
	}



}
