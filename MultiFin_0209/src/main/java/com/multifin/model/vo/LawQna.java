package com.multifin.model.vo;

import java.util.Date;

public class LawQna {

	private int LQno                ;
	private String middleCategory	;
	private String articleNo	;
	private String answer	;
	private String mainCategory	;
	private String question	;
	private String smallCategory	;
	
	public LawQna() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LawQna(int lQno, String middleCategory, String articleNo, String answer, String mainCategory,
			String question, String smallCategory) {
		super();
		LQno = lQno;
		this.middleCategory = middleCategory;
		this.articleNo = articleNo;
		this.answer = answer;
		this.mainCategory = mainCategory;
		this.question = question;
		this.smallCategory = smallCategory;
	}
	@Override
	public String toString() {
		return "LawQna [LQno=" + LQno + ", middleCategory=" + middleCategory + ", articleNo=" + articleNo + ", answer="
				+ answer + ", mainCategory=" + mainCategory + ", question=" + question + ", smallCategory="
				+ smallCategory + "]";
	}
	public int getLQno() {
		return LQno;
	}
	public void setLQno(int lQno) {
		LQno = lQno;
	}
	public String getMiddleCategory() {
		return middleCategory;
	}
	public void setMiddleCategory(String middleCategory) {
		this.middleCategory = middleCategory;
	}
	public String getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(String articleNo) {
		this.articleNo = articleNo;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getMainCategory() {
		return mainCategory;
	}
	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getSmallCategory() {
		return smallCategory;
	}
	public void setSmallCategory(String smallCategory) {
		this.smallCategory = smallCategory;
	}


}
