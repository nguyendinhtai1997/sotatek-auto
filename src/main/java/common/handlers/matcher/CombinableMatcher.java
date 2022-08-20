package common.handlers.matcher;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CombinableMatcher<T> extends BaseMatcher<T> {
    private final List<Matcher<? super T>> matchers = new ArrayList();
    private final List<Matcher<? super T>> failed = new ArrayList();

    private CombinableMatcher(Matcher matcher) {
        this.matchers.add(matcher);
    }

    public static <T> CombinableMatcher<T> all(Matcher<? super T> matcher) {
        return new CombinableMatcher(matcher);
    }

    public CombinableMatcher and(Matcher matcher) {
        this.matchers.add(matcher);
        return this;
    }

    public boolean matches(Object item) {
        boolean finalResult = true;
        Iterator var3 = this.matchers.iterator();

        while (var3.hasNext()) {
            Matcher<? super T> matcher = (Matcher) var3.next();
            if (!matcher.matches(item)) {
                this.failed.add(matcher);
                finalResult = false;
            }
        }

        return finalResult;
    }

    public void describeTo(Description description) {
        description.appendList("(", " and ", ")", this.matchers);
    }

    public void describeMismatch(Object item, Description description) {
        int i = 1;
        description.appendText("\n");

        for (Iterator<Matcher<? super T>> var4 = this.failed.iterator(); var4.hasNext(); ++i) {
            Matcher<? super T> matcher = var4.next();
            description.appendText(String.format("%d. ", i));
            description.appendDescriptionOf(matcher).appendText(" but actual ");
            matcher.describeMismatch(item, description);
            description.appendText("\n");
        }

    }
}
