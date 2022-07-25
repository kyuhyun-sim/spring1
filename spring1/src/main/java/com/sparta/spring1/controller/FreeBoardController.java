package com.sparta.spring1.controller;

import com.sparta.spring1.domain.FreeBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FreeBoardController {

    private final FreeBoardRepository FreeBoardRepository;
    
}
