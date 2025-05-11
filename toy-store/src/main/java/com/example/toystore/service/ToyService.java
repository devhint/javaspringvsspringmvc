public class ToyService {
    private List<Toy> toys = new ArrayList<>();

    public List<Toy> getAllToys() {
        return toys;
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }
}