package src;

public class Voter {

    private String name;
    private int DOB;
    private int SSN;

    public Voter(String name, int DOB, int SSN) {
        this.name = name;
        this.DOB = DOB;
        this.SSN = SSN;
    }

    public String getName() {
        return name;
    }

    public int getDOB() {
        return DOB;
    }

    public int getHash() {
        return DOB + SSN + name.length();
    }

    public boolean isValid(int[] hashes) {
        for(int h : hashes) {
            if (h == this.getHash()) return true;
        }
        return false;
    }
}
