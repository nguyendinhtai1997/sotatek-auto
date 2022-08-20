package common.handlers.matcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class Verifier {
    public Verifier() {
    }

    public static <T> boolean verify(T a, Matcher<? super T> matcher, Description mismatchDesc) {
        boolean result = verify(a, matcher);
        if (!result) {
            matcher.describeMismatch(a, mismatchDesc);
        }

        return result;
    }

    public static <T> boolean verify(T a, Matcher<? super T> matcher) {
        boolean result = matcher.matches(a);

        return result;
    }
}
