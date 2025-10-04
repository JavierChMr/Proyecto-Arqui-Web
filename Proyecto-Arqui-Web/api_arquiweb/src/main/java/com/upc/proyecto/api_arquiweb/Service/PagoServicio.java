package com.upc.proyecto.api_arquiweb.Service;
import com.upc.proyecto.api_arquiweb.Entidades.Pago;
import com.upc.proyecto.api_arquiweb.EntidadesDTO.PagoDTO;
import com.upc.proyecto.api_arquiweb.Interfaces.IPagoServicio;
import com.upc.proyecto.api_arquiweb.Repositorio.PagoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PagoServicio implements IPagoServicio {

    @Autowired
    private PagoRepositorio pagoRepositorio;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PagoDTO registrarPago(PagoDTO pagoDTO) {
        Pago pago = modelMapper.map(pagoDTO, Pago.class);
        Pago savedPago = pagoRepositorio.save(pago);
        return modelMapper.map(savedPago, PagoDTO.class);
    }

    @Override
    public List<PagoDTO> listarPagos() {
       return pagoRepositorio.findAll().stream()
               .map(pago -> modelMapper.map(pago, PagoDTO.class))
               .collect(Collectors.toList());
    }

    @Override
    public PagoDTO actualizarPago(PagoDTO pagoDTO) {
        if (pagoDTO.getId() != null && pagoRepositorio.existsById(pagoDTO.getId())) {
            Pago pago = modelMapper.map(pagoDTO, Pago.class);
            Pago updatedPago = pagoRepositorio.save(pago);
            return modelMapper.map(updatedPago, PagoDTO.class);
        }
        return null;
    }

    @Override
    public void eliminarPago(Integer id) {
        pagoRepositorio.deleteById(id);
    }


    @Override
    public List<PagoDTO> listarporfechadepago(LocalDate fechapago) {
        List<Pago> pagos = pagoRepositorio.findByFechaPago(fechapago);
        return pagos.stream()
                .map(pago -> modelMapper.map(pago, PagoDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public PagoDTO buscarPagoPorId(Integer id) {
        Optional<Pago> pago = pagoRepositorio.findById(id);
        return modelMapper.map(pago, PagoDTO.class);
    }


}
