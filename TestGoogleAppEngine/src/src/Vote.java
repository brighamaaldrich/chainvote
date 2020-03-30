package src;

public class Vote {

    private int vote;
    private String issueKey;
    private Voter person;
    private int prevHash;

    public Vote(int vote, String issueKey, Voter person, int prevHash) {
        this.vote = vote;
        this.issueKey = issueKey;
        this.person = person;
        this.prevHash = prevHash;
    }

    public Vote(int vote, String issueKey, Voter person) {
        this.vote = vote;
        this.issueKey = issueKey;
        this.person = person;
        this.prevHash = 0;
    }

    public int getVote() {
        return vote;
    }

    public String getIssueKey() {
        return issueKey;
    }

    public Voter getPerson() {
        return person;
    }

    public int getHash() {
        return person.getHash();
    }

    public int getPrevHash() {
        return prevHash;
    }

    public String getVoteString() {
        return vote + "..." + issueKey + "..." + person.getName() + "..." + person.getDOB() + "..." + getHash() + "..." + prevHash;
    }
}
