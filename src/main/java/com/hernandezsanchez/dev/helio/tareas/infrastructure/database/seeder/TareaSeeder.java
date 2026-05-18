package com.hernandezsanchez.dev.helio.tareas.infrastructure.database.seeder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.database.entity.TareaEntity;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.database.repository.QueryTareaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TareaSeeder implements CommandLineRunner {

    private final QueryTareaRepository queryTareaRepository;
    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {

        long count = queryTareaRepository.count();

        if(count == 0) {
            Resource resource = resourceLoader.getResource("classpath:tareas.json");

            List<TareaEntity> tareas = objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {
            });

            queryTareaRepository.saveAll(tareas);
        }
    }
}
