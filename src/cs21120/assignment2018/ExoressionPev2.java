package cs21120.assignment2018;

import java.util.Iterator;

public class ExoressionPev2 implements IExpression, IExpressionFactory {
    private IExpression left, right;
    private Operation operation;
    private int intVal = -1;

    /**
     * Evaluate the expression tree recursively, checking that the result is a
     * positive integer at every step, as required in a Countdown solution
     *
     * @return returns the result of evaluating the expression tree
     * @throws Exception throws an exception if a problem is encountered, including if the Countdown rules are violated.
     */
    @Override
    public int evaluateCountdown() throws Exception {
        return 0;
    }

    /**
     * Assigns the values of an internal node
     *
     * @param left  the expression to use for the left hand side
     * @param right the expression to use for the right hand side
     * @param op    the operation to use at the node
     */
    @Override
    public void set(IExpression left, IExpression right, Operation op) {
            this.left = left;
            this.right = right;
            this.operation = op;
            this.intVal = -1;
    }

    /**
     * Assign the value of a leaf node
     *
     * @param value the value to use at this leaf
     */
    @Override
    public void set(int value){
        this.intVal = value;
    }

    /**
     * Get the value of a leaf node
     *
     * @return returns the leaf node value
     * @throws Exception should throw an Exception if this is not a leaf node
     */
    @Override
    public int getValue() throws Exception {
        if (isLeaf()) {
            return intVal;
        }else
            throw new IllegalStateException();
    }

    /**
     * Get the left side of the equation
     *
     * @return the left side node, null if a leaf
     */
    @Override
    public IExpression getLeft() {
        if (left == null){
            return null;
        }else
            return left;
    }

    /**
     * Get the right side of the equation
     *
     * @return return the right side, null if it is a leaf
     */
    @Override
    public IExpression getRight() {
        if (isLeaf()){
            return right;
        }
        return null;
    }

    /**
     * Get the operations
     *
     * @return returns the operation, null if it is a leaf
     */
    @Override
    public Operation getOperation() {
        if (isLeaf()){
            return null;
        }
        return operation;
    }

    /**
     * Return an iterator for this equation.  An iterator implementation is provided,
     * so you just need to return an instance of it.
     *
     * @return returns an iterator
     */
    @Override
    public Iterator<IExpression> getIterator() {
        return new ExpressionIterator(this);
    }

    /**
     * Checks if this is a leaf node (both children null) or not (both children not null)
     *
     * @return returns true if this is a leaf node
     */
    @Override
    public boolean isLeaf() {
        return (left == null && right == null);
    }

    /**
     * Returns a random equation using (some of) the values given and the available operations
     *
     * @param vals the values that can be used in the equation
     * @return return the root of the random equation tree
     */
    @Override
    public IExpression createRandomEquation(int[] vals) {
        return null;
    }

    /**
     * Searches (somehow) for an equation that evaluates as close as possible to the target value
     *
     * @param vals   the values available to use in the equation
     * @param target the target value
     * @return returns the equation that the system thinks is the best
     */
    @Override
    public IExpression findBestSolution(int[] vals, int target) {
        return null;
    }

    /**
     * Factory method to return a leaf IExpression
     *
     * @param val the value to store in the leaf
     * @return returns the IExpression containing the value
     */
    @Override
    public IExpression createLeaf(int val) {
        IExpression newLeaf = new ExoressionPev2();
        newLeaf.set(val);
        return newLeaf;
    }

    /**
     * Factory method to return a new IExpression with the specified children and operation
     *
     * @param l  the left side of the equation
     * @param r  the right side of the equation
     * @param op the operation to use
     * @return returns the IExpression "l op r"
     */
    @Override
    public IExpression createInternalNode(IExpression l, IExpression r, Operation op) {
        IExpression newNode = new ExoressionPev2();
        newNode.set(l, r, op);
        return newNode;
    }

    public String toString(){

        if (isLeaf()){
        }
        else {
            return left.toString() + operation.toString() + right.toString();
        }
        return null;
    }
}