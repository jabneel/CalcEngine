/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcengine;

/**
 *
 * @author Jabneel
 * This program is created to demonstrate the use of Methods, Classes, Actuators,
 * and Mutators.
 */
public class CalcEngine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
//       double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
//       double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
//       char[] opCodes = {'d', 'a', 's', 'm'};
//       double[] results = new double[opCodes.length];
//       MathEquation testEquation = new MathEquation();
//       testEquation.execute();
//       System.out.print("test = ");
//       System.out.println(testEquation.getResult());
        
        /*CalcEngine using create method
        
        MathEquation [] equations = new MathEquation[4];
        equations[0] = create(100.0d, 50.0d, 'd');
        equations[1] = create(25.0d, 92.0d, 'a');
        equations[2] = create(225.0d, 17.0d, 's');
        equations[3] = create(11.0d, 3.0d, 'm');
        */
        
        //MathEquation 2.0 using constructors to set objects in the appropriate 
        //state
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
    }
}
    
         
//MathEquation 1.0 using Accessors and Mutators
//    public static MathEquation create(double leftVal, double rightVal, char opCode){
//        MathEquation equation = new MathEquation();
//        equation.setLeftVal(leftVal);
//        equation.setRightVal(rightVal);
//        equation.setOpCode(opCode);
//        
//        return equation;
//    }
    

