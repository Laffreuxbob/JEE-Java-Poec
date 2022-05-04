package fr.epsi.rennes.poec.bob.service;


import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.time.temporal.ChronoUnit;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static java.time.temporal.ChronoUnit.YEARS;

@Service
public class AgeService {
    public int age(String BirthDate) {
        LocalDate birth = LocalDate.parse(BirthDate, ISO_LOCAL_DATE);
        LocalDate today = LocalDate.now();
        // return Period.between(birth, today).getYears();
        return Math.abs((int) Duration.between(birth, today).get(YEARS));
    }
}
