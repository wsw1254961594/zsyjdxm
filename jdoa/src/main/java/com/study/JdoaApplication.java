package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.study.model.mdao"})
public class JdoaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdoaApplication.class, args);
        System.out.println("  _          _ _                         _     _ \n" +
                " | |        | | |                       | |   | |\n" +
                " | |__   ___| | | _____      _____  _ __| | __| |\n" +
                " | '_ \\ / _ \\ | |/ _ \\ \\ /\\ / / _ \\| '__| |/ _` |\n" +
                " | | | |  __/ | | (_) \\ V  V / (_) | |  | | (_| |\n" +
                " |_| |_|\\___|_|_|\\___( )_/\\_/ \\___/|_|  |_|\\__,_|\n" +
                "                     |/                          \n" +
                "                                                 ");
    }

}
