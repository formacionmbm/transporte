package com.practica.transporte.repository;

import com.practica.transporte.common.Tipo;
import com.practica.transporte.common.TipoDescuento;
import com.practica.transporte.entity.AbonoTransporte;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Slf4j
class ATRepositoryTest {

    @Autowired
    private ATRepository atRepository;

    @Test
    void findByTipo() {

        AbonoTransporte at = new AbonoTransporte();
        at.setTipo(Tipo.MENOR_7_ANIOS);

        atRepository.save(at);

        List<AbonoTransporte> resultado = atRepository.findByTipo(Tipo.MENOR_7_ANIOS);

        assertThat(resultado)
                .isNotEmpty()
                .hasSize(1);

        assertThat(resultado.get(0).getTipo())
                .isEqualTo(Tipo.MENOR_7_ANIOS);
    }

    @Test
    void findByTipo_ko() {

        List<AbonoTransporte> resultado = atRepository.findByTipo(Tipo.valueOf("JOVEN"));

        assertThat(resultado).isEmpty();
    }


    @Test
    void findByDescuento() {

        AbonoTransporte at = new AbonoTransporte();
        at.setTipodescuento(TipoDescuento.FAMILIA_NUMEROSA);
        atRepository.save(at);

        List<AbonoTransporte> resultado = atRepository.findByDescuento(TipoDescuento.FAMILIA_NUMEROSA);

        assertThat(resultado)
                .isNotEmpty()
                .allMatch(a -> a.getTipodescuento().equals(TipoDescuento.FAMILIA_NUMEROSA));
    }

}