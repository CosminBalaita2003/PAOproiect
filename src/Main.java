import controller.*;
import database.DbContext;
import models.MemberClient;

import java.sql.Connection;
import java.util.Scanner;

public static void main(String[] args) {
    // Replace with your database credentials
    String database = "proiectpao";
    String user = "admin";
    String password = "admin";

    // Get a connection to the database
    Connection con = DbContext.getInstace(database, user, password);

    // List all databases
    DbContext dbContext = new DbContext();
    dbContext.listDatabases(con);

    ActorController actorController = ActorController.getInstance();
    DirectorController directorController = DirectorController.getInstance();
    MovieController movieController = MovieController.getInstance();
    GenresController genresController = GenresController.getInstance();
    ClientController clientController = ClientController.getInstance();
    MemberClientController memberClientController = MemberClientController.getInstance();
    TicketController ticketController = TicketController.getInstance();
    TheaterController theaterController = TheaterController.getInstance();

    System.out.println("Cinema:");
    Scanner scanner = new Scanner(System.in);
    String option;

    do {
        System.out.println("Insert option: ");
        System.out.println("1. Action on Actors");
        System.out.println("2. Action on Directors");
        System.out.println("3. Action on Movies");
        System.out.println("4. Action on Genres");
        System.out.println("5. Action on Clients");
        System.out.println("6. Action on Member Clients");
        System.out.println("7. Action on Tickets");
        System.out.println("8. Action on Theaters");
        System.out.println("9. Action on Database");

        option = scanner.nextLine();
        System.out.println(STR."Option: \{option}");
        if (Integer.parseInt(option) == 1) {
            System.out.println("1. Add Actor");
            System.out.println("2. Get Actor");
            System.out.println("3. Get All Actors");
            System.out.println("4. Delete Actor");
            System.out.println("5. Update Status");
            System.out.println("6. Get Actors by First Name");
            System.out.println("7. Make all actors alive");

            String optionActor = scanner.nextLine();
            if (optionActor.equals("1")) {
                actorController.addActor();

            }
            if (optionActor.equals("2")) {
                System.out.println("Insert actor id: ");
                String actorId = scanner.nextLine();
                actorController.getActor(Integer.parseInt(actorId));

            }
            if (optionActor.equals("3")) {
                actorController.getAllActors();


            }
            if (optionActor.equals("4")) {
                System.out.println("Insert actor id: ");
                String actorId = scanner.nextLine();
                actorController.deleteActor(Integer.parseInt(actorId));
            }
            if (optionActor.equals("5")) {
                System.out.println("Insert actor id: ");
                String actorId = scanner.nextLine();
                System.out.println("Insert status: ");
                String status = scanner.nextLine();
                actorController.updateStatus(Integer.parseInt(actorId), Boolean.parseBoolean(status));
            }
            if (optionActor.equals("6")) {
                System.out.println("Insert first name: ");
                String firstName = scanner.nextLine();
                actorController.getActorsByFirstName(firstName);
            }
            if (optionActor.equals("7")) {
                actorController.makeAllActorsAlive();
            }

        }
        if (Integer.parseInt(option) == 2) {
            System.out.println("1. Add Director");
            System.out.println("2. Get Director");
            System.out.println("3. Get All Directors");
            System.out.println("4. Delete Director");
            String optionDirector = scanner.nextLine();
            if (Integer.parseInt(optionDirector) == 1) {
                directorController.addDirector();
            }
            if (Integer.parseInt(optionDirector) == 2) {
                System.out.println("Insert director id: ");
                String directorId = scanner.nextLine();
                directorController.getDirector(Integer.parseInt(directorId));
            }
            if (Integer.parseInt(optionDirector) == 3) {
                directorController.getAllDirectors();
            }
            if (Integer.parseInt(optionDirector) == 4) {
                System.out.println("Insert director id: ");
                int directorId = scanner.nextInt();
                directorController.deleteDirector(directorId);
            }
        }
        if (Integer.parseInt(option) == 3) {
            System.out.println("1. Add Movie");
            System.out.println("2. Get Movie");
            System.out.println("3. Get All Movies");
            System.out.println("4. Delete Movie");
            System.out.println("5. Update Rating");
            String optionMovie = scanner.nextLine();
            if (Integer.parseInt(optionMovie) == 1) {
                movieController.addMovie();
            }
            if (Integer.parseInt(optionMovie) == 2) {
                System.out.println("Insert movie id: ");
                String movieId = scanner.nextLine();
                movieController.getMovie(Integer.parseInt(movieId));
            }
            if (Integer.parseInt(optionMovie) == 3) {
                movieController.getAllMovies();
            }
            if (Integer.parseInt(optionMovie) == 4) {
                System.out.println("Insert movie id: ");
                int movieId = scanner.nextInt();
                movieController.deleteMovie(movieId);
            }
            if (Integer.parseInt(optionMovie) == 5) {
                System.out.println("Insert movie id: ");
                int movieId = scanner.nextInt();
                System.out.println("Insert rating: ");
                String rating = scanner.nextLine();
                movieController.updateRating(movieId, rating);
            }
        }
        if (Integer.parseInt(option) == 4) {
            System.out.println("1. Add Genre");
            System.out.println("2. Get Genre");
            System.out.println("3. Get All Genres");
            System.out.println("4. Delete Genre");
            String optionGenre = scanner.nextLine();
            if (Integer.parseInt(optionGenre) == 1) {
                genresController.addGenre();
            }
            if (Integer.parseInt(optionGenre) == 2) {
                System.out.println("Insert genre id: ");
                String genreId = scanner.nextLine();
                actorController.getActor(Integer.parseInt(genreId));
            }
            if (Integer.parseInt(optionGenre) == 3) {
                genresController.getAllGenres();
            }
            if (Integer.parseInt(optionGenre) == 4) {
                System.out.println("Insert genre id: ");
                int genreId = scanner.nextInt();
                genresController.deleteGenre(genreId);
            }
        }
        if (Integer.parseInt(option) == 5) {
            System.out.println("1. Add Client");
            System.out.println("2. Get Client");
            System.out.println("3. Get All Clients");
            System.out.println("4. Delete Client");
            String optionClient = scanner.nextLine();
            if (Integer.parseInt(optionClient) == 1) {
                clientController.addClient();
            }
            if (Integer.parseInt(optionClient) == 2) {
                System.out.println("Insert client id: ");
                String clientId = scanner.nextLine();
                clientController.getClient(Integer.parseInt(clientId));

            }
            if (Integer.parseInt(optionClient) == 3) {
                clientController.getAllClients();
            }
            if (Integer.parseInt(optionClient) == 4) {
                System.out.println("Insert client id: ");
                int clientId = scanner.nextInt();
                clientController.deleteClient(clientId);
            }
        }
        if (Integer.parseInt(option) == 6) {
            System.out.println("1. Add Member Client");
            System.out.println("2. Get Member Client");
            System.out.println("3. Get All Member Clients");
            System.out.println("4. Delete Member Client");
            System.out.println("5. Update No Points");
            String optionMemberClient = scanner.nextLine();
            if (Integer.parseInt(optionMemberClient) == 1) {
                memberClientController.addMemberClient();
            }
            if (Integer.parseInt(optionMemberClient) == 2) {
                System.out.println("Insert member client id: ");
                String memberClientId = scanner.nextLine();
                memberClientController.getMemberClient(Integer.parseInt(memberClientId));

            }
            if (Integer.parseInt(optionMemberClient) == 3) {
                memberClientController.getAllMemberClients();
            }
            if (Integer.parseInt(optionMemberClient) == 4) {
                System.out.println("Insert member client id: ");
                int memberClientId = scanner.nextInt();
                memberClientController.deleteMemberClient(memberClientId);
            }
            if (Integer.parseInt(optionMemberClient) == 5) {
                System.out.println("Insert member client id: ");
                int memberClientId = scanner.nextInt();
                MemberClient member = memberClientController.getMemberClient(memberClientId);
                System.out.println("Insert no points: ");
                int noPoints = scanner.nextInt();
                memberClientController.updateNoPoints(member, noPoints);
            }

        }
        if (Integer.parseInt(option) == 7) {
            System.out.println("1. Add Ticket");
            System.out.println("2. Get Ticket");
            System.out.println("3. Get All Tickets");
            System.out.println("4. Delete Ticket");
            String optionTicket = scanner.nextLine();
            if (Integer.parseInt(optionTicket) == 1) {
                ticketController.addTicket();
            }
            if (Integer.parseInt(optionTicket) == 2) {
                System.out.println("Insert ticket id: ");
                String ticketId = scanner.nextLine();
                ticketController.getTicket(Integer.parseInt(ticketId));

            }
            if (Integer.parseInt(optionTicket) == 3) {
                ticketController.getAllTickets();
            }
            if (Integer.parseInt(optionTicket) == 4) {
                System.out.println("Insert ticket id: ");
                int ticketId = scanner.nextInt();
                ticketController.deleteTicket(ticketId);
            }
        }
        if (Integer.parseInt(option) == 8) {
            System.out.println("1. Add Theater");
            System.out.println("2. Get Theater");
            System.out.println("3. Get All Theaters");
            System.out.println("4. Delete Theater");
            System.out.println("5. Update Theater Capacity");
            String optionTheater = scanner.nextLine();
            if (Integer.parseInt(optionTheater) == 1) {
                theaterController.addTheater();
            }
            if (Integer.parseInt(optionTheater) == 2) {
                System.out.println("Insert theater id: ");
                String theaterId = scanner.nextLine();
                theaterController.getTheater(Integer.parseInt(theaterId));
            }
            if (Integer.parseInt(optionTheater) == 3) {
                theaterController.getAllTheaters();
            }
            if (Integer.parseInt(optionTheater) == 4) {
                System.out.println("Insert theater id: ");
                int theaterId = scanner.nextInt();
                theaterController.deleteTheater(theaterId);
            }


        }
        if (Integer.parseInt(option) == 9) {
            System.out.println("Enter the name of the table: ");
            String table = scanner.nextLine();
            System.out.println("Enter the action (create, insert, select, delete, update, drop): ");
            String action = scanner.nextLine();
            switch (action.toLowerCase()) {
                case "create":
                    dbContext.CreateTable(con, table);
                    break;
                case "insert":
                    //print the columns
                    dbContext.PrintColumns(con, table);
                    System.out.println("Enter the values: ");
                    String values = scanner.nextLine();
                    // Split values by comma and remove quotes
                    String[] valueArray = values.split(",");
                    for (int i = 0; i < valueArray.length; i++) {
                        valueArray[i] = valueArray[i].trim().replace("'", "").replace("\"", "");
                    }
                    dbContext.InsertValues(con, table, valueArray);
                    break;
                case "select":
                    dbContext.Select(con, table);
                    break;
                case "delete":
                    System.out.println("Enter the condition: ");
                    String deleteCondition = scanner.nextLine();
                    dbContext.DeleteValues(con, table, deleteCondition);
                    break;
                case "update":
                    System.out.println("Enter the column to update: ");
                    String column = scanner.nextLine();
                    System.out.println("Enter the new value: ");
                    String updateValue = scanner.nextLine();
                    System.out.println("Enter the condition: ");
                    String updateCondition = scanner.nextLine();
                    dbContext.UpdateValues(con, table, column, updateValue, updateCondition);
                    break;
                case "drop":
                    dbContext.DropTable(con, table);
                    break;
                default:
                    System.out.println("Invalid action.");
                    break;
            }
        }


    } while (!option.equals("exit"));
    scanner.close();
}