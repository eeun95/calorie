package calendar.model.vo;

import java.sql.Date;

public class DietInfo {
	private String member_id;
	private int height;
	private int weight;
	private int purpose_weight;
	private int objective_date;
	private Date diet_date;
	
	public DietInfo() {}

	public DietInfo(String member_id, int height, int weight, int purpose_weight, int objective_date, Date diet_date) {
		super();
		this.member_id = member_id;
		this.height = height;
		this.weight = weight;
		this.purpose_weight = purpose_weight;
		this.objective_date = objective_date;
		this.diet_date = diet_date;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getPurpose_weight() {
		return purpose_weight;
	}

	public void setPurpose_weight(int purpose_weight) {
		this.purpose_weight = purpose_weight;
	}

	public int getObjective_date() {
		return objective_date;
	}

	public void setObjective_date(int objective_date) {
		this.objective_date = objective_date;
	}

	public Date getDiet_date() {
		return diet_date;
	}

	public void setDiet_date(Date diet_date) {
		this.diet_date = diet_date;
	}

	@Override
	public String toString() {
		return "DietInfo [member_id=" + member_id + ", height=" + height + ", weight=" + weight + ", purpose_weight="
				+ purpose_weight + ", objective_date=" + objective_date + ", diet_date=" + diet_date + "]";
	}
	
	 
	
}

