package jeelibrary.interfaces;

import jeelibrary.models.Book;

public interface IBookService {
    void add(Book book);
    Book[] list();
    Book get(int id);
    void update(Book book);
    void delete(int id);
}
