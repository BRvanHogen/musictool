package com.backend.eindopdracht.musictool.repository;

import com.backend.eindopdracht.musictool.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, String> {
}
