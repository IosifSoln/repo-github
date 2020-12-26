public class Main {

    public static void main(String[] args) {


        Team[] team = new Team[3];
        team[0] = new Cat("Мартин", 350, 5);
        team[1] = new Man("Павел", 1000, 2);
        team[2] = new Robot("Бэндер", 30000, 30);

        Treadmill treadmill = new Treadmill(300);
        Wall wall = new Wall(2);


        playMarathon(team, treadmill, wall);
    }


    public static void playMarathon(Team[] team, Treadmill treadmill, Wall wall) {
        int Stage;
        for (Stage = 1; Stage <= 3; Stage++) {
            treadmill.setRange(treadmill.getRange() * Stage);
            wall.setHeight(wall.getHeight() * Stage);
            for (int i = 0; i < 3; i++) {
                if (team[i].getMaxRange() < treadmill.getRange()) {
                    continue;
                }
                team[i].runTreadmill(treadmill);
            }
            for (int j = 0; j < 3; j++) {
                if (team[j].getMaxJump() < wall.getHeight()) {
                    continue;
                }
                team[j].jumpWall(wall);
            }
            System.out.println("\n" + Stage + " раунд окончен" + "\n\n");
        }
    }
}