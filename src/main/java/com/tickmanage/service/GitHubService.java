package com.tickmanage.service;

import com.tickmanage.dto.GitHubUserDTO;
import java.util.List;

public interface GitHubService {
    List<GitHubUserDTO> searchUsers(String name);
}
