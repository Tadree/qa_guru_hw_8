package ru.jiehk.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.jiehk.pages.RegistrationFormPage;

import static ru.jiehk.tests.TestData.*;

public class StudentRegistrationFormTest {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void formTest() {
        TestData testData = new TestData();

        registrationFormPage.openPage()
                .closeAds()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setNumber(testData.mobile)
                .setBirthDate(testData.birthYear, testData.birthMonth, testData.birthDay)
                .setSubjects(testData.subjects)
                .setHobby(testData.hobby)
                .uploadPicture("src/test/resources/" + testData.pictureName)
                .setAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .submitForm()
                .checkResultsTableVisible()
                .checkResults("Student Name", testData.firstName + " " + testData.lastName)
                .checkResults("Student Email", testData.email)
                .checkResults("Gender", testData.gender)
                .checkResults("Mobile", testData.mobile)
                .checkResults("Date of Birth", testData.birthDay + " " + testData.birthMonth + "," + testData.birthYear)
                .checkResults("Subjects", testData.subjects)
                .checkResults("Hobbies", testData.hobby)
                .checkResults("Picture", testData.pictureName)
                .checkResults("Address", testData.currentAddress)
                .checkResults("State and City", testData.state + " " + testData.city);
    }
}
