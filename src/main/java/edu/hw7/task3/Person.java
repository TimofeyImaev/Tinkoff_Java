package edu.hw7.task3;

public record Person(int id, String name, String address, String phoneNumber) {
    @Override
    public boolean equals(Object person) {
        if (person == null || person.getClass() != Person.class) {
            return false;
        }

        if (person == this) {
            return true;
        }

        return this.id == ((Person) person).id && this.name.equals(((Person) person).name)
            && this.address.equals(((Person) person).address)
            && this.phoneNumber.equals(((Person) person).phoneNumber);
    }

    @Override
    public int hashCode() {
        return id;
    }
}
