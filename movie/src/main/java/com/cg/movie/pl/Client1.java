package com.cg.movie.pl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.cg.movie.bean.Show;
import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;
import com.cg.movie.service.AdminService;
import com.cg.movie.service.AdminServiceImpl;

public class Client1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		AdminService adminService = new AdminServiceImpl();
		Show show = null;
		Theater theater = new Theater();
		int choice = 0;

		while (choice != 5) {

			System.out.println("1.Add Theater\n2.Delete Theater\n3.Add Show\n4.Delete Show");
			try {
				System.out.println("Enter your choice");
				choice = scanner.nextInt();
			} catch (Exception e) {
				System.err.println("Enter Valid Input");
				scanner.nextLine();
			}

			switch (choice) {

			case 1:
				
					try {
						System.out.println("Enter theater Id");
						int theaterId = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Enter theater Name");
						String theaterName = scanner.nextLine();
						System.out.println("Enter theater City");
						String theaterCity = scanner.nextLine();
						System.out.println("Enter Manager Name");
						String managerName = scanner.nextLine();
						System.out.println("Enter Manager Contact");
						String managerContact = scanner.nextLine();

						theater.setTheaterId(theaterId);
						theater.setTheaterName(theaterName);
						theater.setTheaterCity(theaterCity);
						theater.setManagerName(managerName);
						theater.setManagerContact(managerContact);

						Theater theater1 = adminService.addTheater(theater);
						System.out.println("Added theater sucessfully ");
					} catch (MovieException e) {
						System.err.println(e.getMessage());
					} catch (Exception e) {
						System.err.println("Type Mismatch enter corret Theater Id");
						scanner.nextLine();
					}
				
				break;

			case 2:
				if (theater.getTheaterId() > 0) {
					try {
						System.out.println("Enter theater id to delete");

						int theaterId1 = scanner.nextInt();

						boolean flag = adminService.deleteTheater(theaterId1);
						if (flag == true) {
							System.out.println("Deleted successfully");
						}

					} catch (MovieException e) {
						System.err.println(e.getMessage());
					} catch (Exception e) {
						System.err.println("Type Mismatch enter corret Theater Id");
						scanner.nextLine();
					}
				} else {
					System.err.println("Add theater first so that you can add show and delete show");
				}
				break;

			case 3:
				if (theater.getTheaterId() > 0) {
					try {
						System.out.println("Enter Show Id ");
						int showId = scanner.nextInt();

						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
						System.out.println("Enter Show start time");
						LocalTime showStartTime = LocalTime.now();
						System.out.println(showStartTime);

						System.out.println("Enter Show end time");
						LocalTime showEndTime = LocalTime.now();
						System.out.println(showEndTime);

						System.out.println("Enter Show name");
						scanner.nextLine();
						String showName = scanner.nextLine();

						System.out.println("Enter Screen ID");
						int screenId = scanner.nextInt();

						show = new Show();

						show.setShowId(showId);
						show.setShowName(showName);
						show.setScreenId(screenId);
						int theaterId2 = theater.getTheaterId();

						adminService.addShow(theaterId2, show);
						System.out.println("Added Show ");

					} catch (MovieException e) {
						System.err.println(e.getMessage());
					} catch (Exception e) {
						System.err.println("Type Mismatch enter corret Show Id");
						scanner.nextLine();
					}
				} else {
					System.err.println("Add theater first so that you can add show and delete show");
				}
				break;

			case 4:
				if (theater.getTheaterId() > 0) {
					try {
						System.out.println("Enter show Id to delete ");
						int showId1 = scanner.nextInt();
						int theaterId3 = theater.getTheaterId();

						boolean flag = adminService.deleteShow(theaterId3, showId1);
						if (flag == true) {
							System.out.println("Delection success");
						}
					} catch (MovieException e) {
						System.err.println(e.getMessage());
					} catch (Exception e) {
						System.err.println("Type Mismatch enter corret Show Id");
						scanner.nextLine();
					}
				} else {
					System.err.println("Add theater first so that you can add show and delete show");
				}
				break;
			}
		}
	}
}
