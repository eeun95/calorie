package calendar.model.vo;

import java.sql.Date;

public class Calendar {
	private int calendar_num;
	private int member_num;
	private String title;
	private Date start;
	private Date end;
	private int diet_food_num;
	private int exercise_num;
	
	public Calendar() {}
	
	public Calendar(int calendar_num, int member_num, String title, Date start, Date end, int diet_food_num,
			int exercise_num) {
		super();
		this.calendar_num = calendar_num;
		this.member_num = member_num;
		this.title = title;
		this.start = start;
		this.end = end;
		this.diet_food_num = diet_food_num;
		this.exercise_num = exercise_num;
	}
	public int getCalendar_num() {
		return calendar_num;
	}
	public void setCalendar_num(int calendar_num) {
		this.calendar_num = calendar_num;
	}
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public int getDiet_food_num() {
		return diet_food_num;
	}
	public void setDiet_food_num(int diet_food_num) {
		this.diet_food_num = diet_food_num;
	}
	public int getExercise_num() {
		return exercise_num;
	}
	public void setExercise_num(int exercise_num) {
		this.exercise_num = exercise_num;
	}

	@Override
	public String toString() {
		return "Calendar [calendar_num=" + calendar_num + ", member_num=" + member_num + ", title=" + title + ", start="
				+ start + ", end=" + end + ", diet_food_num=" + diet_food_num + ", exercise_num=" + exercise_num + "]";
	}
	
}
