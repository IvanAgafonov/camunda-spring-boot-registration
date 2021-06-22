package org.registration.config.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Table(name = "USER")
@Entity
public class User {
    @Id
    private String nickname;

    private String email;

    private LocalDate birthday;

    public User(String nickname, String email, LocalDate birthday) {
        this.nickname = nickname;
        this.email = email;
        this.birthday = birthday;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}