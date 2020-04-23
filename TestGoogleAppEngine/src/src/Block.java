package src;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.logging.Logger;

public class Block {

    private String hash;
    private String previousHash;
    private Map data;
    private long timeStamp;

    public Block(Map data, String previousHash, long timeStamp)
    {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = timeStamp;
        this.hash = calculateBlockHash();
    }



    public String calculateBlockHash(){
        String dataToHash = previousHash
                + timeStamp
                + data;
        MessageDigest digest = null;
        byte[] bytes = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes(Charset.defaultCharset()));
        }
        catch(NoSuchAlgorithmException e)
        {

        }
        StringBuffer buffer = new StringBuffer();
        for(byte b: bytes)
        {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();
    }

    public Map getData()
    {
        return this.data;
    }

    public String getHash()
    {
        return this.hash;
    }

}
