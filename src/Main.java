import controller.*;
import database.DbContext;
import models.Director;
import models.MemberClient;
import models.Theater;

import java.sql.Connection;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main{
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
//        DbContext dbContext = new DbContext();
//        Connection connection = DbContext.getInstace("proiectpao", "admin", "admin");
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
            System.out.println("Option: " + option);
            if (Integer.parseInt(option) == 1) {
                System.out.println("1. Add Actor");
                System.out.println("2. Get Actor");
                System.out.println("3. Get All Actors");
                System.out.println("4. Delete Actor");
                String optionActor = scanner.nextLine();
                if (Integer.parseInt(optionActor) == 1) {
                    actorController.addActor();
                }
                if (Integer.parseInt(optionActor) == 2) {
                    System.out.println("Insert actor id: ");
                    int actorId = scanner.nextInt();
                    actorController.getActor(actorId);
                }
                if (Integer.parseInt(optionActor) == 3) {
                    actorController.getAllActors();
                }
                if (Integer.parseInt(optionActor) == 4) {
                    System.out.println("Insert actor id: ");
                    int actorId = scanner.nextInt();
                    actorController.deleteActor(actorId);
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
                    int directorId = scanner.nextInt();
                    directorController.getDirector(directorId);
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
                    int movieId = scanner.nextInt();
                    movieController.getMovie(movieId);
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
                    int genreId = scanner.nextInt();
                    genresController.getGenre(genreId);
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
                    int clientId = scanner.nextInt();
                    clientController.getClient(clientId);
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
                    int memberClientId = scanner.nextInt();
                    memberClientController.getMemberClient(memberClientId);
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
                    int ticketId = scanner.nextInt();
                    ticketController.getTicket(ticketId);
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
                    int theaterId = scanner.nextInt();
                    theaterController.getTheater(theaterId);
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
                System.out.println("Enter the action: ");
                String action = scanner.nextLine();
                if (action.equals("create")) {
                    dbContext.CreateTable(con, table);
                }
                else if (action.equals("insert"))
                {
                    System.out.println("Enter the values: ");
                    String values = scanner.nextLine();
                    dbContext.InsertValues(con, table, values);
                }
                else if (action.equals("select"))
                {
                    dbContext.Select(con, table);
                }
                else if (action.equals("delete"))
                {
                    System.out.println("Enter the condition: ");
                    String condition = scanner.nextLine();
                    dbContext.DeleteValues(con, table, condition);
                }
                else if (action.equals("update"))
                {
                    System.out.println("Enter the values: ");
                    String values = scanner.nextLine();
                    System.out.println("Enter the condition: ");
                    String condition = scanner.nextLine();
                    System.out.println("Enter the column: ");
                    String column = scanner.nextLine();
                    dbContext.UpdateValues(con, table, column, values, condition);
                }
                else if (action.equals("drop"))
                {
                    dbContext.DropTable(con, table);
                }



        }
    }while (Integer.parseInt(option) != 0);
        scanner.close();
    }

}