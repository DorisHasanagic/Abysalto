package php.automationpractice.core.randomgenerator;

import net.datafaker.Faker;

public class RandomGenerator {
    Faker faker = new Faker();

    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String password = faker.internet().password();
    private String email = faker.internet().emailAddress();
    private int day = faker.number().numberBetween(1, 28); // saljemo value opcije, ne vrijednost
    private int month = faker.number().numberBetween(1,12);
    private int year = faker.number().numberBetween(1920, 2007);

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
