package mofgenTests;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.junit.Before;
import org.junit.Test;

import TestModels.api.generators.TestForLoopGenerator;
import TestModels.api.generators.TestOrderingGenerator;
import TestModels.api.generators.TestPattern1Generator;
import TestModels.api.generators.TestSettingEnumGenerator;
import TestModelsGeneral.api.generators.TestPatternCallReturnGenerator;
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

}
