package com.sparta.spring1.controller;

import com.sparta.spring1.domain.FreeBoard;
import com.sparta.spring1.domain.FreeBoardRepository;
import com.sparta.spring1.domain.FreeBoardRequestDto;
import com.sparta.spring1.service.FreeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FreeBoardController {

    private final FreeBoardRepository freeBoardRepository;
    private final FreeBoardService freeBoardService;

    @PostMapping("/api/post")
    public FreeBoard createFreeBoard(@RequestBody FreeBoardRequestDto requestDto){
        FreeBoard freeBoard = new FreeBoard(requestDto);
        return freeBoardRepository.save(freeBoard);
    }

}
