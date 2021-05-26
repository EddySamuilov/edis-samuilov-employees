package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateFormatter {

    private static final List<SimpleDateFormat> knownPatterns = List.of(
            new SimpleDateFormat("dd-MM-yyyy"),
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyy.MM.dd"),
            new SimpleDateFormat("yyyy-dd-MM"),
            new SimpleDateFormat("yyyy.dd.MM"),
            new SimpleDateFormat("MM-dd-yyyy"),
            new SimpleDateFormat("MM/dd/yyyy"),
            new SimpleDateFormat("MM.dd.yyyy"),
            new SimpleDateFormat("MMM-dd-yyyy"),
            new SimpleDateFormat("MMM/dd/yyyy"),
            new SimpleDateFormat("MMM.dd.yyyy"),
            new SimpleDateFormat("MMMM-dd-yyyy"),
            new SimpleDateFormat("MMMM/dd/yyyy"),
            new SimpleDateFormat("MMMM.dd.yyyy"),
            new SimpleDateFormat("MM.dd.yyyy")
    );

    public static LocalDate getCorrectDatePattern(String dateToParse) {
        DateFormat sdf = SimpleDateFormat.getDateInstance(DateFormat.DATE_FIELD, Locale.ROOT);
        Date date = null;
        try {
            date = sdf.parse(dateToParse);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ZoneId defaultZoneId = ZoneId.systemDefault();
        Instant instant = date.toInstant();
        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();

        return localDate;
    }
}
