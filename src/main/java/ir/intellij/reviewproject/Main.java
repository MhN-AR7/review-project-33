package ir.intellij.reviewproject;

import ir.intellij.reviewproject.dto.UserInfoResponseDTO;

public class Main {
    static void main() {
        UserInfoResponseDTO userInfoResponseDTO = new UserInfoResponseDTO(
                1L,
                "postgres",
                "John Doe",
                (short) 32
        );



        System.out.println(userInfoResponseDTO.username());
        System.out.println(userInfoResponseDTO);
    }
}
