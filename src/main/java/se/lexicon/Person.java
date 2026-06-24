package se.lexicon;

public class Person {
    String name;
    String email;
    String phonenumber;

    public void Person(){


    }

    public Person addPerson(String name, String email, String phonenumber)
    {
        this.name=name;
        this.email=email;
        this.phonenumber=phonenumber;
        return this;
    }

    public void printCard()
    {
        IO.println("=================");
        IO.println("Name:" + this.name);
        IO.println("Email: " + this.email);
        IO.println("Phonenumber: " + this.phonenumber);
    }



}
