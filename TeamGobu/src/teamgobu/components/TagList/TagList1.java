package teamgobu.components.TagList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Noah Gibson on 5/20/2017.
 *
 *
 */
//TODO - Write convention and correspondence
public class TagList1 extends TagListSecondary {

    /*
     * Private Members----------------------------------------------------------
     */

    /**
     * A list representation for the TagList.
     */
    private List<String> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new LinkedList<>();
    }

    /*
     * Constructors-------------------------------------------------------------
     */
    /**
     * No argument constructor.
     */
    public TagList1() {
        this.createNewRep();
    }

    /**
     * From String constructor.
     *
     * @param tagListString
     *            the string to create the TagList from, formatted correctly
     */
    //TODO - Make String constructor more efficient/easier to understand
    public TagList1(String tagListString) {
        this.createNewRep();
        String tagListVariable = tagListString;
        while (tagListVariable.length() > 0) {
            int slashIndex = tagListVariable.indexOf("/");
            String nextTag;
            if (slashIndex >= 0) {
                nextTag = tagListVariable.substring(0, slashIndex);
                tagListVariable = tagListVariable.substring(slashIndex + 1);
            } else {
                nextTag = tagListVariable.substring(0);
                tagListVariable = "";
            }
            this.rep.add(nextTag);
            slashIndex = tagListVariable.indexOf("/");
        }
    }

    /*
     * Standard Methods---------------------------------------------------------
     */
    @SuppressWarnings("unchecked")
    @Override
    public final TagList newInstance() {
        try {
            return this.getClass().newInstance();
        } catch (Exception e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(TagList source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof TagList1 : ""
                + "Violation of: source is of dynamic type TagList1";

        TagList1 localSource = (TagList1) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel Methods-----------------------------------------------------------
     */
    @Override
    public final void addTag(String tag) {
        this.rep.add(tag);
    }

    @Override
    public final void removeTag(String tag) {
        assert this.rep.contains(tag) : "Violation of: " + tag + " is in this";
        this.rep.remove(tag);
    }

    @Override
    public final String removeAnyTag() {
        assert this.rep.size() > 0 : "Violation of: this is not empty";
        return this.rep.remove(0);
    }

    @Override
    public final boolean isInList(String tag) {
        return this.rep.contains(tag);
    }

    @Override
    public final int length() {
        return this.rep.size();
    }

    @Override
    public final Iterator<String> iterator() {
        return this.rep.iterator();
    }

}
