import enums.Gender;
import enums.Genre;
import enums.Language;
import model.Book;
import model.User;
import service.ServiceClasses.ServiceBookImppl;
import service.ServiceClasses.ServiceUserImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Бардык Id лер уникальный болуш керек. Эгер уникальный болбосо озубуз тузгон UniqueConstraintException класс ыргытсын.
        // User дин email адресси уникальный болуш керек жана @ болуусу керек. Эгер уникальный болбосо UniqueConstraintException класс,
        // @ болбосо озубуз тузгон BadRequestException класс ыргытсын.
        // User дин телефон номери +996 дан башталып 13 символдон турсун. Болбосо BadRequestException класс ыргытсын.
        // Китептин баасы терс сан болбошу керек. Болбосо NegativeNumberException ыргытсын.
        // Китептин чыккан жылы келечек убакыт болбошу керек.Болбосо DateTimeException ыргытсын.
        // Китептин автору бош болбошу керек. Болбосо EmptyStackException ыргытсын.


        Book book = new Book(1L,"Titanic", Genre.ROMANCE, BigDecimal.valueOf(3000),"James Caroon", Language.ENGLISH, LocalDate.of(2012,11,12));
        Book book1 = new Book(2L,"Deadpool", Genre.FANTASY, BigDecimal.valueOf(2000),"John Marry", Language.ENGLISH, LocalDate.of(2018,8,11));
        Book book2 = new Book(3L,"Troia", Genre.HISTORICAL, BigDecimal.valueOf(3500),"Jonathan Lames", Language.ENGLISH, LocalDate.of(2008,2,10));
        Book book3 = new Book(4L,"Jamilia", Genre.ROMANCE, BigDecimal.valueOf(2500),"Chyngyz Aitmatov", Language.KYRGYZ, LocalDate.of(2003,13,12));
        Book book4 = new Book(5L,"Mafia", Genre.DETECTIVE, BigDecimal.valueOf(4000),"Andrei Petrov", Language.RUSSIAN, LocalDate.of(2017,9,23));
        Book book5 = new Book(6L,"Voina i mir", Genre.HISTORICAL, BigDecimal.valueOf(3200),"Lev Tolstoi", Language.RUSSIAN, LocalDate.of(2019,12,6));
        Book book6 = new Book(7L,"Erte kelgen turnalar", Genre.HISTORICAL, BigDecimal.valueOf(2800),"Chyngyz Aitmatov", Language.KYRGYZ, LocalDate.of(2012,2,24));
        Book book7 = new Book(8L,"Delbirim", Genre.HISTORICAL, BigDecimal.valueOf(3200),"Chyngyz Aitmatov", Language.KYRGYZ, LocalDate.of(2010,5,13));
        Book book8 = new Book(9L,"300 Spatrns", Genre.FANTASY, BigDecimal.valueOf(4000),"Robert John", Language.ENGLISH, LocalDate.of(2020,4,24));
        Book book9 = new Book(10L,"Killer", Genre.DETECTIVE, BigDecimal.valueOf(2800),"Sergei Romanov", Language.RUSSIAN, LocalDate.of(2012,23,12));
        ArrayList<Book>arrayListBook = new ArrayList<>(
                Arrays.asList(book1,book2,book3,book,book4,book5,book6,book7,book9,book8)
        );

        User user = new User(11L," Asan","Samatov","@samatov.12","996778455332", Gender.MALE,BigDecimal.valueOf(5000), arrayListBook);
        User user1 = new User(12L," Kanat","Kanatov","@kanatov.12","9967784553456", Gender.MALE,BigDecimal.valueOf(10000), arrayListBook);
        User user2 = new User(13L," Asel","Samatova","@samatova.12","996778455345", Gender.FEMALE,BigDecimal.valueOf(15000), arrayListBook);
        User user3 = new User(14L," Aijan","Akylova","@akylova.12","996775455332", Gender.FEMALE,BigDecimal.valueOf(50000), arrayListBook);
        User user4 = new User(15L," Samat","Aktanov","@samat.12","996779455332", Gender.MALE,BigDecimal.valueOf(25000), arrayListBook);
        ArrayList<User>userArrayList = new ArrayList<>(
                Arrays.asList(user1,user2,user,user4,user3)
        );

        ServiceUserImpl serviceUser = new ServiceUserImpl();
        System.out.println(serviceUser.createUser(userArrayList));
        System.out.println(serviceUser.findAllUsers());
        System.out.println("Write the user ID");
        long num = new Scanner(System.in).nextLong();
        System.out.println(serviceUser.findUserById(num));
        System.out.println("Write user name : ");
        String n = new Scanner(System.in).nextLine();
        System.out.println(serviceUser.removeUserByName(n));
        serviceUser.groupUsersByGender();
        System.out.println("Write the user name : ");
        String nam = new Scanner(System.in).nextLine();
        System.out.println(serviceUser.buyBooks(nam, arrayListBook));

        System.out.println("--------------------------------");

        ServiceBookImppl bookImppl = new ServiceBookImppl();
        System.out.println(bookImppl.createBooks(arrayListBook));
        System.out.println(bookImppl.getAllBooks());
        System.out.println("Write the genre : ");
        String na = new Scanner(System.in).nextLine();
        System.out.println(bookImppl.getBooksByGenre(na));
        System.out.println(bookImppl.maxPriceBook());
        System.out.println("Write the book ID");
        long num1 = new Scanner(System.in).nextLong();
        System.out.println(bookImppl.removeBookById(num1));
        System.out.println(bookImppl.sortBooksByPriceInDescendingOrder());
        System.out.println(bookImppl.getBookByInitialLetter());
    }
}