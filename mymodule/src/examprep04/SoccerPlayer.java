package examprep04;

public class SoccerPlayer extends Athlete {
    @Override
    public void speakTo(Athlete other) {
        System.out.println("respect");
    }

    @Override
    public void speakTo(Person other) {
        System.out.println("hmph");
    }
}
