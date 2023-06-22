package de.benevolo.member_management.membership.servicetask;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidateCancelationDateService {

    public static boolean isWithinRange(LocalDate dateToCheck, LocalDate referenceDate, long days) {
        long difference = ChronoUnit.DAYS.between(referenceDate, dateToCheck);
        return Math.abs(difference) <= days;
    }

}
