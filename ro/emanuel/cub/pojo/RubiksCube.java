package ro.emanuel.cub.pojo;

public class RubiksCube {
	
	private int id;
	private String brand;
	private int weight;
	private int sides;
	
	
	
	public RubiksCube(int id, String brand, int weight, int sides) {
		this.id =id;
		this.brand = brand;
		this.weight = weight;
		this.sides = sides;
	}
	public RubiksCube( String brand, int weight, int sides) {
		this.brand = brand;
		this.weight = weight;
		this.sides = sides;
	}
	
	@Override
	public String toString() {
		return "RubiksCube [ id=" + id + ", brand=" + brand + ", weight=" + weight + ", sides=" + sides + "]";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}
	
	public RubiksCube() {
		
	}

}
