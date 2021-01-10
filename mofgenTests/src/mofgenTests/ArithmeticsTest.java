package mofgenTests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import TestModels.api.generators.arithmetics.*;
import arithmeticsModel.BooleanResult;
import arithmeticsModel.NumberResult;
import arithmeticsModel.StringResult;

public class ArithmeticsTest {

	@Test
	public void arithmetics1Test() {
		NumberResult res = (NumberResult) (new Arithmetics1Generator().start());
		assertTrue(res.getResult() == 10.0);
	}
	
	@Test
	public void arithmetics2Test() {
		NumberResult res = (NumberResult) (new Arithmetics2Generator().start());
		assertTrue(res.getResult() == 68.0);
	}
	
	@Test
	public void arithmeticsSqrtTest() {
		NumberResult res = (NumberResult) (new ArithmeticsSqrtGenerator().start());
		assertTrue(res.getResult() == 7.0);
	}
	
	@Test
	public void arithmeticsAbsTest() {
		NumberResult res = (NumberResult) (new ArithmeticsAbsGenerator().start());
		assertTrue(res.getResult() == 42.0);
	}
	
	@Test
	public void arithmeticsStringTest() {
		StringResult res = (StringResult) (new ArithmeticsStringGenerator().start());
		assertTrue(res.getResult().equals("1a2b"));
	}

	@Test
	public void arithmeticsBoolean1Test() {
		BooleanResult res = (BooleanResult) (new ArithmeticsBoolean1Generator().start());
		assertTrue(res.isResult());
	}
	
	@Test
	public void arithmeticsBoolean2Test() {
		BooleanResult res = (BooleanResult) (new ArithmeticsBoolean2Generator().start());
		assertTrue(res.isResult());
	}
	
	@Test
	public void arithmeticsBoolean3Test() {
		BooleanResult res = (BooleanResult) (new ArithmeticsBoolean3Generator().start());
		assertTrue(!res.isResult());
	}
	
	@Test
	public void arithmeticsBoolean4Test() {
		BooleanResult res = (BooleanResult) (new ArithmeticsBoolean4Generator().start());
		assertTrue(res.isResult());
	}
	
	@Test
	public void arithmeticsBoolean5Test() {
		BooleanResult res = (BooleanResult) (new ArithmeticsBoolean5Generator().start());
		assertTrue(res.isResult());
	}
	
	@Test
	public void arithmeticsBoolean6Test() {
		BooleanResult res = (BooleanResult) (new ArithmeticsBoolean6Generator().start());
		assertTrue(!res.isResult());
	}
	
	@Test
	public void arithmeticsBoolean7Test() {
		BooleanResult res = (BooleanResult) (new ArithmeticsBoolean7Generator().start());
		assertTrue(!res.isResult());
	}
}
