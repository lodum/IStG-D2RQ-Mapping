package de.ifgi.lodum;

import java.util.ArrayList;
import java.util.Iterator;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.vocabulary.DCTerms;

import de.fuberlin.wiwiss.d2rq.jena.ModelD2RQ;

public class IStGD2RQ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IStGD2RQ istgD2RQ = new IStGD2RQ();
		
		istgD2RQ.retrieveUpdates();
	}

	public ModelD2RQ dump() {
		return null;
		
	}

	public ModelD2RQ retrieveUpdates() {
		Model m = new ModelD2RQ("file:istg_mapping_staedtegeschichten.ttl");
		
		ResIterator nodeIt = m.listSubjectsWithProperty(DCTerms.modified);
		ArrayList<String> listWithURIs = new ArrayList<String>();
		String URI = "";
		while (nodeIt.hasNext())
		{
			URI = nodeIt.nextResource().getURI();
			System.out.println(URI);
			listWithURIs.add(URI);
		}

		deleteOldFromStore(listWithURIs);
		
		return null;
		
	}
	
	public ModelD2RQ cleanData(ModelD2RQ model) {
		return model;
//		SELECT DISTINCT * WHERE {
//			  ?s dct:modified ?date.
//			  FILTER ( ?date < "2013-04-11T21:32:52+02:00"^^xsd:dateTime )
//			}
//			LIMIT 10
	}
	
	public void deleteOldFromStore(ArrayList<String> oldURIs) {
		Iterator<String> i = oldURIs.iterator();
		System.out.println("delete");
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
	
	public void submitModelToStore(ModelD2RQ model) {
		
	}
}
