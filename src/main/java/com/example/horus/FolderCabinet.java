package com.example.horus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implementacja systemu zarządzania folderami, który umożliwia przechowywanie
 * i wyszukiwanie folderów
 *
 * Rozmiary folderów są zdefiniowane jako: SMALL, MEDIUM, LARGE
 */
public class FolderCabinet implements Cabinet {
    private List<Folder> folders;

    /**
     * Tworzy nowy gabinet folderów.
     * @param folders lista folderów początkowych, może być null
     */
    public FolderCabinet(List<Folder> folders) {
        this.folders = folders != null ? folders : new ArrayList<>();
    }

    /**
     * Pomocnicza metoda zwracająca strumień wszystkich folderów
     * @return Strumień zwraca wszytskie dostepne foldery
     */
    private Stream<Folder> getAllFoldersStream() {
        return folders.stream()
            .flatMap(folder -> {
                if (folder instanceof MultiFolder) {
                    return Stream.concat(
                        Stream.of(folder),
                        ((MultiFolder) folder).getFolders().stream()
                    );
                }
                return Stream.of(folder);
            });
    }

    /**
     * Wyszukuje folder o podanej nazwie
     * @param name nazwa szukanego folderu
     * @return Optional zawierający znaleziony folder lub pusty
     */
    @Override
    public Optional<Folder> findFolderByName(String name) {
        if (name == null) {
            return Optional.empty();
        }
        return getAllFoldersStream()
            .filter(folder -> folder.getName().equals(name))
            .findFirst();
    }

    /**
     * Wyszukuje wszystkie foldery o podanym rozmiarze.
     * @param size rozmiar folderów (SMALL/MEDIUM/LARGE)
     * @return lista folderów o podanym rozmiarze
     */
    @Override
    public List<Folder> findFoldersBySize(String size) {
        if (size == null) {
            return new ArrayList<>();
        }
        return getAllFoldersStream()
            .filter(folder -> folder.getSize().equals(size))
            .collect(Collectors.toList());
    }

    /**
     * Zlicza wszystkie foldery
     * @return całkowita liczba folderów
     */
    @Override
    public int count() {
        return (int) getAllFoldersStream().count();
    }
} 
