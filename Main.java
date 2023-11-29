import javax.naming.Name;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Stream<User> userList = Stream.of(new User(1, "Oliver", 15), new User(2, "Jack", 20),
                new User(3, "Harry", 30), new User(4, "Jacob", 25), new User(5, "Charley", 13),
                new User(6, "Thomas", 18), new User(7, "George", 23), new User(8, "Oscar", 45),
                new User(9, "Ariella", 19), new User(10, "Jasmine", 23));
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        switch (a)
        {
            //Все пользователи
            case 1:
                userList.map(p->"Id:" + p.getId() + " Имя: " + p.getName() + " Возраст: " + p.getAge())
                        .forEach(p -> System.out.println(p));
                break;
            //По Id
            case 2:
                int id = in.nextInt();
                userList.
                        filter(p -> p.getId() == id)
                        .map(p->  "Имя: " + p.getName() + " Возраст: " + p.getAge())
                        .forEach(p->System.out.println(p));
                break;
            //добавление
            case 3:
                int iD = in.nextInt();
                String name = in.next();
                int age = in.nextInt();
                Stream<User> newUserList = Stream.of(new User(iD, name, age));
                Stream.concat(userList, newUserList).
                        map(p->"Id:" + p.getId() + " Имя: " + p.getName() + " Возраст: " + p.getAge()).
                        forEach(n -> System.out.println(n));
                break;

            //Редактирование
            case 4:
            break;
            //удаление
            case 5:
//                int i = in.nextInt();
//                userList.remove(i);
//                break;
            //Только возраст и имя
            case 6:
                userList.
                        map(p-> "Имя: " + p.getName() + " Возраст: " + p.getAge())
                        .forEach(s->System.out.println(s));
                break;
            //Сортировка по длине имени
            case 7:
                userList.
                        map(p-> "Имя: " + p.getName().length() + " Возраст: " + p.getAge()).sorted()
                        .forEach(s->System.out.println(s));
                break;
            //Минимальный возраст
            case 8:
                System.out.println(userList
                        .mapToInt(User::getAge)
                        .min().getAsInt());
                break;
            //Максимальный возраст
            case 9:
                System.out.println(userList
                        .mapToInt(User::getAge)
                        .max().getAsInt());
                break;
            //Проверка на букву
            case 10:
                String letter = in.next();
                System.out.println(userList.anyMatch(p -> p.getName().startsWith(letter)));
                break;
            //12 задание
            case 11:
                userList.
                        filter(p -> p.getAge() > 18 && p.getAge() <= 25 && p.getId() % 3 == 0).
                        map(p -> p.getId() + " " + p.getName()).
                        forEach(s -> System.out.println(s));

        }
    }

}