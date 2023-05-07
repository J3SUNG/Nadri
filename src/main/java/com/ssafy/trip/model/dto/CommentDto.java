package com.ssafy.trip.model.dto;

public class CommentDto {
	private int commentNo;
	private String content;
	private String createTime;
	private int userNo;
	private int boardNo;
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getUesrNo() {
		return userNo;
	}
	public void setUesrNo(int uesrNo) {
		this.userNo = uesrNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	@Override
	public String toString() {
		return "CommentDto [commentNo=" + commentNo + ", content=" + content + ", createTime=" + createTime
				+ ", uesrNo=" + userNo + ", boardNo=" + boardNo + "]";
	}
}
