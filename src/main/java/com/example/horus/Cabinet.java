package com.example.horus;

import java.util.List;
import java.util.Optional;

/**
 * Interfejs definiujący główne operacje na systemie zarządzania folderami.
 */
interface Cabinet {
    /**
     * Wyszukuje folder o podanej nazwie.
     * @param name nazwa szukanego folderu
     * @return Optional zawierający znaleziony folder lub pusty
     */
    Optional<Folder> findFolderByName(String name);

    /**
     * Wyszukuje wszystkie foldery o podanym rozmiarze.
     * @param size rozmiar folderów (SMALL/MEDIUM/LARGE)
     * @return Lista folderów o podanym rozmiarze
     */
    List<Folder> findFoldersBySize(String size);

    /**
     * Zlicza wszystkie foldery w strukturze.
     * @return liczba wszystkich folderów
     */
    int count();
} 