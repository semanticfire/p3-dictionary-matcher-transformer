package eu.fusepoolp3.dmasimple;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an entity and stores its label, URI, begin and end
 * position, its weight, whether it overlaps with other entities and the label
 * divided into tokens.
 * @author Gábor Reményi
 */
public class Annotation {
    String label;
    String prefLabel;
    String altLabel;
    String uri;
    String type;
    private int begin;
    private int end;
    private int tokenizedBegin;
    private int tokenizedEnd;
    double score;
    boolean overlap;
    List<Token> tokens;
    
    /**
     * Simple constructor.
     */
    public Annotation() {
        tokens = new ArrayList<Token>();
        score = 1;
    }
    
    /**
     * Simple constructor.
     */
    public Annotation(String label, String uri) {
        this.label = label;
        this.uri = uri;
        tokens = new ArrayList<Token>();
        score = 1;
    }
    
    /**
     * Simple constructor.
     */
    public Annotation(String label, String uri, String type) {
        this.label = label;
        this.uri = uri;
        this.type = type;
        tokens = new ArrayList<Token>();
        score = 1;
    }
    
    /**
     * Returns the label of the entity.
     * @return 
     */
    public String getLabel() {
        return label;
    }

    public String getUri() {
        return uri;
    }

    public String getType() {
        return type;
    }

    public String getPrefLabel() {
        return prefLabel;
    }

    public String getAltLabel() {
        return altLabel;
    }
     

    /**
     * Returns the label of the entity stripping it from new line characters.
     * @return 
     */
    public String getDisplayText() {
        return label.replace("\\n", " ");
    }
    
    /**
     * Returns the begin position of the entity.
     * @return 
     */
    public int getBegin() {
        return begin;
    }
    
    /**
     * Returns the end position of the entity.
     * @return 
     */
    public int getEnd() {
        return end;
    }
    
    /**
     * Returns the whether the entity overlaps with another.
     * @return 
     */
    public boolean isOverlap() {
        return overlap;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setOverlap(boolean overlap) {
        this.overlap = overlap;
    }

    /**
     * Returns the label of the entity as a token list.
     * @return 
     */
    public List<Token> getTokens() {
        return tokens;
    }
    
    /**
     * Returns the length of the entity label.
     * @return 
     */
    public int getLength(){
        return end - begin;
    }
    
    /**
     * Adds a new token the to token list.
     * @param t 
     */
    public void addToken(Token t) {
        this.tokens.add(t);
    }
    
    public int getTokenizedBegin() {
        return tokenizedBegin;
    }

    public void setTokenizedBegin(int tokenizedBegin) {
        this.tokenizedBegin = tokenizedBegin;
    }

    public int getTokenizedEnd() {
        return tokenizedEnd;
    }

    public void setTokenizedEnd(int tokenizedEnd) {
        this.tokenizedEnd = tokenizedEnd;
    }
    
    /**
     * It is a lookup function to find the entity in the original text.
     * @param originalText 
     */
    public void FindEntityInOriginalText(String originalText) {
        int tokenCount = this.tokens.size();

        if(tokenCount == 1){
            begin = this.tokens.get(0).originalBegin;
            end = this.tokens.get(0).originalEnd;
            label = originalText.substring(begin, end);
        }
        else if(tokenCount > 1){
            begin = this.tokens.get(0).originalBegin;
            end = this.tokens.get(tokenCount-1).originalEnd;
            label = originalText.substring(begin, end);
        }
        else{
            label = "";
        }
    }

    @Override
    public String toString() {
        return "Entity{\r\n" 
                + "\tprefLabel=\"" + prefLabel + "\",\r\n"
                + "\taltLabel=\"" + altLabel + "\",\r\n"
                + "\turi=\"" + uri + "\",\r\n"
                + "\ttype=\"" + type + "\",\r\n"
                + "\ttextFound=\"" + label + "\",\r\n"
                + "\tbegin=" + begin + ",\r\n"
                + "\tend=" + end + "\r\n"
                + "}\r\n";
    }
}
