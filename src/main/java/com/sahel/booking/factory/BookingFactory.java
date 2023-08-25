package com.sahel.booking.factory;

import com.sahel.booking.page.models.HomePage;
import com.sahel.booking.page.models.SignInPage;

public class BookingFactory{

    private HomePage homePage;
    private SignInPage signInPage;

    public BookingFactory(){
        this.homePage = new HomePage();
    }


    public SignInPage signInPage() {
        return signInPage;
    }

    public HomePage homePage() {
        return homePage;
    }
}
