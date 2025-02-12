package com.tickmanage.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GitHubUserDTO {
    private String login;
    private String avatarUrl;
    private String htmlUrl;
}
