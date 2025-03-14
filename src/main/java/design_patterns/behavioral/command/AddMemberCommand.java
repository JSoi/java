package design_patterns.behavioral.command;

public class AddMemberCommand implements Command {
    // add needed members
    private final String emailAddress;
    private final String listName;
    private final EWSService receiver;

    public AddMemberCommand(String emailAddress, String listName, EWSService receiver) {
        this.emailAddress = emailAddress;
        this.listName = listName;
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.addMember(emailAddress, listName);
    }
}
