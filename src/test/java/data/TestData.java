package data;

import com.github.javafaker.Faker;

public class TestData {
    public final Faker faker;

    public final String firstName;
    public final String lastName;
    public final String userEmail;
    public final String userNumber;
    public final String incorrectUserNumber;
    public final String currentAddress;
    public final String fileName;
    public final String gender;
    public final String userBirthDay;
    public final String userBirthMonth;
    public final String userBirthYear;
    public final String hobby;
    public final String subject;
    public final String state;
    public String city;

    public TestData() {
        this.faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        userNumber = faker.number().digits(10);
        incorrectUserNumber = faker.number().digits(3);
        currentAddress = faker.address().fullAddress();
        fileName = "wolf.JPG";
        gender = faker.options().option("Male", "Female", "Other");
        userBirthDay = String.format("%02d", faker.number().numberBetween(1, 28));
        userBirthMonth = faker.options().option("January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November", "December");
        userBirthYear = String.format("%s", faker.number().numberBetween(1900, 2100));
        hobby = faker.options().option("Sports", "Reading", "Music");
        subject = faker.options().option("Maths", "Art", "Accounting", "Physics", "Chemistry", "Economics", "English",
                "Biology", "History", "Civics", "Computer Science", "Social Studies", "Hindi", "Commerce");
        state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        city = getRandomCity();
    }

    public String getRandomCity() {
        if (state.equals("NCR")) city = faker.options().option("Delhi", "Gurgaon", "Noida");
        if (state.equals("Uttar Pradesh")) city = faker.options().option("Agra", "Lucknow", "Merrut");
        if (state.equals("Haryana")) city = faker.options().option("Karnal", "Panipat");
        if (state.equals("Rajasthan")) city = faker.options().option("Jaipur", "Jaiselmer");
        return city;
    }
}
