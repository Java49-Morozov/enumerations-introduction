package telran.measure;

public enum LengthUnit {
	MM(1), CM(10), IN(25.4f), FT(304.8f), YD(914.4f), M(1000), KM(1_000_000), MI(1_609_344);
	
	float value;
	LengthUnit(float value) {
		this.value = value;
	}
	
	public Length between (Length length1, Length length2) {
		Length convertedLength2 = length2.convert(this);
		Length resLength = new Length(convertedLength2.getAmount() - length1.getAmount(), this);
		return resLength;
	}
	
}
