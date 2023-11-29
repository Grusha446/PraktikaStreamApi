import javax.naming.Name;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<User> userList = new ArrayList<>();
        User[] users = {new User(1, "Oliver", 15), new User(2, "Jack", 20),
                new User(3, "Harry", 30), new User(4, "Jacob", 25), new User(5, "Charley", 13),
                new User(6, "Thomas", 18), new User(7, "George", 23), new User(8, "Oscar", 45),
                new User(9, "Ariella", 19), new User(10, "Jasmine", 23),};
        for (User user: users) {
            userList.add(user);
        }
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        switch (a)
        {
            //Все пользователи
            case 1:
                userList.stream().map(p->"Id:" + p.getId() + " Имя: " + p.getName() + " Возраст: " + p.getAge())
                        .forEach(p -> System.out.println(p));
                break;
            //По Id
            case 2:
                int id = in.nextInt();
                userList.stream().
                        filter(p -> p.getId() == id)
                        .map(p->  "Имя: " + p.getName() + " Возраст: " + p.getAge())
                        .forEach(p->System.out.println(p));
                break;
            //добавление
            case 3:
                int iD = in.nextInt();
                if (userList.stream().filter(p -> p.getId() == iD) != null)
                {
                    System.out.println("Так не работает");
                    break;
                }
                else
                {
                    String name = in.next();
                    int age = in.nextInt();
                    userList.add(new User(iD, name, age));
                    break;
                }

            //Редактирование
            case 4:
            break;
            //удаление
            case 5:
                int i = in.nextInt();
                userList.remove(i);
                break;
            //Только возраст и имя
            case 6:
                userList.stream().
                        map(p-> "Имя: " + p.getName() + " Возраст: " + p.getAge())
                        .forEach(s->System.out.println(s));
                break;
            //Сортировка по длине имени
            case 7:
                userList.stream().filter(p -> p.getName().length() < 12).
                        sorted().
                        map(p-> "Имя: " + p.getName() + " Возраст: " + p.getAge())
                        .forEach(s->System.out.println(s));
                break;
            //Минимальный возраст
            case 8:
                System.out.println(userList.stream()
                        .mapToInt(User::getAge)
                        .min().getAsInt());
                break;
            //Максимальный возраст
            case 9:
                System.out.println(userList.stream()
                        .mapToInt(User::getAge)
                        .max().getAsInt());
                break;
            //Проверка на букву
            case 10:
                String letter = in.next();
                System.out.println(userList.stream().anyMatch(p -> p.getName().startsWith(letter)));
                break;
            //12 задание
            case 11:
                userList.stream().
                        filter(p -> p.getAge() > 18 && p.getAge() <= 25 && p.getId() % 3 == 0).
                        map(p -> p.getId() + " " + p.getName()).
                        forEach(s -> System.out.println(s));

        }
    }

}