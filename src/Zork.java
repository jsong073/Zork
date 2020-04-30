import java.util.*;

public class Zork {
    public static void main (String[] args) {
        Random random = new Random();
        String response = "";
        int roomNum = 0;
        int numRoomsVisited = 0;
        boolean secretFound = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Bork!");
        roomNum = 1;
        while (roomNum != 99) {
            switch (roomNum) {
                case 1:
                    roomNum = room1Foyer(input);
                    if (roomNum != 1 && roomNum != 0) {
                        numRoomsVisited++;
                    }

                    break;
                case 2:
                    roomNum = room2Front(input);
                    if (roomNum != 2 && roomNum != 0) {
                        numRoomsVisited++;
                    }

                    break;
                case 3:
                    roomNum = room3Library(input);
                    if (roomNum != 3 && roomNum != 0) {
                        numRoomsVisited++;
                    }

                    break;
                case 4:
                    roomNum = room4Kitchen(input);
                    if (roomNum != 4 && roomNum != 0) {
                        numRoomsVisited++;
                    }

                    break;
                case 5:
                    roomNum = room5Dining(input);
                    if (roomNum != 5 && roomNum != 0) {
                        numRoomsVisited++;
                    }

                    break;
                case 6:
                    roomNum = room6Vault(input, random, secretFound);
                    if (roomNum != 6 && roomNum != 0) {
                        numRoomsVisited++;
                    }

                    break;
                case 7:
                    roomNum = room7Parlor(input);
                    if (roomNum != 7 && roomNum != 0) {
                        numRoomsVisited++;
                    }

                    break;
                case 8:
                    roomNum = room8Secret(input, secretFound);
                    if (roomNum != 8 && roomNum != 0) {
                        numRoomsVisited++;
                    }
                    secretFound = true;

                    break;
                default:
                    roomNum = endCard(numRoomsVisited, random);


                    break;
            }
        }



    }

    public static int room1Foyer(Scanner input) {
        System.out.println("You are standing in the foyer. There is a dead scorpion on the rug in the middle of the " +
                "room.");
        System.out.print("There is a door to the NORTH, and an exit to the SOUTH. Which way do you want to go? ");
        String response = input.nextLine();
        int roomNum;
        if (response.equalsIgnoreCase("north")) {
            roomNum = 2;
        } else if (response.equalsIgnoreCase("south") || response.equalsIgnoreCase("quit")){
            roomNum = 0;
        } else {
            System.out.println("You wander around the room, but there are no other doors.");
            roomNum = 1;
        }
        return roomNum;

    }

    public static int room2Front(Scanner input) {
        int roomNum;
        System.out.println("You are standing in the front room. There is a grand piano in the corner.");
        System.out.print("Play the piano? (y/n) ");
        String response = input.nextLine();
        if (response.equalsIgnoreCase("y")) {
            System.out.println("The piano makes no sound. Its strings have rusted into reddish-brown dust.");
        }
        System.out.println("There is a door to the EAST, WEST, and SOUTH. Which way do you want to go?");
        response = input.nextLine();
        if (response.equalsIgnoreCase("EAST")) {
            roomNum = 4;
        } else if (response.equalsIgnoreCase("WEST")) {
            roomNum = 3;
        } else if (response.equalsIgnoreCase("SOUTH")) {
            roomNum = 1;
        } else if (response.equalsIgnoreCase("quit")) {
            roomNum = 0;
        } else {
            System.out.println("You wander around, but there are no other exits");
            roomNum = 2;
        }
        return roomNum;
    }

    public static int room3Library(Scanner input) {
        int roomNum;
        System.out.println("It seems you are in the library. There are spiders crawling on the shelves");
        System.out.println("There is an elaborate doorway to the NORTH, and double door leading back to the front room\n" +
                "to the EAST. Which way do you want to go?");
        String response = input.nextLine();
        if (response.equalsIgnoreCase("EAST")) {
            roomNum = 2;
        } else if (response.equalsIgnoreCase("NORTH")) {
            roomNum = 5;
        } else if (response.equalsIgnoreCase("quit")) {
            roomNum = 0;
        } else {
            System.out.println("You wander around, but there are no other exits");
            roomNum = 3;
        }
        return roomNum;
    }

    public static int room4Kitchen(Scanner input) {
        int roomNum;
        System.out.println("You are now in the kitchen. The pots and pans are thick with dust. YOu can see bats \n" +
                "flying across the ceiling.");
        System.out.println("There is a door leading back to the front room to the WEST and a metal door to the NORTH.\n" +
                "Which way do you want to go?");
        String response = input.nextLine();
        if (response.equalsIgnoreCase("WEST")) {
            roomNum = 2;
        } else if (response.equalsIgnoreCase("NORTH")) {
            roomNum = 7;
        } else if (response.equalsIgnoreCase("quit")) {
            roomNum = 0;
        } else {
            System.out.println("You wander around, but there are no other exits");
            roomNum = 4;
        }
        return roomNum;
    }

    public static int room5Dining(Scanner input) {
        int roomNum;
        System.out.println("You are now in the dining room. The dining table is caked with dust. There is a ornate box" +
                " at the center of the table");
        System.out.println("Open the box? (y/n)");
        String response = input.nextLine();
        if (response.equalsIgnoreCase("y")) {
            System.out.println("You open the box. It's empty.");
        }
        System.out.println("There is a door leading back to the library to the SOUTH. Which way do you want to go?");
        response = input.nextLine();
        if (response.equalsIgnoreCase("SOUTH")) {
            roomNum = 3;
        } else if (response.equalsIgnoreCase("quit")) {
            roomNum = 0;
        } else {
            System.out.println("You wander around, but there are no other exits");
            roomNum = 5;
        }
        return roomNum;
    }

    public static int room6Vault(Scanner input, Random random, boolean secretFound) {
        int roomNum;
        System.out.println("You push through the heavy doors and into the vault. The interior is empty save for 3 " +
                "walking skeletons. They are playing Settlers of Catan, when they turn and see you.");
        System.out.println("Attack the skeletons? (y/n)");
        String response = input.nextLine();
        if (response.equalsIgnoreCase("y")) {
            System.out.println("You grab a rock off the ground a throw it at the nearest skeleton, knocking its head " +
                    "clean off. The skeleton picks its head off the floor, places it back on its neck, and resumes " +
                    "playing.");
        }
        if (secretFound == true) {
            System.out.println("There is a door leading back to the parlor to the EAST. Next to it, you can see the " +
                    "switch leading to the vault. You can type \"VAULT\" to access it.");
        } else {
            System.out.println("There is a door leading back to the parlor to the EAST. Which way do you want to go?");
        }
        response = input.nextLine();
        if (response.equalsIgnoreCase("EAST")) {
            int randNum = random.nextInt(100);
            if (randNum < 24 && secretFound == false) {
                roomNum = 8;
            } else {
                roomNum = 7;
            }
        } else if (response.equalsIgnoreCase("vault")) {
            roomNum = 8;
        } else if (response.equalsIgnoreCase("quit")) {
            roomNum = 0;
        } else {
            System.out.println("You wander around, but there are no other exits");
            roomNum = 6;
        }
        return roomNum;

    }

    public static int room7Parlor(Scanner input) {
        int roomNum;
        System.out.println("You are now in the parlor. There are faded paintings on the walls and a small wooden chest" +
                " sitting on the coffee table.");
        System.out.println("Open the chest? (y/n)");
        String response = input.nextLine();
        if (response.equalsIgnoreCase("y")) {
            System.out.println("You force open the rusty hinges and find a small locket with a illegible engraving.");
        }
        System.out.println("There is a door leading back to the kitchen to the SOUTH, and a heavy metal door to the " +
                "WEST. Which way do you want to go?");
        response = input.nextLine();
        if (response.equalsIgnoreCase("SOUTH")) {
            roomNum = 4;
        } else if (response.equalsIgnoreCase("WEST")) {
            roomNum = 6;
        } else if (response.equalsIgnoreCase("quit")) {
            roomNum = 0;
        } else {
            System.out.println("You wander around, but there are no other exits");
            roomNum = 7;
        }
        return roomNum;
    }

    public static int room8Secret(Scanner input, boolean secretFound) {
        int roomNum;
        if (secretFound == true) {
            System.out.println("You press the secret button next to the door of the vault, revealing the hidden passage.");
        } else {
            System.out.println("As you head back to the parlor, you notice a small bump next to the vault door. " +
                    "Brushing away the dirt, you see that it's a secret button. You push it, \nrevealing a hidden passage" +
                    " leading down the stairs.");
        }
        System.out.println("You are now in the secret room underneath the vault. You can see a pile of gold and gems " +
                "resting at back of the room, along with an ornate steel sword. ");
        System.out.println("Take the treasure? (y/n)");
        String response = input.nextLine();
        if (response.equalsIgnoreCase("y")) {
            System.out.println("You shovel as much gold as you can into your pack, and strap the sword onto your hip.");
        }
        System.out.println("There is a staircase leading back to the vault to the WEST. Which way do you want to go?");
        response = input.nextLine();
        if (response.equalsIgnoreCase("WEST")) {
            roomNum = 6;
        } else if (response.equalsIgnoreCase("quit")) {
            roomNum = 0;
        } else {
            System.out.println("You wander around, but there are no other exits");
            roomNum = 8;
        }
        return roomNum;
    }

    public static int endCard(int numRoomsVisited, Random random) {
        int roomNum = 99;
        int randNum = random.nextInt(100);
        if (randNum < 25) {
            System.out.println("Ask you leave the house, you feel a chill. You're being haunted by a ghost.");
        } else {
            System.out.println("You exit the house");
        }
        System.out.println("Number of rooms visited: " + numRoomsVisited);
        return roomNum;
    }
}
