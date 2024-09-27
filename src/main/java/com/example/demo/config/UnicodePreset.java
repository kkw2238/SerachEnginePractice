package com.example.demo.config;

import java.util.Map;

public class UnicodePreset {

    public static final int FIRST_CONSONANT_OFFSET = 588;

    static public Map<Character, Character> UNICODE_MAP = Map.ofEntries(
        Map.entry('ㄱ', '가'),
        Map.entry('ㄲ', '까'),
        Map.entry('ㄴ', '나'),
        Map.entry('ㄷ', '다'),
        Map.entry('ㄸ', '따'),
        Map.entry('ㄹ', '라'),
        Map.entry('ㅁ', '마'),
        Map.entry('ㅂ', '바'),
        Map.entry('ㅃ', '빠'),
        Map.entry('ㅅ', '사'),
        Map.entry('ㅆ', '싸'),
        Map.entry('ㅇ', '아'),
        Map.entry('ㅈ', '자'),
        Map.entry('ㅉ', '짜'),
        Map.entry('ㅊ', '차'),
        Map.entry('ㅋ', '카'),
        Map.entry('ㅌ', '타'),
        Map.entry('ㅍ', '파'),
        Map.entry('ㅎ', '하')
    );
}