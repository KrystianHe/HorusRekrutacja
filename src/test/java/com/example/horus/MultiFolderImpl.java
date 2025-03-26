package com.example.horus;

import java.util.List;

/**
 * Implementacja testowa interfejsu MultiFolder.
 * Reprezentuje folder, który może zawierać inne foldery.
 */
public class MultiFolderImpl implements MultiFolder {
    private final String name;
    private final String size;
    private final List<Folder> folders;

    public MultiFolderImpl(String name, String size, List<Folder> folders) {
        this.name = name;
        this.size = size;
        this.folders = folders;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public List<Folder> getFolders() {
        return folders;
    }
} 