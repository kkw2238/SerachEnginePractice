package com.example.demo;

import com.example.demo.config.FirstConsonantUtil;
import com.example.demo.container.Trie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Demo1Application {

	private static final Logger log = LoggerFactory.getLogger(Demo1Application.class);
	private static final FirstConsonantUtil util = new FirstConsonantUtil();
	private static Trie db = new Trie();

	public static void init() {
		String[] shops = {
				"번쩍피자",
				"미친피자",
				"탐나는피자",
				"예술피자",
				"고피자",
				"노모어피자",
				"피자마루",
				"서오릉피자",
				"비스트로피자",
				"브룩스피자",
				"미스터피자",
				"백종원의 빽보이 피자",
				"피자스쿨",
				"맘스터치"
		};

		for(String shop : shops) {
			String firstConsonant = util.convertFirstConsonant(shop);
			db.insert(shop, firstConsonant, 0);
		}
	}

	public static void show(List<String> datas) {
		if (datas == null || datas.isEmpty()) {
			System.out.println("데이터 없음");
			return;
		}

		System.out.print("[ ");
		for (String str : datas) {
			System.out.print(str + " ");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		init();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("초성 검색 : ");
			String firstConsonant = scanner.nextLine();

			List<String> result = db.find(firstConsonant,0);
			show(result);
		}


		// SpringApplication.run(Demo1Application.class, args);
	}

}
