package model.BOT;

public class BotDifficultyFactory {

    public static BotStratergy BotStratergyType(BotDifficulty botDifficulty){

        switch (botDifficulty){
            case EASY:
                return new EasyMove();
        }
        return null;
    }
}
