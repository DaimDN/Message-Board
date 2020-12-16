package com.jpmorgan.board.Configuration;


import com.jpmorgan.board.Services.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class ArrayConfig {

    @Bean
    public ArrayList arrayList(){
        return new ArrayList<Message>();
    }
}

