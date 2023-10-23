package Turkcellbootcamp.Springstart.core.configurations;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class modelMapperConfiguration {
    @Bean
    public ModelMapper modelMapper(){
        
        var mapper=new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return mapper;
    }


}
