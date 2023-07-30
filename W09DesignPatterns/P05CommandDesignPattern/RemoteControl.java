package W09DesignPatterns.P05CommandDesignPattern;

public class RemoteControl {
    private int volume;
    private int program;

    public RemoteControl() {
        volume = 0;
        program = 0;

    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getProgram() {
        return program;
    }

    public void setProgram(int program) {
        this.program = program;
    }
}
