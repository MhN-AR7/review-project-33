package ir.intellij.reviewproject.dao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_info")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoDAO extends DAO{

    private String username;
    private String password;
    private String name;
    private short age;
}
