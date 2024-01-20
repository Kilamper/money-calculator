package software.ulpgc.moneycalculator.command;

import java.io.IOException;

public interface Command {
    void execute() throws IOException;
}
