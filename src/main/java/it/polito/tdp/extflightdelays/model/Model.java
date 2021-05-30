package it.polito.tdp.extflightdelays.model;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
Graph<Airport,DefaultWeightedEdge>grafo;  // grafo pesato 
ExtFlightDelaysDAO dao= new ExtFlightDelaysDAO();
Map <Integer,Airport>idMap= new HashMap<Integer,Airport>(); //FACCIO UN'IDENTITY MAP 


public void creaGrafo(int distance) {
this.grafo= new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

//aggiungo alla mappa che ho creato gli oggetti dell'areoporto 
dao.loadAllAirports(idMap);
Graphs.addAllVertices(grafo, idMap.values()); //HO AGGIUNTO AL GRAFO I VERTICI

//AGGIUNGO GLI ARCHI CON L'APPROCCIO 3 OVVERO CREO UNA CLASSE ADIACENZE CHE PRIMA VADO A CREARE NEL DAO 
for(Adiacenza a: dao.getAdiacenze(idMap, distance)) {
	Graphs.addEdge(this.grafo, a.getPartenza(), a.getDestinazione(), a.getPeso());
}
	}


	 public int  getNvertici () {
		 return this.grafo.vertexSet().size();
		 
	 }
	 public int  getNarchi () {
		 return this.grafo.edgeSet().size();
		 
	 }


public List<Adiacenza> getArchi(int peso){
	 List <Adiacenza> archi= new ArrayList <Adiacenza>();
	 for(Adiacenza a: dao.getAdiacenze(idMap,peso)) {
		 archi.add(a);
	 }
	 
	 return archi;
}

}