package io.marmer.github.demo.novatecsummit2023demo.testdata;


import lombok.experimental.Delegate;

/**
 * Base class for testdatagenerators. An implementation would use a {@link ValueProvider} to fill complex objects with
 * state. By default, an {@link IncrementalValueProvider} is used, but this may change on later versions.
 * <p>
 * An Implementation could either be done as Junit Jupiter Extension, JUnit4 Rule or an equivalent of other testing
 * frameworks or do a {@link #reset()} somehow else before or after each test lifecycle to get comparable results.
 * <p>
 * In Addition you should add a methods to provide Objects (or builder) populated by values of the {@link ValueProvider}
 * for some real testdata. In your testcode you then only have to change values relevant for your testcase.
 */
public class TestdatageneratorBase {
    @Delegate
    private final ValueProvider valueProvider;

    /**
     * Takes the value provider, the values are based on.
     *
     * @param valueProvider ValueProvider.
     */
    public TestdatageneratorBase(final ValueProvider valueProvider) {
        this.valueProvider = valueProvider;
    }

    /**
     * Default Constructor. Initializes the instance with an Incremental valueprovider based on an initial Value of 1
     * and an Increment of 1.
     */
    public TestdatageneratorBase() {
        this(new IncrementalValueProvider(1).withIncrement(1));
    }

    /**
     * Returns the value provider used internally. This can be helpful to get some more base values withing you test.
     *
     * @return The value provider used internally.
     */
    public ValueProvider getValueProvider() {
        return valueProvider;
    }
}
