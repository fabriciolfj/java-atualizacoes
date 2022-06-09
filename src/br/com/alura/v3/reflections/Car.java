package br.com.alura.v3.reflections;

public class Car {

    private int id;
    private String name;
    private Color color;

    public Car() { }

    public Car(int id, Color color) {
        this.id = id;
        this.color = color;
    }

    public Car(int id, String name, Color color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Car(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color=" + color +
                '}';
    }

    public class Engine {

        private String capacity;

        public Engine(final String capacity) {
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "capacity='" + capacity + '\'' +
                    '}';
        }
    }
}
