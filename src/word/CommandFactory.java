package word;

/**
 *
 * @author Fabián B.
 */

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static CommandFactory instance = null;
    private Document document;
    
    public static CommandFactory instance() {
        if (instance == null) instance = new CommandFactory();
        return instance;
    }
    
    private CommandFactory() {
    }
    
    public Map<String,Command> build() {
        Map<String, Command> result = new HashMap<>();
        result.put("new", newCommand());
        result.put("open", openCommand());
        result.put("save", saveCommand());
        result.put("print", printCommand());
        result.put("cut", cutCommand());
        result.put("copy", copyCommand());
        result.put("paste", pasteCommand());
        return result;
    }

    private Command newCommand() {
        return new Command() {
            @Override
            public void execute() {
                document = new Document();
                System.out.println("new");
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }

    private Command openCommand() {
        return new Command() {
            @Override
            public void execute() {
                document = new Document();
                System.out.println("open");
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }

    private Command saveCommand() {
        return new Command() {
            @Override
            public void execute() {
                System.out.println("save");
            }

            @Override
            public boolean isEnabled() {
                return document != null && document.isDirty();
            }
        };
    }

    private Command printCommand() {
        return new Command() {
            @Override
            public void execute() {
                System.out.println("print");
            }

            @Override
            public boolean isEnabled() {
                return document != null;
            }
        };
    }
    
    private Command cutCommand() {
        return new Command() {
            @Override
            public void execute() {
                System.out.println("cut");
                document.cut();
            }

            @Override
            public boolean isEnabled() {
                return document != null;
            }
        };
    }
    
    private Command copyCommand() {
        return new Command() {
            @Override
            public void execute() {
                System.out.println("copy");
                document.copy();
            }

            @Override
            public boolean isEnabled() {
                return document != null;
            }
        };
    }
    
    private Command pasteCommand() {
        return new Command() {
            @Override
            public void execute() {
                System.out.println("paste");
                document.paste();
            }

            @Override
            public boolean isEnabled() {
                return document != null;
            }
        };
    }
}