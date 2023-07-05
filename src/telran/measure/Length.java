package telran.measure;

public class Length implements Comparable<Length> {
	float amount;
	LengthUnit unit;
	public Length (float amount, LengthUnit unit){
		this.amount = amount;
		this.unit = unit;
	}
	@Override
	public int compareTo(Length length) {
		Length convertedLength = length.convert(unit);
		return amount == convertedLength.amount ? 0 : (amount > convertedLength.amount ? 1 : -1);
	}
	
	public Length convert(LengthUnit lengthUnit) {
		float lengthAmount = unit.value * amount / lengthUnit.value;
		return new Length(lengthAmount, lengthUnit);
	}
	
	public LengthUnit getUnit () {
		return unit;
	}
	
	public float getAmount () {
		return amount;
	}
	
	public boolean equals (Length length) {
		return compareTo(length) == 0;
	}
	
	@Override
	public String toString() {
		return ((Float)amount).toString()+unit.toString();
	}
}
