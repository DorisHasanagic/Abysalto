package php.automationpractice.core.utility;

import php.automationpractice.core.randomgenerator.RandomGenerator;
import java.util.ArrayList;
import java.util.List;

public class UserDataStorage {

    private static List<RandomGenerator> users = new ArrayList<>();

    public static void addUser(RandomGenerator user) {
        users.add(user);
    }

    public static List<RandomGenerator> getUsers() {
        return users;
    }

    public static void clear() {
        users.clear();
    }
}
