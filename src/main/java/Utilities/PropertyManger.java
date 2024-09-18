package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyManger {
    public static String url, validUsername, validPassword, invalidUsername, invalidPassword;
    public static String userName, passWord, submitButton, firsName, lastname, emailId, adduserpassWord,
            addusersubmitButton, signUpButton, addeUserErrorMessage;
    // addContact Page variable
    public static String firstName, lastName, birthdate, email, phone, street1, street2, city, stateProvince, postalCode, country;
    // ContactList
    public static String addNewContact, contactTable;
    public static PropertyManger instance;

    public static PropertyManger getInstance() {
        if (instance == null) {
            instance = new PropertyManger();
            instance.loadData();
        }

        return instance;
    }

    private void loadData() {
        Properties properties = new Properties();
        Properties Locators = new Properties();

        try {
            FileInputStream fi = new FileInputStream("C:\\inellij Project\\untitled\\src\\main\\resources\\Config.Properties");
            properties.load(fi);
            FileInputStream loc = new FileInputStream("C:\\inellij Project\\untitled\\src\\main\\resources\\Locators.Properties");
            Locators.load(loc);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        // Login Details
        url = properties.getProperty("url");
        validPassword = properties.getProperty("validPassword");
        validUsername = properties.getProperty("validUsername");
        invalidUsername = properties.getProperty("invalidUsername");
        invalidPassword = properties.getProperty("invalidPassword");

        //Locators
        userName = Locators.getProperty("login.usernameField");
        passWord = Locators.getProperty("login.passwordField");
        submitButton = Locators.getProperty("login.loginButton");
        // AdduserPage
        firsName = Locators.getProperty("addUser.firstName");
        lastname = Locators.getProperty("addUser.lastName");
        emailId = Locators.getProperty("addUser.emaiId");
        adduserpassWord = Locators.getProperty("adduser.passWord");
        addusersubmitButton = Locators.getProperty("adduser.submitButton");
        signUpButton = Locators.getProperty("login.signUpButton");
        addeUserErrorMessage = Locators.getProperty("addeUserErrorMessage");

        //ContactList
        addNewContact = Locators.getProperty("contactList.addContactButton");
        contactTable = Locators.getProperty("//table[@class='contactTable']");
        // AddContact
        firstName = Locators.getProperty("addContact.firstName");
        lastName = Locators.getProperty("addContact.lastName");
        birthdate = Locators.getProperty("addContact.dateOfBrith");
        email = Locators.getProperty("addContact.email");
        phone = Locators.getProperty("addContact.phone");
        street1 = Locators.getProperty("addContact.addressOne");
        street2 = Locators.getProperty("addContact.addressTwo");
        city = Locators.getProperty("addContact.city");
        stateProvince = Locators.getProperty("addContact.state");
        postalCode = Locators.getProperty("addContact.postalCode");
        country = Locators.getProperty("addContact.country");


    }

    public String getUrl() {
        return url;
    }

    public String getValidUsername() {
        return validUsername;
    }
}
