package by.scooter.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {

    private String firstName;

    private String lastName;

    private UserStatus userStatus;

    private UserSex userSex;

    private Set<UUID> orders;
}
