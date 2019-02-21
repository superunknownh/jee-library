package jeelibrary.interfaces;

import jeelibrary.models.Borrow;

public interface IBorrowService {
    void add(Borrow borrow);
    Borrow[] list();
    Borrow get(int bookId);
    void update(Borrow borrow);
    void delete(int bookId);
}
