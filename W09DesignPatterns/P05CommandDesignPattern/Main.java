package W09DesignPatterns.P05CommandDesignPattern;

public class Main {
    public static void main(String[] args) {

        RemoteControl remoteControl = new RemoteControl();


        // Основната идея е да се добавя функционалност без да се променя класа
        VolumeUp volumeUp = new VolumeUp(remoteControl);

        volumeUp.execute();
        volumeUp.execute();
        volumeUp.execute();



    }
}
