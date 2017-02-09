package org.prototype.lambda;

/**
 * Created by kmenzli on 2/8/17.
 */
public class FormulaImpl implements Formula {

    @Override
    public double calculate(int a) {
        return sqrt(a * 100);
    }
}
