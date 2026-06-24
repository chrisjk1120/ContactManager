package se.lexicon;

public class Person {
    String name;
    String email;
    String phonenumber;

    public  Person(String name, String email, String phonenumber){
        this.name=name;
        this.email=email;
        this.phonenumber=phonenumber;
    }

    public Person addPerson(String name, String email, String phonenumber)
    {

        this.name=name;
        this.email=email;
        this.phonenumber=phonenumber;
        if(ValidatePerson()) {
            return this;
        } else {
            return null;
        }
    }

    public void printCard()
    {
        IO.println("=================");
        IO.println("Name:" + this.name);
        IO.println("Email: " + this.email);
        IO.println("Phonenumber: " + this.phonenumber);
    }

    private boolean ValidatePerson()
    {

        if(CommonValidators.isValidEmail(this.email) && CommonValidators.isValidPhoneNumber(this.phonenumber)){
            return true;
        } else {
            return false;
        }
    }

}
