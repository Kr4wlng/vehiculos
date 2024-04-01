package com.codigo.vehiculos.application.controller;

import com.codigo.vehiculos.domain.aggregates.dto.VehiculosDTO;
import com.codigo.vehiculos.domain.ports.in.VehiculosServiceIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/vehiculos")
@RequiredArgsConstructor
public class VehiculosController {
    private final VehiculosServiceIn vehiculosServiceIn;

    @PostMapping
    public ResponseEntity<VehiculosDTO> registrar(@RequestBody VehiculosDTO vehiculosDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(vehiculosServiceIn.crearVehiculoIn(vehiculosDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculosDTO> obtenerVehiculo(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vehiculosServiceIn.obtenerVehiculoIn(id));
    }

    @GetMapping()
    public ResponseEntity<List<VehiculosDTO>> obtenerTodos(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vehiculosServiceIn.obtenerTodosIn());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehiculosDTO> actualizar(@PathVariable Long id, @RequestBody VehiculosDTO vehiculosDTO){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vehiculosServiceIn.actualizarIn(id, vehiculosDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VehiculosDTO> eliminar(@PathVariable Long id, @RequestHeader("id") Integer integer){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vehiculosServiceIn.deleteIn(id));
    }
}
