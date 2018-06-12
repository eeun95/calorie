package board.model.vo;

import java.sql.Date;

public class BoardFree {

	private int fb_num;
	private String fb_title;
	private String fb_content;
	private String fb_id;
	private Date fb_date;
	private int fb_count;
	
	public BoardFree() {}
	
	
	public BoardFree(int fb_num, String fb_title, String fb_content, String fb_id, Date fb_date, int fb_count) {
		this.fb_num = fb_num;
		this.fb_title = fb_title;
		this.fb_content = fb_content;
		this.fb_id = fb_id;
		this.fb_date = fb_date;
		this.fb_count = fb_count;
	}

	public int getFb_num() {
		return fb_num;
	}


	public void setFb_num(int fb_num) {
		this.fb_num = fb_num;
	}


	public String getFb_title() {
		return fb_title;
	}


	public void setFb_title(String fb_title) {
		this.fb_title = fb_title;
	}


	public String getFb_content() {
		return fb_content;
	}


	public void setFb_content(String fb_content) {
		this.fb_content = fb_content;
	}


	public String getFb_id() {
		return fb_id;
	}


	public void setFb_id(String fb_id) {
		this.fb_id = fb_id;
	}


	public Date getFb_date() {
		return fb_date;
	}


	public void setFb_date(Date fb_date) {
		this.fb_date = fb_date;
	}


	public int getFb_count() {
		return fb_count;
	}


	public void setFb_count(int fb_count) {
		this.fb_count = fb_count;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Board [no=" + fb_num + ", title=" + fb_title + ", content=" + fb_content + ", id=" + fb_id + ", date=" + fb_date + ", count= "+fb_count+"]";
	}
		
}
