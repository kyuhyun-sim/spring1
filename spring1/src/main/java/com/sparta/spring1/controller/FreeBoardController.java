package com.sparta.spring1.controller;

import com.sparta.spring1.domain.FreeBoardRepository;
import com.sparta.spring1.service.FreeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FreeBoardController {

    private final FreeBoardRepository FreeBoardRepository;
    private final FreeBoardService freeBoardService;

}
