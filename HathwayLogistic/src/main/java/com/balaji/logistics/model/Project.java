package com.balaji.logistics.model;

import java.math.BigDecimal;
//Plain POJO class
public class Project {

	private int projectId;
	private String projectName;
	private String projectOwner;
	private BigDecimal projectDuration;
	private int projectCost;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Project(int projectId, String projectName, String projectOwner, BigDecimal projectDuration,
			int projectCost) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectOwner = projectOwner;
		this.projectDuration = projectDuration;
		this.projectCost = projectCost;
	}




	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectOwner() {
		return projectOwner;
	}
	public void setProjectOwner(String projectOwner) {
		this.projectOwner = projectOwner;
	}
	public BigDecimal getProjectDuration() {
		return projectDuration;
	}
	public void setProjectDuration(BigDecimal projectDuration) {
		this.projectDuration = projectDuration;
	}
	public int getProjectCost() {
		return projectCost;
	}
	public void setProjectCost(int projectCost) {
		this.projectCost = projectCost;
	}
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectOwner=" + projectOwner
				+ ", projectDuration=" + projectDuration + ", projectCost=" + projectCost + "]";
	}
	
	
	
}
