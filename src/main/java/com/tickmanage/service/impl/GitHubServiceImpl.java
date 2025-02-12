package com.tickmanage.service.impl;

import com.tickmanage.dto.GitHubUserDTO;
import com.tickmanage.service.GitHubService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GitHubServiceImpl implements GitHubService {
    private final RestTemplate restTemplate;

    @Override
    public List<GitHubUserDTO> searchUsers(String name) {
        String url = "https://api.github.com/search/users?q=" + name;
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        List<Map<String, Object>> items = (List<Map<String, Object>>) response.getBody().get("items");

        return items.stream()
                .map(user -> new GitHubUserDTO(
                        (String) user.get("login"),
                        (String) user.get("avatar_url"),
                        (String) user.get("html_url")
                ))
                .collect(Collectors.toList());
    }
}
