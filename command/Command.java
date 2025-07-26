package command;

// command = action info, event encapsulation
interface GateCommand {

    void execute();
    void observe();
}

class OpenGateCommand implements GateCommand {

    Gate gate;
    
    OpenGateCommand(Gate gate) {
        this.gate = gate;
    }
    
    @Override
    public void execute() {
        gate.openGate();
    }
    
    @Override
    public void observe() {
        System.out.println("The current command is to open the gate.");
    }
}

class CloseGateCommand implements GateCommand {

    Gate gate;
    
    CloseGateCommand(Gate gate) {
        this.gate = gate;
    }
    
    @Override
    public void execute() {
        gate.closeGate();
    }
    
    @Override
    public void observe() {
        System.out.println("The current command is to close the gate.");
    }
}

class Gate {

    public void openGate() {
        System.out.println("Command taken. The door is opened.");
    }

    public void closeGate() {
        System.out.println("Command taken. The door is closed.");
    }
}

class Lever {
    
    private GateCommand command;
    private final Gate gate;
    
    Lever(Gate gate) {
        this.gate = gate;
        command = new OpenGateCommand(this.gate);
    }
    
    private void changeCommand() {
        command = command instanceof OpenGateCommand
                ? command = new CloseGateCommand(gate) 
                : new OpenGateCommand(gate);
    }
    
    public void interact() {
        command.execute();
        changeCommand();
    }
    
    public void observe() {
        command.observe();
    }
}

public class Command {

    public static void main(String[] args) {

        Gate gate = new Gate();
        Lever lever = new Lever(gate);
        
        lever.observe();
        lever.interact();
        lever.observe();
        lever.interact();
    }
}
