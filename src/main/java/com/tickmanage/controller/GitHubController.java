package com.tickmanage.controller;

import com.tickmanage.constant.PathGeneric;
import com.tickmanage.dto.GitHubUserDTO;
import com.tickmanage.service.GitHubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PathGeneric.PATH_API_GITHUB)  // Base path for GitHub API
@RequiredArgsConstructor
public class GitHubController {
    private final GitHubService gitHubService;

    @GetMapping(PathGeneric.PATH_SEARCH_USERS)
    public ResponseEntity<List<GitHubUserDTO>> searchUsers(@RequestParam String name) {
        return ResponseEntity.ok(gitHubService.searchUsers(name));
    }
}
