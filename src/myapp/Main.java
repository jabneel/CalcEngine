/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;

import calcengine.Adder;
import calcengine.CalculateBase;
import calcengine.CalculateHelper;
import calcengine.Divider;
import calcengine.DynamicHelper;
import calcengine.InvalidStatementException;
import calcengine.MathEquation;
import calcengine.MathProcessing;
import calcengine.Multiplier;
import calcengine.PowerOf;
import calcengine.Subtracter;

/**
 *
 * @author Jabneel
 * This program is created to demonstrate the use of Methods, Classes, Actuators,
 * and Mutators.
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //useMathEquation(); Ch. 1 -10 version
       //useCalculateBase();
       //useCalculateHelper();
       
       String[] statements ={
           "add 25.0 92.0", // 25.0 + 92.0 = 117.0
           "power 5.0 2.0"  // 5.0 ^ 2.0 = 25.0
       };
       
       DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
           new Adder(),
           new PowerOf()
       });
       for(String statement: statements){
           String output = helper.process(statement);
           System.out.println(output);
       }
    
    }
    
    static void useCalculateHelper(){
           
        String [] statements ={
           /*used for creating own Exception Practice*/
           "add 1.0",           //Error: incorrect number of values
           "add xx 25.0",       //Error: non-numeric data
           "addX 0.0.0.0",      //Error: invalid command
           /**/
           "divide 100.0 50.0", 
           "add 25.0 92.0",
           "subtract 225.0 17.0",
           "multiply 11.0 3.0"
       };
        
       CalculateHelper helper = new CalculateHelper();
       for(String statement:statements)
       {
           try{
                helper.process(statement);
                System.out.println(helper);
           }catch(InvalidStatementException e){
                System.out.println(e.getMessage());
                if(e.getCause() !=null)
                    System.out.println("    Original exception: " +e.getCause().getMessage());
           }
       }
    }
    
    static void useMathEquation(){       
        //MathEquation 2.0 using constructors to set objects in the appropriate state
        MathEquation [] equations = new MathEquation[4];
        equations[0] = new MathEquation('d',100.0d, 50.0d );
        equations[1] = new MathEquation('a',25.0d, 92.0d );
        equations[2] = new MathEquation('s',225.0d, 17.0d );
        equations[3] = new MathEquation('m',11.0d, 3.0d );
        
        
        for(MathEquation equation : equations){
            equation.execute();
            System.out.print("result = ");
            System.out.println(equation.result);
        }
        
        System.out.println();
        System.out.println("Using Overloads \n");
         
        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        int leftInt = 9;
        int rightInt = 4;
        
        MathEquation equationOverLoad = new MathEquation('d');
        
        equationOverLoad.execute(leftDouble,rightDouble);
        System.out.print("result = ");
        System.out.println(equationOverLoad.getResult());
        
        //Without the new overload execute,(Widening conversion) automatic type conversion will occur
        //Since double is bigger than int
        equationOverLoad.execute(leftInt,rightInt);
        System.out.print("result = ");
        System.out.println(equationOverLoad.getResult());
        
        equationOverLoad.execute((double)leftInt,rightInt);
        System.out.print("result = ");
        System.out.println(equationOverLoad.getResult());
        
        
        System.out.println("\n\nUsing Inheritance\n");    
    }

    static void useCalculateBase(){
            CalculateBase[] calculations ={
            new Divider(100.0d, 50.0d),
            new Adder(25.0d, 92.0d),
            new Subtracter(225.0d, 17.0d),
            new Multiplier(11.0d, 3.0d)
        };
        
        for(CalculateBase calculator:calculations)
        {
            calculator.calculate();
            System.out.println("result: "+calculator.getResult());
        }    
    }
}       
/*MathEquation 1.0 using Accessors and Mutators
    public static MathEquation create(double leftVal, double rightVal, char opCode){
        MathEquation equation = new MathEquation();
        equation.setLeftVal(leftVal);
        equation.setRightVal(rightVal);
        equation.setOpCode(opCode);
        
        return equation;
    }
    
    useMathEquation 1.0
       double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
       double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
       char[] opCodes = {'d', 'a', 's', 'm'};
       double[] results = new double[opCodes.length];
       MathEquation testEquation = new MathEquation();
       testEquation.execute();
       System.out.print("test = ");
       System.out.println(testEquation.getResult());
*/      
        /*CalcEngine using create method
        
        MathEquation [] equations = new MathEquation[4];
        equations[0] = create(100.0d, 50.0d, 'd');
        equations[1] = create(25.0d, 92.0d, 'a');
        equations[2] = create(225.0d, 17.0d, 's');
        equations[3] = create(11.0d, 3.0d, 'm');
        */

