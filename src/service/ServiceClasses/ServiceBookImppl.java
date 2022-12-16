package service.ServiceClasses;

import model.Book;
import service.BookService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ServiceBookImppl implements BookService {
    List<Book>bookList = new ArrayList<>();
    @Override
    public List<Book> createBooks(List<Book> books) {
        this.bookList.addAll(books);
        return books;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookList;
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        bookList.stream().filter(s->s.getGenre().equals(genre.toUpperCase())).forEach(System.out::println);
        return bookList;
    }

    @Override
    public Book removeBookById(Long id) {
        System.out.println("Write the employee name : ");
        Long name = new Scanner(System.in).nextLong();
        for (Book  e: bookList) {
            if(name.equals(e.getId())){
                bookList.remove(e);

            }
        }return null;

    }

    @Override
    public List<Book> sortBooksByPriceInDescendingOrder() {
        bookList.stream().sorted((o1, o2) -> o2.getPrice().compareTo(o1.getPrice())).forEach(System.out::println);
        return bookList;
    }

    @Override
    public List<Book> filterBooksByPublishedYear() {
        return null;
    }

    @Override
    public List<Book> getBookByInitialLetter()
    {
        System.out.println("Write the letter");
        String c = new Scanner(System.in).nextLine();
        bookList.stream().filter(s->s.getName().startsWith(c.toUpperCase())).forEach(System.out::println);
        return bookList;
    }

    @Override
    public Book maxPriceBook() {

        return bookList.stream().max(Comparator.comparing(Book::getPrice)).orElseThrow();
    }
}
