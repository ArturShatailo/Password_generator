package password_jfx.password_generator;

public class Tech {

    public static Integer getRandom(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

}
