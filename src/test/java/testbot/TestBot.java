package testbot;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import bot.Bot;

public class TestBot {
	@Test
	public void testBotInstructionIsValidwithoutSpace() {

		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				Bot robo1 = new Bot();
				robo1.processInput(" ");
			}
		}, "Blank space is invalid command");
		Assertions.assertEquals("Blank space is invalid command", thrown.getMessage());
	}

	@Test
	public void testBotInstructionIsEmpty() {

		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				Bot robo1 = new Bot();
				robo1.processInput("");
			}
		}, "Enter valid command");
		Assertions.assertEquals("Enter valid command", thrown.getMessage());
	}

	@Test
	public void testBotInstructionIsNull() {

		NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				Bot robo1 = new Bot();
				robo1.processInput(null);
			}
		}, "null command is invalid");
		Assertions.assertEquals("null command is invalid", thrown.getMessage());
	}

	@Test
	public void testInvalidBotInstruction() {

		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				Bot robo1 = new Bot();
				robo1.processInput("z");
			}
		}, "Entered command is invalid");
		Assertions.assertEquals("Entered command is invalid", thrown.getMessage());
	}
//	 @Test
//	    public void testInvalidBotSteps() {
//	         
//	    	IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
//	             
//	            @Override
//	            public void execute() throws Throwable {
//	                Bot robo1 = new Bot();
//	                robo1.processInput("I 10");
//	                robo1.processInput("M 0");
//	            }
//	        }, "Invalid steps! Please enter positive value");
//	    	assertNotEquals("Invalid steps! Please enter positive value", thrown.getMessage());
//	    }

	@Test
	public void ArrayOnlyChangeWhenPenIsDown() {

		Bot user = new Bot();
		user.processInput("i 10");
		user.penDown = true;
		user.processInput("m 2");
//	       	user.currentPositionX= 0;
//	       	user.currentPositionY= 0;
//	    	user.penDown= true;
//	        user.robotPosition[1]= 7;
//	       	user.direction='N';
//	       	user.penDown=true;
//	           user.processCommand("m2");

//	       	assertEquals("1",user.floor[0][0]);
//	          assertEquals("1",user.floor[0][1]);
//	          assertEquals("1",user.floor[0][2]);
		System.out.println(user.floor[0][0]);
		System.out.println(user.floor[1][0]);
		System.out.println(user.floor[2][0]);
		// assertEquals("7", user.robotPosition[0]);

		// System.out.println(user.processCommand("c"));
//	       	System.out.println(user.robotPosition[1]);
	}

//	 @Test
//	    public void testRobotInputIsInvalidforInvalidCommand() {
//	         
//	    	IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
//	             
//	            @Override
//	            public void execute() throws Throwable {
//	                Robot robot2 = new Robot();
//	                robot2.analyseInput("z4");
//	            }
//	        }, "Invalid Character Input");
//	    	Assertions.assertEquals("Invalid Character Input", thrown.getMessage());
//	    }

//	@Test
//    public void testRobotInputIsInvalidForBlankSpacesOnly() {
//         
//    	IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
//             
//            @Override
//            public void execute() throws Throwable {
//                Robot user = new Robot();
//                user.analyseInput("      ");
//            }
//        }, "cannot be blank Spaces only");
//    	Assertions.assertEquals("cannot be blank Spaces only", thrown.getMessage());
//    }
//	
//	@Test
//    public void testRobotInputIsInvalidforInvalidCommand() {
//         
//    	IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
//             
//            @Override
//            public void execute() throws Throwable {
//                Robot user = new Robot();
//                user.analyseInput("b6");
//            }
//        }, "Invalid Input");
//    	Assertions.assertEquals("Invalid Input", thrown.getMessage());
//    }
//	
//	@Test
//    public void testRobotforPenDown() {
//         
//		Robot user = new Robot();
//		 user.changePenPosition("d");
//		 assertEquals("down", user.penPosition);
//		 
//    }
//	
//	@Test
//    public void testRobotforPenUp() {
//         
//		Robot user = new Robot();
//		 user.changePenPosition("u");
//		 assertEquals("up", user.penPosition);
//		 
//    }
//	
//	@Test
//    public void testFloorNotInilizeWithZero() {
//         
//    	IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
//             
//            @Override
//            public void execute() throws Throwable {
//                Robot user = new Robot();
//                user.initailizeArray("i0");
//            }
//        }, "Floor size cannot be zero or negative");
//    	Assertions.assertEquals("Floor size cannot be zero", thrown.getMessage());
//    }

//	@Test
//    public void testMoveNorth() {
//       	
//       	Bot user = new Bot();
//       	user.size=10;
//       	user.initializeSystem(10);
//       	user.currentRow= 7;
//        user.currentCol= 7;
//       	user.direction.equals("N");
//       	user.penDown=true;
//           user.moveForward(2);
//           //assertEquals("7", user.robotPosition[0]);
//       	System.out.println(user.currentRow);
////       	System.out.println(user.robotPosition[1]);
//       }

}

//	   public void testFloorNotInilizeWithNegativeNumber() {
//	         
//	    	IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
//	             
//	            @Override
//	            public void execute() throws Throwable {
//	                Robot user = new Robot();
//	                user.initailizeArray("i -2");
//	            }
//	        }, "Floor size cannot be Negative");
//	    	Assertions.assertEquals("Floor size cannot be Negative", thrown.getMessage());
//	    }