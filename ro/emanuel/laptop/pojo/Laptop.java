package ro.emanuel.laptop.pojo;

public class Laptop {
		
		private int id;
		private String brand;
		private String model;
		private int storage;
		
		public Laptop(String brand, String model, int storage) {
			this.brand = brand;
			this.model = model;
			this.storage = storage;
		}
		
		public Laptop(int id, String brand, String model, int storage) {
			this.id = id;
			this.brand = brand;
			this.model = model;
			this.storage = storage;
		}
		
		@Override
		public String toString() {
			return "Laptop [ id=" + id + ", brand=" + brand + ", model=" + model + ", storage=" + storage + "]";
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
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public int getStorage() {
			return storage;
		}
		public void setStorage(int storage) {
			this.storage = storage;
		}
		
		
		
}
