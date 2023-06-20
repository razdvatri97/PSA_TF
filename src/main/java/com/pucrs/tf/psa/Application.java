package com.pucrs.tf.psa;

import com.pucrs.tf.psa.model.Reembolso;
import com.pucrs.tf.psa.repository.ReembolsoRepositorio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages = {"com.pucrs.tf.psa.repository"})
//@ComponentScan(basePackages = "com.pucrs.tf.psa.repository")
//@ComponentScan(basePackages = {"com.pucrs.tf.psa"})
//@EnableJpaRepositories(basePackageClasses = ReembolsoRepositorio.class)
//@SpringBootApplication(scanBasePackages={"com.pucrs.tf.psa", "com.pucrs.tf.psa.repository"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
