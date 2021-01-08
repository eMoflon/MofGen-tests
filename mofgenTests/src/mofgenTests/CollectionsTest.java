package mofgenTests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import TestModels.api.generators.collections.*;
import glossarDocumentation.Document;
import glossarDocumentation.DocumentationContainer;

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
	
	@Test
	public void testListObjects() {
		DocumentationContainer container = (DocumentationContainer) (new ListTestObjectsGenerator()).start();
		List<Document> docs = container.getDocuments();
		assertTrue(docs.size() == 5);
		for(int i = 0; i < 10; i++) {
			if(i % 2 == 0) {
				docs.get(i/2).getName().equals("doc"+i);
			}
		}
	}
	
	@Test
	public void testMapObjects() {
		DocumentationContainer container = (DocumentationContainer) (new MapTestObjectsGenerator()).start();
		List<Document> docs = container.getDocuments();
		assertTrue(docs.size() == 9);
		for(int i = 0; i < 9; i++) {
			docs.get(i).getName().equals("doc"+ 7 * (i + 1));
		}
	}
	
	@Test
	public void nullOnListTest1() {
		DocumentationContainer container = (DocumentationContainer) (new NullOnListTest1Generator()).start();
		List<Document> docs = container.getDocuments();
		assertTrue(docs.size() == 1);
		assertTrue(docs.get(0).getName().equals("dolittle"));
	}
	
	@Test
	public void nullOnListTest2() {
		DocumentationContainer container = (DocumentationContainer) (new NullOnListTest2Generator()).start();
		List<Document> docs = container.getDocuments();
		assertTrue(docs.size() == 1);
		assertTrue(docs.get(0).getName().equals("dolittle"));
	}

	// TODO tests for collection methods
}
