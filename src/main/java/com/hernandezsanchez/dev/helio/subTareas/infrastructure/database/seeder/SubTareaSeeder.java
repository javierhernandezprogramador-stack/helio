package com.hernandezsanchez.dev.helio.subTareas.infrastructure.database.seeder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.database.entity.SubTareaEntity;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.database.repository.QuerySubTareaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubTareaSeeder implements CommandLineRunner {

    private final QuerySubTareaRepositorio querySubTareaRepositorio;
    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;


    @Override
    public void run(String... args) throws Exception {
        long count = querySubTareaRepositorio.count();

        if(count == 0) {
            Resource resource = resourceLoader.getResource("classpath:subtareas.json");

            List<SubTareaEntity> subTareas = objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {
            });

            querySubTareaRepositorio.saveAll(subTareas);
        }

    }
}
