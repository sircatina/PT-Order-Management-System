package bll.validators;

/**

 The Validator interface defines a contract for validating objects of type T.

 Implementations of this interface can perform validation logic on objects to ensure their

 compliance with certain rules or constraints.

 @param <T> the type of object to be validated
 */
public interface Validator<T> {
    /**

     Validates the specified object of type T.
     @param t the object to be validated
     @throws IllegalArgumentException if the object does not meet the validation criteria
     */
    public void validate(T t);
}
