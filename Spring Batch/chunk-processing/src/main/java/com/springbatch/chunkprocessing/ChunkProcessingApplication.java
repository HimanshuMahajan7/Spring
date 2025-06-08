package com.springbatch.chunkprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.springbatch"})
public class ChunkProcessingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChunkProcessingApplication.class, args);
        System.out.println("Chunk Processing in Spring Batch Application!");
    }

}
