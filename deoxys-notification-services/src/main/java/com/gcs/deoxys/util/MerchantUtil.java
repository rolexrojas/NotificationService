package com.gcs.deoxys.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class MerchantUtil {


    public static String formatDateToString(Date dateTransaction, String stringFormat){

        DateFormat df = new SimpleDateFormat(stringFormat);

        String dateFormated = df.format(dateTransaction);


        return dateFormated;
    }

    public static String parseAccountNumber(String accountNumber){

        String result = Optional.ofNullable(accountNumber)
                .filter(sStr -> accountNumber.length() != 0)
                .map(sStr -> accountNumber.substring(0, accountNumber.length() - 4))
                .orElse("");

        result = result.substring(result.length() - 4);

        return result;

    }

    public static String parseMsisdn(String msisdn){

        String firstPart;
        String secondPart;

        firstPart = msisdn.substring(0,3);
        secondPart = msisdn.substring(6,10);

        return firstPart + "***" + secondPart;

    }

}
