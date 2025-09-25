package Entity;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book>books;
    private List<User>users;

    public Library(){

        books=new ArrayList<>();
        users=new ArrayList<>();


    }

    public void addBook(Book book){

        books.add(book);
    }

    public void addUser(User user){

        users.add(user);
    }

    // is issue

    public void isissue(int bookId,int userId){

        Book book=findBookById(bookId);
        User user=findUserById(userId);

        if(user==null){
            System.out.print("user not found");
            return;
        }

        if(book==null){
            System.out.print("book not found");
            return;
        }

        if(book.isIssued()){
            System.out.print("book is already issued ");
            return;
        }

        book.setIssued(true);
        user.borrowBook(book);

        System.out.print("book has been issue sucessfull");

    }

    // reeturn the book

    public void returnBook(int UserId,int BookId){

        Book book=findBookById(BookId);
        User user=findUserById(UserId);

        if (book == null || user == null) {
            System.out.println("Book or User not found.");
            return;
        }

        if(user.getBorrowedBooks().contains(book)){
            book.setIssued(false);
            user.returnBook(book);
        }else{
            System.out.print("user did not borrow the book");
        }

    }

    // helper method  --->  verry important


    public Book findBookById(int bookId){

        for(Book b:books){

            if(b.getId()==bookId){
                return b;
            }
        }
        return null;
    }

    public User findUserById(int UserId){

        for(User u:users){
            if(u.getId()==UserId){
                return u;
            }
        }
        return null;
    }

    /// / show all the user
    ///
    public void showUser(){

        if(users.isEmpty()){

            System.out.print("no user present");
        }else {
            for (User u : users) {
                System.out.println(u);
            }
        }

    }

    /// / show all the books

    public void showbooks(){

        if(books.isEmpty()){

            System.out.print("no books found");
        }else{
            for(Book b:books){
                System.out.println(b);
            }
        }
    }
}