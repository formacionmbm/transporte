package com.practica.transporte.service;

import com.practica.transporte.common.Descuento;
import com.practica.transporte.common.Tipo;
import com.practica.transporte.entity.AbonoTransporte;
import com.practica.transporte.repository.ATRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ATServiceImpl implements ATService {

    private final ATRepository atRepository;

    public ATServiceImpl(ATRepository atRepository) {
        this.atRepository = atRepository;
    }

    @Override
    public List<AbonoTransporte> listarTodas() {
        log.info("[listarTodas]");
        log.debug("[listarTodas]");
        return atRepository.findAll();
    }

    @Override
    public Optional<AbonoTransporte> buscarPorId(int id){
        log.info("[findById]");
        log.debug("[findById]");
        return atRepository.findById(id);
    }

    @Override
    public List<AbonoTransporte> buscarPorTipo(Tipo tipo) {
        log.info("[busquedaPorTipo]");
        log.debug("[busquedaPorTipo]");
        return atRepository.findByTipo(tipo);
    }

    @Override
    public List<AbonoTransporte> buscarPorDescuento(Descuento descuento) {
        log.info("[busquedaPorDescuento]");
        log.debug("[busquedaPorDescuento]");
        return atRepository.findByDescuento(descuento);
    }

    @Override
    public void crearAbono(AbonoTransporte abono) {
        log.info("[crearAbono]");
        atRepository.save(abono);
    }
}

