package board.model.vo;

import java.sql.Date;

public class BoardFreeComment {
	private int commentNum;
	private int commentLev;
	private int freeBoardNum;
	private String freeBoardWrite;
	private String commentContent;
	private int parentId;
	private Date commentDate;
	
	public BoardFreeComment() {
	}

	public BoardFreeComment(int commentNum, int commentLev, int freeBoardNum, String freeBoardWrite,
			String commentContent, int parentId, Date commentDate) {
		super();
		this.commentNum = commentNum;
		this.commentLev = commentLev;
		this.freeBoardNum = freeBoardNum;
		this.freeBoardWrite = freeBoardWrite;
		this.commentContent = commentContent;
		this.parentId = parentId;
		this.commentDate = commentDate;
	}


	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public int getCommentLev() {
		return commentLev;
	}

	public void setCommentLev(int commentLev) {
		this.commentLev = commentLev;
	}

	public int getFreeBoardNum() {
		return freeBoardNum;
	}

	public void setFreeBoardNum(int freeBoardNum) {
		this.freeBoardNum = freeBoardNum;
	}

	public String getFreeBoardWrite() {
		return freeBoardWrite;
	}

	public void setFreeBoardWrite(String freeBoardWrite) {
		this.freeBoardWrite = freeBoardWrite;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "BoardFreeComment [commentNum=" + commentNum + ", commentLev=" + commentLev + ", freeBoardNum="
				+ freeBoardNum + ", freeBoardWrite=" + freeBoardWrite + ", commentContent=" + commentContent
				+ ", parentId=" + parentId + "]";
	}
	
}
