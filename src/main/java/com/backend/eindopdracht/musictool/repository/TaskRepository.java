package com.backend.eindopdracht.musictool.repository;

import com.backend.eindopdracht.musictool.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TaskRepository extends JpaRepository <Task, Long> {

}
