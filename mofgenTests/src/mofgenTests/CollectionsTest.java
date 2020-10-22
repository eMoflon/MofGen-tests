package mofgenTests;

import static org.junit.Assert.*;

import TestModelsCollections.api.generators.ListTestGenerator;
import TestModelsCollections.api.generators.MapTestEntriesGenerator;
import TestModelsCollections.api.generators.MapTestKeysGenerator;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.junit.Before;
import org.junit.Test;

import glossarDocumentation.Document;
import glossarDocumentation.DocumentationContainer;
import glossarDocumentation.Entry;

public class CollectionsTest {

	@Test
	public void testForEachList() {
		String[] names = { "DocUno", "DocDeux", "DocTrois" };
		DocumentationContainer container = (DocumentationContainer) (new ListTestGenerator()).start();
		List<Document> docs = container.getDocuments();
		assertTrue(docs.size() == 3);

		for (int i = 0; i < docs.size(); i++) {
			assertTrue(docs.get(i).getName().equals(names[i]));
		}
	}

	@Test
	public void testForEachMapEntries() {
		String[] names = { "DocUno", "DocDeux", "DocTrois" };
		DocumentationContainer container = (DocumentationContainer) (new MapTestEntriesGenerator()).start();
		List<Document> docs = container.getDocuments();
		assertTrue(docs.size() == 3);
		for (int i = 0; i < docs.size(); i++) {
			assertTrue(docs.get(i).getName().equals(names[i]));
		}
	}

	@Test
	public void testForEachMapKeys() {
		String[] names = { "one", "two", "three" };
		DocumentationContainer container = (DocumentationContainer) (new MapTestKeysGenerator()).start();
		List<Document> docs = container.getDocuments();
		assertTrue(docs.size() == 3);
		for (int i = 0; i < docs.size(); i++) {
			assertTrue(docs.get(i).getName().equals(names[i]));
		}
	}

	// TODO tests for collection manipulations

	// TODO new test case collection for control flow
}
