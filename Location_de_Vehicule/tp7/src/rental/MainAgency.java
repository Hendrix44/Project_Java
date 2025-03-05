package rental;

import rental.filter.*;


/**
 * The  class represents the main program for testing the rental agencies and filters.
 * It creates instances of different rental agencies, vehicles, clients, and filters to demonstrate
 * the functionality of the rental system.

 */
public class MainAgency {


   /**
    * The main method for testing the rental agencies and filters.
    *
    * @param args command line arguments (not used)
    */
    public static void main(String[] args) {

       RentalAgency shop= new RentalAgency();
       Vehicle vehicle1 = new Vehicle("Brand1", "Model1", 2022, 50.0);
       Vehicle vehicle2 = new Vehicle("Brand1", "Model2", 2021, 56.0);
       Vehicle vehicle3 = new Vehicle("Brand3", "Model3", 2020, 70.0);

       Client client1= new Client("bob",25);
       Client client2= new Client("manu",29);

       Car car = new Car("Yamaha", "GT45", 2022, 70.0, 4);
       Car car2 = new Car("Yamaha", "GT44", 2020, 70.0, 5);
       Bike bike = new Bike("BMW","ZT55",2018,80.0,100);
       Bike bike2 = new Bike("BMW","ZT65",2018,80.0,100);

       SuspiciousRentalAgency susAgency = new SuspiciousRentalAgency();
       FriendlyRentalAgency friendlyAgency = new FriendlyRentalAgency();
       Client youngDriver = new Client("Alicia", 20);
       Client normalDriver = new Client("zenyatta", 30);



       // Create an AndFilter and add some filters to it
       AndFilter andFilter = new AndFilter();
       andFilter.addFilter(new BrandFilter("Brand1"));
       andFilter.addFilter(new MaxPriceFilter(60.0));

       // Test the filter with the vehicles
       System.out.println("Vehicle 1: " + andFilter.accept(vehicle1));  // Should be true
       System.out.println("Vehicle 2: " + andFilter.accept(vehicle2));  // Should be true
       System.out.println("Vehicle 3: " + andFilter.accept(vehicle3));  // Should be false


       System.out.println("-----------------------------------------");

       shop.addVehicle(vehicle1);
       System.out.println("tout les vehicules de l agence sont " + shop.getAllVehicles());
       try {
          shop.rentVehicle(client1,vehicle1);
       } catch (UnknownVehicleException e) {
          throw new RuntimeException(e);
       }
       System.out.println("client 1 is renting a vehicule ?"+shop.hasRentedAVehicle(client1));

       System.out.println("vehicule 1 is rented ?"+shop.isRented(vehicle1));
       shop.addVehicle(vehicle3);
       System.out.println("tout les vehicules de l agence sontshop"+shop.getAllVehicles());
       shop.returnVehicle(client1);
       try {
          shop.rentVehicle(client1,vehicle3);
       } catch (UnknownVehicleException e) {
          throw new RuntimeException(e);
       }
       System.out.println("client 1 is renting a vehicule ?"+shop.hasRentedAVehicle(client1));
       System.out.println("vehicule 1 is rented ?"+shop.isRented(vehicle1));
       System.out.println("vehicule 2 is rented ?"+shop.isRented(vehicle3));



       System.out.println("----------------------------------------------");

       shop.addVehicle(vehicle2);
       shop.addVehicle(bike);
       shop.addVehicle(car);

       AndFilter priceFilter = new AndFilter();
       priceFilter.addFilter(new MaxPriceFilter(100.0));
       shop.displaySelection(priceFilter);

       System.out.println("-----------------------------------------------------");
       susAgency.addVehicle(car);
       susAgency.addVehicle(car2);
       try {
          double youngDriverSurcharge = susAgency.rentVehicle(youngDriver,car);
          System.out.println("Young Driver Surcharge: " + youngDriverSurcharge);
       } catch (UnknownVehicleException | IllegalStateException e) {
          e.printStackTrace();
       }

       try {
          double normalDriverSurcharge = susAgency.rentVehicle(normalDriver,car2);
          System.out.println("Normal Driver Surcharge: " + normalDriverSurcharge);
       } catch (UnknownVehicleException | IllegalStateException e) {
          e.printStackTrace();
       }



       System.out.println("--------------------------------------------------------");
       friendlyAgency.addVehicle(vehicle1);
       friendlyAgency.addVehicle(vehicle2);
       friendlyAgency.addVehicle(bike2);


       try {
          double price1 = friendlyAgency.rentVehicle(client1, vehicle1);
          System.out.println("Rent for " + client1.getName() + ": " + price1);

          double price2 = friendlyAgency.rentVehicle(client2, bike2);
          System.out.println("Rent for " + client2.getName() + ": " + price2);

          friendlyAgency.returnVehicle(client1);
          friendlyAgency.returnVehicle(client2);


          double price3 = friendlyAgency.rentVehicle(client1, vehicle1);
          System.out.println("Rent for " + client1.getName() + " " + price3);

          friendlyAgency.returnVehicle(client1);
          // Rent again for client1 to test loyalty program discount
          double price4 = friendlyAgency.rentVehicle(client1, vehicle1);
          System.out.println("Rent for " + client1.getName() + " (with discount): " + price4);

          double price5 = friendlyAgency.rentVehicle(client2, bike2);
          System.out.println("Rent for " + client2.getName() + ": " + price5);

          friendlyAgency.returnVehicle(client2);

          double price6 = friendlyAgency.rentVehicle(client2, bike2);
          System.out.println("Rent for " + client2.getName() + ": " + price6);

          System.out.println( friendlyAgency.clientPoints(client2));

           friendlyAgency.returnVehicle(client1);



       } catch (UnknownVehicleException | IllegalStateException e) {
          e.printStackTrace();
       }
    }

    }




