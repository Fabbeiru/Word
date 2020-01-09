package word;

/**
 *
 * @author Fabián B.
 */

class Document {

    private boolean dirty = false;
    
    public boolean isDirty() {
        return dirty;
    };

    void cut() {
        dirty = true;
    }

    void copy() {
    }

    void paste() {
        dirty = true;
    }
    
}