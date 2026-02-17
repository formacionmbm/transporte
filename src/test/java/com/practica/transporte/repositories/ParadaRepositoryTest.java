package com.practica.transporte.repositories;

import com.practica.transporte.entities.Parada;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest

public class ParadaRepositoryTest {
    @Autowired
    private ParadaRepository paradaRepository;

    @Test
    void findByNumeroParada_ok(){
        log.info("[findByNumeroParada_ok]");
        //given
        Parada parada = new Parada();
        parada.setNumeroParada(101);

        paradaRepository.save(parada);
        Optional<Parada> encontrado = paradaRepository.findByNumeroParada(101);

        assertThat(encontrado).isPresent();
        assertThat(encontrado.get().getNumeroParada()).isEqualTo(101);

    }


}
