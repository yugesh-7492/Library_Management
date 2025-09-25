
import Entity.Library;
import Entity.Book;
import Entity.User;
import java.util.Scanner;

public class Librarymanagement {

    public static void main(String[] args) {

//        Library l=new Library();

         Scanner sc = new Scanner(System.in);

        Library library = new Library();




        while (true) {
            System.out.println("\n1. Show Books\n2. Show Users\n3. Issue Book\n4. Return Book \n5. add book \n6. add user\n7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> library.showbooks();
                case 2 -> library.showUser();
                case 3 -> {
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    library.isissue(bookId,userId);

                }
                case 4 -> {
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    library.returnBook(userId,bookId);
                }
                case 7-> {
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                }
                case 5-> {
                    System.out.print("enter the book id :");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.print("enter the book tittle :");
                    String tittle=sc.nextLine();
                    System.out.print("enter the book author :");
                    String author=sc.nextLine();

                    library.addBook(new Book(id, tittle, author));
                          }

                case 6-> {
                    System.out.print("enter the user id :");
                    int id1=sc.nextInt();
                    sc.nextLine();
                    System.out.print("enter the user name");
                    String name1=sc.nextLine();
                    library.addUser(new User(id1, name1));
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }


}