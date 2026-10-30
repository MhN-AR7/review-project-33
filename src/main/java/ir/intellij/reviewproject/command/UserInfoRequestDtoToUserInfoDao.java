package ir.intellij.reviewproject.command;

import ir.intellij.reviewproject.dao.UserInfoDAO;
import ir.intellij.reviewproject.dto.UserInfoRequestDTO;

public class UserInfoRequestDtoToUserInfoDao {

    public static UserInfoDAO convert(UserInfoRequestDTO userInfoRequestDTO) {

        return UserInfoDAO
                .builder()
                .username(userInfoRequestDTO.username())
                .name(userInfoRequestDTO.name())
                .password(userInfoRequestDTO.password())
                .age(userInfoRequestDTO.age())
                .build();
    }
}
