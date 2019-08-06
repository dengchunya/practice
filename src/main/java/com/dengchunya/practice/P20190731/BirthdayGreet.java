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
                User user = buildUser(record);
                if (todayIsBirthday(user.getBirthday())) {
                    sendBirthdayEmail(user);
                }
            }
        }
    }

    private User buildUser(String record) {
        String[] userInfo = record.split(",");
        return User.builder()
                .lastName(userInfo[0])
                .firstName(userInfo[1])
                .birthday(userInfo[2])
                .email(userInfo[3])
                .build();
    }

    private void sendBirthdayEmail(User user) {
        System.out.println("Happy birthday, dear " + user.getFirstName());
    }

    private boolean todayIsBirthday(String birthdayStr) {
        LocalDate birthday = LocalDate.parse(birthdayStr);
        return todayIsBirthday(birthday);
    }

    private boolean todayIsBirthday(LocalDate birthday) {
        LocalDate today = LocalDate.now();
        return today.getDayOfMonth() == birthday.getDayOfMonth()
                && today.getMonth() == birthday.getMonth();
    }
}
