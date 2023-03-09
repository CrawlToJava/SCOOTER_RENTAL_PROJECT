package by.scooter.application.service.dto.user;

import by.scooter.application.entity.UserSex;
import by.scooter.application.entity.UserStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

import java.util.UUID;

@Data
public class UserUpdateRequestDto {
    private UUID uuid;

    private String firstName;

    private String lastName;

    @ColumnTransformer(read = "UPPER(user_status)", write = "LOWER(?)")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @ColumnTransformer(read = "UPPER(user_sex)", write = "LOWER(?)")
    @Enumerated(EnumType.STRING)
    private UserSex userSex;
}
