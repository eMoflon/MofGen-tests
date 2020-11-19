package mofgenTests;

import static org.junit.Assert.*;

import TestModelsCollections.api.generators.ListAddTestGenerator;
import TestModelsCollections.api.generators.ListSizeTestGenerator;
import TestModelsCollections.api.generators.ListTestGenerator;
import TestModelsCollections.api.generators.MapPutTestGenerator;
import TestModelsCollections.api.generators.MapSizeTestGenerator;
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
	
	@Test
	public void testListAdd() {
		String[] names = { "Ich", "bin", "Teil", "eines", "vollständigen", "und", "fehlerfreien", "Satzes."};
		DocumentationContainer container = (DocumentationContainer) (new ListAddTestGenerator()).start();
		List<Document> docs = container.getDocuments();
		assertTrue(docs.size() == 8);
		for (int i = 0; i < docs.size(); i++) {
			assertTrue(docs.get(i).getName().equals(names[i]));
		}
	}
	
	@Test
	public void testMapPut() {
		String[] names = { "Ich", "bin", "Teil", "eines", "Satzes"};
		DocumentationContainer container = (DocumentationContainer) (new MapPutTestGenerator()).start();
		List<Document> docs = container.getDocuments();
		assertTrue(docs.size() == 10);
		for (int i = 0; i < 5; i++) {
			assertTrue(docs.get(i).getName().equals(names[i]));
		}
		for(int j = 5; j < docs.size(); j++) {
			assertTrue(docs.get(j).getName().equals(String.valueOf(j-4)));
		}
	}
	
	@Test
	public void testListSize() {
		int correctSize = 8;
		DocumentationContainer container = (DocumentationContainer) (new ListSizeTestGenerator()).start();
		Document doc = container.getDocuments().get(0);
		assertTrue(doc.getName().equals("doc"+correctSize));
	}
	
	@Test
	public void testMapSize() {
		int correctSize = 5;
		DocumentationContainer container = (DocumentationContainer) (new MapSizeTestGenerator()).start();
		Document doc = container.getDocuments().get(0);
		assertTrue(doc.getName().equals("doc"+correctSize));
	}

	// TODO tests for collection methods

	// TODO new test case collection for control flow
}
