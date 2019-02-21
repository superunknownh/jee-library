package jeelibrary.services;

import java.util.ArrayList;
import jeelibrary.interfaces.IBookService;
import jeelibrary.models.Book;

public class MemoryBookService implements IBookService {

    private MemoryBookService() {
    }

    public static MemoryBookService getInstance() {
        if (instance == null) {
            instance = new MemoryBookService();
        }
        return instance;
    }

    @Override
    public void add(Book book) {
        DATABASE.add(book);
    }

    @Override
    public Book[] list() {
        Book[] books = new Book[DATABASE.size()];
        for (int i = 0; i < DATABASE.size(); i++) {
            books[i] = DATABASE.get(i);
        }
        return books;
    }

    @Override
    public Book get(int id) {
        for (int i = 0; i < DATABASE.size(); i++) {
            if (DATABASE.get(i).getId() == id) {
                return DATABASE.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(Book book) {
        for (int i = 0; i < DATABASE.size(); i++) {
            if (DATABASE.get(i).getId() == book.getId()) {
                DATABASE.get(i).setTitle(book.getTitle());
                DATABASE.get(i).setAuthor(book.getAuthor());
                DATABASE.get(i).setISBN(book.getISBN());
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < DATABASE.size(); i++) {
            if (DATABASE.get(i).getId() == id) {
                DATABASE.remove(i);
            }
        }
    }
    
    private static final ArrayList<Book> DATABASE = new ArrayList<>();
    private static MemoryBookService instance;
 }
