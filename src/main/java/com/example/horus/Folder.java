package com.example.horus;

/**
 * Interfejs reprezentujący podstawowy folder w systemie.
 * Każdy folder posiada nazwę oraz rozmiar.
 */
interface Folder {
    /**
     * @return nazwa folderu
     */
    String getName();

    /**
     * @return rozmiar folderu (SMALL/MEDIUM/LARGE)
     */
    String getSize();
} 