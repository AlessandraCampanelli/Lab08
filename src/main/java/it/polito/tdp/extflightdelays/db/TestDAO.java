package it.polito.tdp.extflightdelays.db;

import java.util.HashMap;
import java.util.Map;

import it.polito.tdp.extflightdelays.model.Airport;

public class TestDAO {

	public static void main(String[] args) {
		Map<Integer,Airport> aereoporto=new HashMap<Integer,Airport>();
		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();

		System.out.println(dao.loadAllAirlines());
		//System.out.println(dao.loadAllAirports( aereoporto));
		System.out.println(dao.loadAllFlights().size());
	}

}
