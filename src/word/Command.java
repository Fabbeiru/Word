package word;

/**
 *
 * @author Fabián B.
 */

public interface Command {
    public void execute();
    public boolean isEnabled();
        
}