package com.backend.eindopdracht.musictool.repository;

import com.backend.eindopdracht.musictool.model.Soundfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoundfileRepository extends JpaRepository <Soundfile, Long> {
}
