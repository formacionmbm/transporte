package com.practica.transporte.service;

import com.practica.transporte.common.TipoDescuento;
import com.practica.transporte.common.Tipo;
import com.practica.transporte.entity.AbonoTransporte;
import com.practica.transporte.repository.ATRepository;
import com.practica.transporte.service.interfaces.ATService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return atRepository.findAll();
    }

    @Override
    public AbonoTransporte buscarPorId(int id){
        log.info("[findById]");

        return atRepository.findById(id).orElse(null);
    }

    @Override
    public List<AbonoTransporte> buscarPorTipo(Tipo tipo) {
        log.info("[busquedaPorTipo]");
        log.debug("[busquedaPorTipo]");
        return atRepository.findByTipo(tipo);
    }

    @Override
    public List<AbonoTransporte> buscarPorDescuento(TipoDescuento tipodescuento) {
        log.info("[busquedaPorDescuento]");
        log.debug("[busquedaPorDescuento]");
        return atRepository.findByDescuento(tipodescuento);
    }

    @Override
    public void crearAbono(AbonoTransporte abono) {
        log.info("[crearAbono]");
        atRepository.save(abono);
    }
}

