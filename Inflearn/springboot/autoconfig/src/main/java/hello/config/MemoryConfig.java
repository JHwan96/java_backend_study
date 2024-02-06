package hello.config;

import memory.Memory;
import memory.MemoryCondition;
import memory.MemoryController;
import memory.MemoryFinder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

@Configuration
//@Conditional(MemoryCondition.class)
@ConditionalOnProperty(name="memory", havingValue = "on")
public class MemoryConfig {
    @Bean
    public MemoryController memoryController(){
        return new MemoryController(memoryFinder());
    }
    @Bean
    public MemoryFinder memoryFinder(){
        return new MemoryFinder();
    }
}
