package com.cheroliv

import groovy.transform.CompileStatic
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@CompileStatic
@SpringBootApplication
class ReservationsApplication {

    static void main(String[] args) {
        SpringApplication.run(ReservationsApplication, args)
	}
}
