package mymemoryspace.backend.entity.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue
    private Long userNo;

    @Column(unique = true, nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;

    @Column(length = 8)
    private String birthDate;

    private String mobileNo;

    private String email;

    @Enumerated(EnumType.STRING)
    private UserLevel accessLevel;

    private String activeYn;

}