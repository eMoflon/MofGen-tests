package mofgenTests;

import static org.junit.Assert.*;

import TestModels.api.generators.controlFlow.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;

import glossarDocumentation.Document;
import glossarDocumentation.DocumentationContainer;
import glossarDocumentation.Entry;
import simpleInheritanceModel.A;
import simpleInheritanceModel.B;

public class ControlFlowTest {

	@Test
	public void forRangeTest() {
		DocumentationContainer container = (DocumentationContainer) (new ForRangeTestGenerator()).start();
		List<Document> docs = container.getDocuments();
		assertTrue(docs.size() == 10);
		for (int i = 0; i < 10; i++) {
			assertTrue(docs.get(i).getName().equals("doc" + (i + 1)));
		}
	}

	@Test
	public void ifElseSwitchTest1() {
		DocumentationContainer container = (DocumentationContainer) (new IfElseSwitchTest1Generator()).start();
		List<Document> docs = container.getDocuments();
		assertTrue(docs.size() == 7);
		for (int i = 0; i < 7; i++) {
			int i2 = i - 3;
			if (i2 < 0) {
				assertTrue(docs.get(i).getName().equals("doc" + (-i2)));
			} else if (i2 > 0) {
				assertTrue(docs.get(i).getName().equals("doc" + i2));
			} else {
				assertTrue(docs.get(i).getName().equals("docNull"));
			}
		}
	}

	@Test
	public void ifElseSwitchTest2() {
		DocumentationContainer container = (DocumentationContainer) (new IfElseSwitchTest2Generator()).start();
		String[] docNames = { "a", "b", "c", "d", "e" };
		List<Document> docs = container.getDocuments();
		assertTrue(docs.size() == 10);
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				assertTrue(docs.get(i).getName().equals(docNames[i / 2]));
			} else if (i % 2 != 0) {
				assertTrue(docs.get(i).getName().equals(String.valueOf(i)));
			} else {
				throw new AssertionError();
			}
		}
	}

	@Test
	public void ifElseSwitchTestNone1() {
		Document doc = (Document) (new IfElseSwitchTestNone1Generator()).start();
		assertTrue(doc.getName().equals("NameWasNone"));
	}

	@Test
	public void ifElseSwitchTestNone2() {
		Document doc = (Document) (new IfElseSwitchTestNone2Generator()).start();
		assertTrue(doc.getName().equals("NameWasGiven"));
	}

	@Test
	public void castTest() {
		DocumentationContainer container = (DocumentationContainer) (new CastTestGenerator()).start();
		List<Document> docs = container.getDocuments();
		String docPrefix = "doc";
		String entryPrefix = "entry";
		assertTrue(docs.size() == 5);
		int i = 0;
		for (Document doc : docs) {
			assertTrue(doc.getName().equals(docPrefix + i));
			List<Entry> entries = doc.getEntries();
			assertTrue(entries.size() == 1);
			i++;
			Entry e = entries.get(0);
			assertTrue(e.getName().equals(entryPrefix + i));
			i++;
		}
	}

	@Test
	public void nestedSwitchTest() {
		DocumentationContainer container = (DocumentationContainer) (new NestedSwitchTestGenerator()).start();
		List<Document> docs = container.getDocuments();
		String docPrefix = "doc";
		String entryPrefix = "entry";
		assertTrue(docs.size() == 10);
		for (int i = 0; i < 10; i++) {
			Document doc = docs.get(i);
			List<Entry> entries = doc.getEntries();
			if (i % 2 == 0) {
				assertTrue(doc.getName().equals("IAmNew"));
				assertTrue(entries.isEmpty());
			} else {
				assertTrue(doc.getName().equals(docPrefix + (i - 1)));
				assertTrue(entries.size() == 3);
				assertTrue(entries.get(0).getName().equals(entryPrefix + i));
				assertTrue(entries.get(1).getName().equals("IAmNew"));
				assertTrue(entries.get(2).getName().equals("IAmNew2"));
			}
		}
	}
	
	@Test
	public void nestedForTest() {
		DocumentationContainer container = (DocumentationContainer) (new NestedForTestGenerator()).start();
		List<Document> docs = container.getDocuments();
		assertTrue(docs.size() == 36);
		for (int i = 0; i < 36; i++) {
			int j1 = Math.floorDiv(i, 6)+1;
			int j2 = i % 6 + 1;
			Document doc = docs.get(i);
			assertTrue(Integer.valueOf(doc.getName()) == j1*j2);
		}
	}
	
	@Test
	public void nestedSwitchPatternTest() {
		Document doc = (Document) (new NestedSwitchPatternTestGenerator()).start();
		assertTrue(doc.getName().equals("dolittle"));
	}
	
	@Test
	public void polymorphicSwitchPatternTest() {
		DocumentationContainer container = (DocumentationContainer) (new PolymorphicSwitchPatternTestGenerator()).start();
		List<Document> docs = container.getDocuments();
		assertTrue(docs.size() == 2);
		assertTrue(docs.get(0).getName().equals("b"));
		assertTrue(docs.get(1).getName().equals("c"));
	}
	
	
	@Test
	public void polymorphicTest1() {
		EObject result = (new PolymorphicTest1Generator()).start();
		assertTrue(result != null && result instanceof A);
	}
	
	@Test
	public void earlyReturnInSwitchTest1() {
		EObject res = (new EarlyReturnInSwitchTest1Generator()).start();
		assertTrue(res instanceof B);
	}
	
	@Test
	public void earlyReturnInSwitchTest2() {
		DocumentationContainer container = (DocumentationContainer) (new EarlyReturnInSwitchTest2Generator()).start();
		List<Document> docs = container.getDocuments();
		assertTrue(docs.size() == 5);
		for(int i = 0; i < docs.size(); i++) {
			assertTrue(Integer.valueOf(docs.get(i).getName()) == (i+1));
		}
	}

}
