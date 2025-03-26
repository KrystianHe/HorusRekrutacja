package com.example.horus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Klasa testowa dla FolderCabinet.
 */
class FolderCabinetTest {
    private FolderCabinet cabinet;
    private SimpleFolder folder1;
    private SimpleFolder folder2;
    private MultiFolderImpl multiFolder;

    @BeforeEach
    void setUp() {
        folder1 = new SimpleFolder("Dokumenty", "LARGE");
        folder2 = new SimpleFolder("Zdjęcia", "MEDIUM");
        
        SimpleFolder nestedFolder1 = new SimpleFolder("Wakacje", "SMALL");
        SimpleFolder nestedFolder2 = new SimpleFolder("Praca", "MEDIUM");
        
        multiFolder = new MultiFolderImpl("Archiwum", "LARGE", 
            Arrays.asList(nestedFolder1, nestedFolder2));
        
        cabinet = new FolderCabinet(Arrays.asList(folder1, folder2, multiFolder));
    }

    @Test
    void testFindMainFolder() {
        Optional<Folder> result = cabinet.findFolderByName("Dokumenty");
        assertTrue(result.isPresent());
        assertEquals("Dokumenty", result.get().getName());
    }

    @Test
    void testFindNestedFolder() {
        Optional<Folder> result = cabinet.findFolderByName("Wakacje");
        assertTrue(result.isPresent());
        assertEquals("Wakacje", result.get().getName());
    }

    @Test
    void testFindNonExistingFolder() {
        Optional<Folder> result = cabinet.findFolderByName("Brak");
        assertFalse(result.isPresent());
    }

    @Test
    void testFindBySize() {
        List<Folder> mediumFolders = cabinet.findFoldersBySize("MEDIUM");
        assertEquals(2, mediumFolders.size());
        assertTrue(mediumFolders.stream()
            .allMatch(f -> f.getSize().equals("MEDIUM")));
    }

    @Test
    void testCount() {
        assertEquals(5, cabinet.count());
    }
}
