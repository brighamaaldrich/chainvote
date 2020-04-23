package src;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Write {

    public static void writeBlock(Block newBlock)
    {

        JSONObject transaction = new JSONObject();

        JSONObject voter = new JSONObject();
        voter.put("Name", newBlock.getData().get("name"));

        JSONObject vote = new JSONObject();
        vote.put("choice", newBlock.getData().get("choice"));

        JSONObject hashSSN = new JSONObject();
        hashSSN.put("choice", newBlock.getData().get("hashSSN"));

        JSONObject hash = new JSONObject();
        hash.put("hash", newBlock.getHash());

        transaction.put("Voter", voter);
        transaction.put("vote",vote);
        transaction.put("hashSSN", hashSSN);

        JSONArray container = new JSONArray();

        container.add(transaction);

        try(FileWriter file = new FileWriter("Vote.json"))
        {
            file.write(transaction.toJSONString());
            file.flush();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
