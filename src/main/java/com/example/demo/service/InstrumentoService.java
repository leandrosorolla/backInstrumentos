package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.InstrumentoDto;
import com.example.demo.entity.Instrumento;
import com.example.demo.repository.InstrumentoRepository;

@Service
public class InstrumentoService {

	private InstrumentoRepository repo;

	public InstrumentoService(InstrumentoRepository repo) {
		super();
		this.repo = repo;
	}

	
	public List<InstrumentoDto> findAll() throws Exception {
		List<Instrumento> ents = repo.findAll();
		List<InstrumentoDto> dtos = new ArrayList();
		try {
			for (Instrumento i : ents) {
				InstrumentoDto ent = new InstrumentoDto();
				ent.setId(i.getId());
				ent.setInstrumento(i.getInstrumento());
				ent.setMarca(i.getMarca());
				ent.setModelo(i.getModelo());
				ent.setPrecio(i.getPrecio());
				ent.setCostoEnvio(i.getCostoEnvio());
				ent.setCantidadVendida(i.getCantidadVendida());
				ent.setDescripcion(i.getDescripcion());
				ent.setImagen(i.getImagen());

				dtos.add(ent);
			}
		} catch (Exception e) {
			throw new Exception();
		}
		return dtos;
	}

	
	public InstrumentoDto findById(int id) throws Exception {
		Optional<Instrumento> entOp = repo.findById(id);
		InstrumentoDto dto = new InstrumentoDto();
		try {
			Instrumento ent = entOp.get();

			dto.setId(ent.getId());
			dto.setInstrumento(ent.getInstrumento());
			dto.setMarca(ent.getMarca());
			dto.setModelo(ent.getModelo());
			dto.setPrecio(ent.getPrecio());
			dto.setCostoEnvio(ent.getCostoEnvio());
			dto.setCantidadVendida(ent.getCantidadVendida());
			dto.setDescripcion(ent.getDescripcion());
			dto.setImagen(ent.getImagen());

			return dto;

		} catch (Exception e) {
			throw new Exception();
		}
	}

	public InstrumentoDto save(InstrumentoDto dto) throws Exception {
		Instrumento ent = new Instrumento();
		try {
		ent.setInstrumento(dto.getInstrumento());
		ent.setMarca(dto.getMarca());
		ent.setModelo(dto.getModelo());
		ent.setPrecio(dto.getPrecio());
		ent.setCostoEnvio(dto.getCostoEnvio());
		ent.setCantidadVendida(dto.getCantidadVendida());
		ent.setDescripcion(dto.getDescripcion());
		ent.setImagen(dto.getImagen());

		
			ent = repo.save(ent);
			dto.setId(ent.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	
	public InstrumentoDto update(int id, InstrumentoDto dto) throws Exception {
		Optional<Instrumento> entOp = repo.findById(id);
		try {
			Instrumento ent = entOp.get();
			try {
				if (repo.existsById(id)) {
					ent.setInstrumento(dto.getInstrumento());
					ent.setMarca(dto.getMarca());
					ent.setModelo(dto.getModelo());
					ent.setPrecio(dto.getPrecio());
					ent.setCostoEnvio(dto.getCostoEnvio());
					ent.setCantidadVendida(dto.getCantidadVendida());
					ent.setDescripcion(dto.getDescripcion());
					ent.setImagen(dto.getImagen());

					repo.save(ent);
					dto.setId(ent.getId());
					return dto;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				throw new Exception();

			}
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public boolean delete(int id)throws Exception{
		try {
			if(repo.existsById(id)) {
				repo.deleteById(id);
				return true;
			}else {
				throw new Exception();
			}
		}catch(Exception e) {
			throw new Exception();

		}
		
	}
}
