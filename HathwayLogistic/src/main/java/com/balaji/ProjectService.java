package com.balaji;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balaji.logistics.dao.ProjectDAO;
import com.balaji.logistics.entities.ProjectEntity;
import com.balaji.logistics.model.Logistics;
import com.balaji.logistics.model.Project;

@Service
public class ProjectService {

	@Autowired
	ProjectDAO projectDAO;

	public boolean saveProject(Project project){
		
		ProjectEntity projEntity = new ProjectEntity();
		
		projEntity.setProjectId(project.getProjectId());
		projEntity.setProjectName(project.getProjectName());
		projEntity.setProjectOwner(project.getProjectOwner());
		projEntity.setProjectDuration(project.getProjectDuration());
		projEntity.setProjectCost(project.getProjectCost());
		
		projectDAO.saveProject(projEntity);
		
		return true;
	}
	
	public boolean deleteProject(int projectId){
		
		return true;
	}
	
	public Project getProject(int projectId){
		return null;
	}
		
	public List<Project> getAllProjects(){
		return null;
	}	
}
