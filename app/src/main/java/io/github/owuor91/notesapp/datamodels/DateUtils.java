package io.github.owuor91.notesapp.datamodels;

import android.util.Log;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by johnowuor on 13/04/2018.
 */

public class DateUtils {
  private static DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");

  public static Date parseDate(String dateString) {

    Date date = new Date();
    try {
      date = dateFormat.parse(dateString);
    } catch (Exception e) {
      Log.e("DateParseError", e.getMessage());
    }
    return date;
  }

  public static String convertDateTostring(Date date) {
    return dateFormat.format(date);
  }
}
