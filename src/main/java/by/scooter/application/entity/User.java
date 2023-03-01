package by.scooter.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_status")
    @ColumnTransformer(read = "UPPER(user_status)", write = "LOWER(?)")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Column(name = "user_sex")
    @ColumnTransformer(read = "UPPER(user_sex)", write = "LOWER(?)")
    @Enumerated(EnumType.STRING)
    private UserSex userSex;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "orders_users",
            joinColumns = @JoinColumn(name = "order_uuid"))
    private Set<UUID> orders;
}
