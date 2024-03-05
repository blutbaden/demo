package com.example.blog.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostResponseDTO {
    private String id;
    private String title;
    private String content;
    private Instant created_date;
    private String createdBy;
}
