package com.bogdanova.tests;

import com.bogdanova.pages.RegistrationFormPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class testPageObjectsTestMiniForm {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormMiniTest() {
        registrationFormPage.openPage()
                .setFirstName("Vadim")
                .setLastName("Pirogkov")
                .setEmail("Pirogkov@gmail.com")
                .setGender("Other")
                .setuserNumber("9051112233");

        $("#submit").click();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Vadim Pirogkov")
                .checkResult("Student Email", "Pirogkov@gmail.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "9051112233");
        $("#closeLargeModal").click();
    }
}
