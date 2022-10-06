package com.bogdanova;

        import com.codeborne.selenide.Condition;
        import com.codeborne.selenide.Configuration;
        import com.codeborne.selenide.Selenide;
        import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.Test;

        import javax.xml.namespace.QName;

        import static com.codeborne.selenide.Condition.text;
        import static com.codeborne.selenide.Selectors.byText;
        import static com.codeborne.selenide.Selenide.*;

public class testPageObjectsTestForm {

    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        Selenide.zoom(0.8);
        $("#firstName").setValue("Vadim");
        $("#lastName").setValue("Pirogkov");
        $("#userEmail").setValue("Pirogkov@gmail.com");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("9051112233");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1951");
        $(".react-datepicker__day--016:not(.react-datepicker__day--selected").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-2").parent().click();
        $("#uploadPicture").uploadFromClasspath("3.jpg");
        $("#currentAddress").setValue("red light, Geeta Colony");
        $(byText("Select State")).click();
        $(byText("Haryana")).click();
        $(byText("Select City")).click();
        $(byText("Panipat")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Vadim Pirogkov"),
                text("Pirogkov@gmail.com"),
                text("Male"),
                text("9051112233"),
                text("16 June,1951"),
                text("Maths"),
                text("Reading"),
                text("3.jpg"),
                text("red light, Geeta Colony"),
                text("Haryana Panipat"));
        $("#closeLargeModal").click();
    }
}
