package org.jayden.bookllist;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org/jayden/bookllist/mapper")
public class BookllistApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookllistApplication.class, args);
    }

}
