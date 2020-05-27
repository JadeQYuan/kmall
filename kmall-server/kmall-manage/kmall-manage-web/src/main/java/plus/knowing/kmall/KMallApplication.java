package plus.knowing.kmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"plus.knowing.kmall.dao"})
@SpringBootApplication
public class KMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(KMallApplication.class);
    }
}
