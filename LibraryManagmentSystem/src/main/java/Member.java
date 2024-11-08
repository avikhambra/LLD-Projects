import java.util.ArrayList;
import java.util.List;

class Member {
    private String name;
    private int memberID;
    private List<Book> booksBorrowed;

    public Member(String name, int memberID) {
        this.name = name;
        this.memberID = memberID;
        this.booksBorrowed = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.checkoutBook();
            booksBorrowed.add(book);
        } else {
            System.out.println("The book is not available for checkout.");
        }
    }

    public void returnBook(Book book) {
        if (booksBorrowed.contains(book)) {
            book.returnBook();
            booksBorrowed.remove(book);
        } else {
            System.out.println("This book is not borrowed by this member.");
        }
    }
}
