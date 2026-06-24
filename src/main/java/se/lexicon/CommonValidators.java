package se.lexicon;

public class CommonValidators
{
    static boolean isValidEmail(String emailAddress)
    {
        return emailAddress.matches("\"^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    static boolean isValidPhoneNumber(String phoneNumber)
    {
        phoneNumber=phoneNumber.replaceAll("[\\s-()]", "");  // Removes any ()-prefixes.
        return phoneNumber.matches("^(\\\\+?\\\\d{1,3})?\\\\d{7,12}$");
    }
}
