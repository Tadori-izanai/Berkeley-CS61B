package examprep04;

public class Test {
    public static void main(String[] args) {
        Person itai = new Person();
//    SoccerPlayer shivani = new Person();      // CE
        Athlete sohum = new SoccerPlayer();
        Person jack = new Athlete();
        Athlete anjali = new Athlete();
        SoccerPlayer chirasree = new SoccerPlayer();

        itai.watch(chirasree);      // wow
//        jack.watch(sohum);          // CE
        itai.speakTo(sohum);        // kudos        (Person)
        jack.speakTo(anjali);       // kudos        (Person)
        anjali.speakTo(chirasree);  // take notes   (Athlete)

        sohum.speakTo(itai);        // hmph        (Person -> SoccerPlayer)
        chirasree.speakTo((SoccerPlayer) sohum);    // respect  (Person -> SoccerPlayer, sohum is-a Person)

//        sohum.watch(itai);          // CE
//        sohum.watch((Athlete) itai);                // RE!!!!!!!!! (不允许 dynamic type 是 Person 的映射到其 subClass)
        ((Athlete) jack).speakTo(anjali);   // take notes
//        ((SoccerPlayer) jack).speakTo(chirasree);   // RE!!!!
        ((Person) chirasree).speakTo(itai);     // hmph     (still call SoccerPlayer.speakTo)


        /* (b) */
        jack.watch((SoccerPlayer) sohum);   // wow
        ((Athlete) jack).watch(sohum);      // game on

        /* (c) */
        SoccerPlayer shicani = new SoccerPlayer();

        // sohum.watch(itai);               // helpless

        // sohum.watch((Athlete) itai);     // helpless

        // ((SoccerPlayer) jack).speakTo(chirasree);
//        jack.speakTo((Athlete) chirasree);    // 没必要 cast
        jack.speakTo(chirasree);
        ((Athlete) jack).speakTo(chirasree);

    }
}
