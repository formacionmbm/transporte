package com.practica.transporte.repository;

import com.practica.transporte.entity.AbonoTransporte;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ATRepositoryTest {
    Logger log = LoggerFactory.getLogger(ATRepositoryTest.class);

    @Autowired
    ATRepository atRepository;

    @Test
    void buscarPorId_ok() {
        log.info("[buscarPorId_ok]");

        // given
        AbonoTransporte abonoTransporte = new AbonoTransporte();
        AbonoTransporte buscar = atRepository.save(abonoTransporte);

        // when
        Optional<AbonoTransporte> resultado = atRepository.buscarPorIdKo(0);

        // then
        assertThat(resultado).isPresent();
        assertThat(resultado.get().getId()).isEqualTo(guardado.getId());
    }

    @Test
    void buscarPorId_ko() {
        log.info("[buscarPorId_ko]");

        // given
        AbonoTransporte abonoTransporte = new AbonoTransporte();
        abonoTransporte.setBuscarPorIdKo(1);
        atRepository.save(abonoTransporte);

        // when
        Optional<AbonoTransporte> resultado = atRepository.buscarPorIdKo(0);

        // then
        assertThat(resultado).isPresent();
    }

    @Test
    void buscarPorId_ko() {
        log.info("[buscarPorId_ko]");

        // given
        AbonoTransporte abonoTransporte = new AbonoTransporte();
        abonoTransporte.setBuscarPorIdKo(0);
        atRepository.save(abonoTransporte);

        // when
        Optional<AbonoTransporte> resultado = atRepository.buscarPorIdKo(0);

        // then
        assertThat(resultado).isPresent();
    }

    @Test
    void buscarPorTipo_ok() {
        log.info("[buscarPorTipo_ok]");
        // given
        AbonoTransporte abonoTransporte = new AbonoTransporte();
        abonoTransporte.setBuscarPorTipo_Ok(0);
       AbonoTransporte guardado = atRepository.save(abonoTransporte);

        // when
        Optional<AbonoTransporte> resultado = atRepository.buscarPorTipo_ok(0);

        // then
        assertThat(resultado).isPresent();
        assertThat(resultado.get().getBuscarPorTipo_ok()).isEqualTo(0);
    }

    @Test
    void buscarPorTipo_ko() {
        log.info("[buscarPorTipo_ko]");

        // given
        AbonoTransporte abonoTransporte = new AbonoTransporte();
        abonoTransporte.setBuscarPorTipo_ko(1);
        atRepository.save(abonoTransporte);

        // when
        Optional<AbonoTransporte> resultado = atRepository.buscarPorTipo_ok(0);

        // then
        assertThat(resultado).isPresent();
        assertThat(resultado.get().getBuscarPorTipo_ok()).isEqualTo();
    }

}