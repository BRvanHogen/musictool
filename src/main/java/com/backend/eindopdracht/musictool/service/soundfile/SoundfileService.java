package com.backend.eindopdracht.musictool.service.soundfile;

import com.backend.eindopdracht.musictool.model.Soundfile;

import java.util.Collection;

public interface SoundfileService {

    public abstract Collection<Soundfile> getSoundfiles();
}
