package ir.intellij.reviewproject.command;

import ir.intellij.reviewproject.dao.UserInfoDAO;
import ir.intellij.reviewproject.dto.UserInfoResponseDTO;

public class UserInfoDaoToUserInfoResponseDto {

    public static UserInfoResponseDTO convert(UserInfoDAO userInfoDAO) {
        return new UserInfoResponseDTO(
                userInfoDAO.getId(),
                userInfoDAO.getUsername(),
                userInfoDAO.getName(),
                userInfoDAO.getAge()
        );
    }
}
