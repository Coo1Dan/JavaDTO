package org.example.generation;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.models.User;
import org.example.models.UserRole;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Random;

public class UserGenerator {

    public static User generateUser() {
        User dto = new User(); // role = USER
        Random random = new Random();
        dto.setId(random.nextLong());
        dto.setName(RandomStringUtils.randomAlphabetic(random.nextInt(6) + 4));
        dto.setEmail(RandomStringUtils.randomAlphabetic(20));
        dto.setPhoneNumber(RandomStringUtils.randomNumeric(11));
        dto.setRole(UserRole.USER);
        return dto;
    }

    public static User fillUser(User dto) {
        Field[] fields = dto.getClass().getDeclaredFields();
        Random random = new Random();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                var val = field.get(dto);
                if (val == null) {
                    Type fieldType = field.getType();
                    if (fieldType == Long.class) {
                        field.set(dto, random.nextLong());
                    } else if (fieldType == String.class) {
                        field.set(dto, RandomStringUtils.randomAlphanumeric(15));
                    } else if (fieldType == UserRole.class) {
                        var roles = UserRole.values();
                        field.set(dto, roles[random.nextInt(roles.length)]);
                        break;
                    } else throw new RuntimeException("This field was not found!");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return dto;
    }
}