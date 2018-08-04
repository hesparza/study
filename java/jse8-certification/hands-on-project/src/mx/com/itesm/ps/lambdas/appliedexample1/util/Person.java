package mx.com.itesm.ps.lambdas.appliedexample1.util;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person() { /** Default Constructor **/ }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "First name: ["+this.firstName+"], last name: ["+this.lastName+"], age: ["+this.age+"]";
    }

}
