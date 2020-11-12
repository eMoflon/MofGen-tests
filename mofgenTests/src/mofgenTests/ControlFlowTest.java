package mofgenTests;

import static org.junit.Assert.*;

import TestModelsControlFlow.api.generators.ForRangeTestGenerator;
import TestModelsControlFlow.api.generators.IfElseSwitchTest1Generator;

import java.util.List;

import org.junit.Test;

import glossarDocumentation.Document;
import glossarDocumentation.DocumentationContainer;

public class ControlFlowTest {

	@Test
	public void forRangeTest() {
		DocumentationContainer container = (DocumentationContainer) (new ForRangeTestGenerator()).start();
		List<Document> docs = container.getDocuments();
		assertTrue(docs.size() == 10);
		for (int i = 0; i < 10; i++) {
			assertTrue(docs.get(i).getName().equals("doc"+(i+1)));
		}
	}

	@Test
	public void ifElseSwitchTest1() {
		DocumentationContainer container = (DocumentationContainer) (new IfElseSwitchTest1Generator()).start();
		List<Document> docs = container.getDocuments();
		assertTrue(docs.size() == 7);
		for (int i = 0; i < 7; i++) {
			int i2 = i-3;
			if(i2 < 0) {
				assertTrue(docs.get(i).getName().equals("doc"+(-i2)));
			}else if(i2 > 0) {
				assertTrue(docs.get(i).getName().equals("doc"+i2));
			}else {
				assertTrue(docs.get(i).getName().equals("docNull"));
			}
		}
	}
}
