import java.util.regex.*;

Session dbSession = new Session("localhost", 5984);

List <String> listofdb = dbSession.getDatabaseNames();
