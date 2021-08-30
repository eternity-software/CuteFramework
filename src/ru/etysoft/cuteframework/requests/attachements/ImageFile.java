package ru.etysoft.cuteframework.requests.attachements;


import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * Custom file type for simple data formatting
 */
public class ImageFile extends File {

    public ImageFile(@NotNull String pathname) {
        super(pathname);
    }

}
