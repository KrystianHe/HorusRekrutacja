package com.example.horus;

import java.util.List;

/**
 * Interfejs reprezentujący folder, który może zawierać inne foldery.
 * MultiFolder jest odpowiedzialny za przetrzymywanie kolekcji folderów
 */
interface MultiFolder extends Folder {
    /**
     * @return lista folderów zawartych w tym folderze
     */
    List<Folder> getFolders();
} 