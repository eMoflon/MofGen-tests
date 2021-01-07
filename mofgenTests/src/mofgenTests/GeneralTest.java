package mofgenTests;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.junit.Before;
import org.junit.Test;

import TestModels.api.generators.general.*;
import glossarDocumentation.Document;
import glossarDocumentation.DocumentationContainer;
import glossarDocumentation.Entry;

public class GeneralTest {

	@Test
	public void testContainer() {
		EObject containerForLoopObject = (new TestForLoopGenerator()).start();
		assertNotNull(containerForLoopObject);
		assertTrue(containerForLoopObject instanceof DocumentationContainer);
	}

	@Test
	public void testRangeForLoop() {
		DocumentationContainer container = (DocumentationContainer) (new TestForLoopGenerator()).start();
		String docNamePrefix = "IchBinDoc";
		assertTrue(container.getDocuments().size() == 10);
		for(int i = 0; i < 10; i++) {
			Document doc = container.getDocuments().get(i); 
			assertTrue(doc instanceof Document);
			assertTrue(doc.getName().equals(docNamePrefix + i));
		}
	}
	
	@Test
	public void testFurtherAttributes() {
		DocumentationContainer container = (DocumentationContainer) (new TestPattern1Generator()).start();
		String docNamePrefix = "IchBinDoc";
		String entryNamePrefix = "ChildOf_"+docNamePrefix;
		assertTrue(container.getDocuments().size() == 11);
		assertTrue(container.getDocuments().get(0).getName().equals(docNamePrefix));
		
		for(int i=0; i <= 10; i++) {
			List<Entry> entries = container.getDocuments().get(i).getEntries();
			assertTrue(entries.size() == i + 1);
			for(Entry e : entries) {
				assertTrue(e.getName().equals(entryNamePrefix+i));
			}
		}
	}
	
	@Test
	public void testOrdering() {
		DocumentationContainer container = (DocumentationContainer) (new TestOrderingGenerator()).start();
		String name = "WennIchEinDocBinWäreichLieberEinEntry";
		assertTrue(container.getDocuments().size() == 1);
		Document doc = container.getDocuments().get(0);
		assertTrue(doc.getName().equals(name));
		assertTrue(doc.getEntries().size() == 1);
		Entry e = doc.getEntries().get(0);
		assertTrue(e.getName().equals(name));
	}
	
	@Test 
	public void testSettingEnum() {
		EObject eObj = (new TestSettingEnumGenerator()).start();
		assertTrue(eObj instanceof Entry);
		Entry e = (Entry) eObj;
		assertTrue(e.getType() == glossarDocumentation.EntryType.METHOD);
	}
	
	@Test 
	public void testPatternCallReturn() {
		EObject eObj = (new TestPatternCallReturnGenerator()).start();
		assertTrue(eObj instanceof DocumentationContainer);
		DocumentationContainer container = (DocumentationContainer) eObj;
		assertTrue(container.getDocuments().isEmpty());
		assertTrue(container.getGlossar() == null);
	}

	@Test 
	public void testPatternWithinPattern() {
		EObject eObj = (new TestPatternWithinPatternGenerator()).start();
		assertTrue(eObj instanceof DocumentationContainer);
		DocumentationContainer container = (DocumentationContainer) eObj;
		assertTrue(container.getDocuments().size() == 10);
	}
	
	@Test
	public void testVariableManipulation() {
		DocumentationContainer container = (DocumentationContainer) (new TestVariableManipulationGenerator()).start();
		List<Document> docs = container.getDocuments();
		assertTrue(docs.size() == 2);
		Document doc1 = docs.get(0);
		assertTrue(doc1.getName().equals("test0"));
		Document doc2 = docs.get(1);
		assertTrue(doc2.getName().equals("testitest10"));
	}
	
	@Test
	public void testPatternObjectAccess() {
		Document doc = (Document) (new TestPatternObjectAccessGenerator()).start();
		assertTrue(doc.getName().equals("docName"));
	}
	
	@Test
	public void testPatternObjectAsParameter() {
		DocumentationContainer container = (DocumentationContainer) (new TestPatternObjectAsParameterGenerator()).start();
		Document doc = container.getDocuments().get(0);
		assertTrue(doc.getName().equals("docName"));
	}
	
	@Test
	public void testPatternObjectMultipleRefCalls() {
		Document doc = (Document) (new TestPatternObjectMultipleRefCallsGenerator()).start();
		assertTrue(doc.getName().equals("docName"));
	}
	
	@Test
	public void testThis1() {
		TestThis1Generator gen = new TestThis1Generator();
		Document doc = (Document) gen.start();
		assertTrue(doc.getName().equals("IAmGladToBeHere"));
	}
	
	@Test
	public void testThis2() {
		Document doc = (Document) (new TestThis2Generator()).start();
		assertTrue(doc.getName().equals("IAmGladToBeHere"));
	}
}
