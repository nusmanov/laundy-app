package com.example.laundry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LaundryAppApplication

fun main(args: Array<String>) {
	runApplication<LaundryAppApplication>(*args)
}
