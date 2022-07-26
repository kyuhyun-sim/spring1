package com.sparta.spring1.service;

import com.sparta.spring1.domain.FreeBoard;
import com.sparta.spring1.domain.FreeBoardRepository;
import com.sparta.spring1.domain.FreeBoardRequestDto;
import com.sparta.spring1.domain.PassWordRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PasswordConfirm {
    private final FreeBoardRepository freeBoardRepository;

    @Transactional
    public Boolean confirm(Long id, PassWordRequestDto requestDto){
        FreeBoard freeBoard = freeBoardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        return freeBoard.confirm(requestDto);
    }
}
