package com.balaji.logistics.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.balaji.logistics.entities.ProjectEntity;

@Repository
public class ProjectDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean saveProject(ProjectEntity project){
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(project);
		
		return true;
	}
	
	public boolean deleteProject(int projectId){
		
		return true;
	}
	
	public ProjectEntity getProject(int projectId){
		return null;
	}
		
	public List<ProjectEntity> getAllProjects(){
		return null;
	}	
	
}
