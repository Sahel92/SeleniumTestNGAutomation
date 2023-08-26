package com.sahel.booking.factory;

import com.sahel.booking.page.models.HomePage;
import com.sahel.booking.page.models.SignInPage;

public class BookingFactory{

    private final HomePage homePage;
    private final SignInPage signInPage;

    public BookingFactory(){
        this.homePage = new HomePage();
        this.signInPage = new SignInPage();
    }


    public SignInPage signInPage() {
        return signInPage;
    }

    public HomePage homePage() {
        return homePage;
    }
}
