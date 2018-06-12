package diary.model.vo;

import java.sql.Date;

public class Diary {
	private int diaryNum;
	private String diaryContent;
	private String diaryWriter;
	private Date diaryDate;
	
	public Diary() {}
	
	
	
	public Diary(int diaryNum, String diaryContent, String diaryWriter, Date diaryDate) {
		super();
		this.diaryNum = diaryNum;
		this.diaryContent = diaryContent;
		this.diaryWriter = diaryWriter;
		this.diaryDate = diaryDate;
	}


	public int getDiaryNum() {
		return diaryNum;
	}
	public void setDiaryNum(int diaryNum) {
		this.diaryNum = diaryNum;
	}
	public String getDiaryContent() {
		return diaryContent;
	}
	public void setDiaryContent(String diaryContent) {
		this.diaryContent = diaryContent;
	}
	public String getDiaryWriter() {
		return diaryWriter;
	}
	public void setDiaryWriter(String diaryWriter) {
		this.diaryWriter = diaryWriter;
	}
	public Date getDiaryDate() {
		return diaryDate;
	}
	public void setDiaryDate(Date diaryDate) {
		this.diaryDate = diaryDate;
	}

	@Override
	public String toString() {
		return "Diary [diaryNum=" + diaryNum + ", diaryContent=" + diaryContent + ", diaryWriter=" + diaryWriter
				+ ", diaryDate=" + diaryDate + "]";
	}
	

}
