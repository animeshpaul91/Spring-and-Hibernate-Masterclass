package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MessageGeneratorImpl implements MessageGenerator{

    // == constants ==
    private static final Logger logger = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    private final int guessCount;

    public MessageGeneratorImpl() {
        guessCount = 10;
    }

    @Autowired
    private Game game;

    @PostConstruct
    public void reset() {
        logger.info("Game is: {}", game);
    }

    // == public methods ==
    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() + " and " +
                game.getBiggest() +
                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon())
            return "You guessed it! The number was " + game.getNumber();
        else if (game.isGameLost())
            return "You lost. The number was " + game.getNumber();
        else if (!game.isValidNumberRange())
            return "Invalid Number range";
        else if (game.getRemainingGuesses() == guessCount)
            return "What is your first guess?";
        else  {
            String direction = "lower";
            if (game.getGuess() < game.getNumber())
                direction = "higher";
            return direction + "! You have " + game.getRemainingGuesses() + " guess left";
        }
    }

    @PreDestroy
    public void destroy() {
        logger.info("Destroying Game: {}", game);
    }
}
