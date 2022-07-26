package com.sparta.spring1.controller;

import com.sparta.spring1.domain.FreeBoard;
import com.sparta.spring1.domain.FreeBoardRepository;
import com.sparta.spring1.domain.FreeBoardRequestDto;
import com.sparta.spring1.domain.PassWordRequestDto;
import com.sparta.spring1.service.FreeBoardService;
import com.sparta.spring1.service.PasswordConfirm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class FreeBoardController {

    private final FreeBoardRepository freeBoardRepository;
    private final FreeBoardService freeBoardService;

    private final PasswordConfirm passwordConfirm;

    @PostMapping("/api/post")
    public FreeBoard createFreeBoard(@RequestBody FreeBoardRequestDto requestDto){
        FreeBoard freeBoard = new FreeBoard(requestDto);
        return freeBoardRepository.save(freeBoard);
    }
    @GetMapping("/api/post")
    public List<FreeBoard> readFreeBoard(){
        return freeBoardRepository.findAllByOrderByCreatedAtDesc();
    }
    @GetMapping("/api/post/{id}")
    public Optional<FreeBoard> readWrite(@PathVariable Long id){

        return freeBoardRepository.findById(id);
    }
    @PutMapping("/api/post/{id}")
    public Long updateFreeBoard(@PathVariable Long id, @RequestBody FreeBoardRequestDto requestDto){
        freeBoardService.update(id, requestDto);
        return id;
    }
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){
        freeBoardRepository.deleteById(id);
        return id;
    }

    @PostMapping("/api/post/{id}")
    public boolean passwordConfirm1(@PathVariable Long id, @RequestBody PassWordRequestDto requestDto){
        return passwordConfirm.confirm(id, requestDto);
    }
}
