package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LibraryTest {

    @org.junit.jupiter.api.Test
    @DisplayName("preCondition Test")
    void preConditionTest() {
//        try {
//            new Library(-1);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Library(-1));
    }

    @ParameterizedTest
    @DisplayName("Library consturtor Test")
    @ValueSource(ints = {1, 10, 100, 1000})
    void libraryTEst(int size) {
        Library library = new Library(size);
        Assertions.assertEquals(size, library.getLibrary());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Library add() test")
    void addTest() {
        Library library = new Library(1);
        library.add("book 1");

        Assertions.assertEquals(1, library.getCount());
    }


    @org.junit.jupiter.api.Test
    @DisplayName("Library 꽉 찬 경우 테스트")
    void fulllibrary() {
        Library library = new Library(1);
        library.add("book1");

        Assertions.assertThrows(IllegalArgumentException.class, () -> library.add("book2"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Library 책이 중복된 경우")
    void sameNameLibrary() {
        Library library = new Library(2);
        library.add("java1");

        Assertions.assertThrows(IllegalArgumentException.class, () -> library.add("java1"));
    }


    @org.junit.jupiter.api.Test
    @DisplayName("Library delete Test")
    void libraryDelteTest() {
        Library library = new Library(1);
        library.add("java1");
        library.delete("java1");

        Assertions.assertEquals(0, library.getCount());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Library empty delete")
    void libraryEmptyDelete() {
        Library library = new Library(1);
        library.add("java1");
        library.delete("java1");

        Assertions.assertThrows(IllegalArgumentException.class, () -> library.delete("java1"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Library missingbook delete")
    void missingBookDelete() {
        Library library = new Library(1);
        library.add("java1");

        Assertions.assertThrows(IllegalArgumentException.class, () -> library.delete("java2"));
    }


}
