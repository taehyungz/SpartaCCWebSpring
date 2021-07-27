package com.sparta.week03.controller;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRequestDto;
import com.sparta.week03.repository.MemoRepository;
import com.sparta.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;
    private final MemoRepository memoRepository;

    @GetMapping("/api/memos")
    public List<Memo> readMemo() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto memoRequestDto) {
        Memo memo = new Memo(memoRequestDto);
        return memoRepository.save(memo);
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto memoRequestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(NullPointerException::new);
        memo.update(memoRequestDto);
        return memo.getId();
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }

}
