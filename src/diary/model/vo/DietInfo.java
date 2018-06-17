package diary.model.vo;

import java.sql.Date;

public class DietInfo {
	private String memberId;
	private int height;
	private int weight;
	private int purposeWeight;
	private Date objectiveDate;
	private Date dietDate;
	
	public DietInfo() {}

	public DietInfo(String memberId, int height, int weight, int purposeWeight, Date objectiveDate, Date dietDate) {
		super();
		this.memberId = memberId;
		this.height = height;
		this.weight = weight;
		this.purposeWeight = purposeWeight;
		this.objectiveDate = objectiveDate;
		this.dietDate = dietDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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

	public int getPurposeWeight() {
		return purposeWeight;
	}

	public void setPurposeWeight(int purposeWeight) {
		this.purposeWeight = purposeWeight;
	}

	public Date getObjectiveDate() {
		return objectiveDate;
	}

	public void setObjectiveDate(Date objectiveDate) {
		this.objectiveDate = objectiveDate;
	}

	public Date getDietDate() {
		return dietDate;
	}

	public void setDietDate(Date dietDate) {
		this.dietDate = dietDate;
	}

	@Override
	public String toString() {
		return "DietInfo [memberId=" + memberId + ", height=" + height + ", weight=" + weight + ", purposeWeight="
				+ purposeWeight + ", objectiveDate=" + objectiveDate + ", dietDate=" + dietDate + "]";
	}

	
	
	
}
