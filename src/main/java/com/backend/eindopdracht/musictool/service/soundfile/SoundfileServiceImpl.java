package com.backend.eindopdracht.musictool.service.soundfile;

import com.backend.eindopdracht.musictool.model.Soundfile;
import com.backend.eindopdracht.musictool.repository.SoundfileRepository;
import com.backend.eindopdracht.musictool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SoundfileServiceImpl implements SoundfileService {

    @Autowired
    private SoundfileRepository soundfileRepository;

    @Override
    public Collection<Soundfile> getSoundfiles() {
        return soundfileRepository.findAll();
    }
}
