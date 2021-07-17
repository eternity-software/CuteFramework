package ru.etysoft.cuteframework.requests.attachements;


import com.sun.istack.internal.NotNull;

import java.io.File;

public class ImageFile extends File {

    public ImageFile(@NotNull String pathname) {
        super(pathname);
    }

}
