package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MessageGeneratorImpl implements MessageGenerator{

    // == constants ==
    private static final Logger logger = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    private int guessCount;

    public MessageGeneratorImpl() {
        guessCount = 10;
    }

    @Autowired
    private Game game;

    @PostConstruct
    public void reset() {
        logger.info("Game is: {}", game);
        guessCount++;
        logger.info("GuessCount is now: " + guessCount);
    }

    // == public methods ==
    @Override
    public String getMainMessage() {
        return "getMainMessage() called";
    }

    @Override
    public String getResultMessage() {
        return "getResultMessage() called";
    }

    @PreDestroy
    public void destroy() {
        logger.info("Destroying Game: {}", game);
    }
}
