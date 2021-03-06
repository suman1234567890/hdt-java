package org.rdfhdt.hdt.rdf.parsers;

import org.rdfhdt.hdt.enums.ResultEstimationType;
import org.rdfhdt.hdt.triples.IteratorTripleString;
import org.rdfhdt.hdt.triples.TripleString;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class JenaModelIterator implements IteratorTripleString {
	private Model model;
	private StmtIterator iterator;
	
	public JenaModelIterator(Model model) {
		this.model = model;
		this.iterator = model.listStatements();
	}
	
	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public TripleString next() {
        Statement stm = iterator.nextStatement();

        return new TripleString(
                        stm.getSubject().toString(),
                        stm.getPredicate().toString(),
                        stm.getObject().toString());
	}

	@Override
	public void goToStart() {
		this.iterator = model.listStatements();
	}

	@Override
	public long estimatedNumResults() {
		return model.size();
	}

	@Override
	public ResultEstimationType numResultEstimation() {
		return ResultEstimationType.MORE_THAN;
	}


	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasPrevious() {
		throw new UnsupportedOperationException();
	}

	@Override
	public TripleString previous() {
		throw new UnsupportedOperationException();
	}

}
