package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * List all blocked users and IP addresses.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Blocks">API:Blocks</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class BlocksList extends AbstractList {

    private Instant bkStart;
    private Instant bkEnd;
    private Dir.Time bkDir;
    private Set<Integer> bkIds;
    private Set<String> bkUsers;
    private String bkIp;
    private int bkLimit;
    private EnumSet<BkProp> bkProp;
    private EnumSet<BkShow> bkShow;
    private String bkContinue;

    private BlocksList() {
        super("blocks");
    }

    public static class Builder extends AbstractBuilder {

        private final BlocksList blocksList = new BlocksList();

        /**
         * The timestamp to start enumerating from.
         * @return {@code Builder}
         */
        public Builder bkStart(final Instant bkStart) {
            blocksList.bkStart = bkStart;
            blocksList.apiUrl.putQuery("bkstart", bkStart.toString());
            return this;
        }

        /**
         * The timestamp to stop enumerating at.
         * @return {@code Builder}
         */
        public Builder bkEnd(final Instant bkEnd) {
            blocksList.bkEnd = bkEnd;
            blocksList.apiUrl.putQuery("bkend", bkEnd.toString());
            return this;
        }

        /**
         * In which direction to enumerate:
         *
         * <ul>
         *    <li>{@code newer} - Lists the oldest records first.
         *    <br>Note: {@code bkstart} must be earlier than {@code bkend}.</li>
         *    <li>{@code older} - Lists the newest records first (default).
         *    <br>Note: {@code bkstart} must be later than {@code bkend}.</li>
         * </ul>
         *
         * @return {@code Builder}
         */
        public Builder bkDir(final Dir.Time bkDir) {
            blocksList.bkDir = bkDir;
            blocksList.apiUrl.putQuery("bkdir", bkDir.getValue());
            return this;
        }

        /**
         * List of block IDs to list (optional).
         *
         * @param bkIds Maximum number of values is 50 (500 for clients that are allowed higher limits).
         *
         * @return {@code Builder}
         */
        public Builder bkIds(final Set<Integer> bkIds) {
            blocksList.bkIds = bkIds;
            blocksList.apiUrl.putQuery("bkids", bkIds.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * List of users to search for (optional).
         *
         * @param bkUsers Maximum number of values is 50 (500 for clients that are allowed higher limits).
         *
         * @return {@code Builder}
         */
        public Builder bkUsers(final Set<String> bkUsers) {
            blocksList.bkUsers = bkUsers;
            blocksList.apiUrl.putQuery("bkusers", String.join("|", bkUsers));
            return this;
        }

        /**
         * Get all blocks applying to this IP address or CIDR range, including range blocks. Cannot be used together
         * with {@code bkusers}. CIDR ranges broader than IPv4/16 or IPv6/19 are not accepted.
         *
         * @return {@code Builder}
         */
        public Builder bkIp(final String bkIp) {
            blocksList.bkIp = bkIp;
            blocksList.apiUrl.putQuery("bkipip", bkIp);
            return this;
        }

        /**
         * The maximum number of contributions to return.
         *
         * @param bkLimit The value must be between 1 and 500.
         *
         * @return {@code Builder}
         */
        public Builder bkLimit(final int bkLimit) {
            blocksList.bkLimit = bkLimit;
            blocksList.apiUrl.putQuery("bklimit", bkLimit);
            return this;
        }

        /**
         * Which properties to get.
         * @return {@code Builder}
         */
        public Builder bkProp(final EnumSet<BkProp> bkProp) {
            blocksList.bkProp = bkProp;
            blocksList.apiUrl.putQuery("bkprop", merge(bkProp));
            return this;
        }

        /**
         * Show only items that meet these criteria. For example, to see only indefinite blocks on IP addresses,
         * set {@code bkshow=ip|!temp}.
         * @return {@code Builder}
         */
        public Builder bkShow(final EnumSet<BkShow> bkShow) {
            blocksList.bkShow = bkShow;
            blocksList.apiUrl.putQuery("bkshow", merge(bkShow));
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder bkContinue(final String bkContinue) {
            blocksList.bkContinue = bkContinue;
            blocksList.apiUrl.putQuery("bkcontinue", bkContinue);
            return this;
        }

        public BlocksList build() {
            return blocksList;
        }

    }

    @Getter
    public enum BkProp implements EnumValueProvider {

        /**
         * Adds the ID of the block.
         */
        ID("id"),

        /**
         * Adds the username of the blocked user.
         */
        USER("user"),

        /**
         * Adds the user ID of the blocked user.
         */
        USER_ID("userid"),

        /**
         * Adds the username of the blocking user.
         */
        BY("by"),

        /**
         * Adds the user ID of the blocking user.
         */
        BY_ID("byid"),

        /**
         * Adds the timestamp of when the block was given.
         */
        TIMESTAMP("timestamp"),

        /**
         * Adds the timestamp of when the block expires.
         */
        EXPIRY("expiry"),

        /**
         * Adds the reason given for the block
         */
        REASON("reason"),

        /**
         * Adds the range of IP addresses affected by the block.
         */
        RANGE("range"),

        /**
         * Tags the ban with (autoblock, anononly, etc.).
         */
        FLAGS("flags"),

        /**
         * Adds the partial block restrictions if the block is not sitewide.
         */
        RESTRICTIONS("restrictions");

        private final String value;

        BkProp(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum BkShow implements EnumValueProvider {

        NOT_ACCOUNT("!account"),
        NOT_IP("!ip"),
        NOT_RANGE("!range"),
        NOT_TEMP("!temp"),
        ACCOUNT("account"),
        IP("ip"),
        RANGE("range"),
        TEMP("temp");

        private final String value;

        BkShow(String value) {
            this.value = value;
        }

    }

}
