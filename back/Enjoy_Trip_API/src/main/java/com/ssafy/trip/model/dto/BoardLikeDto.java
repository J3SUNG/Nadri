package com.ssafy.trip.model.dto;

public class BoardLikeDto {

	private int boardNo;
	private int userNo;
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	@Override
	public String toString() {
		return "BoardLikeDto [boardNo=" + boardNo + ", userNo=" + userNo + "]";
	}
	
	
}
