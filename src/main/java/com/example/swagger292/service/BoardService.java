package com.example.swagger292.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swagger292.dao.BoardDao;
import com.example.swagger292.vo.BoardVo;

@Service
public class BoardService {

    // @Autowired
    // BoardDao boardDao;

    private final BoardDao boardDao;
    public BoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    //질문목록
    public ArrayList<BoardVo> selectList() {
        ArrayList<BoardVo> vo = boardDao.selectList();
        return vo;

    }
    
}
