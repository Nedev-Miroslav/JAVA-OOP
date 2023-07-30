package W09DesignPatterns.P05CommandDesignPattern;

public class VolumeUp implements Command{


    // Логиката за увеличаването на звука на дистанционното е скрита в този клас
    private RemoteControl remoteControl;

    public VolumeUp(RemoteControl remoteControl) {
        this.remoteControl = remoteControl;
    }

    @Override
    public void execute() {
        int currentVolume = remoteControl.getVolume();
        remoteControl.setVolume(currentVolume + 1);

    }
}
