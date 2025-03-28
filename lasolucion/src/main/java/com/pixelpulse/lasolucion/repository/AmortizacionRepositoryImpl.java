package com.pixelpulse.lasolucion.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.pixelpulse.lasolucion.model.Amortizacion;


@Repository
public class AmortizacionRepositoryImpl implements AmortizacionRepository{
	
	public static Collection<Amortizacion> itemsA= new ArrayList<>();
	
	@Override
	public void insert(Amortizacion amortizacion) {
		itemsA.add(amortizacion);
	}
	@Override
	public void update(Amortizacion amortizacion) {
		Amortizacion aBuscado = findById(amortizacion.getNumAmortizacion());
		itemsA.remove(aBuscado);
		insert(aBuscado);
	}
	@Override
	public void delete(int id) {
		Amortizacion aBuscado = findById(id);
		itemsA.remove(aBuscado);
	}
	@Override	
	public Amortizacion findById(int id) {
		Optional<Amortizacion> aBuscado = itemsA.stream().filter(p -> p.getNumAmortizacion() == id).findFirst();
		return aBuscado.orElse(null);
	}
	
	@Override	
	public Collection<Amortizacion> findAll() {
		return itemsA;
	}
}
