import controller.*;
import database.DbContext;
import models.*;

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

    for (int i = 0; i < 10; i++) {
        actorController.addActor(new Actor("Actor" + i, "Actor" + i, "01-01-2000", true));
    }
    for (int i = 0; i < 10; i++) {
        directorController.addDirector(new Director("Director" + i, "Director" + i, "01-01-2000",true));
    }
    for (int i = 0; i < 10; i++) {
        Genres genre = new Genres("Genre" + i);
        Director director = new Director("Director" + i,"Director" + i,"01-01-2000",true);
        movieController.addMovie(new Movie("Movie" + i, genre, director, 120, "10"));
    }
    for (int i = 0; i < 10; i++) {
        genresController.addGenre(new Genres("Genre" + i));
    }
    for (int i = 0; i < 10; i++) {
        clientController.addClient(new Client("Client" + i, "Client" + i,"Client"+i+"@ymail.com", "01-01-2000"));
    }
    for (int i = 0; i < 10; i++) {
        memberClientController.addMemberClient(new MemberClient("MemberClient" + i, "MemberClient" + i, "MemberClient" + i + "@yahoo.com", "01-01-2000", 0));
    }
    for (int i = 0; i < 10; i++) {
        Theater theater = new Theater( "100");
        theaterController.addTheater(theater);
    }
    for (int i = 0; i < 10; i++) {
        Ticket ticket = new Ticket(i,i, "01-01-2000", "10");
        ticketController.addTicket(ticket);
    }
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
                String Id = scanner.nextLine();
                int directorId = Integer.parseInt(Id);
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
                String id = scanner.nextLine();
                int movieId = Integer.parseInt(id);
                movieController.deleteMovie(movieId);
            }
            if (Integer.parseInt(optionMovie) == 5) {
                System.out.println("Insert movie id: ");
                String id = scanner.nextLine();
                int movieId = Integer.parseInt(id);
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
                String Id = scanner.nextLine();
                int genreId = Integer.parseInt(Id);
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
                String Id = scanner.nextLine();
                int clientId = Integer.parseInt(Id);
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
                String id = scanner.nextLine();
                int memberClientId = Integer.parseInt(id)-1;
                memberClientController.deleteMemberClient(memberClientId);
            }
            if (Integer.parseInt(optionMemberClient) == 5) {
                System.out.println("Insert member client id: ");
                String id = scanner.nextLine();
                int memberClientId = Integer.parseInt(id);
                MemberClient member = memberClientController.getMemberClient(memberClientId);
                System.out.println("Insert no points: ");
                String points = scanner.nextLine();
                int noPoints = Integer.parseInt(points);
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
                String id = scanner.nextLine();
                int ticketId = Integer.parseInt(id);
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
                String id = scanner.nextLine();
                int theaterId = Integer.parseInt(id);
                theaterController.deleteTheater(theaterId);
            }


        }
        if (Integer.parseInt(option) == 9) {
            System.out.println("Enter the name of the table: ");
            String table = scanner.nextLine();
            System.out.println("Enter the action (create, insert, select, selectord, delete, update, drop): ");
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
                case "selectord":
                    dbContext.selectOrderedTable(con, table);
                    break;
                default:
                    System.out.println("Invalid action.");
                    break;
            }
        }


    } while (!option.equals("exit"));
    scanner.close();
}