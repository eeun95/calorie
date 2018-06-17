package calendar.model.vo;

import java.sql.Date;

public class Calendar {
	private String title;
	private String start;
	private String end;
	private String description;
	private String rendering;
	private String color;
	
	public Calendar() {}

	public Calendar(String title, String start, String end, String description, String rendering, String color) {
		super();
		this.title = title;
		this.start = start;
		this.end = end;
		this.description = description;
		this.rendering = rendering;
		this.color = color;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRendering() {
		return rendering;
	}

	public void setRendering(String rendering) {
		this.rendering = rendering;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Calendar [title=" + title + ", start=" + start + ", end=" + end + ", description=" + description
				+ ", rendering=" + rendering + ", color=" + color + "]";
	}

	
	
}
