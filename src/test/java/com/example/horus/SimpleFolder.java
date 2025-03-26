package com.example.horus;

/**
 * Podstawowa implementacja interfejsu Folder do uzywania podczas testów
 * Reprezentuje folder
 */
public class SimpleFolder implements Folder {
    private final String name;
    private final String size;

    public SimpleFolder(String name, String size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSize() {
        return size;
    }
} 