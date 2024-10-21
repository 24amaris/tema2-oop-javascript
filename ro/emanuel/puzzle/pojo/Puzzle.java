package ro.emanuel.puzzle.pojo;

public class Puzzle {
			
			private int id;
			private String brand;
			private String material;
			private int size;
			
			public Puzzle(int id, String brand, String material, int size) {
				this.id = id;
				this.brand = brand;
				this.material = material;
				this.size = size;
			}
			
			public Puzzle( String brand, String material, int size) {
				this.brand = brand;
				this.material = material;
				this.size = size;
			}
			
			@Override
			public String toString() {
				return "Puzzle [ id=" + id + ", brand=" + brand + ", material=" + material + ", size=" + size + "]";
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
			public String getMaterial() {
				return material;
			}
			public void setMaterial(String material) {
				this.material = material;
			}
			public int getSize() {
				return size;
			}
			public void setSize(int size) {
				this.size = size;
			}
			
			
			
	}


