package ir.intellij.reviewproject.dto;

public record UserInfoResponseDTO(
        Long id,
        String username,
        String name,
        short age
) {
}
