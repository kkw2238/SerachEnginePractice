package com.example.demo.container;

import java.util.*;

public class Trie {
    private final int MAX_COUNT_EACH = 10;
    Map<Character, Trie> children;
    Set<String> words;

    public Trie() {
        children = new HashMap<>();
        words = new HashSet<>();
    }

    /**
     * 문자열을 Trie에 삽입하는 메서드
     * @param word 삽입할 문자열
     * @param firstConsonant 해당 문자열의 초성
     * @param index 현재 문자열의 index
     */
    public void insert(final String word, final String firstConsonant, int index) {
        if (isAbleInsert(word)) {
            words.add(word);
        }

        // 문자열의 끝인 경우
        if (index == word.length()) {
            return ;
        }

        char consonant = firstConsonant.charAt(index);

        if (!children.containsKey(consonant)) {
            children.put(consonant, new Trie());
        }

        children.get(consonant).insert(word, firstConsonant, index + 1);
    }

    /**
     * 관련 문자열을 추출하는 메서드
     * @param firstConsonant 초성으로 구성된 문자열
     * @param index 현재 위치
     * @return null : 찾는 데이터가 없는 경우 / 나머지 : 해당 초성과 관련된 문자열들
     */
    public List<String> find(final String firstConsonant, int index) {
        if (words.isEmpty()) {
           return null;
        }

        if(index == firstConsonant.length()) {
            return new ArrayList<>(words);
        }

        char consonant = firstConsonant.charAt(index);
        if (!children.containsKey(consonant)) {
            return null;
        }

        return children.get(consonant).find(firstConsonant, index + 1);
    }

    /**
     * word를 저장할 수 있는지에 대한 여부
     *  저장할 수 없는 상황 : 문자열이 비어있는 경우 / words가 이미 꽉찬 경우
     * @param word 저장할 문자열
     * @return Ture : 저장이 가능한 상태 / False : 저장이 불가능한 상태
     */
    private boolean isAbleInsert(String word) {
        return !word.isEmpty() && words.size() < MAX_COUNT_EACH;
    }
}
