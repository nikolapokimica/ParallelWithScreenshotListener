package data_generators;

import com.github.javafaker.Faker;

public class DataGeneratorForRegistration extends DataGenerator {

    public DataGeneratorForRegistration() {
        Faker faker = new Faker();
        map.put("email", faker.internet().emailAddress());
        map.put("first name", faker.name().firstName());
        map.put("last name", faker.name().lastName());
        map.put("password", faker.internet().password());
        map.put("address", faker.address().streetAddress());
        map.put("city", faker.address().city());
        map.put("postcode", faker.numerify("#####"));
        map.put("mobile phone", faker.phoneNumber().cellPhone());
        map.put("alias address", faker.address().streetAddress());
    }

    @Override
    public String toString() {
        return "Data for registration:\n" + super.toString();
    }
}
