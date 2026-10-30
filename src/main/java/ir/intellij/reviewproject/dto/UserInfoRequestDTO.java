package ir.intellij.reviewproject.dto;

public record UserInfoRequestDTO(
        String username,
        String password,
        String name,
        short age
) {
}


