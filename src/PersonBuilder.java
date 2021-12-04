public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;
    private PersonBuilder pb;

    public PersonBuilder() {
    }

    public Person build() throws IllegalStateException {
        if (name != null && surname != null) {
            return !Integer.valueOf(age).equals(null) ? new Person(name, surname, age) : new Person(name, surname);
        } else {
            StringBuilder sb = new StringBuilder("Не введены следующие данные: \n");
            if (name == null) {
                sb.append("имя\n");
            }
            if (surname == null) {
                sb.append("фамилия");
            }
            throw new IllegalStateException(sb.toString());
        }
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age >= 0) {
            this.age = age;
            return this;
        } else {
            throw new IllegalArgumentException("Некорректный возраст!");
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }
}