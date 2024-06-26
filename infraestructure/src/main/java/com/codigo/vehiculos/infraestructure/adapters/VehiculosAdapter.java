package com.codigo.vehiculos.infraestructure.adapters;

import com.codigo.vehiculos.domain.aggregates.constants.Constants;
import com.codigo.vehiculos.domain.aggregates.dto.VehiculosDTO;
import com.codigo.vehiculos.domain.ports.out.VehiculosServiceOut;
import com.codigo.vehiculos.infraestructure.entity.VehiculosEntity;
import com.codigo.vehiculos.infraestructure.mapper.VehiculosMapper;
import com.codigo.vehiculos.infraestructure.redis.RedisService;
import com.codigo.vehiculos.infraestructure.repository.MarcasRepository;
import com.codigo.vehiculos.infraestructure.repository.TipoCombustibleRepository;
import com.codigo.vehiculos.infraestructure.repository.TipoVehiculoRepository;
import com.codigo.vehiculos.infraestructure.repository.VehiculosRepository;
import com.codigo.vehiculos.infraestructure.util.Util;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
/* @RequiredArgsConstructor */
@AllArgsConstructor
public class VehiculosAdapter implements VehiculosServiceOut {

    private final VehiculosRepository vehiculosRepository;
    private final TipoVehiculoRepository tipoVehiculoRepository;
    private final TipoCombustibleRepository tipoCombustibleRepository;
    private final MarcasRepository marcasRepository;
    private final VehiculosMapper vehiculosMapper;
    private final RedisService redisService;
    private final Util util;

    @Override
    public VehiculosDTO crearVehiculoOut(VehiculosDTO vehiculosDTO) {
        VehiculosEntity vehiculosEntity = vehiculosMapper.mapToEntity(vehiculosDTO);
        vehiculosEntity.setDateCreate(getTimestamp());
        vehiculosRepository.save(vehiculosEntity);
        return vehiculosMapper.mapTopDto(vehiculosEntity);
    }

    @Override
    public Optional<VehiculosDTO> obtenerVehiculoOut(Long id) {
        String redisInfo = redisService.getFromRedis(Constants.REDIS_KEY_VEHICULO+id);
        if (redisInfo != null){
            VehiculosDTO vehiculosDTO = util.convertFromJson(redisInfo, VehiculosDTO.class);
            return Optional.of(vehiculosDTO);
        } else {
            VehiculosDTO dto = vehiculosMapper.mapTopDto(vehiculosRepository.findById(id).get());
            String redis = util.convertToJson(dto);
            redisService.saveInRedis(Constants.REDIS_KEY_VEHICULO+id, redis, 1);
            return Optional.of(dto);
        }
        // return vehiculosRepository.findById(id).map(vehiculosMapper::mapTopDto);
    }

    @Override
    public List<VehiculosDTO> obtenerTodosOut() {
        return vehiculosRepository.findAll().stream().map(vehiculosMapper::mapTopDto).toList();
    }

    @Override
    public VehiculosDTO actualizarOut(Long id, VehiculosDTO vehiculosDTO) {
        if (vehiculosRepository.existsById(id)){
            VehiculosEntity vehiculosEntity = vehiculosMapper.mapToEntity(vehiculosDTO);
            vehiculosEntity.setIdVehiculo(id);
            vehiculosEntity.setDateUpdate(getTimestamp());
            vehiculosEntity.setUsuarioUpdate(vehiculosDTO.getUsuarioUpdate());
            vehiculosRepository.save(vehiculosEntity);
            return vehiculosMapper.mapTopDto(vehiculosEntity);
        }
        return null;
    }

    @Override
    public VehiculosDTO deleteOut(Long id, String usuario) {
        if (vehiculosRepository.existsById(id)){
            Optional<VehiculosEntity> entity=vehiculosRepository.findById(id);
            entity.get().setEstado(Constants.STATUS_INACTIVE);
            entity.get().setDateDelete(getTimestamp());
            entity.get().setUsuarioDelete(usuario);
            vehiculosRepository.save(entity.get());
            return vehiculosMapper.mapTopDto(entity.get());
        }
        return null;
    }

    private Timestamp getTimestamp(){
        long currentTime = System.currentTimeMillis();
        Timestamp timestamp= new Timestamp(currentTime);
        return timestamp;
    }
}
