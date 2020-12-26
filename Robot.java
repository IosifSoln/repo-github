

public class Robot implements Team {

    int maxRange;
    int maxJump;
    String name;

    public Robot(String name, int maxRange, int maxJump) {
        this.maxRange = maxRange;
        this.maxJump = maxJump;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public int getMaxJump() {
        return maxJump;
    }


    public void runTreadmill(Treadmill treadmill) {
        if (treadmill.getRange() <= getMaxRange())
            System.out.println("Робот по имени " + getName() + " пробежал " + treadmill.getRange() + " метров\n");
    }


    public void jumpWall(Wall wall) {
        if (wall.getHeight() <= getMaxJump())
            System.out.println("Робот по имени " + getName() + " смог перепрыгнуть стену высотой " + wall.getHeight() + " метра\n");

    }


}


