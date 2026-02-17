package com.practica.transporte.service;

import com.practica.transporte.dto.ConductorDTO;
import com.practica.transporte.entities.Conductor;
import com.practica.transporte.mapper.ConductorMapper;
import com.practica.transporte.repositories.ConductorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ConductorServiceImplTest {

    @InjectMocks
    private ConductorServiceImpl conductorService;

    @Mock
    private ConductorRepository conductorRepository;

    @Mock
    private ConductorMapper conductorMapper;

    private Conductor conductor;
    private ConductorDTO conductorDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        conductor = new Conductor();
        conductor.setId(1L);
        conductor.setNombre("TestNombre");
        conductor.setApellidos("TestApellidos");
        conductor.setFechaIncorporacion(LocalDate.now());
        conductor.setNumEmpleado("TEST001");
        conductor.setTipoLicencia("D");
        conductor.setCaducidadLicencia(LocalDate.now().plusYears(5));
        conductor.setDisponible(true);
        conductor.setIdAutobus(10L);

        conductorDTO = new ConductorDTO();
        conductorDTO.setNumEmpleado(conductor.getNumEmpleado());
        conductorDTO.setNombre(conductor.getNombre());
        conductorDTO.setApellidos(conductor.getApellidos());
    }

    @Test
    void testFindByNumeroEmpleado_Found() {
        when(conductorRepository.findByNumEmpleado("TEST001")).thenReturn(Optional.of(conductor));
        when(conductorMapper.toDTO(conductor)).thenReturn(conductorDTO);

        ConductorDTO result = conductorService.findByNumeroEmpleado("TEST001");

        assertNotNull(result);
        assertEquals("TEST001", result.getNumEmpleado());
        verify(conductorRepository, times(1)).findByNumEmpleado("TEST001");
        verify(conductorMapper, times(1)).toDTO(conductor);
    }

    @Test
    void testFindByNumeroEmpleado_NotFound() {
        when(conductorRepository.findByNumEmpleado("NOEXISTE")).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> conductorService.findByNumeroEmpleado("NOEXISTE"));

        assertTrue(exception.getMessage().contains("Conductor no encontrado"));
        verify(conductorRepository, times(1)).findByNumEmpleado("NOEXISTE");
        verify(conductorMapper, never()).toDTO(any());
    }

    @Test
    void testFindAll() {
        when(conductorRepository.findAll()).thenReturn(Arrays.asList(conductor));
        when(conductorMapper.toDTO(conductor)).thenReturn(conductorDTO);

        List<ConductorDTO> result = conductorService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("TEST001", result.get(0).getNumEmpleado());
        verify(conductorRepository, times(1)).findAll();
        verify(conductorMapper, times(1)).toDTO(conductor);
    }
}
