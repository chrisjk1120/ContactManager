package se.lexicon;

public class Person {
    String name;
    String email;
    String phonenumber;

    public  Person(String name, String email, String phonenumber){
        this.name=name;
        this.email=email;
        this.phonenumber=phonenumber;
        ValidatePerson(); // As we throw an exception if this is not true, this person should not be added.

    }
    public Person(){

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
        //if(CommonValidators.isValidEmail(this.email)){
            return true;
        } else {
            throw new IllegalArgumentException("ERROR: Invalid format on either email or phonenumber");

        }
    }
public String getName()
{
    return this.name;

}
    public String csvNotation(){
        String csvLine = String.format("%s,%s,%s",this.name,this.email,this.phonenumber);
        return csvLine;
    }
}


