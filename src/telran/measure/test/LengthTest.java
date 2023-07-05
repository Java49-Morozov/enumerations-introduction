package telran.measure.test;

import telran.measure.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class LengthTest {
	Length length1 = new Length(1, LengthUnit.KM);
	Length length2 = new Length(500, LengthUnit.M);
	Length l3 = new Length(50000, LengthUnit.CM);

	@BeforeEach
	void setUp() throws Exception {
	}

 	@Test
	void testEqualsObject() {
		//assertEquals (length2, l3);
		//assertNotEquals(length1, length2);
 		assertTrue (length2.equals(l3));
 		assertFalse (length2.equals(length1));
	}
 
	@Test
	void testCompareTo() {
		assertTrue(length2.compareTo(length1) < 0);
		assertFalse(length2.compareTo(length1) > 0);
		assertTrue(length1.compareTo(length2) > 0);
		assertTrue(length2.compareTo(l3) == 0);
		assertFalse(length2.compareTo(length1) == 0);
	}
	
	@Test
	void testConvert() {
		Length l = l3.convert(LengthUnit.M);
		assertEquals(length2.getAmount(), l.getAmount());
		assertEquals(length2.getUnit(), l.getUnit());
	}
	 
	@Test
	void testToString() {
		assertEquals("500.0M", length2.toString());
		assertEquals("1.0KM", length1.toString());
	}
	
	@Test
	void testBetween() {
		Length l = LengthUnit.M.between(length2, length1);
		assertEquals(l.getAmount(), length2.getAmount());
		assertEquals(l.getUnit(), length2.getUnit());
		assertEquals(l.getUnit(), LengthUnit.M);
	}
 
}
