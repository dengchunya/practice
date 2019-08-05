package com.dengchunya.practice.P20190731;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

/**
 * @author dengchunya
 */
public class BirthdayGreet {
    public void greet(String filePath) throws IOException {
        try (
                FileInputStream inputStream = new FileInputStream(filePath);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))
        ) {
            String record;
            bufferedReader.readLine();
            while ((record = bufferedReader.readLine()) != null) {
                String[] userInfo = record.split(",");
                String birthdayStr = userInfo[2];
                if (todayIsBirthday(birthdayStr)) {
                    String firstName = userInfo[1];
                    String emailAddress = userInfo[3];
                    sendBirthdayEmail(emailAddress, firstName);
                }
            }
        }
    }

    private void sendBirthdayEmail(String emailAdress,String firstName) {
        System.out.println("Happy birthday, dear " + firstName);
    }

    private boolean todayIsBirthday(String birthdayStr) {
        LocalDate birthday = LocalDate.parse(birthdayStr);
        return todayIsBirthday(birthday);
    }

    private boolean todayIsBirthday(LocalDate birthday) {
        return LocalDate.now().isEqual(birthday);
    }
}
