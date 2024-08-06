package com.diwakar15.selenium_docker.tests.flightreservation.model;

public record FlightReservationTestData(String firstName, 
										String lastName,
										String email, 
										String password,
										String street,
										String city,
										String zip,
										String passangersCount,
										String expectedPrice)
										{}
