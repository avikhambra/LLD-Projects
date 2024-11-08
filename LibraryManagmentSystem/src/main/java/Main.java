public class Main {
    public static void main(String[] args) {
        // Creating a library
        Library library = new Library("City Library", "123 Main St");

        // Adding books to the library
        Book book1 = new Book("Java Programming", "John Doe", "123467890");
        Book book2 = new Book("Python Programming", "Jane Smith", "0987654329");
        Book book3 = new Book("C+ Programming", "Monu", "098654321");
        Book book4 = new Book("HTML Programming", "Ravi Sk", "0987654322");
        Book book5 = new Book("C++ Programming", "RK ", "09876543");
        Book book6 = new Book("JavaScript Programming", "D Marton", "054321");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);


        // Displaying all books in the library
        System.out.println("Display all books in Morning State  ->");
        library.displayBooks();


        System.out.println();

        // Creating a member
        Member member1 = new Member("Alice", 1);

        // Member borrowing a book
        member1.borrowBook(book1);
        library.removeBook(book1);

        member1.borrowBook(book5);
        library.removeBook(book5);

        // Displaying all books in the library after book is borrowed
        System.out.println("Display all books in Evening State  ->");
        library.displayBooks();

    }
}