package ir.intellij.reviewproject.service;

import ir.intellij.reviewproject.command.UserInfoDaoToUserInfoResponseDto;
import ir.intellij.reviewproject.command.UserInfoRequestDtoToUserInfoDao;
import ir.intellij.reviewproject.dao.UserInfoDAO;
import ir.intellij.reviewproject.dto.UserInfoRequestDTO;
import ir.intellij.reviewproject.dto.UserInfoResponseDTO;
import ir.intellij.reviewproject.repository.Repository;
import ir.intellij.reviewproject.repository.UserInfoRepository;

public class UserInfoService {

    private Repository<UserInfoDAO> repository;

    public UserInfoService(Repository<UserInfoDAO> repository) {
        this.repository = repository;
    }

    public UserInfoResponseDTO create(UserInfoRequestDTO userInfoRequestDTO) {

        UserInfoDAO userInfoDAO = this.repository.create(UserInfoRequestDtoToUserInfoDao.convert(userInfoRequestDTO));

        return UserInfoDaoToUserInfoResponseDto.convert(userInfoDAO);
    }
}
