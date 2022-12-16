package service.ServiceClasses;

import enums.Gender;
import model.Book;
import model.User;
import service.UserService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceUserImpl implements UserService {
    List<User>userList = new ArrayList<>();
    @Override
    public String createUser(List<User> users) {
        this.userList.addAll(users);
        return "Create user ";
    }

    @Override
    public List<User> findAllUsers() {
        return userList;
    }

    @Override
    public String findUserById(Long id) {
        System.out.println("Write id ");
        long name = new Scanner(System.in).nextLong();
        userList.stream().filter(s->s.getId().equals(name)).forEach(System.out::println);
        return "Find User ";
    }

    @Override
    public String removeUserByName(String name) {
        System.out.println("Write the user name : ");
        String name1 = new Scanner(System.in).nextLine();
        for (User e : userList) {
            if (name1.equals(e.getName())) {
                userList.remove(e);
                System.out.println(e);
            }

        }  return "Remove user";
    }

    @Override
    public void updateUser(Long id) {

    }

    @Override
    public void groupUsersByGender() {
        System.out.println("Male group :");
        userList.stream().filter(s->s.getGender().equals(Gender.MALE)).toList().forEach(System.out::println);
        System.out.println("Female group : ");
        userList.stream().filter(s->s.getGender().equals(Gender.FEMALE)).toList().forEach(System.out::println);

    }

    @Override
    public String buyBooks(String name, List<Book> books) {
        System.out.println("Write the book name : ");
        String bookName = new Scanner(System.in).nextLine();
        for (Book b:books) {
            for (User u:userList) {
                if(name.equals(u.getName())) {
                    if (bookName.equals(b.getName())) {
                        u.getBooks().add(b);
                    }
                }
            }
        }

      return "Successfully buy !";
    }
}
