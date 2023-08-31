package Module_2_3;


import java.util.ArrayList;


class LibraryWithUsers {

}


class User {
    private final String name;
    private final int age;
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}


public class LibraryUsers {
    public static void main(String[] args) {

    }
}
