package clubUser;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandTool {
    private ClubUserSystem clubUserSystem;
    public CommandTool(){
        clubUserSystem = new ClubUserSystem();
    }
    public void parseCommand(String command) {
        final String addRank = "(addrank) ([a-zA-Z\\sа-яА-Я\\- W$0-9]+)";
        final String addUser = "(adduser) ([a-zA-Z\\sа-яА-Я\\- W$0-9]+;[a-zA-Z\\sа-яА-Я\\- W$0-9]+;[a-zA-Z\\sа-яА-Я\\- W$0-9@.]+)";
        Matcher matcher = isPatternMatches(command, addRank);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] adminData = data.split(";");
            clubUserSystem.addRank(adminData[0]);
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, addUser);
        if (matcher.find()){
            String data = matcher.group(2);
            System.out.println(data);
            String [] userData = data.split(";");
            clubUserSystem.addUser(userData[0],userData[1],userData[2]);
        }
    }
    public Matcher isPatternMatches(String command, String regex){
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(command);
        return matcher;
    }

    public static void main(String[] args) {
        CommandTool commandTool = new CommandTool();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please, type a command");
            String command = sc.nextLine();
            commandTool.parseCommand(command);
        }
    }
}
