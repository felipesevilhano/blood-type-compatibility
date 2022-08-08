package com.kamila;

import com.kamila.model.BloodClinic;
import com.kamila.model.BloodType;
import com.kamila.model.Donor;
import com.kamila.model.Receiver;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstName, lastName;
        int donorOrReceiver;
        BloodType bloodType;
        Donor donor;
        Receiver receiver;
        BloodClinic bloodClinic = new BloodClinic();

        do {
            System.out.print("Please Input your first name: ");
            firstName = input.nextLine();
        }while(firstName == null || firstName.isBlank());

        do {
            System.out.print("Please Input your last name: ");
            lastName = input.nextLine();
        }while(lastName == null || lastName.isBlank());

        do {
            System.out.print("Are you a donor or receiver (1 for Donor, 2 for Receiver): ");
            try {
                donorOrReceiver = input.nextInt();
                input.nextLine();
            }catch (InputMismatchException e) {
                donorOrReceiver = 0;
            }
        }while(donorOrReceiver != 1 && donorOrReceiver != 2);

        do {
            System.out.printf("Please provide your blood type (%s): ", String.join(", ", BloodType.getAllTypes()));
            bloodType = BloodType.fromType(input.nextLine());
        }while(bloodType == null);

        if(donorOrReceiver == 1) {
            donor = new Donor(firstName, lastName, bloodType);
            System.out.printf("%s, your blood can be given to the following blood type: %s\n",
                    donor.getName(),
                    bloodClinic.analyze(donor).stream()
                            .map(BloodType::getType)
                            .collect(Collectors.joining(", ")));
        } else {
            receiver = new Receiver(firstName, lastName, bloodType);
            System.out.printf("%s, you can receive the following blood type: %s\n",
                    receiver.getName(),
                    bloodClinic.analyze(receiver).stream()
                            .map(BloodType::getType)
                            .collect(Collectors.joining(", ")));
        }
    }
}
