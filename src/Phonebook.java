import java.util.*;

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();
    public void add(String name, Integer phoneNum) {
        if (phoneBook.containsKey(name)) {
            ArrayList<Integer> list = phoneBook.get(name);
            list.add(phoneNum);
            System.out.println("Номер успешно добавлен!");
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(phoneNum);
            phoneBook.put(name, list);
            System.out.println("Новый контакт успешно добавлен!");
        }
    }

    public ArrayList<Integer> find(String name) {
        for (var item : phoneBook.entrySet()) {
            if (item.getKey().equals(name)) {
                return item.getValue();
            }
        }
        return new ArrayList<>();

    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }

    public static void printByTask() {
        TreeMap<Integer, ArrayList<HashMap<String, ArrayList<Integer>>>> tMap = new TreeMap();
        for (var contact : phoneBook.entrySet()) {
            String name = contact.getKey();
            ArrayList<Integer> list = contact.getValue();
            int size = list.size();
            HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
            hashMap.put(name, list);
            ArrayList<HashMap<String, ArrayList<Integer>>> mainValue = new ArrayList<>();
            mainValue.add(hashMap);
            if (tMap.containsKey(size)) {
                ArrayList<HashMap<String, ArrayList<Integer>>> listTemp = new ArrayList<>();
                listTemp = tMap.get(size);
                listTemp.add(hashMap);
            } else {
                tMap.put(size, mainValue);
            }
        }
        Stack<Integer> stack = new Stack<>();
        for (var item : tMap.entrySet()) {
            stack.add(item.getKey());
        }
        LinkedHashMap<Integer, ArrayList<HashMap<String, ArrayList<Integer>>>> result = new LinkedHashMap<>();
        for (int i = 0; i < tMap.size(); i++) {
            int key = stack.pop();
            result.put(key, tMap.get(key));
        }
        System.out.println(result);

    }


}