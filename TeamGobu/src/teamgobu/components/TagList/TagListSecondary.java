package teamgobu.components.TagList;

/**
 * Created by Noah Gibson on 5/19/2017.
 *
 * Layered implementations of secondary methods for {@code TagList}, including
 * overriden methods inherited from {@code Object}.
 */
public abstract class TagListSecondary implements TagList {

    /*
     * Public members-----------------------------------------------------------
     */

    /*
     * Common methods (from Object)---------------------------------------------
     */
    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof TagList)) {
            return false;
        }
        TagList tags = (TagList) obj;
        if (this.length() != tags.length()) {
            return false;
        }
        for (String tag : this) {
            if (!tags.isInList(tag)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final String toString() {
        String tagListString = "";
        for (String tag : this) {
            tagListString += tag + "/";
        }
        //Removes last / from the string
        return tagListString.substring(0, tagListString.length() - 1);
    }

    @Override
    public final int hashCode() {
        //TODO - Write hashCode method
        return 1;
    }

    /*
     * TagList interface methods------------------------------------------------
     */
}
