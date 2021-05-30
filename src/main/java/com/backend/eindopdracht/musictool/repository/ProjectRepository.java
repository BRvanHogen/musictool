package com.backend.eindopdracht.musictool.repository;


import com.backend.eindopdracht.musictool.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository <Project, String> {  //of moet ik hier de ID (dus long) opgeven?
}
