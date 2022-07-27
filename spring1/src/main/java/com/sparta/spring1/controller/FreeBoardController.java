package com.sparta.spring1.controller;

import com.sparta.spring1.apiresult.ApiResult;
import com.sparta.spring1.apiresult.ResultPrint;
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
    public ApiResult<?> createFreeBoard(@RequestBody FreeBoardRequestDto requestDto){
        FreeBoard freeBoard = new FreeBoard(requestDto);
        return ResultPrint.success(freeBoardRepository.save(freeBoard));
    }
    @GetMapping("/api/post")
    public ApiResult<?> readFreeBoard(){
        return ResultPrint.success(freeBoardRepository.findAllByOrderByCreatedAtDesc());
    }
    @GetMapping("/api/post/{id}")
    public ApiResult<?> readWrite(@PathVariable Long id){
        return ResultPrint.success(freeBoardRepository.findById(id));
    }
    @PutMapping("/api/post/{id}")
    public ApiResult<?> updateFreeBoard(@PathVariable Long id, @RequestBody FreeBoardRequestDto requestDto){
        freeBoardService.update(id, requestDto);
        return ResultPrint.success(freeBoardRepository.findById(id));
    }
    @DeleteMapping("/api/post/{id}")
    public ApiResult<?> deleteMemo(@PathVariable Long id){
        freeBoardRepository.deleteById(id);
        return ResultPrint.success(true);
    }

    @PostMapping("/api/post/{id}")
    public ApiResult<?> passwordConfirm1(@PathVariable Long id, @RequestBody PassWordRequestDto requestDto){
        return ResultPrint.success(passwordConfirm.confirm(id, requestDto));
    }
}
