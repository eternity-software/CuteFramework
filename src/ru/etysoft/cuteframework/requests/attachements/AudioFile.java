package ru.etysoft.cuteframework.requests.attachements;

import org.jetbrains.annotations.NotNull;

import java.io.File;

public class AudioFile extends File {

    public AudioFile(@NotNull String pathname) {
        super(pathname);
    }

}