package data_generators;

import com.github.javafaker.Faker;

public class DataCreation {

    private DataCreation() {}

    public static String email(){
        return  new Faker().internet().emailAddress();
    }
    public static String password(){
        return new Faker().internet().password();
    }

    public static String firstName() {
        return new Faker().name().firstName();
    }

    public static String lastName() {
        return new Faker().name().lastName();
    }

    public static String streetAddress() {
        return new Faker().address().streetAddress();
    }

    public static String cityName() {
        return new Faker().address().cityName();
    }

    public static String postalCode () {
        return new Faker().number().digits(5);
    }

    public static  String cellPhone() {
        return new Faker().phoneNumber().cellPhone();
    }
}
