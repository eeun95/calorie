package diary.model.vo;

import java.sql.Date;

public class Diary {
	private int diaryNum;
	private String diaryTitle;
	private String diaryContent;
	private Date diaryDate;
	
	public Diary() {}
	
	
	
	public Diary(int diaryNum, String diaryTitle, String diaryContent, Date diaryDate) {
		super();
		this.diaryNum = diaryNum;
		this.diaryTitle=diaryTitle;
		this.diaryContent = diaryContent;
		this.diaryDate = diaryDate;
	}


	public int getDiaryNum() {
		return diaryNum;
	}
	public void setDiaryNum(int diaryNum) {
		this.diaryNum = diaryNum;
	}
	public String getDiaryTitle() {
		return diaryTitle;
	}
	public void setDiaryTitle(String diaryTitle) {
		this.diaryTitle = diaryTitle;
	}
	public String getDiaryContent() {
		return diaryContent;
	}
	public void setDiaryContent(String diaryContent) {
		this.diaryContent = diaryContent;
	}
	public Date getDiaryDate() {
		return diaryDate;
	}
	public void setDiaryDate(Date diaryDate) {
		this.diaryDate = diaryDate;
	}



	@Override
	public String toString() {
		return "Diary [diaryNum=" + diaryNum + ", diaryTitle=" + diaryTitle + ", diaryContent=" + diaryContent
				+ ", diaryDate=" + diaryDate + "]";
	}

	

}
