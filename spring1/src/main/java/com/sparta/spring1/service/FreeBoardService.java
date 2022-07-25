package com.sparta.spring1.service;

import com.sparta.spring1.domain.FreeBoard;
import com.sparta.spring1.domain.FreeBoardRepository;
import com.sparta.spring1.domain.FreeBoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class FreeBoardService {
    private final FreeBoardRepository freeBoardRepository;

    @Transactional
    public Long update(Long id, FreeBoardRequestDto requestDto){
        FreeBoard freeBoard = freeBoardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        freeBoard.update(requestDto);
        return freeBoard.getId();
    }
}
