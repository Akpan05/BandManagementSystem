
import java.io.FileInputStream;
import java.io.IOException;
import opennlp.tools.tokenize.Tokenizer;

import opennlp.tools.tokenize.TokenizerME;

import opennlp.tools.tokenize.TokenizerModel;

import java.io.InputStream;

public class NLPProcessor {

    private Tokenizer tokenizer;

    /**
     * Constructs an NLPProcessor instance and initializes the tokenizer.
     * Attempts to load the tokenizer model from the specified file. If loading
     * fails, an error message is printed and the tokenizer remains null.
     */
    public NLPProcessor() {

        // Load the tokenizer model from resources (put en-token.bin inside /src/main/resources/models/)
        try (InputStream modelIn = new FileInputStream("opennlp-en-ud-ewt-tokens-1.3-2.5.4.bin")) {
            TokenizerModel model = new TokenizerModel(modelIn);

            tokenizer = new TokenizerME(model);

        } catch (IOException e) {

            System.err.println(e.getMessage());;

        }

    }

    /**
     * Tokenizes given text using internal tokenizer. If the tokenizer is not
     * initialized returns and empty array
     *
     * @param text
     * @return
     */
    public String[] tokenize(String text) {

        if (tokenizer == null) {
            return new String[0];
        }

        return tokenizer.tokenize(text);

    }

}
