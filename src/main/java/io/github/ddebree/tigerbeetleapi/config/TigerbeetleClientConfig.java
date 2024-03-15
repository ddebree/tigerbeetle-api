package io.github.ddebree.tigerbeetleapi.config;

import com.tigerbeetle.Client;
import com.tigerbeetle.UInt128;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TigerbeetleClientConfig {

    @Bean
    public Client tigerbettleClient() {
        return new Client(UInt128.asBytes(0), new String[] {"127.0.0.1:3000"});
    }

}
