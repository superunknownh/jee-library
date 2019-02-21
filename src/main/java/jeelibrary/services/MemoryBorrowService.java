package jeelibrary.services;

import java.util.ArrayList;
import jeelibrary.interfaces.IBorrowService;
import jeelibrary.models.Borrow;

public class MemoryBorrowService implements IBorrowService {

    private MemoryBorrowService() {
    }

    public static MemoryBorrowService getInstance() {
        if (instance == null) {
            instance = new MemoryBorrowService();
        }
        return instance;
    }

    @Override
    public void add(Borrow borrow) {
        DATABASE.add(borrow);
    }

    @Override
    public Borrow[] list() {
        Borrow[] borrows = new Borrow[DATABASE.size()];
        for (int i = 0; i < DATABASE.size(); i++) {
            borrows[i] = DATABASE.get(i);
        }
        return borrows;
    }

    @Override
    public Borrow get(int id) {
        for (int i = 0; i < DATABASE.size(); i++) {
            if (DATABASE.get(i).getId() == id) {
                return DATABASE.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(Borrow borrow) {
        for (int i = 0; i < DATABASE.size(); i++) {
            if (DATABASE.get(i).getId() == borrow.getId()) {
                DATABASE.get(i).setStudent(borrow.getStudent());
                DATABASE.get(i).setBook(borrow.getBook());
                DATABASE.get(i).setBorrowDate(borrow.getBorrowDate());
                DATABASE.get(i).setBorrowed(borrow.isBorrowed());
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
    
    private static final ArrayList<Borrow> DATABASE = new ArrayList<>();
    private static MemoryBorrowService instance;
 }
