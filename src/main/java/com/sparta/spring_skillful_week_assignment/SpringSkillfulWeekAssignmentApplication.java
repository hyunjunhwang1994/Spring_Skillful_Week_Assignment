package com.sparta.spring_skillful_week_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableJpaAuditing
@SpringBootApplication
public class SpringSkillfulWeekAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSkillfulWeekAssignmentApplication.class, args);
    }

}
