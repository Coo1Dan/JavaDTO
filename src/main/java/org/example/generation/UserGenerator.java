package org.example.generation;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.models.User;
import org.example.models.UserRole;

import java.lang.reflect.Field;
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
        for (Field f : fields) {
            try {
                f.setAccessible(true);
                var val = f.get(dto);
                if (val == null) {
                    switch (f.getName()) {
                        case "id":
                            f.set(dto, random.nextLong());
                            break;
                        case "name":
                            f.set(dto, RandomStringUtils.randomAlphabetic(random.nextInt(6) + 4));// random string;
                            break;
                        case "email":
                            f.set(dto, RandomStringUtils.randomAlphabetic(20));
                            break;
                        case "phoneNumber":
                            f.set(dto, RandomStringUtils.randomNumeric(11));
                            break;
                        case "role":
                            var roles = UserRole.values();
                            f.set(dto, roles[random.nextInt(roles.length)]);
                            break;
                        default:
                            throw new RuntimeException("This field was not found!");
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return dto;
    }
}
