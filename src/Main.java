import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PhoneBook contacts = new PhoneBook();
        contacts.add("Владимир", 7775544);
        contacts.add("София", 4565543);
        contacts.add("София", 6845543);
        contacts.add("Иван", 1112233);
        contacts.add("Тимур", 9991234);
        contacts.add("Тимур", 8885544);
        contacts.add("Тимур", 5554455);
        contacts.add("Гена", 6546548);
        System.out.println(contacts.find("София"));
        System.out.println(contacts.getPhoneBook());
        contacts.printByTask();
    }
}