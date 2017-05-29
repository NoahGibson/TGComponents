package teamgobu.components.TagList;

import teamgobu.components.Standard.Standard;

/**
 * Created by Noah Gibson on 5/19/2017.
 *
 * An object to hold the contents of a list of tags.
 */
public interface TagListKernel extends Standard<TagList>, Iterable<String> {

    /**
     * Method to add the given string {@code tag} to {@code this}.
     *
     * @param tag
     *            the tag to add to the list
     * @updates this
     * @ensures this.isInList(tag)
     */
    void addTag(String tag);

    /**
     * Removes the given string {@code tag} from this.
     *
     * @param tag
     *            the tag to remove from the list
     * @updates this
     * @requires this.isInList(tag)
     * @ensures [this contains all previous tags minus the given tag]
     */
    void removeTag(String tag);

    /**
     * Removes and returns a tag in {@code this}.
     *
     * @requires this.length > 0
     * @ensures [this contains all previous tags minus removeAnyTag]
     * @return a tag in this
     */
    String removeAnyTag();

    /**
     * Reports whether the given string {@code tag} is already in {@code this}.
     *
     * @param tag
     *            the tag to check
     * @return true iff tag is in this
     */
    boolean isInList(String tag);

    /**
     * Reports the number of tags in {@code this}.
     *
     * @return the length of this
     */
    int length();

}
