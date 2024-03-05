package com.example.blog.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostRequestDTO {
    @NotBlank(message = "Title is required.")
    @Size(min = 4, max = 20, message = "Title needs to be between 4 and 20 characters.")
    private String title;
    private String content;
    private String tags;
}
