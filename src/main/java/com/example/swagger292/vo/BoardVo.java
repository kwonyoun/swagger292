package com.example.swagger292.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVo {
    int qnaNum; 
	String qnaFil;
	String qnaTitle;
	String qnaCon;
	String qnaImg;
	String qnaDate;
	String qnaReply;
	String qnaOpen;
	String qnaMemId;

	@Override
	public String toString() {
		return "BoardVo{" + "qnaNum=" + qnaNum +", qnaFil=" + qnaFil+", qnaTitle=" + qnaTitle +	", qnaCon=" + qnaCon + 
				", qnaImg=" + qnaImg + 	", qnaDate=" + qnaDate + ", qnaReply=" + qnaReply+ ", qnaOpen="+qnaOpen+", qnaMemId="+qnaMemId+	"}";
	}
}
