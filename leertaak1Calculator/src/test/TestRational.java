package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Rational;

/**
 * JUnit Testcase to test Rational. 
 * Note that this class uses 'annotations' (the @...). This is a Java 1.5 feature. 
 * @author gebruiker
 *
 */
public class TestRational {
	Rational r;
	Rational r2;

	@Before
	public void setUp(){
		r = new Rational();
		r2 = new Rational();
	}
	
	@Test
	public void testSimplify() {
		r.setNumerator(25);
		r.setDenominator(5);
		r.simplify();
		
		assertEquals(5.0, r.getNumerator(), 0);
		assertEquals(1.0, r.getDenominator(), 0);
		
		r.setNumerator(10);
		r.setDenominator(0.5);
		r.simplify();
		
		assertEquals(10.0, r.getNumerator(), 0);
		assertEquals(0.5, r.getDenominator(), 0);		
	}
	
	@Test
	public void testCanonical() {
		r.setNumerator(12.5);
		r.setDenominator(1.0);
		r.canonical();
		
		assertEquals(125.0, r.getNumerator(), 0);
		assertEquals(10.0, r.getDenominator(), 0);

		r.setNumerator(12.5);
		r.setDenominator(0.01);
		r.canonical();
		
		assertEquals(125.0, r.getNumerator(), 0);
		assertEquals(0.1, r.getDenominator(), 0);	
	}
	
	@Test
	public void testCanonicalAndSimplify() {
		r.setNumerator(12.5);
		r.setDenominator(1.0);
		r.canonical();
		r.simplify();
		
		assertEquals(25.0, r.getNumerator(), 0);
		assertEquals(2.0, r.getDenominator(), 0);		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDivideByZero() {
		r.setNumerator(10);
		r.setDenominator(1);
		r2.setNumerator(0);
		r2.setDenominator(1);
		
		r.div(r2);
	}


}
