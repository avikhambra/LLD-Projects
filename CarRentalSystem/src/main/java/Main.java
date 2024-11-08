public class Main {
    public static void main(String[] args) {

        CarRentalSystem rentalSystem = new CarRentalSystem();

        Car car1 = new Car("C001", "Toyota", "Camry", 60.0); // Different base price per day for each car
        Car car2 = new Car("C002", "Honda", "Accord", 70.0);
        Car car3 = new Car("C003", "Mahindra", "Thar", 130.0);
        Car car4 = new Car("C004", "Swift", "Baleno", 50.0);
        Car car5 = new Car("C005", "BMW", "Classic", 170.0);
        Car car6 = new Car("C006", "Audi", "G23", 190.0);

        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
        rentalSystem.addCar(car4);
        rentalSystem.addCar(car5);
        rentalSystem.addCar(car6);

        rentalSystem.menu();

    }
}