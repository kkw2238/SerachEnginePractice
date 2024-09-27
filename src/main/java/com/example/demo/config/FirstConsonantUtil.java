package com.example.demo.config;

import org.springframework.stereotype.Component;

@Component
public class FirstConsonantUtil {
    public static final char KOREAN_BEGIN_UNICODE = 0xAC00;
    public static final char KOREAN_END_UNICODE = 0xD7A3;

    /**
     * 해당 문자열을 초성으로 바꿔주는 메서드
     * @param input 입력된 문자열
     * @return 초성으로 변환된 문자열
     */
    public String convertFirstConsonant(String input) {
        StringBuilder stringBuilder = new StringBuilder();

        for(char c : input.toCharArray()) {
            stringBuilder.append(getFirstConsonant(c));
        }

        return stringBuilder.toString();
    }
    /**
     * 해당 문자의 초성을 알아오는 메서드
     * @param c 초성을 확인할 문자
     * @return 한글일 경우 : 초성 / 그 외 : c 그대로 반환
     */
    public String getFirstConsonant(char c) {
        if (!isKorean(c)) {
            return String.valueOf(c);
        }

        char beginUnicode = ' ';
        for (Character key : UnicodePreset.UNICODE_MAP.keySet()) {
            beginUnicode = UnicodePreset.UNICODE_MAP.get(key);

            if (isMatchFirstConsonant(c, beginUnicode)) {
                return String.valueOf(key);
            }
        }

        return String.valueOf(c);
    }

    /**
     * 문자 c가 해당 초성 유니코드 범위에 들어있는지 확인하는 메서드
     * @param c 확인할 문자
     * @param beginUnicode 초성 유니코드 시작 지점 ( ㄱ = 0xAC00 )
     * @return True : 해당 초성 범위 내부 / False : 해당 초성 범위 밖
     */
    private boolean isMatchFirstConsonant(char c, char beginUnicode) {
        return c >= beginUnicode && c < beginUnicode + UnicodePreset.FIRST_CONSONANT_OFFSET;
    }

    /**
     * 해당 문자가 한글인지 확인하는 메서드
     * @param c 확인할 메서드
     * @return True : 한글 / False : 그 외의 언어
     */
    private boolean isKorean(char c) {
        return c >= KOREAN_BEGIN_UNICODE && c <= KOREAN_END_UNICODE;
    }
}
