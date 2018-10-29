/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcengine;

/**
 *
 * @author Jabneel
 */
public abstract class CalculateBase {
   public double leftVal;
    public double rightVal;
    public double result;
    
    //Accessors and Mutators
    public double getLeftVal() {return leftVal;}
    public void setLeftVal(double leftVal) {this.leftVal = leftVal;}
    public double getRightVal() {return rightVal;}
    public void setRightVal(double rightVal){this.rightVal = rightVal;}
    public double getResult() {return result;}
    public void setResult(double result){this.result = result;}
    //*******
    
    public CalculateBase(){}
    public CalculateBase(double leftVal, double rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }
    
    public abstract void calculate();
}
