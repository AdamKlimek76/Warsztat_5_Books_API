package pl.coderslab.service;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemoryBookService {

    private static Long nextId = 4L;
    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking in Java", "Bruce Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kathy, Bates Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion",
                "programming"));
    }

    public List<Book> showAllBooks() {
        return list;
    }


    public Book showBookById(Long id) {
        List<Book> oneBook = list.stream()
                .filter(book -> book.getId().equals(id))
                .collect(Collectors.toList());
        return oneBook.get(0);
    }

    public void addBook(Book book) {
        book.setId(nextId);
        nextId++;
        list.add(book);
    }

    public void deleteBook(Long id){
        List<Book> result = list.stream()
                .filter(book -> !book.getId().equals(id))
                .collect(Collectors.toList());
        list=result;
    }

}
